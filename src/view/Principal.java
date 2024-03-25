package view;

import java.util.concurrent.Semaphore;
import controller.Corredor;

public class Principal {

	public static void main(String[] args) {
		//Instanciar 
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		//Criar e iniciar as Threads
		for(int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread tCorredor = new Corredor(idPessoa, semaforo, semaforo);
			tCorredor.start();
		}
	}

}
