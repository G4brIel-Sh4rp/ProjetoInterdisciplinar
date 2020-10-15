
package projetoInterdiciplinar;

import java.util.Date;


public class Celulares extends Produto{
    private String modelo;
    private Date dataLancamento;
    
    public Celulares (int id, String nome, String marca, int qnt, int qntMin, float preco, String modelo, Date lancamento){
        super(id, nome, marca, qnt, qntMin, preco);
        this.modelo = modelo;
        this.dataLancamento = lancamento;
    }
    
    public void setTudo(String nome, String marca, int qnt, int qntMin, float preco, String modelo, Date lancamento){
        this.nome = validaNome(nome);
        this.marca = validaNome(marca);      
        this.qntEstoque = qnt;
        this.qntMin = qntMin;
        this.preco = preco;
        this.modelo = modelo;
        this.dataLancamento = lancamento;
    }
    
    //metodos set
    
    //metodos get
    public Date getLancamento(){
        return dataLancamento;
    }

}
