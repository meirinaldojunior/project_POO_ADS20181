
package project_poo_ads20181.acessos;

import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author valte
 */

public interface DAOAutor {
    /**
     * Grava o nome da categoria no BD
     * @param a Objeto com os dados validos
     * @throws ConexaoException 
     * @throws DAOException 
     */
    
    public void inserir(Autor a) throws ConexaoException,DAOException;
}
