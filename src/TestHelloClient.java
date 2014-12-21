import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceFactory;
import java.net.URL;
import javax.xml.namespace.QName;

public class TestHelloClient {
	public static void main(String[] args) {
		try {
			String wsdlUrl = "http://localhost:8080/axis/HelloClient.jws?wsdl";
			String nameSpaceUri = "http://localhost:8080/axis/HelloClient.jws";
			String serviceName = "HelloClientService";
			String portName = "HelloClient";

			ServiceFactory serviceFactory = ServiceFactory.newInstance();
			Service afService = serviceFactory.createService(new URL(wsdlUrl), new QName(nameSpaceUri, serviceName));
			HelloClientInterface proxy =
											(HelloClientInterface) afService.getPort(new QName(nameSpaceUri, portName), HelloClientInterface.class);
			System.out.println("return value is " + proxy.getName("john"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
