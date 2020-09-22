package controller;

import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread{
	
	private int idCarro;
	private static int posChegada;
	private String sentido;
	private static int saiu;
	private Semaphore semaforo;
		
	public ThreadCar (int idCarro, Semaphore semaforo,String sentido) {

		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.sentido = sentido;
	}
	
	public void run() {
		
		chegada();
		try {
			semaforo.acquire();
			cruzando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			cruzou();
		}
		
		
	}
	
	public void chegada() {
		
		int distanciaCruzamento = 50;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 11) + 10);
		int tempo = 1000;
		
		while (distanciaPercorrida < distanciaCruzamento) {
			
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idCarro + "| andou " + distanciaPercorrida + " m.");
		}
		posChegada++;
		System.out.println("#" + idCarro + "| foi o " + posChegada + " carro a chegar no cruzamento!");
	}
	
	public void cruzando() {
		
		int tempo = (int) ((Math.random() * 2001) + 1000);
		try {
			sleep(tempo);
			if (posChegada == 1) {
				System.out.println("#" + idCarro + "| está cruzando para o sentido " + sentido);
			} else if (posChegada == 2) {
				System.out.println("#" + idCarro + "| está cruzando para o sentido " + sentido);
			} else if (posChegada == 3) {
				System.out.println("#" + idCarro + "| está cruzando para o sentido " + sentido);
			} else {
				System.out.println("#" + idCarro + "| está cruzando para o sentido " + sentido);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void cruzou() {
		
		saiu++;
		System.out.println("#" + idCarro + "| cruzou");
	}
}
