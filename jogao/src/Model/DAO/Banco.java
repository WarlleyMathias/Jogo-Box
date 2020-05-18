/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import java.util.ArrayList;

import Model.Lutador;

/**
 *
 * @author tiago
 */
public class Banco {

    public static ArrayList<Lutador> lutador;
    
    
    public static void inicia(){
    
        //Instancia os Objetos

        lutador = new ArrayList<Lutador>();
        
        //criando elementos

        Lutador lutador1 = new Lutador(10, 10, "fernando", "Brasil", 18, 10, 10, 10);
  
        //Adiciona Elementos na lista

        
        lutador.add(lutador1);


        
    }
    
    
}
