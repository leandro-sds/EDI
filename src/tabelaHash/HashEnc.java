package tabelaHash;

import java.util.Iterator;
import simpEnc.ListaSimpEnc;
import vetor.Vetor;

public class HashEnc<T> implements ITabelaHash<T> {
	
	private int tamHash;
	private Vetor<ListaSimpEnc<T>> hashEnc;
	private int contElementos;
	/*private Iterator*/

	
	public HashEnc() {
		this.tamHash = 11;
		this.hashEnc = new Vetor<ListaSimpEnc<T>>(this.tamHash);
		this.contElementos = 0;
	}

	@Override
	public void inserir(T elemento) {
		if(elemento != null) {
			ListaSimpEnc<T> aux = new ListaSimpEnc<T>();
			
			verificarCarga();
			aux.InserirFim(elemento);
			this.hashEnc.Adicionar(this.hash(elemento), aux);
			this.contElementos++;
		}
	}

	@Override
	public void remover(T elemento) {
		int k = 0;
			for (ListaSimpEnc<T> i : hashEnc) {
				if(k == this.hash(elemento)) {
					i.RemoverElemento(elemento);
				}
			}
	}

	@Override
	public boolean contem(T elemento) {
		for (ListaSimpEnc<T> i : hashEnc) {
			if(i != null) {
				for (T item : i) {
					if(item != null && item.equals(elemento)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public int hash(T elemento) {
		return Math.abs(elemento.hashCode()% this.tamHash);
		
	}

	@Override
	public int tamanho() {
		return contElementos;
	}

	@Override
	public ListaSimpEnc<T> todosElementos() {
		ListaSimpEnc<T> listaAux = new ListaSimpEnc<T>();
		for (ListaSimpEnc<T> i : hashEnc) {
	/* Dentro de cada posição em hashEnc ele vai procurar um elemento do tipo lista encadeada*/
			if(i != null) { 
				for (T item : i) {
	/* Dentro de cada item do tipo lista encadeada ele vai procurar itens do tipo T */
					listaAux.InserirFim(item);
				}	
			}
		}
		
		return listaAux;
	}

	@Override
	public void verificarCarga() {
		if(this.contElementos / this.tamHash > 0.75 ) {
			redimensionarTabela();
		}
		
	}

	@Override
	public void redimensionarTabela() {
		Vetor<ListaSimpEnc<T>> hashEncAux = new Vetor<ListaSimpEnc<T>>(this.tamHash * 2);
		for (ListaSimpEnc<T> i : hashEnc) {
			hashEncAux.Adicionar(i);
		}
		
		this.hashEnc.Limpar();
		this.hashEnc = hashEncAux;
		this.tamHash = this.tamHash * 2;
	}
}
