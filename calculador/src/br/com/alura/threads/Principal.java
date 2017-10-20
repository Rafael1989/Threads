package br.com.alura.threads;

public class Principal {
	public static void main(String[] args) {
		String nome = "da";
		
		Thread threadAutores = new Thread(new TarefaBuscaNome("autores.txt",nome));
		Thread threadAssinaturas1 = new Thread(new TarefaBuscaNome("assinaturas1.txt", nome));
		Thread threadAssinaturas2 = new Thread(new TarefaBuscaNome("assinaturas2.txt", nome));
		
		threadAutores.start();
		threadAssinaturas1.start();
		threadAssinaturas2.start();
		
		
	}
}
