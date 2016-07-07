
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class KnockKnockClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String host = args[0];
		int post = Integer.parseInt(args[1]);
		
		try (
				Socket kkSocket = new Socket(host, post);
				PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
				){
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
			String fromUser;
			
			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equals("Bye"))
					break;
				
				fromUser = stdIn.readLine();
				if(fromUser != null) {
					System.out.println("Client: " + fromUser);
					out.println(fromUser);
				}
				
			}
				
		} catch (IOException e) {
			System.out.print("Err");
			
		}
	}
	
	
	

}
