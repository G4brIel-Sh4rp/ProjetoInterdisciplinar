
package projetoInterdiciplinar.controler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import projetoInterdiciplinar.entities.*;
import java.util.*;
import javax.swing.JOptionPane;



public class Estoque{
    
    private ArrayList listaProdutos = new ArrayList<Produto>();
    private String caminho;
    
    public Estoque (){}
    
    public Estoque (ArrayList lista){
        listaProdutos = lista;
    }
    public Estoque (String path){
        carregarCelulares(path);
        this.caminho = path;
    }
    
    private void carregarCelulares(String path){
        this.caminho = path;
        Loader carregar = new Loader(path);
        ArrayList<String[]> lista = carregar.lerLinhas();
        
        
        DateFormat padraoData = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList end = new ArrayList<Produto>();
        int id = -1;
        try{
            for (int i = 0; i < lista.size(); i++) {
                String[] aux = lista.get(i);
                id = Integer.parseInt(aux[0]);
                String modelo = aux[1];
                String marca = aux[2];
                int qnt = Integer.parseInt(aux[3]);
                int qntMin = Integer.parseInt(aux[4]);
                float preco = Float.parseFloat(aux[5]);
                Date lancam = padraoData.parse(aux[6]); 
                       
                Produto c = new Celulares(id, modelo, marca, qnt, qntMin, preco, lancam);
                end.add(c);
            }
        }
        catch (ParseException e){
            JOptionPane.showMessageDialog(null,"Houve um erro ao converter valores dentro do arquivo+"
                    + " Id do produto: " + id, "Erro", 0);
        }
            listaProdutos = end;
    }
    public void salvar(){
        Saver salvar = new Saver(caminho);
        String cabecalho = "Id,Nome,Marca,Quantidade,Quantidade Min,Valor,Data";
        salvar.ReescreverObjetos(listaProdutos, cabecalho);
    }
    
//    private void carregarCelulares(ArrayList<String[]> lista){
//        DateFormat padraoData = new SimpleDateFormat("dd/MM/yyyy");
//        ArrayList end = new ArrayList<Produto>();
//        int id = -1;
//        try{
//            for (int i = 0; i < lista.size(); i++) {
//                String[] aux = lista.get(i);
//                id = Integer.parseInt(aux[0]);
//                String modelo = aux[1];
//                String marca = aux[2];
//                float preco = Float.parseFloat(aux[3]);
//                int qnt = Integer.parseInt(aux[4]);
//                int qntMin = Integer.parseInt(aux[5]);
//                Date lancam = padraoData.parse(aux[6]); 
//                       
//                Produto c = new Celulares(id, modelo, marca, qnt, qntMin, preco, lancam);
//                end.add(c);
//            }
//        }
//        catch (ParseException e){
//            JOptionPane.showMessageDialog(null,"Houve um erro ao converter valores dentro do arquivo+"
//                    + " Id do produto: " + id, "Erro", 0);
//        }
//            listaProdutos = end;
//    }
    //Construtores e Metodos para Celulares
    public Celulares getProduto(int id){
        try{
            for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i); //Polimorfismo
                if(p.getId() == id){
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
        if(verificaId(p.getId())){   
            listaProdutos.add(p);
        }
        else{
            JOptionPane.showMessageDialog(null, "Id já existe, o produto foi adicionado como ", "Erro", 0);
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
    public ArrayList listar(){
        return listaProdutos;
    }
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
                Calendar anoLancamento = Calendar.getInstance();
                anoLancamento.setTime(p.getLancamento());
                
                if( anoLancamento.get(Calendar.YEAR) == ano){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(int anoMin, int anoMax){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);              
                Calendar anoLancamento = Calendar.getInstance();
                anoLancamento.setTime(p.getLancamento());
                
                if(anoLancamento.get(Calendar.YEAR) >= anoMin && anoMax >= anoLancamento.get(Calendar.YEAR)){
                    aux.add(p);
                }
        }
        return aux;
    }
    public ArrayList listar(float precoMin, float precoMax){
    ArrayList aux = new ArrayList();
        for (int i = 0; i < listaProdutos.size(); i++) {
                Celulares p = (Celulares) listaProdutos.get(i);
                if(p.getPreco() >= precoMin && p.getPreco() <= precoMax){
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
                if(p.getId() == id){
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
                if(p.getId() > maiorId){
                    maiorId = p.getId()+1;
                }
        }
        return maiorId+1;
    }
}
