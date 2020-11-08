
package projetoInterdiciplinar.controler.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import projetoInterdiciplinar.viwers.AdicionarCelular;
import projetoInterdiciplinar.entities.Celulares;

public class HelperAdicionarCelular {
    private final AdicionarCelular view;

    public HelperAdicionarCelular(AdicionarCelular view) {
        this.view = view;
    }
    public Celulares getModelCelular(int id){
        Celulares c = null;
        try{  
            SimpleDateFormat formatar = new SimpleDateFormat("MM/yyyy");
            String nome = view.getTxtBoxNome().getText();
            String marca = view.getTxtBoxMarca().getText();
            int qtd =(int) view.getSpinnerQtd().getValue();
            int qtdMin = (int) view.getSpinnerQtdMin().getValue();
             
            Date lancamento = (Date) view.getSpinnerData().getValue();
            float preco = (float) view.getSpinnerPreco().getValue();
            c = new Celulares(id,nome, marca, qtd, qtdMin, preco,lancamento);
        }
        catch(Exception e ){
            view.exibirMensagem("Ocorreu um erro ao criar o modelo");
        }
        return c;
    }
}
