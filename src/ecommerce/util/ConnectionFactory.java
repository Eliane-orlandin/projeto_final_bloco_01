package ecommerce.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por gerenciar conexões com o banco de dados MySQL.
 * Centraliza a configuração de URL, usuário e senha para facilitar manutenção.
 */
public class ConnectionFactory {

    // Mapa para armazenar variáveis carregadas do .env
    private static final Map<String, String> envVars = loadEnv();

    // Configurações do banco de dados via variáveis de ambiente ou .env
    private static final String URL = getEnvVar("DB_URL");
    private static final String USER = getEnvVar("DB_USER");
    private static final String PASS = getEnvVar("DB_PASSWORD");

    /**
     * Carrega variáveis do arquivo .env na raiz do projeto.
     * @return Map com as variáveis carregadas
     */
    private static Map<String, String> loadEnv() {
        Map<String, String> vars = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(".env"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        vars.put(parts[0], parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            // Arquivo .env não encontrado ou erro de leitura - usa variáveis de ambiente
            System.out.println("Aviso: Arquivo .env não encontrado. Usando variáveis de ambiente.");
        }
        return vars;
    }

    /**
     * Obtém variável de ambiente ou do .env.
     * @param key Nome da variável
     * @return Valor da variável ou null se não encontrada
     */
    private static String getEnvVar(String key) {
        String value = System.getenv(key);
        if (value == null) {
            value = envVars.get(key);
        }
        return value;
    }

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

    /**
     * Método para testar a conexão com o banco de dados.
     * @return true se conexão bem-sucedida, false caso contrário
     */
    public static boolean testConnection() {
        Connection conn = null;
        try {
            conn = getConnection();
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            return true;
        } catch (RuntimeException e) {
            System.out.println("Erro ao testar conexão: " + e.getMessage());
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
    }
}