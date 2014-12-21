/**
 * 
 */
package thread;

import thread.ThreadTest2.DescThread;
import thread.ThreadTest2.IncThread;

/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-3-14 上午11:12:56
 */
public class TestSychnorized {
	Bean b=new Bean();
	static TestSychnorized t=new TestSychnorized();
	static Thread incThread=t.new IncThread();
	static Thread descThread=t.new DescThread();
	static boolean flag=false;
	public static void main(String[] args) {
		incThread.start();
	}
	
	public class IncThread extends Thread{
		public void run() {
			System.out.println(b.sysHi(Thread.currentThread().getName()));
			descThread.start();
		}
	}
	
	class DescThread extends Thread{
		public void run(){
			flag=true;
			System.out.println(b.sysHi2(Thread.currentThread().getName()));
			
		}
	}
}
