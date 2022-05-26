package svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	
	Svemir svem = new Svemir();
	Generator gen = new Generator(svem);
	private Button pokreniDugme = new Button("Pokreni!");
	
	private void popuniProzor() {
		svem.setBackground(Color.BLACK);
		
		add(svem, BorderLayout.CENTER);
		
		pokreniDugme.addActionListener((ae) -> {
			gen.pokreni();
		});
		
		Panel donjiPanel = new Panel();
		
		donjiPanel.add(pokreniDugme);
		
		add(donjiPanel, BorderLayout.SOUTH);
		
	}
	
	public Simulator() {
		setBounds(700, 200, 200, 400);
		setResizable(false);
		
		popuniProzor();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Simulator();
		
	}

}
