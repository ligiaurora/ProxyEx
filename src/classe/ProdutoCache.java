package classe;

import classe.Produto;

public class ProdutoCache {
   
	private Produto produto;
    private long timestamp;

    public ProdutoCache(Produto produto, long timestamp) {
        this.produto = produto;
        this.timestamp = timestamp;
    }

    public ProdutoCache() {
    	
    }
    
    
    public Produto getProduto() {
        return produto;
    }

    public long getTimestamp() {
        return timestamp;
    }

	@Override
	public String toString() {
		return "ProdutoCache [produto=" + produto + ", timestamp=" + timestamp + "]";
	}   
}
