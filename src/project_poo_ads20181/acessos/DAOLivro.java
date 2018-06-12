/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.acessos;

import java.util.ArrayList;
import project_poo_ads20181.classes.Livro;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author Rafael Augusto
 */
public interface DAOLivro {
    
    public void inserir (Livro livro) throws ConexaoException, DAOException;
    
    public void alterar (Livro livro) throws ConexaoException, DAOException;
    
    public void excluir (Livro livro) throws ConexaoException, DAOException;
    
    public ArrayList<Livro> lista() throws ConexaoException, DAOException;
    
    public ArrayList<Livro> lista(Integer param) throws ConexaoException, DAOException;
//falta o método de consulta por id
}
