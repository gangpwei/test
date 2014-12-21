/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2011-6-3 下午06:03:22
 */
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class TestHelloClient2 {

	public static void main(String[] args) {
		try {
			String endpoint = "http://localhost:8080/Axis/HelloClient.jws";

			Service service = new Service();
			Call call = null;

			call = (Call) service.createCall();

			call.setOperationName(new QName("http://localhost:8080/axis/HelloClient.jws", "getName"));
			call.setTargetEndpointAddress(new java.net.URL(endpoint));

			String ret = (String) call.invoke(new Object[] { "zhangsan" });
			System.out.println("return value is " + ret);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
