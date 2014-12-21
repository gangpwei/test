/**
 * 
 */
package socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;



/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-3-8 上午10:20:08
 */
public class UdpServer {

	public void start(){
		try {
			DatagramSocket server=new DatagramSocket(8888);
			byte[] buf=new byte[1024];
			DatagramPacket p=new DatagramPacket(buf,buf.length);
			boolean flag=true;
			System.out.println("Server Start");
			while(flag){
				server.receive(p);
				System.out.println(new String(buf,0,buf.length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UdpServer s=new UdpServer();
		s.start();
		
	}
}
