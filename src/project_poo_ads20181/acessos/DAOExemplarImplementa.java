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
import project_poo_ads20181.classes.Exemplar;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author Hugo
 */
public class DAOExemplarImplementa implements DAOExemplar {
    
    @Override
    public void inserir (Exemplar exemplar) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
       
        String sql = "INSERT INTO exemplar (Id_livro, Id_Categoria, Id_Autor) VALUES (?,?,?)";
        
        PreparedStatement pstm;
        try {
             pstm = c.prepareStatement(sql);
             pstm.setInt(1,exemplar.getIdLivro());
             pstm.setInt(2,exemplar.getIdCategoria());
             pstm.setInt(3,exemplar.getIdAutor());
             pstm.executeUpdate();
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }
	
	}
	
    @Override
    public void alterar(Exemplar exemplar) throws ConexaoException, DAOException {
        
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        
        String sql = "UPDATE exemplar SET Id_livro=? , Id_Categoria=?, Id_Autor=? WHERE Id_exemplar=?";
        
        PreparedStatement pstm;
        
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1,exemplar.getIdLivro());
            pstm.setInt(2,exemplar.getIdCategoria());
            pstm.setInt(3,exemplar.getIdAutor());
            pstm.setDouble(4,exemplar.getIdExemplar());
            pstm.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public void excluir(Exemplar exemplar) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "DELETE FROM exemplar WHERE Id_exemplar =?";
        PreparedStatement pstm;
        
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1,exemplar.getIdExemplar());
            //pstm.setInt(2,alu.getIdAtendente().getIdAtendente());
            //pstm.setInt(3,alu.getExemplar().getIdExemplar());
            //pstm.setString(4,alu.getCpf().getcpf());
            //pstm.setDouble(5,alu.getValor());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public ArrayList<Exemplar> lista() throws ConexaoException, DAOException {
    Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        ArrayList<Exemplar> lista = new ArrayList();
        String sql = "SELECT * FROM exemplar";
        Statement stm;
        
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Exemplar exe = new Exemplar();
                exe.setIdExemplar(rs.getInt("Id_exemplar"));
                //exe.setIdCategoria(rs.getInt("Id_Categoria"));
                //exe.setId(rs.getInt("Id_Autor"));
                //exe.setIdLivro(rs.getInt("Id_livro"));
                lista.add(exe);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("ERRO "+e);
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }
    
    @Override
    public ArrayList<Exemplar> lista(int idLivro) throws ConexaoException, DAOException {
    Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        ArrayList<Exemplar> lista = new ArrayList();
        String sql = "SELECT * FROM exemplar WHERE Id_Livro = ?";
        PreparedStatement pstm;
        
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, idLivro);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Exemplar exe = new Exemplar();
                exe.setIdLivro(rs.getInt("Id_livro"));
                exe.setIdCategoria(rs.getInt("Id_Categoria"));
                exe.setIdAutor(rs.getInt("Id_Autor"));
                exe.setIdLivro(rs.getInt("Id_livro"));
                lista.add(exe);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("ERRO "+e);
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }
    
    @Override
    public Exemplar consultaIdExemplar (Integer idExemplar) throws ConexaoException, DAOException {
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        Exemplar exe = null;
        
        String sql = "SELECT Id_exemplar, Id_livro, Id_Categoria, Id_Autor FROM Exemplar WHERE Id_exemplar=?";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, idExemplar);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                exe = new Exemplar();
                exe.setIdExemplar(rs.getInt("Id_Exemplar"));
                exe.setIdLivro(rs.getInt("Id_Livro"));
                exe.setIdCategoria(rs.getInt("Id_Categoria"));
                //exe.set(rs.getInt("Id_Autor"));      
                }
            return exe;
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);    
        }
    }
    
    @Override
    public Exemplar get(Integer idExemplar) throws ConexaoException, DAOException{
            
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        Exemplar exe = null;
        
        String sql = "SELECT Id_exemplar, Id_livro, Id_Categoria, Id_Autor FROM exemplar WHERE Id_exemplar=?";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, idExemplar);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                exe = new Exemplar();
                exe.setIdExemplar(rs.getInt("Id_exemplar"));
                exe.setIdExemplar(rs.getInt("Id_livro"));
                exe.setIdExemplar(rs.getInt("Id_Categoria"));
                exe.setIdExemplar(rs.getInt("Id_Autor"));
            }
            
            return exe;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }
    }
    
    
}
