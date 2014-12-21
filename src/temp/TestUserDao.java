/**
 * 
 */
package temp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-1-19 下午03:14:23
 */
public class TestUserDao {

	public static void main(String[] args) {
		DaoIntercepter intercepter=new DaoIntercepter();
		UserDao userDao=new UserDaoImp();
		intercepter.setTarget(userDao);
		UserDao userDaoProxy=(UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class}, intercepter);
		userDaoProxy.save();
	}
}
