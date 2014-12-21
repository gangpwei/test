import java.awt.*;
import javax.swing.JApplet;
 
public class Boll extends JApplet implements Runnable{
        private Thread redBall,blueBall;
        Graphics redPen,bluePen;
        private double t=0;
 
        public void init(){
                redBall=new Thread(this);
                blueBall=new Thread(this);
                redPen=getGraphics();
                redPen.setColor(Color.red);
                bluePen=getGraphics();
                bluePen.setColor(Color.blue);
        }
 
        public void start(){
                redBall.start();
                blueBall.start();
        }
 
        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        public void run() {
                while(true){
                        t=t+0.2;
                        if(Thread.currentThread()==redBall){
                                if(t>20)t=0;
                                redPen.clearRect(0, 0, 38, 300);
                                redPen.fillOval(20, (int)(1.0/2*t*t*3.8), 16, 16);
                                try {
                                        redBall.sleep(50);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                        }else if(Thread.currentThread()==blueBall){
                                 bluePen.clearRect(38, 0, 500, 300);
                                 bluePen.fillOval(38+(int)(16*t), (int)(1.0/2*t*t*3.8), 16, 16);
                                 try {
                                        blueBall.sleep(50);
                                } catch (InterruptedException e) {
                                        e.printStackTrace();
                                }
                        }
                }
        }
        
        public static void main(String[] args) {
			Boll b=new Boll();
			Thread t=new Thread(b);
			t.start();
		}
 
}