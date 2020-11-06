
package projetoInterdiciplinar.controler;

import projetoInterdiciplinar.viwers.*;
import projetoInterdiciplinar.controler.Estoque;
import projetoInterdiciplinar.controler.helpers.HelperAdicionarCelular;
import projetoInterdiciplinar.entities.Celulares;
        
public class ControllerAdicionar {
    private AdicionarCelular view;
    private Estoque etqCell;
    private HelperAdicionarCelular helper;
    
    public ControllerAdicionar(AdicionarCelular view) {
        this.view = view;
        etqCell = new Estoque("teste.csv");
        helper = new HelperAdicionarCelular(view);
    }
    
    public void adicionarProduto(){
        int newId = etqCell.getNewId();
        Celulares c = helper.getModelCelular(newId);             
        if(c == null){
            view.exibirMensagem("Ocorreu um erro e não foi possível adicionar este produto");
        }
        else{
            etqCell.addProduto(c);
            etqCell.salvar();
            view.exibirMensagem("Produto adicionado com sucesso!");
        }
    }
}
