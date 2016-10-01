package vetor;

public class VetorApp {

	public static void main(String[] args) {
		Vetor<Integer> lista = new Vetor<Integer>();
		
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Adicionar(4);
		lista.Adicionar(5);
		lista.Adicionar(6);
		lista.Adicionar(7);
		lista.Adicionar(8);
		lista.Adicionar(9);
		lista.Adicionar(10);
		lista.Adicionar(11);
		System.out.println(lista.Tamanho());
	}

}
