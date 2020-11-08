
package projetoInterdiciplinar.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Saver {
    public  File caminho;
    private FileWriter fw;
    private BufferedWriter escrever;
  
    public Saver (){ 
    }
     public Saver (String fileName){ 
      try{
        caminho = getArquivoInterno(fileName);
        fw = new FileWriter (caminho, false); // False - Irá reescrever o arquivo
        escrever = new BufferedWriter(fw);
      }
      catch (IOException e){
          JOptionPane.showMessageDialog(null, e.getMessage() + "O Saver não pode ser instanciado");
      }
  }
  //
    public void ReescreverObjetos(ArrayList lista, String cabecalho){      
        try{
            escrever.write(cabecalho);
            
            for (int i = 0; i < lista.size(); i++) {
            escrever.newLine();
            escrever.write(lista.get(i).toString());           
        }
        escrever.flush();           
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage() + " Houve um erro na escrita do arquivo: " + caminho);
        }
        finally{
            fecharArquivos();
        }
    }
     public void testeEscrever(String cabecalho){      
         try{
            escrever.write(cabecalho);
            escrever.flush();
         }
         catch (IOException e){
             JOptionPane.showMessageDialog(null, " Sem sucesso a sobreescrever " + caminho);
         }
    }
  
  
  
  
  //metodos internos
  private File getArquivoInterno (String fileName){
      File arq = new File("");
      try{        
            String caminho;
            String archivePath = new File("").getCanonicalPath();    
            caminho = archivePath.substring(0, archivePath.lastIndexOf("\\"));
            caminho += "\\"+fileName;
            
            arq = new File(caminho);
            if (!arq.exists()){
                arq.createNewFile();
                JOptionPane.showMessageDialog(null, "Atenção! Arquivo não existe por isso será criado um novo");
            }
        }      
      catch (IOException e){
          JOptionPane.showMessageDialog(null, e.getMessage() + " Um erro ocorreu ao encotrar arquivo");
      }      
      return arq;
  }
  
  private void fecharArquivos(){
      try{
        fw.close();
        escrever.close();
      }
      catch (IOException e){
          JOptionPane.showMessageDialog(null, e.getMessage() + " Não foi possível eliminar o arquivo escritor");
      }
  }
}
