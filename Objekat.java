package svemir;

import java.awt.*;

public abstract class Objekat {
	protected int centarX, centarY;
	protected Color boja;
	
	public Objekat(int centarX, int centarY, Color boja) {
		this.centarX = centarX;
		this.centarY = centarY;
		this.boja = boja;
	}
	
	public int dohvCentarX() {
		return centarX;
	}
	public int dohvCentarY() {
		return centarY;
	}
	
	public void pomeriX(int pomeraj) {
		centarX += pomeraj;
	}
	
	public void pomeriY(int pomeraj) {
		centarY += pomeraj;
	}
	
	public abstract void iscrtaj(Graphics g);

	protected abstract int dohvX(double ugao);

	protected abstract int dohvY(double ugao);
	
	
	
}
