
package project_poo_ads20181.acessos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author valter
 */
public class DAOAutorImplementa implements DAOAutor {

    @Override
    public void inserir(Autor a) throws ConexaoException, DAOException {
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "INSERT INTO Autor (nome) VALUES(?)";
        PreparedStatement pstm;
         try{
            pstm = c.prepareStatement(sql);
            pstm.setString(1, a.getNome());
         
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException();
        }finally{
          GerenciadorConexaoMySql.getInstancia().desconectar(c);  
    }

    }
    @Override
    public void alterar (Autor a) throws ConexaoException, DAOException{
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "UPDATE Autor SET nome=? WHERE Id_Autor=?";
        PreparedStatement pstm;
         try{
            pstm = c.prepareStatement(sql);
            pstm.setString(1, a.getNome());
            pstm.setInt(2, a.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
    }
    }


    @Override
    public ArrayList<Autor>listar()throws ConexaoException, DAOException{
       
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();  
        ArrayList<Autor> lista = new ArrayList();
        
        String sql ="select * from Autor";
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
              Autor  a = new Autor();
                a.setId(  rs.getInt("Id_Autor") );
                a.setNome( rs.getString("Nome") );
                lista.add(a);
            }
             return lista;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
    }
}

    @Override
    public void excluir(Autor a) throws ConexaoException, DAOException {
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "delete from Autor where Id_Autor = ?";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, a.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        
        }  
    }

    @Override
    public Autor buscaPorId(Integer id) throws ConexaoException, DAOException {
       Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        
        Autor a = null;
        
        String sql = "SELECT Id_Autor,nome FROM Autor WHERE Id_Autor=?";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                a = new Autor();
                a.setId(rs.getInt("id_Autor"));
                a.setNome( rs.getString("nome") );
            }
               return a;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
           GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public Autor consultaNome(String nome) throws ConexaoException, DAOException {
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        
        Autor a = null;
        
        String sql = "SELECT nome,Id_Autor FROM Autor WHERE nome=?";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                a = new Autor();
                a.setId(  rs.getInt("Id_Autor") );
                a.setNome( rs.getString("nome") );
                
            }
            
            return a;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
           GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }
        
    

        
        
    }
