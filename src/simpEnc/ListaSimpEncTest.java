package simpEnc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListaSimpEncTest {

	ListaSimpEnc<Integer> lista;
	
	@Before
	public void Iniciar() {
		lista = new ListaSimpEnc<Integer>();

	}

	@Test
	public void InserirNoInicioTest() {
		lista.InserirInicio(9);
		assertEquals("[9]", lista.toString());
	}

	@Test
	public void ContemTest() {
		lista.InserirInicio(9);
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);

		assertEquals(true, lista.contem(2));
	}
	
	@Test
	public void Insertion() {
		lista.InserirFim(2);
		lista.InserirFim(6);
		lista.InserirFim(3);
		lista.Insertion();
		
		assertEquals("[2,3,6]", lista.toString());
	}

	@Test
	public void NaoContemTest() {
		lista.InserirInicio(9);
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);

		assertEquals(false, lista.contem(10));
	}

	@Test
	public void InserirVariosInicioTest() {
		lista.InserirInicio(9);
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);

		assertEquals("[1,2,6,9]", lista.toString());
	}

	@Test
	public void InserirVariosFimTest() {
		lista.InserirInicio(6);
		lista.InserirInicio(2);
		lista.InserirInicio(1);
		lista.InserirFim(9);
		assertEquals("[1,2,6,9]", lista.toString());
	}

	@Test
	public void InserirDoisFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		assertEquals("[9,2]", lista.toString());
	}

	@Test
	public void InserirTresFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		assertEquals("[9,2,1]", lista.toString());
	}

	@Test
	public void InserirPosTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.Inserir(1, (Integer) 6);
		assertEquals("[6,9,2,1]", lista.toString());
	}
	
	@Test
	public void SelectionSort() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.Inserir(1, (Integer) 6);
		lista.SelectionSort();
		assertEquals("[1,2,6,9]", lista.toString());
	}

	@Test
	public void InserirPosFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.Inserir(4, (Integer) 6);
		assertEquals("[9,2,1,6]", lista.toString());
	}

	@Test
	public void RemoverInicioTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.RemoverInicio();
		assertEquals("[2,1]", lista.toString());
	}

	@Test
	public void RemoverUnicoTest() {
		lista.InserirFim(9);
		lista.RemoverInicio();
		assertEquals("[]", lista.toString());
	}

	@Test
	public void RemoverTresTest() {
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.InserirInicio(9);
		lista.RemoverInicio();
		assertEquals("[2,1]", lista.toString());
	}

	@Test
	public void RemoverFimTest() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.InserirFim(1);
		lista.RemoverFim();
		assertEquals("[9,2]", lista.toString());
	}

	@Test
	public void RemoverFimUnicoTest() {
		lista.InserirFim(9);
		lista.RemoverFim();
		assertEquals("[]", lista.toString());
	}


	@Test
	public void AdicionarTest() {
		lista.InserirFim(7);
		assertEquals("[7]", lista.toString());
	}
	
	@Test
	public void Adicionar2ElementosTest() {
		lista.InserirFim(7);
		lista.InserirFim(8);
		assertEquals("[7,8]", lista.toString());
	}
	

	
	
	@Test
	public void AdicionarPosicaoTest() {
		lista.Inserir(1, 1);
		assertEquals("[1]", lista.toString());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void AdicionarPosicaoNegativaTest() {
		lista.Inserir(-1, 1);
	}
	

	public void RemoverInicioListaVaziaTest() {
		lista.RemoverInicio();
		assertEquals("[]", lista.toString());
	}
	

	public void RemoverFimListaVaziaTest() {
		lista.RemoverFim();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void SizeTest() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		assertEquals(3, lista.size());
	}
	
	@Test
	public void TamanhoVaziaTest() {
		assertEquals(0, lista.size());
	}
	
	
	@Test
	public void LimparTest() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		lista.clear();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void LimparListaVaziaTest() {
		lista.clear();
		assertEquals("[]", lista.toString());
	}
	
	
	
	@Test
	public void ContemFalseTest() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);		
		assertEquals(false, lista.contem(5));
	}
	
	@Test
	public void getInicioTest(){
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		assertEquals((Integer) 1, lista.getInicio().getElemento());	
	}
	
	@Test
	public void getFimTest(){
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		assertEquals((Integer) 3, lista.getFim().getElemento());	
	}
	
	
	@Test
	public void estaVaziaTest(){

		assertEquals(true, lista.estaVazia());	
	}
	
	@Test
	public void naoEstaVaziaTest(){
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		assertEquals(false, lista.estaVazia());	
	}
	

}
