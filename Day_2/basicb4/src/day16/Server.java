package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	ServerSocket ss;
	BufferedReader br,in;
	PrintWriter out;
	Socket s;
	
	public Server() throws Exception{
		
		ss=new ServerSocket(2000);
		
		System.out.println("Server ready.....");
		
		while(true) {
			
			s=ss.accept();
			
			out=new PrintWriter(s.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Message For Client..:");
			String msgToClient=in.readLine();
			out.println(msgToClient);
			
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String msg=br.readLine();
			System.out.println("Message From Client..:"+msg);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		new Server();
	}
	
	//ClientHandler class
	private static class ClientHandler implements Runnable {
	    private final Socket clientSocket;

	    // Constructor
	    public ClientHandler(Socket socket)
	    {
	        this.clientSocket = socket;
	    }

	    public void run()
	    {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        try {
	                
	              // get the outputstream of client
	            out = new PrintWriter(
	                clientSocket.getOutputStream(), true);

	              // get the inputstream of client
	            in = new BufferedReader(
	                new InputStreamReader(
	                    clientSocket.getInputStream()));

	            String line;
	            while ((line = in.readLine()) != null) {

	                // writing the received message from
	                // client
	                System.out.printf(
	                    " Sent from the client: %s\n",
	                    line);
	                out.println(line);
	            }
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	        finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (in != null) {
	                    in.close();
	                    clientSocket.close();
	                }
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}



