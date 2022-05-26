package svemir;

import java.awt.*;
import java.util.Random;

public class Kometa extends NebeskoTelo {
	
	private boolean inic = false;
	private int arrX[] = new int[5];
	private int arrY[] = new int[5];
	
	public Kometa(int centarX, int centarY, int r) {
		super(centarX, centarY, r, Color.GRAY);
	}
	
	@Override
	protected int dohvX(double ugao) {
		return (int)(r * Math.cos(ugao));
	}

	@Override
	protected int dohvY(double ugao) {
		return (int)(r * Math.sin(ugao));
	}

	@Override
	public void iscrtaj(Graphics g) {
		Color staraBoja = g.getColor();
		g.setColor(boja);
		g.translate(dohvCentarX(), dohvCentarY());
		
		if(inic == false) {
			double pomeraj = 2 * Math.PI / 5;
			int i = 0;
			
			for(double ugao = new Random().nextDouble(2 * Math.PI), k = ugao; 
					ugao < 2 * Math.PI + k; ugao += pomeraj, i++) {
				if(i < 5) {
					arrX[i] = dohvX(ugao);
					arrY[i] = dohvY(ugao);
				}
			}
			inic = true;
		}
		
		g.fillPolygon(arrX, arrY, 5);
		g.setColor(staraBoja);
	}
}
