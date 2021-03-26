package view;

import java.util.concurrent.Semaphore;

import controller.CaixaEletronico;

public class Main {

	public static void main(String[] args) {
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(1);
		int qtd = 20;
		for (int id = 1; id <= qtd; id++) {
			Thread t = new CaixaEletronico(id, s1, s2);
			t.start();
		}
	}

}
