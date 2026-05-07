package ecommerce.model;

public class ProdutoAcessorio extends Produto{

	private String material;
	
	public ProdutoAcessorio(int id, String nome, String descricao, float preco, String categoria, String tamanho,
			String cor, String material) {
		super(id, nome, descricao, preco, categoria, tamanho, cor);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Material: " + material);
        System.out.println("****************************************************");
    }
	
}
