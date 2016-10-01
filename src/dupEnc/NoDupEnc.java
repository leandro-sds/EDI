package dupEnc;

public class NoDupEnc<T> {
	private T elemento;
	private NoDupEnc<T> proximo;
	private NoDupEnc<T> anterior;
	
	// Construtores
	
	public NoDupEnc(T objeto) {
		this.elemento = objeto;
		this.anterior = null;
		this.proximo = null;
	}
	
	public NoDupEnc(T objeto, NoDupEnc<T> proximo, NoDupEnc<T> anterior) {
		this.elemento = objeto;
		this.proximo = proximo;
		this.anterior = anterior;
	}
	
	public NoDupEnc(NoDupEnc<T> proximo, T objeto) {
		this.elemento = objeto;
		this.proximo = proximo;
	}
	// Getters e Setters

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NoDupEnc<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoDupEnc<T> proximo) {
		this.proximo = proximo;
	}

	public NoDupEnc<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDupEnc<T> anterior) {
		this.anterior = anterior;
	}
}
