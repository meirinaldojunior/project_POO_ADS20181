
package project_poo_ads20181.acessos;

import java.util.ArrayList;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author valte
 */

public interface DAOAutor {
    /**
     * Grava um autor no BD
     * @param a Objeto com os dados validos
     * @throws ConexaoException 
     * @throws DAOException 
     */
    
    public void inserir(Autor a) throws ConexaoException,DAOException;
     /**
     * altera um registro de autor no BD
     * @param a Objeto com os dados validos
     * @throws ConexaoException 
     * @throws DAOException 
     */
    public void alterar(Autor a)throws ConexaoException,DAOException;
    /**
     * cria uma lista de autores cadastrados no BD
     * @param a para criar a listar
     * @throws ConexaoException 
     * @throws DAOException 
     * @return lista
     */
    
    public ArrayList<Autor> listar() throws ConexaoException,DAOException;
    
    /**
     * exclui um cadastro de autor no BD
     * @param a objeto contendo o id de exclusao
     * @throws ConexaoException 
     * @throws DAOException 
     */
    public void excluir(Autor a)throws ConexaoException,DAOException;
    
    /**
     * retorna um objeto com o id informado
     * @param id
     * @return um objeto de autor
     * @throws ConexaoException
     * @throws DAOException 
     */
    public Autor buscaPorId(Integer id)throws ConexaoException,DAOException;
     /**
     * retorna um objeto com o nome informado
     * @param nome
     * @return um objeto de autor
     * @throws ConexaoException
     * @throws DAOException 
    */
    public Autor consultaNome(String nome)throws ConexaoException, DAOException;
    /**
     * verifica se um numero de id é valido
     * @param nome
     * @return um boolean
     * @throws ConexaoException
     * @throws DAOException 
    */
    public boolean checkID (Autor a) throws DAOException,ConexaoException;
        

}

