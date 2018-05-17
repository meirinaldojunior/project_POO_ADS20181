package project_poo_ads20181.acessos;

import java.util.ArrayList;
import project_poo_ads20181.classes.Atendente;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author Meirinaldo
 */
public interface DAOAtendente {
    
    /**
     * Grava o atendente no BD
     * @param p Objeto com os dados validos
     * @throws ConexaoException 
     * @throws DAOException 
     */
    public void inserir(Atendente at)throws ConexaoException,DAOException;
    
    /**
     * Altera os registros do atendente
     * @param p Objeto com os dados
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void alterar(Atendente at)throws ConexaoException,DAOException;
    
    /**
     * Lista os atendendentes
     * @return
     * @throws ConexaoException
     * @throws DAOException 
     */
    public ArrayList<Atendente> listar() throws ConexaoException,DAOException;
    
    /**
     * Exlui o atendente
     * @param a
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void excluir(Atendente a)throws ConexaoException,DAOException;
}
