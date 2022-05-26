package svemir;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Svemir extends Canvas implements Runnable{
	private ArrayList<NebeskoTelo> nebTela = new ArrayList<>();
		
	private Thread nit;
	
	public Svemir dodajTelo(NebeskoTelo nt) {
		nebTela.add(nt);
		return this;
	}
	
	@Override
	public void paint(Graphics g) {
		zavrsi();
		pokreni();

		for (Iterator<NebeskoTelo> it = nebTela.iterator(); it.hasNext();) {
		    NebeskoTelo nt = it.next();
		    
		    if (nt.dohvCentarY() > 500)
		        it.remove();  
		    
		    else
		    	nt.iscrtaj(getGraphics());
		}
	}
	
	public synchronized void pokreni() {
		nit = new Thread(this);
		nit.start();
	}

	public synchronized void zavrsi() {
		if(nit != null) {
			nit.interrupt();
		}
	}

	@Override
	public void run() {
		try {
			nit.sleep(100);
		} catch (InterruptedException e) {}
		
		for(NebeskoTelo nt : nebTela)
			nt.pomeriY(5);
		
		repaint();
		
		synchronized (this) {
			nit = null;
			notify(); 
		}
	}
}
