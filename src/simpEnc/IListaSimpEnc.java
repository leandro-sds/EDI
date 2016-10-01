package simpEnc;

import java.util.Iterator;

public interface IListaSimpEnc<T> {
	// Retorna a referencia do n— que encontra-se no inicio da lista
	public NoSimpEnc<T> getInicio();

	// Retorna a referencia do n— que encontra-se no fim da lista
	public NoSimpEnc<T> getFim();

	// Limpa toda a lista
	public void clear();

	// tamanho de elementos que a lista possui
	public int size();

	// Retorna se a lista esta ou nao vazia
	public boolean estaVazia();

	// Inserir um elemento no inicio da lista
	public void InserirInicio(T elemento);

	// Inserir um elemento no fim da lista
	public void InserirFim(T elemento);

	// Inserir um elemento na posição indicada pelo parametro pos
	public void Inserir(int pos, T elemento);

	// Indica se a lista possui o elemento
	public boolean contem(T elemento);

	// Remove o primeiro elemento da lista
	public void RemoverInicio();

	// Remove o ultimo elemento da lista
	public void RemoverFim();
	
	//toString
	public String toString();
	
	//Iterator
	public Iterator<T> iterator();

}