/**
 * 
 */
package socket;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-3-8 上午10:33:33
 */
public class UdpClient {

	public static void main(String[] args) {
		try {
			byte[] buf=new String("hello").getBytes();
			long i=1000l;
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			DataOutputStream dos=new DataOutputStream(baos);
			dos.writeLong(i);
			byte[] b=baos.toByteArray();
			System.out.println(b.length);
//			DatagramPacket dp=new DatagramPacket(buf, buf.length,new InetSocketAddress("127.0.0.1", 8888));
//			DatagramSocket ds=new DatagramSocket(9999);
//			ds.send(dp);
//			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
