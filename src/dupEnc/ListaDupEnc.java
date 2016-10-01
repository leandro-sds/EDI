package dupEnc;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDupEnc<T> implements IListaDupEnc<T> {
	
	private int contElementos;
	NoDupEnc<T> noCabeca;
	

	
	public ListaDupEnc() {
		noCabeca = new NoDupEnc<T>(null);
		this.contElementos = 0;
	}

	@Override
	public NoDupEnc<T> getInicio() {
		return this.noCabeca.getAnterior();
	}

	@Override
	public NoDupEnc<T> getFim() {
		return this.noCabeca.getProximo();
	}

	@Override
	public void clear() {
		this.noCabeca.setAnterior(null);
		this.noCabeca.setProximo(null);
		this.contElementos = 0;
	}

	@Override
	public int size() {
		return contElementos;
	}

	@Override
	public boolean estaVazia() {
		return this.noCabeca.getAnterior() == null;
	}

	@Override
	public void InserirInicio(T elemento) {
		
		if(this.contElementos == 0) {
			NoDupEnc<T> novo = new NoDupEnc<T>(elemento);
			this.noCabeca.setAnterior(novo);
			this.noCabeca.setProximo(novo);
		} else {
			NoDupEnc<T> novo = new NoDupEnc<T>(this.noCabeca.getAnterior(), elemento);
			this.noCabeca.getAnterior().setAnterior(novo);
			this.noCabeca.setAnterior(novo);			
		}
		this.contElementos++;
		
	}

	@Override
	public void InserirFim(T elemento) {
		if(this.contElementos == 0) {
			this.InserirInicio(elemento);
		} else {
			//caso a lista esteja preenchida
			NoDupEnc<T> novo = new NoDupEnc<T>(elemento);
			novo.setAnterior(this.noCabeca.getProximo());
			this.noCabeca.getProximo().setProximo(novo);
			this.noCabeca.setProximo(novo);
			this.contElementos++;
		}
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.contElementos;
	}
	
	private NoDupEnc<T> getNoDupEnc(int posicao) {
		if(!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		
		NoDupEnc<T> atual = this.noCabeca.getAnterior();
		for (int i = 1; i < posicao; i++) {
		    atual = atual.getProximo();
		  }
		
		return atual;
	}

	@Override
	public void Inserir(int pos, T elemento) {
		if(pos == 1) { //No inicio
			this.InserirInicio(elemento);
		} else if(pos == this.contElementos + 1) { // No fim
			this.InserirFim(elemento);
		} else {
			NoDupEnc<T> anterior = this.getNoDupEnc(pos - 2);
			NoDupEnc<T> proxima = anterior.getProximo();
			NoDupEnc<T> novo = new NoDupEnc<T>(anterior.getProximo(), elemento);
			novo.setAnterior(anterior);
			anterior.setProximo(novo);
			proxima.setAnterior(novo);
			this.contElementos++;
		}
		
	}

	@Override
	public boolean contem(T elemento) {
		NoDupEnc<T> atual = this.noCabeca.getAnterior();
		
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
		if (this.posicaoOcupada(0) == false)
			throw new IllegalArgumentException("Posição inexistente!");
		this.noCabeca.setAnterior(this.noCabeca.getAnterior().getProximo());
		contElementos--;
		
		if (this.contElementos == 0)
			this.noCabeca.setProximo(null);
	}

	@Override
	public void RemoverFim() {
		NoDupEnc<T> proximo = this.noCabeca.getProximo();
		this.noCabeca.setProximo(proximo.getAnterior());
		contElementos--;
	}

	@Override
	public void Remover(int pos) {
		if(pos == 1) { //No inicio
			this.RemoverInicio();
		} else if(pos == this.contElementos) { // No fim
			this.RemoverFim();
		} else {
			NoDupEnc<T> anterior = this.getNoDupEnc(pos - 1);
			anterior.setProximo(anterior.getProximo().getProximo());
		}
		this.contElementos++;
	}
	
	public void listaInvertida() {
		ListaDupEnc<T> listaAux = new ListaDupEnc<T>();
		NoDupEnc<T> atual = this.noCabeca.getAnterior();
		
		for (int i = 0; i < contElementos; i++) {
			listaAux.InserirInicio(atual.getElemento());
			atual = atual.getProximo();
		}
		 
		int tamanho = contElementos;
		clear();
		NoDupEnc<T> aux = listaAux.getInicio();
		
		for (int i = 0; i < tamanho; i++) {
			InserirFim(aux.getElemento());
			aux = aux.getProximo();
		}
	}
	
	public String toString() {
		//Verificando se a lista está vazia
		if(this.contElementos == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");
		NoDupEnc<T> atual = this.noCabeca.getAnterior();
		
		//Percorrendo até o ultimo elemento
		 for (int i = 0; i < this.contElementos - 1; i++) {
			    builder.append(atual.getElemento());
			    builder.append(",");
			    atual = atual.getProximo();
			  }
		
		//último elemento
		  builder.append(atual.getElemento());
		  builder.append("]");
		  
		  return builder.toString();
	}
	
	public Iterator<T> iterator()
	{
		Iterator<T> iterator1 = new Iterator<T>() {
			NoDupEnc<T> posicao = noCabeca.getAnterior();
			@Override
			public boolean hasNext() {
				return posicao.getProximo() != null;
			}

			@Override
			public T next() {
				if (posicao.getProximo() == null && hasNext())
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
		return iterator1;
	}
}
