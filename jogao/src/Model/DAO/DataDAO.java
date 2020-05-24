package Model.DAO;

import Model.Data;

public class DataDAO {

	/**
     * Insere uma data dentro do banco de dados.
     * @insert exige que seja passado um objeto do tipo Data.
     */
    public void insert(Data data){
        Banco.data.add(data);
    }
    /**
     * Atualiza um Objeto do tipo Data no banco de dados.
     * @update exige que seja passado um objeto do tipo Data.
     * 
     */
    public boolean update(Data data){  
        for (int i = 0; i < Banco.data.size(); i++) {
                Banco.data.set(i,data);
                return true;
        }
        return false;      
    }
    /**
     * Pega um objeto do tipo Data do banco de dados.
     * @return data.
     */
    public Data getData(){
        for (Data dataLista : Banco.data) {
                return dataLista;
        }
		return null;
    }	
}
