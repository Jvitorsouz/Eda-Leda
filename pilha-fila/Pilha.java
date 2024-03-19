import java.util.*;

public class Pilha{
	
	private int topo;
	//Pilha de arrays
	private String[] pilha;

	public Pilha(int capacidade){
		this.topo = -1;
		this.pilha = new String[capacidade];
	}

	public boolean isEmpty(){
		return this.topo == -1;
	}

	public boolean isFull(){
		return this.topo+1 == this.pilha.length;
	}

	public void add(String elemento){
		if(isFull()) throw new RuntimeException("Pilha cheia");
		this.pilha[++this.topo] = elemento;
	}

	public String pop(){
		if(isEmpty()) throw new NoSuchElementException();
		return this.pilha[this.topo--];
	}

	public String peek(){
		return this.pilha[this.topo];
	}

	
}
