package ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar conexões com o banco de dados MySQL.
 * Centraliza a configuração de URL, usuário e senha para facilitar manutenção.
 */
public class ConnectionFactory {

    // Configurações do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/db_rocwear"; // URL de conexão com o banco
    private static final String USER = "root"; // Usuário do banco de dados
    private static final String PASS = "sua_senha"; // Senha do banco (ATENÇÃO: não recomendado em produção)

    /**
     * Método para obter uma conexão com o banco de dados.
     * @return Connection - Objeto de conexão JDBC
     * @throws RuntimeException se houver erro na conexão
     */
    public static Connection getConnection() {
        try {
            // Tenta estabelecer a conexão usando DriverManager
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro, com mensagem detalhada
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}