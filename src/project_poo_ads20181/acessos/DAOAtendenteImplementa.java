
package project_poo_ads20181.acessos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project_poo_ads20181.classes.Atendente;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author Meirinaldo
 */
public class DAOAtendenteImplementa implements DAOAtendente {

    
    @Override
    public void inserir(Atendente a) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "INSERT INTO Atendente (Nome, Cpf) VALUES(?, ?)";
        PreparedStatement pstm = null;
         try{
            pstm = c.prepareStatement(sql);
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getCpf());
            pstm.executeUpdate();
           
            System.err.println("inserido com sucesso");

        }catch(SQLException e){
                throw new DAOException();
        }finally{
          GerenciadorConexaoMySql.getInstancia().desconectar(c);  
    }

    }
    @Override
    public void alterar (Atendente a) throws ConexaoException, DAOException{
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
    public ArrayList<Atendente>listar()throws ConexaoException, DAOException{
       
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();  
        ArrayList<Atendente> lista = new ArrayList();
        
        String sql ="select * from Atendente";
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
              Atendente  a = new Atendente();
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
    public void excluir(Atendente a) throws ConexaoException, DAOException {
        Connection c =GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "delete from Atendente where id = ?";
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