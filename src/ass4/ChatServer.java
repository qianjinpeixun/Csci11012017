package ass4;

import java.net.*;
import java.util.*;

/*
 *the basic feature of this ChatServer are:
 *Receive incoming messages from the client
 *Display incoming messages from the client
 *Send messages to the client
 * Wait for feedback from the client
 *Re-transmit in case of lost message 
 */
public class ChatServer {

	// fixed the default port of client and server side
	private static final int server_port = 1700;
	private static final int client_port = 1500;

	public static void main(String[] args) throws Exception {

		String send_data = "";
		byte[] receiveBuffer = new byte[1024];
		// create the socket using UDP
		DatagramSocket datagramSocket = new DatagramSocket(server_port);
		DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, 1024);
		System.out.println("ChatServer is running");
		/*
		 * this HashMap will store the received data from client. Sinde the
		 * message will cover more than one packet, after each receiving data
		 * from client, add it into this hashmap
		 * 
		 */
		HashMap<Integer, String> receivedData = new HashMap<Integer, String>();
		while (true) {
			datagramSocket.receive(receivePacket);
			String clientStr = "Client[" + receivePacket.getAddress().getHostAddress() + ":" + receivePacket.getPort()
					+ "]: ";
			String receivedStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
			String str = clientStr + receivedStr;
			System.out.println(str);

			int count_datagram = 0;
			int current_datagram = 0;

			// according the definition how to extend UDP protocol, get the
			// head1 and head2 from the data body.
			String head1 = receivedStr.substring(0, 10).trim();
			String head2 = receivedStr.substring(11, 20).trim();
			// head1 is an integer indicating how many packets have been split
			count_datagram = Integer.parseInt(head1);
			// head2 is the current sequence number
			current_datagram = Integer.parseInt(head2);
			String data = receivedStr.substring(20);
			if (!receivedData.containsKey(current_datagram)) {
				// if this is the first time to receive this data, add it into
				// hashmap
				receivedData.put(current_datagram, data);
			}
			/*
			 * if all of the packets have been received, assemble it in order
			 * according to sequence number
			 */
			if (receivedData.size() == count_datagram) {
				String final_str = "";
				for (int i = 0; i < count_datagram; i++) {
					final_str = final_str + receivedData.get(i);
				}
				System.out.println("full data from client is:" + final_str);
				receivedData = new HashMap<Integer, String>();
			}

			// finally, print the whole message
			send_data = "Welcome " + clientStr + " I got your message:" + receivedStr;
			DatagramPacket sendPacket = new DatagramPacket(send_data.getBytes(), send_data.length(),
					receivePacket.getAddress(), receivePacket.getPort());
			datagramSocket.send(sendPacket);
			receivePacket.setLength(1024);

		}
		// datagramSocket.close();
	}

}
