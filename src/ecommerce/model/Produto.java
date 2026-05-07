package ecommerce.model;

public abstract class Produto {

	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private String categoria;
	private String tamanho;
	private String cor;

	public Produto(int id, String nome, String descricao, float preco, String categoria, String tamanho, String cor) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.tamanho = tamanho;
		this.cor = cor;
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
	
	public void visualizar() {
	    System.out.println("\n****************************************************");
	    System.out.println("ID: " + this.id);
	    System.out.println("Nome: " + this.nome);
	    System.out.println("Descrição: " + this.descricao);
	    System.out.printf("Preço: R$ %.2f", this.preco);
	    System.out.println("\nCategoria: " + this.categoria);
	    System.out.println("Tamanho: " + this.tamanho);
	    System.out.println("Cor: " + this.cor);
	    ;
	}


}
