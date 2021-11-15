package ups.edu.ec;
import java.net.*;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
public class Cliente {

	public static void main(String[] args) {
		Socket socket =null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWritter = null;
		BufferedReader bufferedReader =null;
		BufferedWriter bufferedWriter = null;
		
		try {
			socket = new Socket ("localhost", 1234);
			
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			outputStreamWritter = new OutputStreamWriter(socket.getOutputStream());
			
			bufferedReader = new BufferedReader(inputStreamReader);
			bufferedWriter = new BufferedWriter(outputStreamWritter);
			
			Scanner sc = new Scanner(System.in);
			while (true) {
				String msgSend = sc.nextLine();
				bufferedWriter.write(msgSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				
				System.out.println("Server: "+bufferedReader.readLine());
				
			}
		}catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(socket !=null)
					socket.close();
				if(inputStreamReader!=null)
					inputStreamReader.close();
				if(outputStreamWritter!=null)
					outputStreamWritter.close();
				if(bufferedReader!=null)
					bufferedReader.close();
				if(bufferedWriter!=null)
					bufferedWriter.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
