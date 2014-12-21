/**
 * 
 */
package temp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-1-19 下午03:02:57
 */
public class DaoIntercepter implements InvocationHandler {

	private Object target;
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("come");
		method.invoke(target, args);
		System.out.println("over");
		return null;
	}
	public Object getTarget() {
		return target;
	}
	public void setTarget(Object target) {
		this.target = target;
	}
	
	

}
