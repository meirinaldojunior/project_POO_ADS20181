package project_poo_ads20181.acessos;

/**
*
* @author Hugo Felipe
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project_poo_ads20181.classes.Categoria;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

public class DAOCategoriaImplementa implements DAOCategoria {
    
    @Override
    public void inserir(Categoria ct)throws ConexaoException,DAOException{
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        String sql = "INSERT INTO Categoria (Nome_categoria) VALUES(?)";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setString(1, ct.getNomeCategoria());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }        
    }
    
    @Override
    public void alterar(Categoria ct)throws ConexaoException,DAOException{
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "UPDATE Categoria SET Nome_categoria=? WHERE Id_categoria=?";
        PreparedStatement pstm;
         try{
            pstm = c.prepareStatement(sql);
            pstm.setString(1, ct.getNomeCategoria());
            pstm.setInt(2, ct.getIdCategoria());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
    }
    }
    
    @Override
    public ArrayList<Categoria> listar()throws ConexaoException,DAOException{
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        ArrayList<Categoria> lista = new ArrayList();
        Categoria ct = null;
        
        String sql = "SELECT * FROM Categoria";
        
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                ct = new Categoria();
                ct.setIdCategoria( rs.getInt("Id_Categoria") );
                lista.add(ct);
            }
            
            return lista;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }    
    }
    
   @Override
    public void excluir(Categoria ct) throws ConexaoException, DAOException{
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        //
        String sql = "DELETE FROM Categoria WHERE Id_categoria=?";
        
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            //pstm.setString(1, ct.getNomeCategoria());
            pstm.setInt(1, ct.getIdCategoria());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        
        }  
    }
    
   @Override
   public Categoria consultaCategoria (String nomeCategoria) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
       gc = GerenciadorConexaoMySql.getInstancia();
       Connection c = gc.conectar();
       
       Categoria ct = null;
       
       String sql = "SELECT * FROM Categoria WHERE nome_Categoria=?";
       
       PreparedStatement pstm;
       try{
           pstm = c.prepareStatement(sql);
           pstm.setString(1, nomeCategoria);
           ResultSet rs = pstm.executeQuery();
           
           if(rs.next()){
               ct = new Categoria();
               ct.setNomeCategoria(rs.getString("nome_categoria"));
           }
           return ct;
       }catch(SQLException e){
           throw new DAOException();
       }finally{
           gc.desconectar(c);
       }
   }
   
}
