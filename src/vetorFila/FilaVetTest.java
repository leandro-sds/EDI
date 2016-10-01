package vetorFila;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FilaVetTest {
	
	FilaVet<Integer> fila = new FilaVet<Integer>();

	@Before
	public void setUp() throws Exception {
		
		fila.enfileirar(2);
	}


	@Test
	public void limparTest() {
		fila.limpar();
		assertFalse(fila.estaVazia());
	}

	@Test
	public void tamanhoTest() {
		assertEquals(1, fila.tamanho());
	}
	
	@Test
	public void estaVaziaTest() {
		assertFalse(fila.estaVazia());
	}

	@Test
	public void contemTest() {
		assertTrue(fila.contem(2));
	}
	
	@Test
	public void naoContemTest() {
		assertFalse(fila.contem(3));
	}
	
	@Test
	public void distanciaTest() {
		assertEquals(0, fila.distancia(2));
		
	}

	@Test
	public void removerTest() {
		fila.enfileirar(3);
		fila.enfileirar(1);
		fila.remover();
		assertEquals("[3,1]",fila.toString());
		
	}
	
	@Test
	public void enfileirarTest() {
		fila.enfileirar(4);
		fila.enfileirar(5);
		assertEquals("[2,4,5]", fila.toString());
	}



}
