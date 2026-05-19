package ecommerce;

import ecommerce.repository.ProdutoRepository;
import ecommerce.repository.ProdutoRepositoryJDBC;
import ecommerce.model.Produto;
import ecommerce.model.ProdutoAcessorio;
import ecommerce.model.ProdutoRoupa;
import ecommerce.util.Cores;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final Scanner leia = new Scanner(System.in);
    private static final ProdutoRepository listaProdutos = new ProdutoRepositoryJDBC();

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

        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(leia.nextLine().trim());

        System.out.print("Categoria: ");
        String categoria = leia.nextLine();

        System.out.print("Tamanho: ");
        String tamanho = leia.nextLine();

        System.out.print("Cor: ");
        String cor = leia.nextLine();

        if (tipo == 1) {
            System.out.print("Tecido: ");
            String tecido = leia.nextLine();
            ProdutoRoupa roupa = new ProdutoRoupa(0, nome, descricao, preco, categoria, tamanho, cor, tecido,
                    quantidade);
            listaProdutos.cadastrar(roupa);
        } else {
            System.out.print("Material: ");
            String material = leia.nextLine();
            ProdutoAcessorio acessorio = new ProdutoAcessorio(0, nome, descricao, preco, categoria, tamanho, cor,
                    material, quantidade);
            listaProdutos.cadastrar(acessorio);
        }
        keyPress();
    }

    private static void atualizarProduto() {
        System.out.println("\n--- Atualizar Produto ---");
        System.out.print("Informe o ID do produto a atualizar: ");
        String idInput = leia.nextLine().trim();
        int id;
        try {
            id = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            System.out.println("\nID inválido!");
            keyPress();
            return;
        }

        Produto produtoAtual = listaProdutos.buscarPorId(id);
        if (produtoAtual == null) {
            System.out.println("\nProduto com ID " + id + " não encontrado no banco de dados.");
            keyPress();
            return;
        }

        System.out.println("\nProduto atual:");
        produtoAtual.visualizar();

        System.out.println("\nInforme os novos dados (pressione Enter sem digitar nada para manter o valor atual):");

        int tipoAtual = (produtoAtual instanceof ProdutoRoupa) ? 1 : 2;
        System.out
                .print("Tipo (1 - Roupa / 2 - Acessório) [Atual: " + (tipoAtual == 1 ? "Roupa" : "Acessório") + "]: ");
        String tipoInput = leia.nextLine().trim();
        int tipo = tipoAtual;
        if (!tipoInput.isEmpty()) {
            try {
                tipo = Integer.parseInt(tipoInput);
                if (tipo != 1 && tipo != 2) {
                    System.out.println(
                            "Tipo inválido! Mantendo o tipo atual (" + (tipoAtual == 1 ? "Roupa" : "Acessório") + ").");
                    tipo = tipoAtual;
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "Entrada inválida! Mantendo o tipo atual (" + (tipoAtual == 1 ? "Roupa" : "Acessório") + ").");
                tipo = tipoAtual;
            }
        }

        System.out.print("Nome [Atual: " + produtoAtual.getNome() + "]: ");
        String nome = leia.nextLine();
        if (nome.trim().isEmpty()) {
            nome = produtoAtual.getNome();
        }

        System.out.print("Descrição [Atual: " + produtoAtual.getDescricao() + "]: ");
        String descricao = leia.nextLine();
        if (descricao.trim().isEmpty()) {
            descricao = produtoAtual.getDescricao();
        }

        System.out.print("Preço [Atual: " + produtoAtual.getPreco() + "]: ");
        String precoInput = leia.nextLine().trim();
        float preco = produtoAtual.getPreco();
        if (!precoInput.isEmpty()) {
            try {
                preco = Float.parseFloat(precoInput);
            } catch (NumberFormatException e) {
                System.out.println("Preço inválido! Mantendo o preço atual (" + produtoAtual.getPreco() + ").");
            }
        }

        System.out.print("Quantidade [Atual: " + produtoAtual.getQuantidade() + "]: ");
        String qtdInput = leia.nextLine().trim();
        int quantidade = produtoAtual.getQuantidade();
        if (!qtdInput.isEmpty()) {
            try {
                quantidade = Integer.parseInt(qtdInput);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Quantidade inválida! Mantendo a quantidade atual (" + produtoAtual.getQuantidade() + ").");
            }
        }

        System.out.print("Categoria [Atual: " + produtoAtual.getCategoria() + "]: ");
        String categoria = leia.nextLine();
        if (categoria.trim().isEmpty()) {
            categoria = produtoAtual.getCategoria();
        }

        System.out.print("Tamanho [Atual: " + produtoAtual.getTamanho() + "]: ");
        String tamanho = leia.nextLine();
        if (tamanho.trim().isEmpty()) {
            tamanho = produtoAtual.getTamanho();
        }

        System.out.print("Cor [Atual: " + produtoAtual.getCor() + "]: ");
        String cor = leia.nextLine();
        if (cor.trim().isEmpty()) {
            cor = produtoAtual.getCor();
        }

        Produto novo;
        if (tipo == 1) {
            String tecidoAtual = (produtoAtual instanceof ProdutoRoupa) ? ((ProdutoRoupa) produtoAtual).getTecido()
                    : "Nenhum";
            System.out.print("Tecido [Atual: " + tecidoAtual + "]: ");
            String tecido = leia.nextLine();
            if (tecido.trim().isEmpty()) {
                tecido = (produtoAtual instanceof ProdutoRoupa) ? ((ProdutoRoupa) produtoAtual).getTecido() : "";
            }
            novo = new ProdutoRoupa(id, nome, descricao, preco, categoria, tamanho, cor, tecido, quantidade);
        } else {
            String materialAtual = (produtoAtual instanceof ProdutoAcessorio)
                    ? ((ProdutoAcessorio) produtoAtual).getMaterial()
                    : "Nenhum";
            System.out.print("Material [Atual: " + materialAtual + "]: ");
            String material = leia.nextLine();
            if (material.trim().isEmpty()) {
                material = (produtoAtual instanceof ProdutoAcessorio) ? ((ProdutoAcessorio) produtoAtual).getMaterial()
                        : "";
            }
            novo = new ProdutoAcessorio(id, nome, descricao, preco, categoria, tamanho, cor, material, quantidade);
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
