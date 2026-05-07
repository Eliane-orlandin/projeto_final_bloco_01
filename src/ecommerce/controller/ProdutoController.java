package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private List<Produto> listaProdutos = new ArrayList<Produto>();
    private int nextId = 1;

    @Override
    public void listarTodos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : listaProdutos) {
            p.visualizar();
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }
        if (produto.getId() <= 0) {
            produto.setId(nextId++);
        } else {
            if (produto.getId() >= nextId) {
                nextId = produto.getId() + 1;
            }
        }
        listaProdutos.add(produto);
        System.out.println("Produto cadastrado com sucesso: " + produto.getNome());
    }

    @Override
    public void procurarPorId(int id) {
        for (Produto p : listaProdutos) {
            if (p.getId() == id) {
                p.visualizar();
                return;
            }
        }
        System.out.println("Produto com ID " + id + " não encontrado.");
    }

    @Override
    public void atualizar(Produto produto) {
        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == produto.getId()) {
                listaProdutos.set(i, produto);
                System.out.println("Produto atualizado: " + produto.getNome());
                return;
            }
        }
        System.out.println("Produto não encontrado para atualização.");
    }

    @Override
    public void deletar(int id) {
        boolean removed = listaProdutos.removeIf(p -> p.getId() == id);
        if (removed) {
            System.out.println("Produto removido: ID " + id);
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }
}
