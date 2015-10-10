 package com.ppusari.java.socket.tcp.expansion;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		// 서버수신
		ReceiveEvent event = new ReceiveEvent() {			
			@Override
			public void Receive(String msg) {
				System.out.println("서버수신: " + msg);				
			}
		};
		
		// 서버시작
		new TcpServer().start(7000, event);	
	}
}

class TcpServer {	
	
	boolean terminater = false;
	
	public void start(int port, ReceiveEvent evnt){
	
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server open port is " + port);
			
			while (!terminater){
				Socket s = serverSocket.accept();
				System.out.println("[" + s.getInetAddress() + ": " + s.getPort() + "] 에서 접속하였습니다.");
				
				Thread t = new Thread(new Receiving(s, evnt));
				t.setDaemon(true);
				t.start();				
			}
			
			serverSocket.close();			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		terminater = true;
	}
	
	private class Receiving implements Runnable {

		Socket socket = null;
		ReceiveEvent event = null;
				
		public Receiving(Socket socket, ReceiveEvent event) {
			this.socket = socket;
			this.event = event;
		}
		
		@Override
		public void run() {
			
			try {
				int nRead = -1, nLength = 0;				
				InputStream in = socket.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
				while (true) {
					String msg = "";
					byte[] buf = new byte[2048];

/*					// readLine test--------------------------------------------------
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String line;
					while ((line = br.readLine()) != null) {
						event.Receive(line);
				 					
						// echo
						OutputStream out = null;
						PrintWriter pw = null;
						out = socket.getOutputStream();
						pw = new PrintWriter(new OutputStreamWriter(out));
						pw.println(line);
						pw.flush();
					}
					//----------------------------------------------------------------
 */
					
					while ((nRead = in.read(buf)) > 0) {
						nLength += nRead;
						baos.write(buf, 0, nRead);
						if (buf[nRead] == '\0') {
							msg = new String(baos.toByteArray(), 0, nLength - 1, "UTF-8");
							event.Receive(msg);
							nLength = 0;
							baos.reset();
							
							//buf = new byte[]{};
							for (int i=0; i<2048; i++){
								buf[i] = 0;
							}							
							
							// echo
							OutputStream out = null;
							PrintWriter pw = null;
							out = socket.getOutputStream();
							pw = new PrintWriter(new OutputStreamWriter(out));
							pw.println(msg);
							pw.flush();
						}
					} 
				}

			} catch (Exception e) {
				System.out.println("Client exit");
				//e.printStackTrace();
			}
			finally{
				System.out.println("Receiving finally.");
			}
			
			System.out.println("Receiving Exit");
		}		
	}
}


