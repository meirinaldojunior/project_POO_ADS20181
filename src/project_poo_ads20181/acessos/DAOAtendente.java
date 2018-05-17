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
     * Insere o registro do atendente
     * @param a recebe o objeto do atendente
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void inserir(Atendente a)throws ConexaoException,DAOException;
    
    /**
     * Altera o registro do atendente
     * @param a recebe o objeto do atendente
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void alterar(Atendente a)throws ConexaoException,DAOException;
    
    /**
     * Listar atendentes
     * @return uma lista de atendentes
     * @throws ConexaoException
     * @throws DAOException 
     */
    public ArrayList<Atendente> listar() throws ConexaoException,DAOException;
    
    /**
     * Exluir o atendente
     * @param a recebe o objeto do atendente
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void excluir(Atendente a)throws ConexaoException,DAOException;
}
