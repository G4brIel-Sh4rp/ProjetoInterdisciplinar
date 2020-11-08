
package projetoInterdiciplinar.controler;

import projetoInterdiciplinar.viwers.*;


public class ControllerMenu {
    
    private Menu view;
    
    public ControllerMenu( Menu view){
        this.view = view;
    }
    
    //Métodos de navegação
    
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

    public void navegarRelatorio() {
        Relatorio relatorio = new Relatorio();
        view.addComponentDesktopPane(relatorio);
        relatorio.setVisible(true);
    }    
    public void navegarSobre(){
        Sobre sobre = new Sobre();
        view.addComponentDesktopPane(sobre);
        sobre.setVisible(true);
    }
    public void navegarCreditos(){
        Creditos credit = new Creditos();
        view.addComponentDesktopPane(credit);
        credit.setVisible(true);
    }
}
