/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoInterdiciplinar.controler.helpers;

import java.util.Date;
import projetoInterdiciplinar.controler.ControllerEditar;
import projetoInterdiciplinar.entities.Celulares;
import projetoInterdiciplinar.entities.Produto;
import projetoInterdiciplinar.viwers.EditarProduto;


public class HelperEditarProduto {
  private EditarProduto view;

    public HelperEditarProduto(EditarProduto view) {
        this.view = view;
    }
    
    public void setModelo (Celulares c){
        String nome = c.getNome();
        String marca = c.getMarca();
        float preco = c.getPreco();
        int qnt = c.getQnt();
        int qntMin = c.getQntMin();
        Date lancamento = c.getLancamento();
        
        view.getTxtBoxNome().setText(nome);
        view.getTxtBoxMarca().setText(marca);
        view.getSpinnerPreco().setValue(preco);
        view.getSpinnerQtd().setValue(qnt);
        view.getSpinnerQtdMin().setValue(qntMin);
        view.getSpinnerData().setValue(lancamento);
        
        
    }
    public void unlockInputs(){
        view.getSpinnerID().setEnabled(false);
        view.getTxtBoxNome().setEnabled(true);
        view.getTxtBoxMarca().setEnabled(true);
        view.getSpinnerPreco().setEnabled(true);
        view.getSpinnerQtd().setEnabled(true);
        view.getSpinnerData().setEnabled(true);
        view.getSpinnerQtdMin().setEnabled(true);
    }
    public void lockInputs(){
        view.getSpinnerID().setEnabled(true);
        view.getTxtBoxNome().setEnabled(false);
        view.getTxtBoxMarca().setEnabled(false);
        view.getSpinnerPreco().setEnabled(false);
        view.getSpinnerQtd().setEnabled(false);
        view.getSpinnerData().setEnabled(false);
        view.getSpinnerQtdMin().setEnabled(false);
    }
    public void limpaTudo(){
        view.getSpinnerID().setValue(0);
        view.getTxtBoxNome().setText("");
        view.getTxtBoxMarca().setText("");
        view.getSpinnerPreco().setValue(1000);
        view.getSpinnerQtd().setValue(0);
        view.getSpinnerData().setValue(new Date());
        view.getSpinnerQtdMin().setValue(0);
    }
}
