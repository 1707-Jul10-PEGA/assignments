package threads;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new MyThread();
		t.("Martha");
		t.start();
	}

}
