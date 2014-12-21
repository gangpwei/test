/**
 * 
 */
package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-3-8 上午10:33:33
 */
public class Client {

	public static void main(String[] args) {
		try {
			Socket s=new Socket("127.0.0.1",8888);
			OutputStream os=s.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF("hello mm");
			dos.flush();
			dos.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
