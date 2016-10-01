package tabelaHash;

import simpEnc.*;
import vetor.*;

public interface ITabelaHash<T> {

	// inserir um novo elemento de acordo com a funcao de hash
	public void inserir(T elemento);

	// remover um elemento, apos a busca de acordo com a funcao de hash
	public void remover(T elemento);

	// busca um elemento de acordo com a funcao de hash
	public boolean contem(T elemento);

	// implementacao da funcao de hash
	public int hash(T elemento);

	// retorna o numero total de elementos presentes na tabela hash
	public int tamanho();

	// coloca todos os elementos em uma unica lista encadeada
	public ListaSimpEnc<T> todosElementos();

	// carga = numeroElementos/numeroDePosicoesNaTabelaHash
	// se for maior que 0.75, entao deve-se redimensionar a tabela hash
	// verficarCarga() deve ser utilizado antes de adicionar um elemento
	public void verificarCarga();

	// redimensiona a tabela se o numero de elementos for maior que a capacidade
	// da tabela
	// aumenta a tabela no dobro de posicoes
	public void redimensionarTabela();

}
