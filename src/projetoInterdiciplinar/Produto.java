
package projetoInterdiciplinar;

import javax.swing.JOptionPane;

/*TODO Set's de numeros verificar se é numerico
Get's Gerais
*/
public class Produto {
    protected int id;
    protected String nome;
    protected String marca;
    protected int qntEstoque;
    protected int qntMin;
    protected float preco;
   
    public Produto (int id, String nome, String marca, int qnt, int qntMin, float preco){
        this.id = id;
        this.nome = validaNome(nome);
        this.marca = validaNome(marca);      
        this.qntEstoque = qnt;
        this.qntMin = qntMin;
        this.preco = preco;
    }
    // métodos SET
    
    public void setNome (String nome){
        this.nome = validaNome(nome);
    }
    public void setMarca (String marca){
        this.marca = validaNome(marca);
    }
    public void atualizaEstoque (int qnt){ // para incremento e decremento do valor estoque
        int aux = qntEstoque;
        if (aux + qnt < 0){
            
        }
    }
    public void setEstoque (int qnt){     
    }
    
    //métodos get
    public String getNome(){
        return nome;
    }
    public float getPreco(){
        return preco;
    }
    public String getMarca(){
        return marca;
    }
    public int getQnt(){
        return qntEstoque;
    }
    public int getMinQnt(){
        return qntMin;
    }
    
    //Métodos Gerais
    public void setTudo(String nome, String marca, int qnt, int qntMin, float preco){
        this.nome = validaNome(nome);
        this.marca = validaNome(marca);      
        this.qntEstoque = qnt;
        this.qntMin = qntMin;
        this.preco = preco;
    }
    
    public float valorTotal (){
        return qntEstoque*preco;
    }
    
    // métodos internos
    protected String validaNome (String nome){  
        try{
            if (nome.length() >= 3 && nome.length()<20){
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
    
    protected boolean isNumeric(String strNum) {
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
}
