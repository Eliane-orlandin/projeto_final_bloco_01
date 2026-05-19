package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {

	public void listarTodos();

	public void cadastrar(Produto produto);

	public void procurarPorId(int id);

	public Produto buscarPorId(int id);

	public void atualizar(Produto produto);

	public void deletar(int id);
	
	public void buscarPorCategoria(String categoria);

}
