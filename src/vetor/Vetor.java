package vetor;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Vetor<T> implements IVetor<T> {
	
	private final int tamVetor;
	private T[] elementos;
	private int contElementos;
	private int vlIncremento;
	private Iterator<T> myIterator = new Iterator<T>() {
		
		int posicao = 0;
		
		@Override
		public boolean hasNext() {
			if (posicao < contElementos) {
				return true;
			} else
				return false;
		}

		@Override
		public T next() {
			if(posicao > contElementos) {
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
	
	public Vetor() {
		tamVetor = 10;
		elementos =  (T[]) new Object[tamVetor];
		contElementos = 0;
		this.vlIncremento = 10;
	}
	
	public Vetor(int tam) {
		tamVetor = tam;
		elementos =  (T[]) new Object[tamVetor];
		contElementos = 0;
		this.vlIncremento = 10;
	}
	
	public void VerificarEspaco() {
		if (elementos.length == contElementos) {
			T[] elementosMaior = (T[]) new Object[elementos.length+vlIncremento];
			System.arraycopy(elementos, 0, elementosMaior, 0, elementos.length);
			elementos = elementosMaior;
		}
	}

	@Override
	public void Adicionar(Object elemento) {
		VerificarEspaco();
		elementos[contElementos] = (T)elemento;
		contElementos++;
	}

	@Override
	public void Adicionar(int posicao, Object elemento) throws IndexOutOfBoundsException {
		VerificarEspaco();
		for(int i = contElementos-1; i <= posicao ; i--) {
				elementos[i++] = elementos[i];
		}
		elementos[posicao] = (T)elemento;
		contElementos++;
	}	

	@Override
	public void AdicionarInicio(Object elemento) {
		Adicionar(0, elemento);
	}

	@Override
	public void Remover(int posicao) {
		for(int i = posicao; i < contElementos-1; i++) {
			elementos[i] = elementos[i+1];
		}
		contElementos--;
	}

	@Override
	public void RemoverElemento(Object elemento) {
		int pos = 0;	
		if(contem(elemento)) {
				for(int i = 0; i < contElementos; i++) {
					if(elementos[i] == elemento) {
						pos = i;
					}
				}
				for(int i = pos; i < contElementos - 1; i++) {
					elementos[i] = elementos[i+1];
				}
		}
		contElementos--;
	}

	@Override
	public void RemoverInicio() {
		for(int i = 0; i < contElementos -1; i++) {
			elementos[i] = elementos[i+1];
		}
		contElementos--;		
	}

	@Override
	public void RemoverFim() {
		elementos[contElementos - 1] = null;
		contElementos--;
	}

	@Override
	public int Tamanho() {
		return contElementos;
	}

	@Override
	public void Limpar() {
		for(int i = 0; i < contElementos; i++) {
			elementos[i] = null;
		}
		contElementos = 0;
	}

	@Override
	public boolean contem(Object elemento)  {
		for(int i = 0; i < elementos.length; i++) {
			if(elementos[i] == elemento) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator iterator() {
		return myIterator;
	}
}