package simpEncPilha;

import simpEnc.NoSimpEnc;

public class PilhaSimpEnc<T> implements IPilha<T> {
	
	private int contElementos;
	private NoSimpEncP<T> inicio;
	private NoSimpEncP<T> topo;
	
	public PilhaSimpEnc() {
		this.contElementos = 0;
	}

	@Override
	public T top() {
		return (T) this.topo;
	}

	@Override
	public void limpar() {
		this.inicio = null;
	}

	@Override
	public int tamanho() {
		return contElementos;
	}

	@Override
	public boolean estaVazia() {
		return contElementos == 0;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.contElementos;
	}
	
	private NoSimpEncP<T> getNoSimEnc(int posicao) {
		if(!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		
		NoSimpEncP<T> atual = this.inicio;
		for (int i = 1; i < posicao; i++) {
		    atual = atual.getProximo();
		  }
		return atual;
	}

	@Override
	public boolean contem(T elemento) {
		if(!estaVazia()) {
			NoSimpEncP<T> atual = this.inicio;
			for (int i = 1; i < this.contElementos; i++) {
				if(atual.getElemento().equals(elemento)) {
					return true;
				} else {
					atual = atual.getProximo();
				}
			  }
		}
		return false;
	}

	@Override
	public int distancia(T elemento) {
		if(this.topo.equals(elemento)) {
			return 0;
		}
		
		int dist = 0;
		if(!estaVazia()) {
			NoSimpEncP<T> atual = (NoSimpEncP<T>) elemento;
			for (int i = 1; i < this.contElementos; i++) {
				if(atual.getElemento().equals(this.topo)) {
					return dist;
				} else {
					atual = atual.getProximo();
					dist++;
				}
			}
		}
		return -1;
	}

	@Override
	public T desempilhar() {
		if(!estaVazia()) {
			T aux;
			aux = this.topo.getElemento();
			this.topo = topo.getProximo();
			return aux;
		}
		return null;
	}

	@Override
	public void empilhar(T elemento) {
		NoSimpEncP<T> novo = new NoSimpEncP<T>(elemento);
		if(this.contElementos == 0) { //caso a lista esteja vazia
			this.inicio = this.topo = novo;
		} else {
			this.topo.setProximo(novo);
			this.topo = novo;
		}
	}

}
