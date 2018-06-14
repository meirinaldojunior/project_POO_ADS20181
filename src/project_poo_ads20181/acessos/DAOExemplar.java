/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.acessos;

/**
 *
 * @author Hugo
 */
import java.util.ArrayList;
import project_poo_ads20181.classes.Exemplar;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

public interface DAOExemplar {
        
    
        public void inserir (Exemplar exemplar) throws ConexaoException, DAOException;
	    
	public void alterar (Exemplar exemplar) throws ConexaoException, DAOException;
	    
	public void excluir (Exemplar exemplar) throws ConexaoException, DAOException;
	    
	public ArrayList<Exemplar> lista() throws ConexaoException, DAOException;
        
        public ArrayList<Exemplar> lista(int idLivro) throws ConexaoException, DAOException;
	    
	Exemplar consultaIdExemplar(Integer idExemplar) throws ConexaoException, DAOException;
    
        public Exemplar get(Integer idExemplar) throws ConexaoException, DAOException;
}
