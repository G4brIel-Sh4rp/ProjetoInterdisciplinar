/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoInterdiciplinar;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ConsolePrincipal {
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList cellList = new ArrayList<Produto>();
        
        Celulares p1 = new Celulares(1,"StarF","Gnusmas",2,1,999.99f,formatar.parse("12/11/2015"));      
        Celulares p2 = new Celulares(2,"StarA","KPhone",10,3,1500.00f,formatar.parse("12/1/2018"));
        Celulares p3 = new Celulares(3,"Star5","KPhone",45,3,1254.00f,formatar.parse("12/12/2018"));
        Celulares p4 = new Celulares(4,"Stard","Gnusmas",20,1,2001.99f,formatar.parse("12/11/2019"));      
        Celulares p5 = new Celulares(5,"Star15Plus","KPhone",13,5,858.00f,formatar.parse("12/12/2017"));
        Celulares p6 = new Celulares(6,"Star05","KPhone",13,10,1900.00f,formatar.parse("12/12/2016"));
        Celulares p7 = new Celulares(7,"StarX","Gnusmas",12,7,1200.99f,formatar.parse("12/6/2018"));      
        Celulares p8 = new Celulares(8,"StarZ","KPhone",20,6,1100.00f,formatar.parse("12/12/2020"));
        Celulares p9 = new Celulares(9,"StarALPHA","KPhone",30,10,1300.00f,formatar.parse("12/12/2017"));
        
        Celulares p10 = new Celulares(10,"StarALPHA","KPhone",30,10,1300.00f,formatar.parse("12/12/2017"));
        
        cellList.add(p1);
        cellList.add(p2);
        cellList.add(p3);
        cellList.add(p4);
        cellList.add(p5);
        cellList.add(p6);
        cellList.add(p7);
        cellList.add(p8);
        cellList.add(p9);
        
        Estoque estoque = new Estoque(cellList);
        System.out.println("Get Produto id inexistente");
        
    }
    public static void imprimeLista(ArrayList lista){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }
    
}
