package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    final static String NOME_DO_BANCO = "test";
    final static String IP = "192.168.0.108"; 

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + IP + "/" + NOME_DO_BANCO;
            //String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO;
            return DriverManager.getConnection(url, "admin", "123456789");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Função para verificar a conexão
    
    ///Metodo jogado para teste unitario
    /*public static void testarConexao() {
        try (Connection connection = conectar()) {
            if (connection != null) {
                System.out.println("Conexão bem-sucedida com o banco de dados.");
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}