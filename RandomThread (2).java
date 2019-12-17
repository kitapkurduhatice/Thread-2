import java.util.Random;

class Threads extends Thread {

	@Override
	public void run() {

		try {
			int a = RandomThread.getRandomNumberInRange(5000, 15000);
			Thread.sleep(a);
			System.out.println("bana müsade (thread " + getName() + ")");
			doldur();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doldur() {
		Thread thread = Thread.currentThread();
		System.out.println("thread "+thread.getName() + "! Yolun açýk olsun...");
	}

}

public class RandomThread {

	public static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static void main(String[] args) throws InterruptedException {
		Threads t1 = new Threads();
		t1.setName("1");
		t1.start();

		Threads t2 = new Threads();
		t2.setName("2");
		t2.start();

		Threads t3 = new Threads();
		t3.setName("3");
		t3.start();
		// System.out.println(t1.isAlive());

		System.out.println("Thread " + t1.getName() + " oluþturuldu..");
		System.out.println("Thread " + t2.getName() + " oluþturuldu..");
		System.out.println("Thread " + t3.getName() + " oluþturuldu.. \n");

		// Thread.sleep(1000);
		t1.join(1000);
		t2.join(1000);
		t3.join(1000);

	}
}