package ups.edu.ec;
import java.net.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Server {

	public static void main(String[] args) throws IOException {
		Socket socket =null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWritter = null;
		BufferedReader bufferedReader =null;
		BufferedWriter bufferedWriter = null;
		ServerSocket serverSocket = null;
		
		serverSocket = new ServerSocket(1234);
		
		while(true) {
			try {
				socket = serverSocket.accept();
				
				inputStreamReader = new InputStreamReader(socket.getInputStream());
				outputStreamWritter = new OutputStreamWriter(socket.getOutputStream());
				
				bufferedReader = new BufferedReader(inputStreamReader);
				bufferedWriter = new BufferedWriter(outputStreamWritter);
				while(true) {
					String msgReceive = bufferedReader.readLine();
					System.out.println("Cliente: "+ msgReceive);
					
					bufferedWriter.write("msg Received");
					bufferedWriter.newLine();
					bufferedWriter.flush(); 
					if (msgReceive.equalsIgnoreCase("BYE"))
						break;
				}
				socket.close();
				inputStreamReader.close();
				outputStreamWritter.close();
				bufferedReader.close();
				bufferedWriter.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
