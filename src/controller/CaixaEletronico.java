package controller;

import java.util.concurrent.Semaphore;

public class CaixaEletronico extends Thread{
	private Semaphore s1, s2;
	private int id;
	
	public CaixaEletronico(int id, Semaphore s1, Semaphore s2) {
		this.id = id;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	@Override
	public void run() {
		int opc = (int)((Math.random()*101)+1);
		if (opc % 2 == 0) {
			try {
			s1.acquire();
				saque();
			} catch (InterruptedException e) {
			e.printStackTrace();
			}finally {
			s1.release();
			}
		}
		else {
			try {
				s2.acquire();
				deposito();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				s2.release();
			}
		}
			
	}

	private void saque() {
		System.out.println("Conta "+id+" está sacando");
	}

	private void deposito() {
		System.out.println("Conta "+id+" está depositando");
	}
	
}
