import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Vector;
public class MyServer 
{
	Vector v=new Vector();
	public static void main(String args[])throws IOException
	{
	
		System.out.print("Enter this IP Address : ");
		System.out.println(InetAddress.getLocalHost()+"\n");
	
		Socket clientsocket = null;
		ServerSocket serversocket=null;
		try
		{
			serversocket =new ServerSocket(4444);
			System.out.println("Server is Activated...");
			
		}catch(Exception e)
		{
	}
		
				String mes;
		while(true)
		{
			clientsocket=serversocket.accept();
			 Scanner in1 = new Scanner(clientsocket.getInputStream());
			if(in1.hasNext())
			{
				
				mes=in1.nextLine();
				if(! new MyServer().checkExistance(mes))
				{	new MyServer().v.add(mes);
				System.out.println("Launching : "+mes);
				Process p;
				String filePath = mes;
				try {
					if(mes=="iexplore")
						p = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe");
					else
					p = Runtime.getRuntime().exec("cmd /c start "+mes);
					//				p.destroy();
					p = Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
				}
				
			}
			
		}
	
	}
	boolean checkExistance(String s)
	{
		for(int i=0;i<v.size();i++)
		{
			if(v.elementAt(i)==s)
			{
				
			}
			
			
		}
		return false;
		
	}

}
