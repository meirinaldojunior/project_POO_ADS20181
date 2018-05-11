package project_poo_ads20181.acessos;

import java.util.ArrayList;
import project_poo_ads20181.classes.Categoria;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author aluno
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
     * Grava as alterações no BD
     * @param p Objeto com os dados
     * @throws ConexaoException
     * @throws DAOException 
     */
    public void alterar(Categoria ct)throws ConexaoException,DAOException;
    
    public ArrayList<Categoria> listar() throws ConexaoException,DAOException;
}
