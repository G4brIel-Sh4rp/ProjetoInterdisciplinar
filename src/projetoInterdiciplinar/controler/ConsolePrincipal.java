/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoInterdiciplinar.controler;

import projetoInterdiciplinar.entities.Celulares;
import projetoInterdiciplinar.entities.Produto;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import projetoInterdiciplinar.entities.*;

public class ConsolePrincipal {
    //TODO metodos que jogam throws
    // GetNewId implementação
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList cellList = new ArrayList<Produto>();       
        Estoque estCel = new Estoque("teste.csv");
        
        
        

        
        Celulares p1 = new Celulares(6,"StartList","Gnusmas",2,1,999.99f,formatar.parse("12/11/2015"));      
        Celulares p2 = new Celulares(7,"StarA","KPhone",10,3,1500.00f,formatar.parse("12/1/2018"));
        Celulares p3 = new Celulares(8,"Star5","KPhone",45,3,1254.00f,formatar.parse("12/12/2018"));
        Celulares p4 = new Celulares(9,"Stard","Gnusmas",20,1,2001.99f,formatar.parse("12/11/2019"));      
        Celulares p5 = new Celulares(10,"Star15Plus","KPhone",13,5,858.00f,formatar.parse("12/12/2017"));
        Celulares p6 = new Celulares(11,"Star05","KPhone",13,10,1900.00f,formatar.parse("12/12/2016"));
        Celulares p7 = new Celulares(12,"StarX","Gnusmas",12,7,1200.99f,formatar.parse("12/6/2018"));      
        Celulares p8 = new Celulares(13,"StarZ","KPhone",20,6,1100.00f,formatar.parse("12/12/2020"));
        Celulares p9 = new Celulares(14,"FinishList","KPhone",30,10,1300.00f,formatar.parse("12/12/2017"));
        estCel.addProduto(p1);
        estCel.addProduto(p2);
        estCel.addProduto(p3);
        
        estCel.addProduto(p4);
        estCel.addProduto(p5);
        estCel.addProduto(p6);
        estCel.addProduto(p7);
        estCel.addProduto(p8);
        estCel.addProduto(p9);
        

        estCel.salvar();
        imprimeLista(estCel.listar());  
    }
    public static void imprimeLista(ArrayList lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
    
}
