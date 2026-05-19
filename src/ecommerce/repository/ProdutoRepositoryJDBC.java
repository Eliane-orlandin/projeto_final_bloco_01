package ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ecommerce.model.Produto;
import ecommerce.model.ProdutoAcessorio;
import ecommerce.model.ProdutoRoupa;
import ecommerce.util.ConnectionFactory;

public class ProdutoRepositoryJDBC implements ProdutoRepository {

    @Override
    public void listarTodos() {
        String sql = "SELECT * FROM produtos";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean any = false;
            while (rs.next()) {
                any = true;
                Produto p = mapResultSetToProduto(rs);
                p.visualizar();
            }
            if (!any) {
                System.out.println("Nenhum produto cadastrado no banco de dados.");
            }

        } catch (SQLException | RuntimeException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
    }

    @Override
    public void cadastrar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, preco, categoria, tamanho, cor, quantidade, tipo, tecido, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setFloat(3, produto.getPreco());
            ps.setString(4, produto.getCategoria());
            ps.setString(5, produto.getTamanho());
            ps.setString(6, produto.getCor());
            ps.setInt(7, produto.getQuantidade());

            String tipo = "";
            String tecido = null;
            String material = null;
            if (produto instanceof ProdutoRoupa) {
                tipo = "roupa";
                tecido = ((ProdutoRoupa) produto).getTecido();
            } else if (produto instanceof ProdutoAcessorio) {
                tipo = "acessorio";
                material = ((ProdutoAcessorio) produto).getMaterial();
            }

            ps.setString(8, tipo);
            ps.setString(9, tecido);
            ps.setString(10, material);

            int affected = ps.executeUpdate();
            if (affected == 0) {
                System.out.println("Falha ao cadastrar produto.");
                return;
            }

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    produto.setId(keys.getInt(1));
                }
            }

            System.out.println("Produto cadastrado com sucesso: " + produto.getNome());

        } catch (SQLException | RuntimeException e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    @Override
    public void procurarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Produto p = mapResultSetToProduto(rs);
                    p.visualizar();
                } else {
                    System.out.println("Produto com ID " + id + " não encontrado no banco de dados.");
                }
            }

        } catch (SQLException | RuntimeException e) {
            System.out.println("Erro ao procurar produto: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Produto produto) {
        String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ?, categoria = ?, tamanho = ?, cor = ?, quantidade = ?, tipo = ?, tecido = ?, material = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setFloat(3, produto.getPreco());
            ps.setString(4, produto.getCategoria());
            ps.setString(5, produto.getTamanho());
            ps.setString(6, produto.getCor());
            ps.setInt(7, produto.getQuantidade());

            String tipo = "";
            String tecido = null;
            String material = null;
            if (produto instanceof ProdutoRoupa) {
                tipo = "roupa";
                tecido = ((ProdutoRoupa) produto).getTecido();
            } else if (produto instanceof ProdutoAcessorio) {
                tipo = "acessorio";
                material = ((ProdutoAcessorio) produto).getMaterial();
            }

            ps.setString(8, tipo);
            ps.setString(9, tecido);
            ps.setString(10, material);
            ps.setInt(11, produto.getId());

            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("Produto atualizado: " + produto.getNome());
            } else {
                System.out.println("Produto não encontrado para atualização.");
            }

        } catch (SQLException | RuntimeException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            if (affected > 0) {
                System.out.println("Produto removido: ID " + id);
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }

        } catch (SQLException | RuntimeException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

    @Override
    public void buscarPorCategoria(String categoria) {
        String sql = "SELECT * FROM produtos WHERE LOWER(categoria) LIKE ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + categoria.toLowerCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                boolean encontrado = false;
                while (rs.next()) {
                    Produto p = mapResultSetToProduto(rs);
                    p.visualizar();
                    encontrado = true;
                }
                if (!encontrado) {
                    System.out.println("Nenhum produto encontrado na categoria: " + categoria);
                }
            }

        } catch (SQLException | RuntimeException e) {
            System.out.println("Erro ao buscar por categoria: " + e.getMessage());
        }
    }

    private Produto mapResultSetToProduto(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String descricao = rs.getString("descricao");
        float preco = rs.getFloat("preco");
        String categoria = rs.getString("categoria");
        String tamanho = rs.getString("tamanho");
        String cor = rs.getString("cor");
        int quantidade = rs.getInt("quantidade");
        String tipo = rs.getString("tipo");
        String tecido = null;
        String material = null;
        try {
            tecido = rs.getString("tecido");
        } catch (SQLException e) {
            // coluna pode não existir
        }
        try {
            material = rs.getString("material");
        } catch (SQLException e) {
            // coluna pode não existir
        }

        if ("roupa".equalsIgnoreCase(tipo)) {
            return new ProdutoRoupa(id, nome, descricao, preco, categoria, tamanho, cor, tecido, quantidade);
        } else if ("acessorio".equalsIgnoreCase(tipo)) {
            return new ProdutoAcessorio(id, nome, descricao, preco, categoria, tamanho, cor, material, quantidade);
        } else {
            // fallback genérico
            return new ProdutoAcessorio(id, nome, descricao, preco, categoria, tamanho, cor, material, quantidade);
        }
    }

}
