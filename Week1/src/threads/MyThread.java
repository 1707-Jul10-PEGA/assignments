package threads;

public class MyThread extends Thread {

	public void run() {
		
		for (int i = 1; i < 101; i++) {
			Thread t = Thread.currentThread();
			System.out.println("Inside thread " + t.getName());
			
			System.out.println(i);
		}
		
	}
}
