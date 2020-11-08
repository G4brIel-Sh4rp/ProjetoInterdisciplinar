
package projetoInterdiciplinar.controler;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import projetoInterdiciplinar.viwers.Creditos;

public class ControllerCreditos {
    private final Creditos view;
    private final JTextArea txtArea;
    
    public ControllerCreditos(Creditos view) {
        this.view = view;
        this.txtArea = view.getTxtAreaCreditos();
    }
    
    
    public void escreveLinhas(int i){
        String l1 = "---CRÉDITOS---\n";
        String l2 = "Created by Gabriel Pinheiro\n";
        String l3 = "RGM: 2303155-7\n";
        switch(i){
            case 1:
                    adicionarLinhas(l1);
                break;
            case 2:
                    adicionarLinhas(l2);
                break;
            case 3:
                adicionarLinhas(l3);
                break;
        }
    }
    public void adicionarLinhas(String linha){
        try{        
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
		e.printStackTrace();
            }
                txtArea.append(linha);
        }
        catch (Exception e){
            System.out.println("Erro,");
        }
    }
    
}
