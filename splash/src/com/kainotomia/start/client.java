package com.kainotomia.start;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.widget.Button;
import android.widget.Toast;

public class client {
	private static String message="";
	private static Socket client;
	static String ip="";
	private static PrintWriter printwriter;
	static int port=4444;
	static void getIP(String s)
	{
		ip=s;
	System.out.print(ip);
	}
	
	public static void launching(String s)
	{
		
		message=s;
		System.out.println("entered in client launching()   message="+ip);
		new Thread(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			try
			{
				client=new Socket(ip, port);
				printwriter=new PrintWriter(client.getOutputStream());
				printwriter.write(message);
				printwriter.flush();
				printwriter.close();
				client.close();
			}catch(UnknownHostException e)
				{
				e.printStackTrace();
				}catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}).start();


	}

}
