package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testthread {
	public static void main(String[] args) {
		Task1 t1 = new Task1();
		Task2 t2 = new Task2();
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t1);
		pool.execute(t2);
	}
}
