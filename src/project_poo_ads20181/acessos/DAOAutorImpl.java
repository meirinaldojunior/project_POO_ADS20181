
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
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author valter
 */
public class DAOAutorImpl implements DAOAutor {

    @Override
    public void inserir(Autor a) throws ConexaoException, DAOException {
        GerenciadorConexao gc = null ;
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
            gc.desconectar(c);
    }

    }
    public void alterar (Autor a) throws ConexaoException, DAOException{
        GerenciadorConexao gc = null ;
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
            gc.desconectar(c);
    }
    }

    /**
     *
     * @return
     * @throws ConexaoException
     * @throws DAOException
     */
    public ArrayList<Autor>listar()throws ConexaoException, DAOException{
        GerenciadorConexao gc = null ;
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();  
        ArrayList<Autor>lista = new ArrayList();
        Autor a = null;
        String sql ="select * from Autor";
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                a = new Autor();
                a.setId(  rs.getInt("id") );
                a.setNome( rs.getString("nome") );
                lista.add(a);
            }
             return lista;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
    }
}
}