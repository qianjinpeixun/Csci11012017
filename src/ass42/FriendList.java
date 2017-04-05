package ass42;


public class FriendList {
   LinkedList2 allUsers;
   public FriendList()
   {
       allUsers=new LinkedList2();
   }
   public void addUser(User u)
   {
	   int years=2017-u.birthYear;
	   int isContains=allUsers.contains(u);
       if((years>=13) && (isContains==-1))
           allUsers.addNodetoEnd(u);
   }
   public void removeUser(User u)
   {
       int pos=allUsers.contains(u);
       allUsers.removeNode(pos);
       for(int i=0;i<allUsers.getCount();i++)
       {
           int pos1=allUsers.getUser(i).getFriends().contains(u);
           if(pos1!=-1)
           {
               allUsers.getUser(i).getFriends().removeNode(pos1);
           }
       }
   }
   public int totalUsers()
   {
       return allUsers.getCount();
   }
   public LinkedList2 getUsers()
   {
       return allUsers;
   }
   
   
   public User mostFriends()
   {
       User user=null;
       int max=0;
       for(int i=0;i<allUsers.getCount();i++)
       {
           if(allUsers.getUser(i).getNumFriends()>max)
           {
               max=allUsers.getUser(i).getNumFriends();
               user=allUsers.getUser(i);
           }
       }
       return user;
   }
  
   public User oldestFriend()
   {
       User user=null;
       int max=0;
       for(int i=0;i<allUsers.getCount();i++)
       {
           if(2017-allUsers.getUser(i).getBirthYear()>max)
           {
               max=2017-allUsers.getUser(i).getBirthYear();
               user=allUsers.getUser(i);
           }
       }
       return user;
      
   }
   public LinkedList2 commonFriends(User u1, User u2)
   {
       LinkedList2 temp=new LinkedList2();
       for(int i=0;i<u1.getFriends().getCount();i++)
       {
           if(u2.getFriends().contains(u1.getFriends().getUser(i)) !=-1)
           {
               temp.addNodeToFront(u1.getFriends().getUser(i));
           }
       }
       return temp;
   }
   
   public LinkedList2 getUsersByFriend(User friend){
	   
	   LinkedList2 temp=new LinkedList2();
	   for(int i=0;i<allUsers.size();i++){
		   User u=allUsers.getUser(i);
		   if(u.getFriends().contains(friend)!=-1){
			   temp.addNodeToFront(u);
		   }
	   }
	   return temp;
	   
   }
}

