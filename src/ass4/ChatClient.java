package ass4;

import java.io.InterruptedIOException;
import java.net.*;
import java.util.*;

/**
 * This is a reliable client/server chat program written in JAVA for assignment 4.
 * This Client use UDP as a transport layer protocol for transmitting messages to server side.
 * The checksums for handling bit errors does not implement in this program. 
 * But the sequence numbers and timer for guaranteed has beedn considered.
 * 
 *
 */
public class ChatClient {
	private static final int time_out_max_value = 30000;
	private static final int server_port = 1700;
	private static int client_port = 1500;
	private static int resend_times_max = 5;

	/*
	 * in order to ensure the reliable UPP, considering add a sequence number
	 * for each data package. for each data package, the maximum length is set
	 * to 10.
	 */
	private static int udp_data_buffer_size = 10;

	public static void main(String[] args) throws Exception {

		/*
		 * This is a sample data which will be sent to server side. Since the
		 * the maximum length of each round is fixed by 10, so this string will
		 * be sent with several rounds.
		 */
		String send_data = "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggg";
		// Begin to create socket client
		DatagramSocket datagramSocket = new DatagramSocket(client_port);
		InetAddress localAddress = InetAddress.getLocalHost();
		DatagramPacket sendPacket = null;

		// determine how many rounds need to send this message
		int package_number = ((send_data.length() / udp_data_buffer_size) + 1);
		String client_info = "Client[" + localAddress.getHostAddress() + ":" + client_port + "] ";
		System.out.println(client_info + "Prepare to send data, the data is:");
		System.out.println(send_data);
		System.out.println(client_info + "Currently, the maximum package size of each UDP Datagram is set to:"
				+ udp_data_buffer_size);
		System.out.println(client_info + "So, this client will send " + package_number + " datagram to server.");

		String[] send_array = new String[package_number];

		// split the message string object to array
		for (int i = 0; i < package_number; i++) {
			int start = i * udp_data_buffer_size;
			int end = ((i + 1) * udp_data_buffer_size - 1);
			if (end > send_data.length())
				end = send_data.length() - 1;
			send_array[i] = send_data.substring(start, end);
		}
		for (int i = 0; i < package_number; i++) {
			System.out.println(client_info + "No " + (i) + ": " + send_array[i]);
		}

		byte[] receiveBuffer = null;
		DatagramPacket receivePacket = null;
		for (int i = 0; i < package_number; i++) {
			/*
			 * the first 10 bits is defined as head1, it indicate the total
			 * number of datagram
			 */
			String head1 = String.format("%10d", package_number);
			/*
			 * in each datagram, the second 10 bits is defined as head2, it
			 * indicates the current number of datagram.
			 */
			String head2 = String.format("%10d", i);
			String str = send_array[i];
			str = head1 + head2 + str;
			System.out.println(client_info + "Begin send no. " + (i) + " datagram:" + str);
			sendPacket = new DatagramPacket(str.getBytes(), str.length(), localAddress, server_port);
			receiveBuffer = new byte[1024];
			receivePacket = new DatagramPacket(receiveBuffer, 1024);
			datagramSocket.setSoTimeout(time_out_max_value);

			int times_resend = 0;
			boolean hasSent = false;
			/*
			 * Start to send the data separately. After each sending, waiting
			 * the response from server side
			 */
			do {
				datagramSocket.send(sendPacket);
				try {
					datagramSocket.receive(receivePacket);
					hasSent = true;
				} catch (InterruptedIOException e) {
					/*
					 * if there is a timeout due to network issues, try to
					 * resend again.
					 */
					times_resend++;
				}
			} while ((!hasSent) && (times_resend < resend_times_max));
			str = "";
			String server_info = "Server[" + receivePacket.getAddress().getHostAddress() + ":" + receivePacket.getPort()
					+ "]: ";
			str = new String(receivePacket.getData(), 0, receivePacket.getLength());
			System.out.println(server_info + str);
			receivePacket.setLength(1024);
		}

		datagramSocket.close();

	}

}
