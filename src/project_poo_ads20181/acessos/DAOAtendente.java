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
    
    public void inserir(Atendente a)throws ConexaoException,DAOException;
    
    public void alterar(Atendente a)throws ConexaoException,DAOException;
    
    public ArrayList<Atendente> listar() throws ConexaoException,DAOException;
    
    public void excluir(Atendente a)throws ConexaoException,DAOException;
}
