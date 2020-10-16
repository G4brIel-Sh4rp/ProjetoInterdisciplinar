
package projetoInterdiciplinar;

import java.util.*;
import javax.swing.JOptionPane;

public class Estoque{
    
    private ArrayList listaProdutos = new ArrayList<Produto>();
    
    public Estoque (ArrayList lista){
        listaProdutos = lista;
    }
    
    //Construtores e Metodos para Celulares
    public Celulares getProduto(int id){
        try{
            for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i); //Polimorfismo
                if(p.id == id){
                    return p;
                }
            }
            throw new Exception("Id não encontrado!");
        }
        catch(Exception e){
            e.getMessage();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
            return null;
        }
    }
    public void addProduto(Celulares p){
        if(verificaId(p.id)){   
            listaProdutos.add(p);
        }
        else{
            JOptionPane.showMessageDialog(null, "Id já existe, não foi possível adicionar produto", "Erro", 0);
        }
    }
    
    public float valorTotal(){
        float acm = 0;
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);
                acm += p.valorTotal();
        }
        return acm;
    }
    //Métodos de Listagem
    
    public ArrayList listar(String marca){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);
                if(p.getMarca().equalsIgnoreCase(marca)){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(int ano){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);
                int anoLancamento = p.getLancamento().getYear();

                if( anoLancamento == ano){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(int anoMin, int anoMax){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);
                if(p.getLancamento().getYear() > anoMin && p.getLancamento().getYear() < anoMax){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(float precoMin, float precoMax){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);
                if(p.getPreco() > precoMin && p.getPreco() < precoMax){
                    aux.add(p);
                }
        }
        return aux;
    }
    
    public ArrayList GerarRelatorio(){
        ArrayList aux = new ArrayList();
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);
                if(p.getQnt()<= p.getQntMin()){
                    aux.add(p);
                }
        }
        return aux;
    }
    // Métodos internos
    
    //verifica se já existe o mesmo id, se sim : false.
    private boolean verificaId(int id) {  
        for (int i = 0; i < listaProdutos.size(); i++) {
                Produto p = (Produto) listaProdutos.get(i);
                if(p.id == id){
                    return false;
                }
        }
        return true;
    }
    // Encontra um valor para novos Id's
    private int getNewId(){ 
        int maiorId = 0;
        for (int i = 0; i < listaProdutos.size(); i++) {
                Produto p = (Produto) listaProdutos.get(i);
                if(p.id > maiorId){
                    maiorId = p.id+1;
                }
        }
        return maiorId+1;
    }
}
