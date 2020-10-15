
package projetoInterdiciplinar;

import java.util.*;
import javax.swing.JOptionPane;

public class EstoqueCelulares{
    
    private ArrayList listaCelulares;
    
    public EstoqueCelulares (ArrayList lista){
        listaCelulares = lista;
    }
    
    public Celulares getProduto(int id){
        try{
            for (int i = 0; i < listaCelulares.size(); i++) {
                Celulares p = (Celulares) listaCelulares.get(i);
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
            listaCelulares.add(p);
        }
        else{
            JOptionPane.showMessageDialog(null, "Id já existe, não foi possível adicionar produto", "Erro", 0);
        }
    }
    
    public float valorTotal(){
        float acm = 0;
        for (int i = 0; i < listaCelulares.size(); i++) {
                Celulares p = (Celulares) listaCelulares.get(i);
                acm += p.valorTotal();
        }
        return acm;
    }
    //Métodos de Listagem
    
    public ArrayList listar(String marca){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaCelulares.size(); i++) {
                Celulares p = (Celulares) listaCelulares.get(i);
                if(p.getMarca().equalsIgnoreCase(marca)){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(int ano){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaCelulares.size(); i++) {
                Celulares p = (Celulares) listaCelulares.get(i);
                if(p.getLancamento().getYear() == ano){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(int anoMin, int anoMax){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaCelulares.size(); i++) {
                Celulares p = (Celulares) listaCelulares.get(i);
                if(p.getLancamento().getYear() > anoMin && p.getLancamento().getYear() < anoMax){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(float precoMin, float precoMax){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaCelulares.size(); i++) {
                Celulares p = (Celulares) listaCelulares.get(i);
                if(p.getPreco() > precoMin && p.getPreco() < precoMax){
                    aux.add(p);
                }
        }
        return aux;
    }
    
    public ArrayList GerarRelatorio(){
        ArrayList aux = new ArrayList();
        for (int i = 0; i < listaCelulares.size(); i++) {
                Celulares p = (Celulares) listaCelulares.get(i);
                if(p.getQnt()<= p.getMinQnt()){
                    aux.add(p);
                }
        }
        return aux;
    }
    // Métodos internos
    
    //verifica se já existe o mesmo id, se sim : false.
    private boolean verificaId(int id) {  
        for (int i = 0; i < listaCelulares.size(); i++) {
                Produto p = (Produto) listaCelulares.get(i);
                if(p.id == id){
                    return false;
                }
        }
        return true;
    }
    // Encontra um valor para novos Id's
    private int getNewId(){ 
        int maiorId = 0;
        for (int i = 0; i < listaCelulares.size(); i++) {
                Produto p = (Produto) listaCelulares.get(i);
                if(p.id > maiorId){
                    maiorId = p.id+1;
                }
        }
        return maiorId+1;
    }
}
