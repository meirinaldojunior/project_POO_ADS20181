/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.acessos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.classes.Categoria;
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
        
        String sql = "INSERT INTO Livro (Nome_livro,Id_Categoria,Id_Autor) VALUES (?,?,?)";
        PreparedStatement pstm;
        
        try {
             pstm = c.prepareStatement(sql);
             pstm.setString(1, livro.getNomeLivro());
             pstm.setInt(2,livro.getCat().getIdCategoria());
             pstm.setInt(3,livro.getAutor().getId());
             pstm.executeUpdate();
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }     
    }

    @Override
    public void alterar(Livro livro) throws ConexaoException, DAOException {
        
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        String sql = "UPDATE Livro SET Nome_livro=?, Id_Categoria=?, Id_Autor=? WHERE Id_livro =?";
        
        PreparedStatement pstm;
        try {
             pstm = c.prepareStatement(sql);
             pstm.setString(1, livro.getNomeLivro());
             pstm.setInt(2,livro.getCat().getIdCategoria());
             pstm.setInt(3,livro.getAutor().getId());
             pstm.setInt(4,livro.getIdLivro());
             pstm.executeUpdate();
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        } 
    }

    @Override
    public void excluir(Livro livro) throws ConexaoException, DAOException {
        
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
               
        String sql = "DELETE FROM Livro WHERE Id_livro =?";
        
        PreparedStatement pstm;
        try {
             pstm = c.prepareStatement(sql);
             pstm.setInt(1,livro.getIdLivro());
             pstm.execute();
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        } 
    
    }

    @Override
    public ArrayList<Livro> lista() throws ConexaoException, DAOException {
        
       Connection c = GerenciadorConexaoMySql.getInstancia().conectar();  
        ArrayList<Livro> lista = new ArrayList();
        
        String sql ="SELECT * FROM Livro";
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
              Livro  a = new Livro();
                a.setIdLivro(rs.getInt("Id_livro"));
                a.setNomeLivro(rs.getString("Nome_livro"));
                lista.add(a);
            }
             return lista;
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        } 
    
       
    }
    
    
    
    
    
    
}
