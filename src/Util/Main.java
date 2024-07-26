package Util;


import BD.Proxy;

public class Main {
    public static void main(String[] args) {
    	
        Proxy p1 = new Proxy();
        System.out.println(p1.buscarProduto(3));
        System.out.println(p1.buscarProduto(2));
        
        //Exemplo de produto que não existe
        System.out.println(p1.buscarProduto(5));
    }
}