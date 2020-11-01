
package projetoInterdiciplinar.entities;

import projetoInterdiciplinar.entities.Produto;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class Celulares extends Produto{
    private int qntMin;
    private Date dataLancamento;    
    private DateFormat padraoData = new SimpleDateFormat("dd/MM/yyyy");
    
    public Celulares (int id, String modelo, String marca, int qnt, int qntMin, float preco, Date lancamento){
        this.id = id;
        this.nome = validaNome(modelo);
        this.marca = validaNome(marca);      
        this.qntEstoque = qnt;
        this.qntMin = qntMin;
        this.preco = preco;
        this.dataLancamento = lancamento;
    }
    
    public void setTudo(String modelo, String marca, int qnt, int qntMin, float preco, Date lancamento){
        this.nome = validaNome(modelo);
        this.marca = validaNome(marca);      
        this.qntEstoque = qnt;
        this.qntMin = qntMin;
        this.preco = preco;
        this.dataLancamento = lancamento;
    }
    
    //metodos set
    
    //metodos get
    public Date getLancamento(){
        return dataLancamento;
    }
    public int getQntMin(){
        return qntMin;
    }
    
    //Dos métodos abstratos:
    @Override
    public void atualizaEstoque (int qnt){ // para incremento e decremento do valor estoque
        try{
            if (qntEstoque + qnt < 0){
                throw new Exception("Impossivel retirar! quantidade em estoque não pode ser menor que 0");
            }
            else{
                qntEstoque += qntEstoque + qnt; 
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
        }
    } 
    @Override
        protected String validaNome (String nome) throws ClassFormatError{  
        try{
            if (nome.length() >= 2 && nome.length()<20){
                    if (!nome.isBlank() || !nome.isEmpty() || !isNumeric(nome)){
                        return nome;
                    }
            }
            else{
                throw new Exception("Nome Inválido!");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
             
        }
        return this.nome;
    }
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return id+","+nome+","+marca+","+qntEstoque+","+qntMin+","+preco+","+padraoData.format(dataLancamento);
    }
}
