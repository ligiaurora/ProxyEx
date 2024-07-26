package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import Conexao.Conexao;
import classe.Produto;
import classe.ProdutoCache;

public class Proxy implements Database {

    private static final long TEMPO_VALIDACAO =  60000; // tempo de validacao
    public static ArrayList<ProdutoCache> lista = new ArrayList<>();

    @Override
    public String query(int id) {
        String result = null;
        try (Connection connection = Conexao.conectar()) {
            if (connection != null) {
                String sql = "SELECT id, nome, preco FROM produto WHERE id = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getFloat("preco"));
                    lista.add(new ProdutoCache(produto, System.currentTimeMillis()));
                    result = "Nome: " + rs.getString("nome") + " Preço: " + rs.getDouble("preco");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Consultando o banco de dados para encontrar o ID: " + id);
        return result;
    }

    public String cache(int id) {
        long currentTime = System.currentTimeMillis();
        Iterator<ProdutoCache> iterator = lista.iterator();
        
        while (iterator.hasNext()) {
            ProdutoCache cache = iterator.next();
            if (currentTime - cache.getTimestamp() > TEMPO_VALIDACAO) {
                iterator.remove(); // Remove entradas expiradas
                continue;
            }
            if (cache.getProduto().getId() == id) {
                return "Nome: " + cache.getProduto().getNome() + " Preço: " + cache.getProduto().getPreco();
            }
        }
        return null;
    }

    public String buscarProduto(int id) {
        // Primeiro, tenta buscar no cache
        String resultado = cache(id);
        if (resultado != null) {
            System.out.println("Produto encontrado no cache.");
            return resultado;
        }
        
        // Se não encontrar no cache, busca no banco de dados
        System.out.println("Produto não encontrado no cache. Consultando o banco de dados...");
        resultado = query(id);
        
        if (resultado != null) {
            System.out.println("Produto encontrado no banco de dados e adicionado ao cache.");
            return resultado;
        } else {
            return "Esse id não existe, faça uma nova busca";
        }
    }
}
