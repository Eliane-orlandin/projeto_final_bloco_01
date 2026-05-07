package ecommerce.model;

public class ProdutoRoupa extends Produto{
	private String tecido;

	public ProdutoRoupa(int id, String nome, String descricao, float preco, String categoria, String tamanho,
			String cor, String tecido) {
		super(id, nome, descricao, preco, categoria, tamanho, cor);
		this.tecido = tecido;

	}

	public String getTecido() {
		return tecido;
	}

	public void setTecido(String tecido) {
		this.tecido = tecido;
	}

	@Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Tecido: " + tecido);
        System.out.println("****************************************************");
    }
	
}
