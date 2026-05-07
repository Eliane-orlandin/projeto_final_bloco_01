package ecommerce;

import java.util.Scanner;

import ecommerce.util.Cores;
import ecommerce.model.ProdutoRoupa;
import ecommerce.model.ProdutoAcessorio;

public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Teste da Classe ProdutoRoupa

		ProdutoRoupa r1 = new ProdutoRoupa(
		    1,
		    "Camiseta Rock Wear",
		    "Camiseta preta 100% algodão",
		    99.90f,
		    "Roupas",
		    "M",
		    "Preto",
		    "Algodão"

		);
		r1.visualizar();
		
		ProdutoAcessorio a1 = new ProdutoAcessorio(
			    2,
			    "Pulseira Rock",
			    "Pulseira de couro com detalhes metálicos",
			    49.90f,
			    "Acessórios",
			    "-",
			    "Preto",
			    "Pulseira"
			);

			a1.visualizar();


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
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nVista o som, sinta o rock");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar produto\n\n");

				break;
			case 2:
				System.out.println("Listar todos produtos\n\n");

				break;

			case 3:
				System.out.println("Atualizar produto\n\n");

				break;
			case 4:
				System.out.println("Excluir produto\n\n");

				break;

			default:
				System.out.println("\nOpção Inválida!\n");
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

}
