
package projetoInterdiciplinar.controler;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import projetoInterdiciplinar.entities.Celulares;
import projetoInterdiciplinar.viwers.Relatorio;



public class ControllerRelatorio {
    private final Estoque etqCell = new Estoque("produtos.csv");
    private final Relatorio view;  
    DecimalFormat df = new DecimalFormat("#,###.00");
    SimpleDateFormat formatarData = new SimpleDateFormat("MMM/yyyy");
    private final JTable tabela;
    
    public ControllerRelatorio(Relatorio view) {
        this.view = view;
        this.tabela = view.tabela();
    }
    public void editarColunas(){
        tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(120);
    }
    
    public void addRowTabela(){        
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        ArrayList<Celulares> list = etqCell.GerarRelatorio();
        if(list.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum produto em mínima");
        }
        Object rowData[] = new Object[6];
        
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getId();
            rowData[1] = list.get(i).getNome();
            rowData[2] = list.get(i).getMarca();
            rowData[3] = list.get(i).getQnt();
            rowData[4] = list.get(i).getQntMin();
            rowData[5] = "R$  "+ df.format(list.get(i).getPreco());      
            
            modelo.addRow(rowData);
            
            DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
            cell.setForeground(Color.BLUE);
            
        }
        
    }
    
}
