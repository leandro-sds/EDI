package simpEnc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dupEnc.NoDupEnc;

public class ListaSimpEnc<T> implements IListaSimpEnc<T>  {
	
	private NoSimpEnc<T> inicio;
	private NoSimpEnc<T> fim;
	private int totalElementos;
	
	@Override
	public NoSimpEnc<T> getInicio() {
		return inicio;
	}

	@Override
	public NoSimpEnc<T> getFim() {
		return fim;
	}

	@Override
	public void clear() {
		this.inicio = null;
		this.fim = null;
		this.totalElementos = 0;
	}

	@Override
	public int size() {
		return this.totalElementos;
	}

	@Override
	public boolean estaVazia() {
		if(this.inicio == null) {
			return true;
		}
		return false;
	}

	@Override
	public void InserirInicio(T elemento) {
		NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento);
		if(this.totalElementos == 0) {
			//caso a lista esteja vazia
			this.inicio = this.fim = novo;
		} else {
			//caso a lista esteja preenchida
			novo.setProximo(inicio);
			this.inicio = novo;	
		}
		this.totalElementos++;
	}

	@Override
	public void InserirFim(T elemento) {
		if(this.totalElementos == 0) {
			NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento);
			this.inicio = this.fim = novo;
		} else {
			NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento);
			this.fim.setProximo(novo);
			this.fim = novo;
		}
		this.totalElementos++;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalElementos;
	}
	
	private NoSimpEnc<T> getNoSimEnc(int posicao) {
		if(!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		
		NoSimpEnc<T> atual = this.inicio;
		for (int i = 1; i < posicao; i++) {
		    atual = atual.getProximo();
		  }
		
		return atual;
	}

	@Override
	public void Inserir(int pos, T elemento) { //qualquer posição
		if(pos == 1) { //No inicio
			NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento);
			novo.setProximo(inicio);
			this.inicio = novo;	
		} else if(pos == this.totalElementos) {
			NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento);
			this.fim.setProximo(novo);
			this.fim = novo;
		} else {
			NoSimpEnc<T> anterior = this.getNoSimEnc(pos - 1);
			NoSimpEnc<T> novo = new NoSimpEnc<T>(elemento, anterior.getProximo());
			anterior.setProximo(novo);
		}
		this.totalElementos++;
	}

	@Override
	public boolean contem(T elemento) {
		NoSimpEnc<T> atual = this.inicio;
		
		while(atual != null) {
			if(atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProximo();
		}
		return false;
	}

	@Override
	public void RemoverInicio() {
		this.inicio = this.inicio.getProximo();
		totalElementos--; 
		
		if(this.totalElementos == 0) {
			this.fim = null;
		}
	}

	@Override
	public void RemoverFim() {
		if(this.totalElementos == 1) {
			RemoverInicio();
		} else {
			NoSimpEnc<T> anterior = getNoSimEnc(totalElementos - 1);
			this.fim = anterior;
			totalElementos--;
		}
	}
	
	public void RemoverElemento(T elemento) {
		NoSimpEnc<T> atual = this.inicio;
		
		if(contem(elemento)) {
			while(atual != null) {
				if(atual.getElemento().equals(elemento)) {
					atual = atual.getProximo();
					this.totalElementos--;
					break;
				}
				atual = atual.getProximo();
			}
		}
	}
	
	public void BubbleSort() {
		if(size() == 1) {
			return;
		}
		
		
		for (int i =0; i < this.totalElementos; i++) {
			NoSimpEnc<T> atual = this.inicio;
			for (; atual.getProximo() != null; atual = atual.getProximo()) {
				if(((Comparable<T>) atual.getElemento()).compareTo(atual.getProximo().getElemento()) > 0) {
					T tmp = atual.getElemento();
					atual.setElemento(atual.getProximo().getElemento());
					atual.getProximo().setElemento(tmp);
				}
			}
		}
	}
	
	public void SelectionSort() {
		if(size() == 1) {
			return;
		}
		
		NoSimpEnc<T> aux = this.inicio.getProximo();
		
		for (NoSimpEnc<T> i = this.inicio; i != null; i = i.getProximo()) {
			for (; aux != null; aux = aux.getProximo()) {
				if(((Comparable<T>) aux.getElemento()).compareTo(i.getElemento()) < 0) {
					T tmp = aux.getElemento();
					aux.setElemento(i.getElemento());
					i.setElemento(tmp);
				}
			}
			aux = i.getProximo();
		}
	}
	
	public void InsertionSort() {
		if(size() == 1) {
			return;
		}
		
		NoSimpEnc<T> aux = this.inicio.getProximo();
		for (NoSimpEnc<T> i = this.inicio; i != null; i = i.getProximo()) {
			for (; aux != null; aux = aux.getProximo()) {
				//se i for maior que aux troca
				if(((Comparable<T>) i.getElemento()).compareTo(aux.getElemento()) > 0) {
					T aux2;
					aux2 = i.getElemento();
					i.setElemento(aux.getElemento());
					aux.setElemento(aux2);
				}
			}
			aux = i.getProximo();
			
		}
	}
	
	// Métodos de saída
	
	public String toString() {
		//Verificando se a lista está vazia
		if(this.totalElementos == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");
		NoSimpEnc<T> atual = inicio;
		
		//Percorrendo até o ultimo elemento
		 for (int i = 0; i < this.totalElementos - 1; i++) {
			    builder.append(atual.getElemento());
			    builder.append(",");
			    atual = atual.getProximo();
			  }
		
		//último elemento
		  builder.append(atual.getElemento());
		  builder.append("]");
		  
		  return builder.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			NoSimpEnc<T> posicao = inicio;
			@Override
			public boolean hasNext() {
				return posicao.getProximo() != null;
			}

			@Override
			public T next() {
				if (!hasNext())
					throw new NoSuchElementException("Não há mais elementos!");
				else {
					T elemento = posicao.getElemento();
					posicao = posicao.getProximo();
					return elemento;
				}
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}

