/**
 * 
 */
package thread;

/**
 * @description: 
 * @author 魏钢鹏
 * @version 创建时间：2012-3-14 上午10:33:20
 */
public class ThreadTest2 {

	int num=0;
	
	
	public static void main(String[] args) {
		ThreadTest2 t=new ThreadTest2();
		for (int i = 0; i < 2; i++) {
			Thread incThread=t.new IncThread();
			Thread descThread=t.new DescThread();
			incThread.start();
			descThread.start();
		}
		
	}
	public synchronized void inc(){
		num++;
		System.out.println(Thread.currentThread().getName()+" inc : "+num);
	}
	
	public synchronized void desc(){
		num--;
		System.out.println(Thread.currentThread().getName()+" desc : "+num);
	}
	
	public class IncThread extends Thread{
		
		public void run() {
			for (int i = 0; i < 100; i++) {
				inc();
			}
		}
	}
	
	class DescThread extends Thread{
		public void run(){
			for (int i = 0; i < 100; i++) {
				desc();
			}
		}
	}
	
	public String sysHi(String name){
		return "hello "+name;
	}
}
