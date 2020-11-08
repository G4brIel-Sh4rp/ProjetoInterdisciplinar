
package projetoInterdiciplinar.entities;

import java.util.Date;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

public class Celulares extends Produto{
    private int qntMin;
    private Date dataLancamento;    
    private final DateFormat padraoData = new SimpleDateFormat("dd/MM/yyyy");
    
    public Celulares (int id, String modelo, String marca, int qnt, int qntMin, float preco, Date lancamento){
        this.id = id;
        this.nome = validaNome(modelo);
        this.marca = validaNome(marca);      
        this.qntEstoque = qnt;
        this.qntMin = qntMin;
        this.preco = preco;
        this.dataLancamento = lancamento;
    }
    
    //Método set
    
    public void setTudo(String modelo, String marca, int qnt, int qntMin, float preco, Date lancamento){
        this.nome = validaNome(modelo);
        this.marca = validaNome(marca);      
        this.qntEstoque = qnt;
        this.qntMin = qntMin;
        this.preco = preco;
        this.dataLancamento = lancamento;
    }
    
    //metodos get
    public Date getLancamento(){
        return dataLancamento;
    }
    public int getQntMin(){
        return qntMin;
    }
    
    //Dos métodos abstratos:  
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
