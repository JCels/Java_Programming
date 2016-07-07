//Echo Sockets are used to test if the connection between the server and client exists. 
//This tutorial uses reader and writers so that it can write Unicode chars over the socket
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class echoSocket {
	public static void main(String[] args) throws UnknownHostException, IOException {

		//MAMP Local Host information
		String host = "localhost";
		int port = 3306;
		//To send data through the socket to the server, the EchoClient need to write to the PrintWriter object
		// To get the server's response, the EchoClient needs to read it from the BufferedReader Object (serverMsg)

		try (
				//create a new socket
				Socket echo = new Socket(host, port);
				//get socket's output stream and open a PrintWriter on it
				PrintWriter outputMsg = new PrintWriter(echo.getOutputStream(), true);
				//Get socket's input stream and open a BufferedReader on it
				BufferedReader inputMsg = new BufferedReader(new InputStreamReader(echo.getInputStream()));
				BufferedReader serverMsg= new BufferedReader(new InputStreamReader(System.in)))
		{


			//Loop reads a line from the standard input stream and instantaneously sends it to the server
			//by writing it to the PrintWriter (which is connected to the socket)
			String usrInput;
			while((usrInput = serverMsg.readLine()) != null) {
				outputMsg.println(usrInput);
				//Reads line from BufferedReader connected to the socket
				//ReadLine() waits until the server echos the information back to the Echo
				System.out.println("echo: " + inputMsg.readLine());
				echo.close();
			}
		}

	}

}
