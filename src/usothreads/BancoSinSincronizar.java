package usothreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Banco banco = new Banco();
		
		for(int i = 0; i < 100; i++) {
			
			EjecucionTransferencia transferencia = new EjecucionTransferencia(banco, i, 2000);
			Thread thread = new Thread(transferencia);
			thread.start();
		}
	}

}

class Banco {
	
	public Banco() {
		
		
		cuentas = new double[100];
		
		for (int i = 0; i < cuentas.length; i++) {
			cuentas[i] = 2000;
		}
		
		//saldoSuficiente = cierre.newCondition();
		
	}
	
	public synchronized void transferencia(int cuenta_origen, int cuenta_destino, double cantidad) throws InterruptedException {
		
		//cierre.lock();
		
		//try {
			
			while (cuentas[cuenta_origen] < cantidad) {
				//saldoSuficiente.await();
				wait();
			}
			
			System.out.println(Thread.currentThread());
			
			cuentas[cuenta_origen] -= cantidad;
			
			System.out.printf(" %10.2f de %d para %d ", cantidad, cuenta_origen, cuenta_destino);
			
			cuentas[cuenta_destino] +=cantidad;
			
			System.out.printf("Saldo total: %10.2f%n ", getSaldoTotal());
			notifyAll();
			//saldoSuficiente.signalAll();
		//} finally {
			//cierre.unlock();			
		//}
		
	}
	
	
	public double getSaldoTotal() {
		
		double suma_cuentas = 0;
				
		for(double cuenta: cuentas) {
			
			suma_cuentas += cuenta;
		}
		
		return suma_cuentas;
	}
	
	private final double[] cuentas;
	
	//private Lock cierre = new ReentrantLock();
	
	//private Condition saldoSuficiente;
}

class EjecucionTransferencia implements Runnable {

	public EjecucionTransferencia (Banco banco, int origen, double maximo) {
		
		this.banco = banco;
		this.origen = origen;
		this.maximo = maximo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while (true) {
					
				int destino = (int)(Math.random() * 100);
					
				double cantidad = maximo * Math.random();
					
				banco.transferencia(origen, destino, cantidad);
				Thread.sleep((int)(Math.random()*10));
			} 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private Banco banco;
	private int origen; 
	private double maximo;
}

