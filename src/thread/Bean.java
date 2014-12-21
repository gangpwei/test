/**
 * 
 */
package thread;

/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-3-14 上午11:15:33
 */
public class Bean {

	int i=0;
	public synchronized String sysHi(String name){
		i++;
		return "hello "+name+" "+i;
	}
	
	public  synchronized String sysHi2(String name){
		i--;
		return "sysHi2 "+name+" "+i;
	}
}
