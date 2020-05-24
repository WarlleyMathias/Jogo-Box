package Model.DAO;

import Model.Contador;

public class ContadorDAO {
	/**
     * Insere um contador dentro do banco de dados.
     * @insert exige que seja passado um objeto do tipo Contador.
     */
    public void insert(Contador contador){
        Banco.contador.add(contador);
    }
    
    /**
     * Atualiza um Objeto do tipo Contador no banco de dados.
     * @update exige que seja passado um objeto do tipo Contador.
     * 
     */
    public boolean update(Contador contador){  
        for (int i = 0; i < Banco.data.size(); i++) {
                Banco.contador.set(i,contador);
                return true;
        }
        return false;      
    }
    /**
     * Pega um objeto do tipo Contador do banco de dados.
     * @return contador1.
     */
    public Contador getContador(){
    	for (Contador contadorLista : Banco.contador) {
            if(contadorLista.getId() == 1){
                return contadorLista;
                }
            }
    	return null;
    	}
    /**
     * Pega um objeto do tipo Contador do banco de dados.
     * @return contador2.
     */
    public Contador getContador2(){
    	for (Contador contadorLista : Banco.contador) {
            if(contadorLista.getId() == 2){
                return contadorLista;
                }
            }
    	return null;
    	}
    
    /**
     * Pega um objeto do tipo Contador do banco de dados.
     * @return contador3.
     */
    public Contador getContador3(){
    	for (Contador contadorLista : Banco.contador) {
            if(contadorLista.getId() == 3){
                return contadorLista;
                }
            }
    	return null;
    	}
    /**
     * Pega um objeto do tipo Contador do banco de dados.
     * @return dado.
     */
    public Contador getdado(){
    	for (Contador contadorLista : Banco.contador) {
            if(contadorLista.getId() == 4){
                return contadorLista;
                }
            }
    	return null;
    	}
    
    /**
     * Pega um objeto do tipo Contador do banco de dados.
     * @return estilo.
     */
    public Contador getEstilo(){
    	for (Contador contadorLista : Banco.contador) {
            if(contadorLista.getId() == 5){
                return contadorLista;
                }
            }
    	return null;
    	}
}
