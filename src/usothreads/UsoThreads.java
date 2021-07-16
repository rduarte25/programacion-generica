package usothreads;


import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}


class PelotaHilos implements Runnable {

	
	public PelotaHilos (Pelota unaPelota, Component unComponent) {
		pelota = unaPelota;
		component = unComponent;
	}
	@Override
	public void run() {
		
		System.out.println("Esta del hilo al comenzar " + Thread.currentThread().isInterrupted());
		// TODO Auto-generated method stub
		
		//for (int i=1; i<=3000; i++){
		//while(!Thread.interrupted()) {
		while(!Thread.currentThread().isInterrupted()) {
			pelota.mueve_pelota(component.getBounds());
			
			component.paint(component.getGraphics());
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				Thread.currentThread().interrupt();
				
			}
			
		}
		
		System.out.println("Esta del hilo al terminar " + Thread.currentThread().isInterrupted());
	}
	
	private Pelota pelota;
	private Component component;
	
	
	
}



//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(200,100,700,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		
		dale_1 = new JButton("Hilo 1");
		
		dale_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comienza_el_juego(evento);
			}

		});
		
		laminaBotones.add(dale_1);
		
		dale_2 = new JButton("Hilo 2");
		
		dale_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comienza_el_juego(evento);
			}

		});
		
		laminaBotones.add(dale_2);
		
		dale_3 = new JButton("Hilo 3");
		
		dale_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comienza_el_juego(evento);
			}

		});
		
		laminaBotones.add(dale_3);
		
		detener_1 = new JButton("Detener Hilo 1");
		
		detener_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}

		});
		
		laminaBotones.add(detener_1);
		
		detener_2 = new JButton("Detener Hilo 2");
		
		detener_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}

		});
		
		laminaBotones.add(detener_2);
		
		detener_3 = new JButton("Detener Hilo 3");
		
		detener_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				detener(evento);
			}

		});
		
		laminaBotones.add(detener_3);
		/*
		
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				comienza_el_juego();
			}
			
		});
		
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0);
				
			}
			
		});
		
		ponerBoton(laminaBotones, "Detener", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				detener();
				
			}
			
		});*/
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	
	/*public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}*/
	
	//Añade pelota y la bota 1000 veces
	
	public void comienza_el_juego (ActionEvent evento){
		
					
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable pelotar = new PelotaHilos(pelota, lamina);
			
			if (evento.getSource().equals(dale_1)) {
				thread_1 = new Thread(pelotar);
				thread_1.start();
			} else if (evento.getSource().equals(dale_2)) {
				thread_2 = new Thread(pelotar);
				thread_2.start();
			} else if (evento.getSource().equals(dale_3)) {
				thread_3 = new Thread(pelotar);
				thread_3.start();
			}
			
		
	}
	
	public void detener(ActionEvent evento) {
		
		if (evento.getSource().equals(detener_1)) {
			thread_1.interrupt();
		} else if (evento.getSource().equals(detener_2)) {
			thread_2.interrupt();
		} else if (evento.getSource().equals(detener_3)) {
			thread_3.interrupt();
		}
		
	}
	
	private LaminaPelota lamina;
	
	private Thread thread_1;
	private Thread thread_2;
	private Thread thread_3;
	
	private JButton dale_1;
	private JButton dale_2;
	private JButton dale_3;
	
	private JButton detener_1;
	private JButton detener_2;
	private JButton detener_3;
	
	
}

