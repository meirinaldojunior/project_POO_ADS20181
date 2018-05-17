package project_poo_ads20181.acessos;

/**
*
* @author Hugo Felipe
*/

import java.util.ArrayList;
import project_poo_ads20181.classes.Aluguel;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

public interface DAOAluguel {

	  	public void inserir (Aluguel aluguel) throws ConexaoException, DAOException;
	    
	    public void alterar (Aluguel aluguel) throws ConexaoException, DAOException;
	    
	    public void excluir (Aluguel aluguel) throws ConexaoException, DAOException;
	    
	    public ArrayList<Aluguel> lista() throws ConexaoException, DAOException;
	
}
