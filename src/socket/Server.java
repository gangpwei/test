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
public class Server {

	public void start(){
		try {
			ServerSocket server=new ServerSocket(8888);
			boolean flag=true;
			System.out.println("Server Start");
			while(flag){
				Socket s= server.accept();
				DataInputStream dis=new DataInputStream(s.getInputStream());
				System.out.println("A client connect");
				System.out.println(dis.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server s=new Server();
		s.start();
		
	}
}
