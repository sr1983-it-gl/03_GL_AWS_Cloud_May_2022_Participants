package rds.multiaz.demo;

import org.junit.Test;

public class DemoTest {

	@Test
	public void test1() {
		
		while (true) {

			Demo.main(null);
			System.out.println("-------------------------------------");
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
