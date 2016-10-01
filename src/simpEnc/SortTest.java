package simpEnc;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
public class SortTest {
	

	ListaSimpEnc<Integer> lista = new ListaSimpEnc<Integer>();

	@Before
	public void setUp() throws Exception {
		lista.InserirInicio(3);
		lista.InserirInicio(5);
		lista.InserirInicio(1);
		lista.InserirInicio(2);
		lista.InserirInicio(20);
		lista.InserirInicio(4);
		lista.InserirInicio(6);
		lista.InserirInicio(10);
		lista.InserirInicio(12);
		lista.InserirInicio(7);
	}


	/*@Test
	public void QuickSortTest() {
	    lista.QuickSort(lista.getInicio(), lista.getFim());
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}*/
	
	@Test
	public void InsertionSortTest() {
	    lista.InsertionSort();
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}
	
	@Test
	public void SelectionSortTest() {
	    lista.SelectionSort();
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}
	
	@Test
	public void BubbleSortTest() {
	    lista.BubbleSort();
		assertEquals("[1,2,3,4,5,6,7,10,12,20]", lista.toString());
	}

}
