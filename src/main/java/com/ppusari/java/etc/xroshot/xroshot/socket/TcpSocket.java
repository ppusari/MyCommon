package com.ppusari.java.etc.xroshot.xroshot.socket;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpSocket {
	
	//private static final Logger logger = LoggerFactory.getLogger(TcpSocket.class);

	Socket sock = null;
 
	public boolean connect(String ip, int port, ReceiveEvent event) {
		boolean bRet = false;
		try {
			sock = new Socket(ip, port);
			Thread t = new Thread(new Received(sock, event));
			t.setDaemon(true);
			t.start();
			bRet = true;
		} catch (Exception e) {			
			System.out.println("MCS Server connection fail.");
			//e.printStackTrace();
		}
		return bRet;
	}

	public void send(String data) {		
		try { 
			OutputStream out = sock.getOutputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			pw.print(data); //pw.println(data); 이렇게 println으로 보내면 안됨			
			pw.flush();	
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void close(){
		try {
			sock.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		finally{
			sock = null;	
		}		
	}

	class Received implements Runnable {		
		ReceiveEvent event = null;
		Socket socket = null;
		
		public Received(Socket socket, ReceiveEvent event) {
			this.event = event;
			this.socket = socket;
		}

		public void run() {
			try {				
				int nRead = -1, nLength = 0;
				byte[] buf = new byte[4096];
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
					
					if (buf[nRead - 1] == '\0') {
						msg = new String(baos.toByteArray(), 0, nLength - 1, "UTF-8");
						
						String[] xml = msg.split("\0");
						for (int i=0; i<xml.length; i++){
							event.Receive(xml[i]); // callback							
						}
						 		
						// init
						nRead = 0;
						baos.reset();
						nLength = 0; 
						for (int i=0; i<4096; i++){
							buf[i] = 0;							
						}
					}
				}	 
			} catch (Exception e) {
				System.out.println("tcp socket disconnection~");
				//e.printStackTrace();
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