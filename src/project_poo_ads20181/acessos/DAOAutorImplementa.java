
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
        String sql = "INSERT INTO Autor (nome,id) VALUES(?,?)";
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
    public void alterar (Autor a) throws ConexaoException, DAOException{
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "UPDATE produtos SET nome=? WHERE id=?";
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

    /**
     *
     * @return
     * @throws ConexaoException
     * @throws DAOException
     */
    @Override
    public ArrayList<Autor>listar()throws ConexaoException, DAOException{
       
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();  
        ArrayList<Autor> lista = new ArrayList();
        
        String sql ="select * from Autor";
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
              Autor  a = new Autor();
                a.setId(  rs.getInt("id") );
                a.setNome( rs.getString("nome") );
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
        String sql = "delete from Autor where id = ?";
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
}