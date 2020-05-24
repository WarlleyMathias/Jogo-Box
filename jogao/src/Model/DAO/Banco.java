package Model.DAO;

import java.util.ArrayList;

import Model.Contador;
import Model.Data;
import Model.Lutador;

/**
 *
 * @author Warlley
 */
public class Banco {

    public static ArrayList<Lutador> lutador;
    public static ArrayList<Data>data;
    public static ArrayList<Contador>contador;
    
    public static void inicia(){
    
        //Instancia os Objetos

        lutador = new ArrayList<Lutador>();
        data    = new ArrayList<Data>();
        contador = new ArrayList<Contador>();
        
        //criando elementos
        Contador contador1 = new Contador(1,-1);
        Contador contador2 = new Contador(2,-1);
        Contador contador3 = new Contador(3,0);
        Contador dado      = new Contador(4,-1);
        Contador estilo    = new Contador(5,0);
        Data    data1    = new Data   (1,1,2020);
        Lutador lutador1 = new Lutador(10, 15, "ro", "Brasil", 18, 50, 20, 14);
        Lutador lutador2 = new Lutador(2, 10, "fernando", "Brasil", 18, 50, 20, 10);
        Lutador lutador3 = new Lutador(3, 10, "roberto", "Brasil", 18, 50, 20, 10);
        Lutador lutador4 = new Lutador(4, 10, "Pablo", "Brasil", 18, 45, 20, 10);
        Lutador lutador5 = new Lutador(5, 10, "joão", "Brasil", 18, 50, 30, 10);
        Lutador lutador6 = new Lutador(6, 10, "ricardo", "Brasil", 18, 60, 20, 10);
        Lutador lutador7 = new Lutador(7, 10, "diego", "Brasil", 18, 50, 15, 10);
        Lutador lutador8 = new Lutador(8, 10, "guga", "Brasil", 18, 50, 20, 10);
        Lutador lutador9 = new Lutador(9, 10, "matheus", "Brasil", 18, 50, 20, 10);
        Lutador lutador10 = new Lutador(1, 10, "matheus", "Brasil", 18, 50, 20, 10);
  
        //Adiciona Elementos na lista
        
        contador.add(estilo);
        contador.add(dado);
        contador.add(contador3);
        contador.add(contador2);
        contador.add(contador1);
        data   .add(data1);
        lutador.add(lutador1);
        lutador.add(lutador2);
        lutador.add(lutador3);
        lutador.add(lutador4);
        lutador.add(lutador5);
        lutador.add(lutador6);
        lutador.add(lutador7);
        lutador.add(lutador8);
        lutador.add(lutador9);
        lutador.add(lutador10);
    }
    
    
}
