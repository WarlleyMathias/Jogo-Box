/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Lutador;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class LutadorDAO {
    
    
    /**
     * Insere um lutador dentro do banco de dados
     * @param lutador exige que seja passado um objeto do tipo lutador
     */
    public void insert(Lutador lutador){
        Banco.lutador.add(lutador);
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param lutador
     * @return 
     */
    public boolean update(Lutador lutador){
        
        for (int i = 0; i < Banco.lutador.size(); i++) {
            if(idSaoIguais(Banco.lutador.get(i),lutador)){
                Banco.lutador.set(i, lutador);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do lutador passado
     * @param lutador
     * @return 
     */
    public boolean delete(Lutador lutador){
        for (Lutador lutadorLista : Banco.lutador) {
            if(idSaoIguais(lutadorLista,lutador)){
                Banco.lutador.remove(lutadorLista);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna um arraylist com todos os lutadores do banco de dados
     * @return uma lista com todos os registros do banco
     */
    public ArrayList<Lutador> selectAll(){
        return Banco.lutador;
    }

    /**
     * Retorna um Objeto do tipo lutador se a funcao encontrar o lutador passado como par√¢metro no banco, para considerar È usado id
     * @param lutador
     * @return Lutador encontrado no banco de dados
     */
    
    public boolean compare(Lutador lutador){
        for (Lutador lutadorLista : Banco.lutador) {
            if(idSaoIguais(lutadorLista,lutador)){
                return true;
            }
        }
        return false;
    }
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param lutador
     * @param lutadorAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    private boolean idSaoIguais(Lutador lutador, Lutador lutadorAComparar) {
        return lutador.getId() ==  lutadorAComparar.getId();
    }
    
    
    
    /**
     * retorna lutador da lista
     */
    public Lutador getLutador(){
        for (Lutador lutadorLista : Banco.lutador) {
            if(lutadorLista.getId() == 11){
                return lutadorLista;
            }
        }
		return null;
    }
    
    /**
     * retorna Oponente da lista
     */
    public Lutador getOponente(){
        for (Lutador lutadorLista : Banco.lutador) {
            if(lutadorLista.getId() == 10){
                return lutadorLista;
            }
        }
		return null;
    }
    
    
}
