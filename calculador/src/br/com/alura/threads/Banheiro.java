package br.com.alura.threads;

public class Banheiro {
	
	private boolean ehSujo = true;
	
	public void limpa() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized(this) {
			System.out.println(nome + " entrando no banheiro");
			
			if(!this.ehSujo) {
				System.out.println(nome + ", n�o est� sujo, vou sair");
				return;
			}
			
			System.out.println(nome + " limpando o banheiro");
			this.ehSujo = false;
			
			try {
				Thread.sleep(13000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			this.notifyAll();
			
			System.out.println(nome + " saindo do banheiro");
		}
	}
	
	private void esperaLaFora(String nome) {
		System.out.println(nome + ", eca banheiro est� sujo");
		try {
			this.wait();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fazNumero1() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized(this) {
			System.out.println(nome + "Entrando no banheiro");
			
			if(this.ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + "Fazendo coisa r�pida");
			
			try {
				Thread.sleep(8000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + "Dando discarga");
			System.out.println(nome + "Lavando a m�o");
			System.out.println(nome + "Saindo do banheiro");
		}
		
		
	}
	
	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized(this) {
			System.out.println(nome + "Entrando no banheiro");
			
			if(this.ehSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + "Fazendo coisa demorada");
			
			try {
				Thread.sleep(15000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(nome + "Dando a discarga");
			System.out.println(nome + "Lavando a m�o");
			System.out.println(nome + "Saindo do banheiro");
		}
	}
}
