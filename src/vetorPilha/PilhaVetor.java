package vetorPilha;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PilhaVetor<T> implements IPilha<T> {
	
	private int topo;
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
	
	public PilhaVetor() {
		this.tamVetor = 10;
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
	public void empilhar(T elemento) {
		VerificarEspaco();
		elementos[topo] = elemento;
		topo++;
	}
	
	
	@Override
	public T desempilhar() {
		if(!estaVazia()) {
			T aux;
			
			aux = elementos[topo];
			elementos[topo] = null;
			topo--;
			
			return aux;
		}
		return null;
	}
		
	@Override
	public T top() {
		if(!estaVazia()) {
			return elementos[topo];
		}
		return null;
	}

	@Override
	public void limpar() {
		elementos = null;
		topo = 0;
	}

	@Override
	public int tamanho() {
		return topo;
	}

	@Override
	public boolean estaVazia() {
		return topo == 0;
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
		if(elementos[topo].equals(elemento)) {
			return 0;
		}
		
		for (int i = 0; i < this.topo; i++) {
			if(elementos[i].equals(elemento))
					return topo - i;
		}
	return -1;
	}
	
	public String toString()
    {
        String valores = "";
        
        valores += "[";
        for (int i = 0; i < this.topo; i++)
        {
            if (this.elementos[i] != null)
                valores += this.elementos[i];
            if (i < this.topo - 1)
                valores += ",";
        }
        
        valores += "]";
        
        return valores;
    }
}
