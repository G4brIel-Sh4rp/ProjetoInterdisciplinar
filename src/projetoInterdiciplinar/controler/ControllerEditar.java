
package projetoInterdiciplinar.controler;

import java.text.SimpleDateFormat;
import java.util.Date;
import projetoInterdiciplinar.controler.helpers.HelperEditarProduto;
import projetoInterdiciplinar.entities.Celulares;
import projetoInterdiciplinar.viwers.EditarProduto;

public class ControllerEditar {
    
    private final Estoque estoque;
    private final EditarProduto view;
    private final HelperEditarProduto helper;
       
    public ControllerEditar(EditarProduto view) {
        this.estoque = new Estoque("produtos.csv");
        this.view = view;
        this.helper = new HelperEditarProduto(view);
    }
    
    //Do botao busca
    public void editar(){
        int id = (int) view.getSpinnerID().getValue();
        if(!estoque.verificaId(id)){
            Celulares c = estoque.getProduto(id);
            helper.setModelo(c);
            helper.unlockInputs();
        }
        else{
            view.ExibirMensagem("Id não existente!");
        }
    }
    //Do botao salvar
    public void salvar(){
            int id = (int) view.getSpinnerID().getValue();
            
            SimpleDateFormat formatar = new SimpleDateFormat("MM/yyyy");
            String nome = view.getTxtBoxNome().getText();
            String marca = view.getTxtBoxMarca().getText();
            int qtd =(int) view.getSpinnerQtd().getValue();
            int qtdMin = (int) view.getSpinnerQtdMin().getValue();            
            Date lancamento = (Date) view.getSpinnerData().getValue();
            float preco = (float) view.getSpinnerPreco().getValue();
            
            Celulares c = estoque.getProduto(id);
            c.setTudo(nome, marca, qtd, qtdMin, preco, lancamento);
            estoque.salvar();
            view.ExibirMensagem("Produto Adicionado!");
            cancelar();
    }
    //Do botao cancelar
    public void cancelar(){
        helper.limpaTudo();
        helper.lockInputs();
    }
}
