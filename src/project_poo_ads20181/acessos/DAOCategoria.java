package project_poo_ads20181.acessos;

import java.util.ArrayList;
import project_poo_ads20181.classes.Categoria;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author Hugo Felipe
 */
public interface DAOCategoria {
    
    /**
     * Grava o nome da categoria no BD
     * @param p Objeto com os dados validos
     * @throws ConexaoException 
     * @throws DAOException 
     */
    public void inserir(Categoria ct)throws ConexaoException,DAOException;
    
    /**
     * Grava as altera��es no BD
     * @param ct
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void alterar(Categoria ct)throws ConexaoException,DAOException;
    
    public ArrayList<Categoria> listar() throws ConexaoException,DAOException;
    
    public void excluir(Categoria ct)throws ConexaoException,DAOException;
    
    Categoria consultaIdCategoria(Integer idCategoria) throws ConexaoException, DAOException;

    public boolean checkID (Categoria ct) throws DAOException, ConexaoException;

    public Categoria consultaNome(String nome) throws ConexaoException, DAOException;
}
