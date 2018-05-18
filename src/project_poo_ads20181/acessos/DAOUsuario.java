package project_poo_ads20181.acessos;

/**
*
* @author Hugo Felipe
*/

import java.util.ArrayList;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

public interface DAOUsuario {


	  	public void inserir (Usuario usuario) throws ConexaoException, DAOException;
	    
	    public void alterar (Usuario usuario) throws ConexaoException, DAOException;
	    
	    public void excluir (Usuario usuario) throws ConexaoException, DAOException;
	    
	    public ArrayList<Usuario> lista() throws ConexaoException, DAOException;
	    
		Usuario consultaCpf(String cpf) throws ConexaoException, DAOException;
	
}

