package Model.DAO;

import Model.Lutador;
import java.util.ArrayList;
import java.util.Random;

public class LutadorDAO {
    /**
     * Insere um lutador dentro do banco de dados.
     * @insert exige que seja passado um objeto do tipo Lutador.
     */
    public void insert(Lutador lutador){
        Banco.lutador.add(lutador);
    }
    /**
     * Atualiza um Objeto do tipo Lutador no banco de dados.
     * @update exige que seja passado um objeto do tipo Lutador.
     * 
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
     * Deleta um objeto do tipo Lutador do banco de dados.
     * @delete exige que seja passado um objeto do tipo Lutador.
     * @return Verdadeiro, se encontrar o ludador com id igual, ao passado como parametro.
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
     * Retorna um arraylist com todos os lutadores do banco de dados.
     * @return uma lista com todos os registros do banco.
     */
    public ArrayList<Lutador> selectAll(){
        return Banco.lutador;
    }

    /**
     * Compara um Lutador passado como parametro, e um Lutador do banco de dados.
     * 
     * @return Verdadeiro, se encontrar o ludador com id igual, ao passado como parametro.
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
     * Compara se dois objetos tem a propriedade id igual.
     * @param lutador.
     * @param lutadorAComparar.
     * @return verdadeiro caso os id forem iguais e falso se nao forem.
     */
    private boolean idSaoIguais(Lutador lutador, Lutador lutadorAComparar) {
        return lutador.getId() ==  lutadorAComparar.getId();
    }
    /**
     * Pega um objeto do tipo Lutador do banco de dados.
     * @return lutador.
     */
    public Lutador getLutador(){
        for (Lutador lutadorLista : Banco.lutador) {
            if(lutadorLista.getId() == 0){
                return lutadorLista;
            }
        }
		return null;
    }
    /**
     * Pega um objeto do tipo Lutador do banco de dados.
     * @return oponente.
     */
    public Lutador getOponente(){
    	Random r = new Random();
    	int a = r.nextInt(11);
    	if(a == 0 ) {
    		while(a == 0) {
    			a = r.nextInt(11);
    		}
    	}
        for (Lutador lutadorLista : Banco.lutador) {
            if(lutadorLista.getId() == a){
                return lutadorLista;
            }
        }
		return null;
    }
    /**
     * Pega um objeto do tipo Lutador do banco de dados.
     * @param id
     * @return Oponente
     */
    public Lutador getOponenteID(int id){
        for (Lutador lutadorLista : Banco.lutador) {
            if(lutadorLista.getId() == id){
                return lutadorLista;
            }
        }
		return null;
    }
}
