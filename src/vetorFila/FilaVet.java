package vetorFila;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilaVet<T> implements IFila<T> {
	
	private int topo;
	private final int inicio;
	private final int tamVetor;
	private T[] elementos;
	private int vlIncremento;
	private Iterator<T> myIterator = new Iterator<T>() {
		
		int posicao = 0;
		
		@Override
		public boolean hasNext() {
			if (posicao < topo) {
				return true;
			} else
				return false;
		}

		@Override
		public T next() {
			if(posicao > topo) {
				throw new NoSuchElementException();
			} else {
				T elem =  elementos[posicao];
				posicao ++;
				return elem;
			}
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}		
	};
	
	public FilaVet() {
		this.tamVetor = 10;
		this.inicio = 0;
		this.topo = 0;
		this.vlIncremento = 10;
		this.elementos = (T[]) new Object[tamVetor];
	}
	
	private void VerificarEspaco() {
		if (elementos.length == topo) {
			T[] elementosMaior = (T[]) new Object[elementos.length+vlIncremento];
			System.arraycopy(elementos, 0, elementosMaior, 0, elementos.length);
			elementos = elementosMaior;
		}
	}

	@Override
	public void limpar() {
		this.elementos = null;
	}

	@Override
	public int tamanho() {
		return this.topo;
	}

	@Override
	public boolean estaVazia() {
		return this.topo == 0;
	}

	@Override
	public boolean contem(T elemento) {
		for (int i = 0; i < this.topo; i++) {
			if(elementos[i].equals(elemento))
				return true;
		}
		return false;
	}

	@Override
	public int distancia(T elemento) {
		for (int i = 0; i < this.topo; i++) {
			if(elementos[i].equals(elemento))
					return topo-1 - i;
		}
	return -1;
	}

	@Override
	public T remover() {
		T aux = elementos[inicio];
		for(int i = 0; i < topo-1; i++) {
			elementos[i] = elementos[i+1];
		}	
		topo--;
		return aux;
	}

	@Override
	public void enfileirar(T elemento) {
		VerificarEspaco();
		if(estaVazia()) {
			elementos[inicio] = elemento;
		} else {
			elementos[topo] = elemento;
		}
		topo++;
		
	}
	
	public String toString()
    {
        String valores = "";
        
        
        valores += "[";
        for (int i = 0; i <= topo-1; i++)
        {
            if (this.elementos[i] != null)
                valores += this.elementos[i];
            if (this.elementos[i] != null && i < topo-1)
                valores += ",";
        }
        valores += "]";

        
        return valores;
    }
}

