package classe;

public class Produto {
	private int id; 
	private String nome; 
	private float preco;
	
	public Produto(int id, String nome, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
}
