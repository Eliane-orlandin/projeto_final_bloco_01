package ecommerce;

import ecommerce.controller.ProdutoController;
import ecommerce.model.Produto;
import ecommerce.model.ProdutoAcessorio;
import ecommerce.model.ProdutoRoupa;
import ecommerce.util.ConnectionFactory;
import ecommerce.util.Cores;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final ProdutoController listaProdutos = new ProdutoController();

	public static void main(String[] args) {


		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                     ROCK WEAR                       ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar produto                    ");
			System.out.println("            2 - Listar todos produtos                ");
			System.out.println("            3 - Atualizar produto                    ");
			System.out.println("            4 - Excluir produto                      ");
			System.out.println("            5 - Buscar produtos por categoria        ");
			System.out.println("            6 - Testar conexão com banco             ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro!");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("\nVista o som, sinta o rock");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
                cadastrarProduto();
                break;
            case 2:
                listaProdutos.listarTodos();
                keyPress();
                break;
            case 3:
                atualizarProduto();
                break;
            case 4:
                excluirProduto();
                break;
            case 5:
                System.out.println("Buscar produtos por categoria\n\n");
                System.out.print("Digite a categoria: ");
                String categoria = leia.nextLine();
                listaProdutos.buscarPorCategoria(categoria);
                keyPress();
                break;
            case 6:
                testarConexao();
                break;
            default:
                System.out.println("\nOpção Inválida!\n");
                keyPress();
                break;
			}
		}		

	}
	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Eliane Orlandin do Carmo");
		System.out.println("E-mail: liorlandin33@gmail.com");
		System.out.println("https://github.com/Eliane-orlandin/projeto_final_bloco_01");
		System.out.println("*********************************************************");
	}
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		leia.nextLine();
	}
	
	private static void testarConexao() {
        System.out.println("\n--- Testar Conexão com Banco de Dados ---");
        ConnectionFactory.testConnection();
        keyPress();
    }
	
	private static void cadastrarProduto() {
        System.out.println("\n--- Cadastrar Produto ---");
        System.out.print("Tipo (1 - Roupa / 2 - Acessório): ");
        int tipo = Integer.parseInt(leia.nextLine().trim());

        System.out.print("Nome: ");
        String nome = leia.nextLine();

        System.out.print("Descrição: ");
        String descricao = leia.nextLine();

        System.out.print("Preço: ");
        float preco = Float.parseFloat(leia.nextLine().trim());

        System.out.print("Categoria: ");
        String categoria = leia.nextLine();

        System.out.print("Tamanho: ");
        String tamanho = leia.nextLine();

        System.out.print("Cor: ");
        String cor = leia.nextLine();

        if (tipo == 1) {
            System.out.print("Tecido: ");
            String tecido = leia.nextLine();
            ProdutoRoupa roupa = new ProdutoRoupa(0, nome, descricao, preco, categoria, tamanho, cor, tecido);
            listaProdutos.cadastrar(roupa);
        } else {
            System.out.print("Material: ");
            String material = leia.nextLine();
            ProdutoAcessorio acessorio = new ProdutoAcessorio(0, nome, descricao, preco, categoria, tamanho, cor, material);
            listaProdutos.cadastrar(acessorio);
        }
        keyPress();
    }

    private static void atualizarProduto() {
        System.out.println("\n--- Atualizar Produto ---");
        System.out.print("Informe o ID do produto a atualizar: ");
        int id = Integer.parseInt(leia.nextLine().trim());

        System.out.println("\nProduto atual:");
        listaProdutos.procurarPorId(id);

        System.out.println("\nInforme os novos dados:");
        System.out.print("Tipo (1 - Roupa / 2 - Acessório): ");
        int tipo = Integer.parseInt(leia.nextLine().trim());

        System.out.print("Nome: ");
        String nome = leia.nextLine();

        System.out.print("Descrição: ");
        String descricao = leia.nextLine();

        System.out.print("Preço: ");
        float preco = Float.parseFloat(leia.nextLine().trim());

        System.out.print("Categoria: ");
        String categoria = leia.nextLine();

        System.out.print("Tamanho: ");
        String tamanho = leia.nextLine();

        System.out.print("Cor: ");
        String cor = leia.nextLine();

        Produto novo;
        if (tipo == 1) {
            System.out.print("Tecido: ");
            String tecido = leia.nextLine();
            novo = new ProdutoRoupa(id, nome, descricao, preco, categoria, tamanho, cor, tecido);
        } else {
            System.out.print("Material: ");
            String material = leia.nextLine();
            novo = new ProdutoAcessorio(id, nome, descricao, preco, categoria, tamanho, cor, material);
        }

        listaProdutos.atualizar(novo);
        keyPress();
    }

    private static void excluirProduto() {
        System.out.println("\n--- Excluir Produto ---");
        System.out.print("Informe o ID do produto a excluir: ");
        int id = Integer.parseInt(leia.nextLine().trim());
        listaProdutos.deletar(id);
        keyPress();
    }

}
