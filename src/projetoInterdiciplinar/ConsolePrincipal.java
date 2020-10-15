/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoInterdiciplinar;

import java.util.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class ConsolePrincipal {
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        Celulares p = new Celulares(1,"smartPhone","Gnusmas",2,1,999.99f,"Star2",formatar.parse("12/11/2019"));      
        System.out.println(formatar.format(p.getLancamento()));
        
    }
    
}
