/*
 * Essa classe tem como objetivo carregar, criar e salvar arquivos .csv 
 */
package projetoInterdiciplinar.entities;
    import java.io.*;
    import javax.swing.JOptionPane;
    import java.util.*;

 public class Loader {
    public  File caminho;
    private FileReader fr;
    private BufferedReader leitor;

  
    public Loader (){ 
    }
     public Loader (String fileName){ 
         setCaminho(fileName);
    }
     
     //set
     public void setCaminho (String fileName){
        try{
            caminho = getArquivoInterno(fileName);
            fr = new FileReader (caminho);
            leitor = new BufferedReader(fr);
      }
      catch (IOException e){
          JOptionPane.showMessageDialog(null, e.getMessage() + "O carregador não pode ser instanciado");
      }
     }
    //
    public ArrayList<String[]> lerLinhas(){
        ArrayList listValores = new ArrayList<String[]>();
        try{
            leitor.readLine(); // pular leitura do cabecalho
            while (leitor.ready()){
                String[] valores = leitor.readLine().split(",");
                listValores.add(valores);
            }
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage() + " Houve um erro na leitura das linhas do arquivo: " + caminho);
        }
        finally{
            fecharArquivos();
        }
        return listValores;
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
        fr.close();
        leitor.close();
      }
      catch (IOException e){
          JOptionPane.showMessageDialog(null, e.getMessage() + " Não foi possível eliminar o arquivo leitor");
      }
  }
  

}
