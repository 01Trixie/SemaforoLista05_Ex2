package controller;

import java.util.concurrent.Semaphore;

public class Corredor extends Thread {
	private int idPessoa;
	private Semaphore semaforo;
	private static int posChegada;

	public Corredor(int idPessoa, Semaphore porta, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	public void run () {
		pessoaCorrendo();
		try {
			semaforo.acquire();
			chegada();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			semaforo.release();
		}
	}
	
	private void pessoaCorrendo() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random()* 41)+ 20);
		int tempo = 1000;
		
		
		while(distanciaTotal > distanciaPercorrida) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa# " + idPessoa + " ja andou " + distanciaPercorrida + "m");
		}
		System.out.println("A pessoa #" + idPessoa + " foi o " + (posChegada + 1) + "° a chegar na porta.");
		posChegada++;
	}
	
	private void chegada() {
		int tempo = (int) ((Math.random() * 1001) +2000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A pessoa #" + idPessoa + " passou pola porta!");
	}
	

}
