/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.acessos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_poo_ads20181.classes.Livro;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author Rafael Augusto
 */
public class DAOLivroImplementa implements DAOLivro{

    @Override
    public void inserir(Livro livro) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        Livro liv = new Livro();
               
        String sql = "INSERT INTO Livro (Nome_livro,Nome_categoria,Nome)VALUES(?,?,?)";
        
        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
             pstm.setString(1,liv.getNomeLivro());
             pstm.setString(2,liv.getCategoria().getNomeCategoria());
             pstm.setString(3,liv.getNomeAutor().getNome());
             
             pstm.executeUpdate();
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        } 
       
               
        
        
        
    }

    @Override
    public void alterar(Livro livro) throws ConexaoException, DAOException {
    
    }

    @Override
    public void excluir(Livro livro) throws ConexaoException, DAOException {
    
    }

    @Override
    public ArrayList<Livro> lista() throws ConexaoException, DAOException {
    
        return null;
    }
    
    
    
    
    
    
}
