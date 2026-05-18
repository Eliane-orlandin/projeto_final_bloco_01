package ecommerce.model;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Produto {

	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private String categoria;
	private String tamanho;
	private String cor;
	private int quantidade;

	public Produto(int id, String nome, String descricao, float preco, String categoria, String tamanho, String cor) {
		this(id, nome, descricao, preco, categoria, tamanho, cor, 0);
	}

	public Produto(int id, String nome, String descricao, float preco, String categoria, String tamanho, String cor, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.tamanho = tamanho;
		this.cor = cor;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void visualizar() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
	    System.out.println("\n****************************************************");
	    System.out.println("ID: " + this.id);
	    System.out.println("Nome: " + this.nome);
	    System.out.println("Descrição: " + this.descricao);
	    System.out.println("Preço: " + nf.format(this.preco));
	    System.out.println("Categoria: " + this.categoria);
	    System.out.println("Tamanho: " + this.tamanho);
	    System.out.println("Cor: " + this.cor);
		System.out.println("Quantidade: " + this.quantidade);
	}
}