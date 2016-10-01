package tabelaHash;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class tabelaHashTest {
	private HashEnc<Integer> hashTest = new HashEnc<Integer>();
	
	@Before
	public void iniciar(){
		hashTest.inserir(11);
		hashTest.inserir(2);
		hashTest.inserir(3);
	}

	@Test
	public void test() {
		hashTest.remover(11);
		assertEquals(hashTest.todosElementos().size(), 2);
	}
}
