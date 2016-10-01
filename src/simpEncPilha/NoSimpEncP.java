package simpEncPilha;

public class NoSimpEncP<T>{
	
	private T elemento;
	private NoSimpEncP<T> proximo;
	
	
	public NoSimpEncP(T elemento) 
	{
		this.elemento = elemento;
		this.proximo = null;
	}
	
	public NoSimpEncP(T elemento, NoSimpEncP<T> proximo)
	{
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	//GET E SET
	
	public void setProximo(NoSimpEncP<T> proximo) {
		this.proximo = proximo;
	}
	
	public NoSimpEncP<T> getProximo() {
		return proximo;
	}
	
	public T getElemento() {
		return elemento;
	}
	
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
}
