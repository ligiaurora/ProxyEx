package Teste;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import org.junit.Test;
import Conexao.Conexao;

public class TesteConexao {
	
	@Test
    public void testConexao() {
		try (Connection connection = Conexao.conectar()) {
            if (connection != null) {
                System.out.println("Conexão bem-sucedida com o banco de dados.");
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
