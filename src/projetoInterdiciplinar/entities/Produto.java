
package projetoInterdiciplinar.entities;

import javax.swing.JOptionPane;


public abstract class Produto {
    protected int id;
    protected String nome;
    protected String marca;
    protected int qntEstoque;
    protected float preco;
   

    public void setNome (String nome){
        this.nome = validaNome(nome);
    }
    public void setMarca (String marca){
        this.marca = validaNome(marca);
    }


    public void setEstoque (int qnt){
       try{
            if (qntEstoque + qnt < 0){
                throw new Exception("Impossivel retirar! quantidade em estoque não pode ser menor que 0");
            }
            else{
                qntEstoque = qnt; 
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
        }
    }
    
    //métodos get
        public int getId (){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public float getPreco(){
        return preco;
    }
    public int getQnt(){
        return qntEstoque;
    }
    public String getMarca(){
        return marca;
    }
    
    public float valorTotal (){
        return qntEstoque*preco;
    }
    
    
    // métodos internos
    protected abstract String validaNome (String nome);  

    
    protected boolean isNumeric(String strNum){
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } 
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    @Override
    public abstract String toString();
}
