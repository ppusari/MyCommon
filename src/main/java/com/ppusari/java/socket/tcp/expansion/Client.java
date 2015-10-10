package com.ppusari.java.socket.tcp.expansion;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		// 서버수신
		ReceiveEvent event = new ReceiveEvent() {			
			@Override
			public void Receive(String msg) {
				System.out.println("서버수신: " + msg);				
			}
		};
		
		// 서버시작
		new TcpClient(event).connect("localhost", 7000);	
	}
}


class TcpClient {
	
	Socket socket = null;
	ReceiveEvent event = null;
		
	public TcpClient(ReceiveEvent event) {
		this.event = event;
	}
	
	public void connect(String ip, int port){
		try {
			socket = new Socket(ip, port);
			new Receiving(socket);
		} catch (Exception e) {
			e.printStackTrace();
		} 			
	}
	
	public void send(String msg){		
		try { 
			OutputStream out = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			pw.println(msg);
			pw.flush();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class Receiving implements Runnable {
		
		Socket socket = null;
		
		public Receiving(Socket socket) {
			this.socket = socket;
			new Thread(this).start();			
		}
		
		public void run() {
			try {				
				int nRead = -1, nLength = 0;
				byte[] buf = new byte[20480];
				String msg = "";
		 
				InputStream in = socket.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(in);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();					
				
/*				// readLine test--------------------------------------------------
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String line;
				while ((line = br.readLine()) != null) 
					System.out.println(line);							
				//----------------------------------------------------------------
*/								
				while (true) {
					nRead = bis.read(buf);
					nLength += nRead;
					baos.write(buf, 0, nRead);						
					if (buf[nRead] == '\0') {
						msg = new String(baos.toByteArray(), 0, nLength - 1, "UTF-8");
						event.Receive(msg); // callback
						nRead = 0;
						baos.reset();
						nLength = 0;
						//buf = new byte[]{};		
						for (int i=0; i<2048; i++){
							buf[i] = 0;
						}	
					}
				}	 
			} catch (Exception e) {
				e.printStackTrace();
			} finally{				
				try {
					socket.close();					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
	}

}