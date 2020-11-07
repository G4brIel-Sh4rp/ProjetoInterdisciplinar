
package projetoInterdiciplinar.controler;

import javax.swing.plaf.DesktopPaneUI;
import projetoInterdiciplinar.viwers.*;


public class ControllerMenu {
    
    private Menu view;
    
    public ControllerMenu( Menu view){
        this.view = view;
    }
    
    public void navergarAdicionar(){
        AdicionarCelular adicionar = new AdicionarCelular();
        view.addComponentDesktopPane(adicionar);
        adicionar.setVisible(true);
       

    }
    public void navegarConsulta(){
        JEstoque estoque = new JEstoque();
        estoque.setVisible(true);
    }
    public void navegarEditarProduto(){
        EditarProduto editar = new EditarProduto();
        view.addComponentDesktopPane(editar);
        editar.setVisible(true);
    }
}
