package vetor;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;

public class ClasseVetorTest {
	
	private static Vetor<Integer> lista; 
	
	@BeforeClass
	public static void Iniciar()
	{
		lista = new Vetor<Integer>();
	}
	
	@Test
	public void AdicionarTest() {
		lista.Adicionar(7);
		assertEquals("[7]", lista.toString());
	}
	
	@Test
	public void Adicionar2ElementosTest() {
		lista.Adicionar(7);
		lista.Adicionar(8);
		assertEquals("[7,8]", lista.toString());
	}
	
	@Test
	public void AdicionarRedimensionandoTest() {
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
		lista.Adicionar(12);
		assertEquals("[1,2,3,4,5,6,7,8,9,10,11,12]", lista.toString());
	}
	
	
	@Test
	public void AdicionarPosicaoTest() {
		lista.Adicionar(0, 1);
		assertEquals("[1]", lista.toString());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void AdicionarPosicaoNegativaTest() {
		lista.Adicionar(-1, 1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void AdicionarPosicaoExtraTest() {
		lista.Adicionar(20, 1);
	}

	
	@Test
	public void AdicionarInicioTest() {
		lista.AdicionarInicio(3);
		lista.AdicionarInicio(2);
		lista.AdicionarInicio(1);
		assertEquals("[1,2,3]", lista.toString());
	}
	
	@Test
	public void AdicionarInicioRedimensionandoTest() {
		lista.AdicionarInicio(12);
		lista.AdicionarInicio(11);
		lista.AdicionarInicio(10);
		lista.AdicionarInicio(9);
		lista.AdicionarInicio(8);
		lista.AdicionarInicio(7);
		lista.AdicionarInicio(6);
		lista.AdicionarInicio(5);
		lista.AdicionarInicio(4);
		lista.AdicionarInicio(3);
		lista.AdicionarInicio(2);
		lista.AdicionarInicio(1);
		assertEquals("[1,2,3,4,5,6,7,8,9,10,11,12]", lista.toString());
	}
	
	@Test
	public void RemoverPosTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Remover(0);
		assertEquals("[2,3]", lista.toString());
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void RemoverPosInexitenteTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Remover(-1);
	}
	
	@Test
	public void RemoverElementoTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Remover(2);
		assertEquals("[1,3]", lista.toString());
	}
	
	@Test
	public void RemoverElementoInexistenteTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Remover(4);
		assertEquals("[1,2,3]", lista.toString());
	}
	
	@Test
	public void RemoverInicioTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.RemoverInicio();
		assertEquals("[2,3]", lista.toString());
	}
	
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void RemoverInicioListaVaziaTest() {
		lista.RemoverInicio();
	}
	
	@Test
	public void RemoverFimTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.RemoverFim();
		assertEquals("[1,2]", lista.toString());
	}
	
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void RemoverFimListaVaziaTest() {
		lista.RemoverFim();
	}
	
	@Test
	public void TamanhoTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		assertEquals(3, lista.Tamanho());
	}
	
	@Test
	public void TamanhoVaziaTest() {
		assertEquals(0, lista.Tamanho());
	}
	
	
	@Test
	public void LimparTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);
		lista.Limpar();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void LimparListaVaziaTest() {
		lista.Limpar();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void ContemTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);		
		assertEquals(true, lista.contem(2));
	}
	
	@Test
	public void ContemFalseTest() {
		lista.Adicionar(1);
		lista.Adicionar(2);
		lista.Adicionar(3);		
		assertEquals(false, lista.contem(5));
	}
	
}
