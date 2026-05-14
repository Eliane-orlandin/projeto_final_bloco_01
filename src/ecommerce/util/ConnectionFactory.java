package ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar conexões com o banco de dados MySQL.
 * Centraliza a configuração de URL, usuário e senha para facilitar manutenção.
 */
public class ConnectionFactory {

    // Configurações do banco de dados via variáveis de ambiente (mais seguro)
    private static final String URL = System.getenv("DB_URL"); // Ex.: jdbc:mysql://localhost:3306/db_rocwear
    private static final String USER = System.getenv("DB_USER"); // Ex.: root
    private static final String PASS = System.getenv("DB_PASSWORD"); // Senha definida externamente

    /**
     * Método para obter uma conexão com o banco de dados.
     * @return Connection - Objeto de conexão JDBC
     * @throws RuntimeException se houver erro na conexão ou variáveis não definidas
     */
    public static Connection getConnection() {
        // Verifica se as variáveis de ambiente estão definidas
        if (URL == null || USER == null || PASS == null) {
            throw new RuntimeException("Variáveis de ambiente DB_URL, DB_USER ou DB_PASSWORD não estão definidas.");
        }
        try {
            // Tenta estabelecer a conexão usando DriverManager
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            // Lança uma exceção em caso de erro, com mensagem detalhada
            throw new RuntimeException("Erro ao conectar ao banco: " + e.getMessage());
        }
    }
}