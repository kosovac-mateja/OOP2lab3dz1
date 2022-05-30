package svemir;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat{
	
	protected int r;
	
	public NebeskoTelo(int centarX, int centarY, int r, Color boja) {
		super(centarX, centarY, boja);
		this.r = r;
	}
	
}
