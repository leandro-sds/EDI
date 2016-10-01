package dupEnc;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class ListaDupEncTest {

	private ListaDupEnc<Integer> lista;
	
	@Before
	public void Iniciar(){
	
		lista = new ListaDupEnc<Integer>();
		lista.InserirInicio(8);
	}
	
	@Test
	public void ListaComElemento() {
		
		assertEquals("[8]", lista.toString());
	}
	
	@Test
	public void ListaComDois() {
		lista.InserirInicio(9);
		assertEquals("[9,8]", lista.toString());
	}
	
	@Test
	public void ListaInvertida() {
		lista.InserirFim(9);
		lista.InserirFim(2);
		lista.listaInvertida();
		assertEquals("[2,9,8]", lista.toString());
	}
	
	@Test
	public void ListaComTres() {
		lista.InserirInicio(9);
		lista.InserirInicio(2);
		assertEquals("[2,9,8]", lista.toString());
	}
	
	@Test
	public void ListaFimComDois() {
		lista.InserirFim(2);
		assertEquals("[8,2]", lista.toString());
	}
	
	@Test
	public void ListaFimComTres() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals("[8,2,9]", lista.toString());
	}
	@Test
	public void ListaPos() {
		lista.Inserir(1,2);
		assertEquals("[2,8]", lista.toString());
	}
	
	@Test
	public void ListaPosDois() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		lista.Inserir(2, 6);
		assertEquals("[8,6,2,9]", lista.toString());
	}
	
	@Test
	public void ListaPosFim() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		lista.Inserir(4, 6);
		assertEquals("[8,2,9,6]", lista.toString());
	}
	
	@Test
	public void ListaContem() {
		assertEquals(true, lista.contem(8));
	}
	
	@Test
	public void ListaContemUltimo() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals(true, lista.contem(9));
	}
	
	@Test
	public void ListaContemMeio() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals(true, lista.contem(2));
	}
	@Test
	public void ListaNaoContem() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		assertEquals(false, lista.contem(19));
	}
	
	@Test
	public void ListaRemoverInicio() {
		lista.RemoverInicio();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void ListaRemoverUm() {
		lista.InserirFim(2);
		lista.RemoverInicio();
		assertEquals("[2]", lista.toString());
	}
	
	@Test
	public void ListaRemoverDois() {
		lista.InserirFim(2);
		lista.InserirFim(9);
		lista.RemoverInicio();	}
	
	@Test
	public void ListaRemoverTres() {
		lista.InserirFim(2);
		lista.InserirFim(7);
		lista.InserirInicio(9);
		lista.RemoverInicio();
		assertEquals("[8,2,7]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFim() {
		lista.RemoverFim();
		assertEquals("[]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFimDois() {
		lista.InserirFim(2);
		lista.RemoverFim();
		assertEquals("[8]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFimTres() {
		lista.InserirFim(2);
		lista.InserirFim(7);
		lista.InserirInicio(9);
		lista.RemoverFim();
		assertEquals("[9,8,2]", lista.toString());
	}
	
	@Test
	public void ListaRemoverFimVarios() {
		lista.InserirInicio(2);
		lista.RemoverFim();
		assertEquals("[2]", lista.toString());
	}
	
	@Test
	public void TestInterator() {
		Iterator<Integer> i = lista.iterator();
		int valor = i.next();
		assertEquals(8, valor);
	}

	@Test
	public void TestTerceiroInterator() {
		lista.InserirFim(2);
		lista.InserirFim(4);
		lista.InserirFim(6);
		Iterator<Integer> i = lista.iterator();
		int valor = i.next();
		valor = i.next();
		valor = i.next();
		assertEquals(4, valor);
	}
	
	@Test
	public void TestUltimoInterator() {
		lista.InserirFim(2);
		lista.InserirFim(4);
		lista.InserirFim(6);
		Iterator<Integer> i = lista.iterator();
		int valor = i.next();
		valor = i.next();
		valor = i.next();
		valor = i.next();
		assertEquals(6, valor);
	}
	
	@Test
	public void SizeTest() {
		lista.InserirFim(1);
		lista.InserirFim(2);
		lista.InserirFim(3);
		assertEquals(4, lista.size());
	}
	
	@Test
	public void TamanhoVaziaTest() {
		lista.RemoverInicio();
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
		assertEquals((Integer) 8, lista.getInicio().getElemento());	
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

		lista.RemoverInicio();
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
