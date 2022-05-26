package svemir;

import java.awt.*;
import java.util.Random;

public class Generator extends Thread{
	private Svemir svem;
	private boolean pokrenuto = false;

	public Generator(Svemir svem) {
		this.svem = svem;
	}
	
	public synchronized void pokreni() {
		if(!pokrenuto) {
			this.start();
			pokrenuto = true;
		}
	}
	
	public synchronized void zavrsi() {
		if(this != null) {
			this.interrupt();
			pokrenuto = false;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			int x = new Random().nextInt(200);
			int y = 0;
			int r = new Random().nextInt(10, 30);
			
			svem.dodajTelo(new Kometa(x, y, r));
			
			try {
				sleep(900);
			} catch (InterruptedException e) { }
		}
	}
	
}
