package ebank;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import web.stockmarket;
import web.stockmarket2;

public class Main {

	public static void main(String[] args) throws IOException {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				try {
					stockmarket.main();
					stockmarket2.main();
					System.out.println("Web Pages Create");
				} catch (IOException e) {
					
				}
			}
		}, 0, 59000);
		Login x=new Login();
		x.process();
	}

}
