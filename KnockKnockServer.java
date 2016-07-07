/*
 * Tutorial: https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockKnockServer {
	public static void main(String[] args) throws IOException {
	
		int portNum = 3306;
		
		try(
				//create ServerSocket object to listen to a specific port
				ServerSocket serverSocket = new ServerSocket(portNum);
				
				//Server accepts request from a client
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
		{
				System.out.print("Hello");
				String inputLine, outputLine;
				//Initiate conversation with client
				KnockKnockProtocol kkp = new KnockKnockProtocol();
				//get the first message that the server sends to the client
				outputLine = kkp.processInput(null);
				out.println(outputLine);
				
				//Communication between the client by reading from and writing to the socket
				//As long as the client and server are still communicating, the server reads to and writes to the socket
				while((inputLine = in.readLine()) != null) {
					outputLine = kkp.processInput(inputLine);
					out.println(outputLine);
					if (outputLine.equals("Bye"))
						break;
				}
		}
		
	}

}
