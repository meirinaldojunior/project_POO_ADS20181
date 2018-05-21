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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import project_poo_ads20181.classes.Aluguel;
import project_poo_ads20181.classes.Atendente;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

public class DAOAluguelImplementa implements DAOAluguel{
	 /**
     * Implementa DAO Inserir, Excluir, atendente, alterar e listar Aluguel
     * @param aluguel
     * @throws ConexaoException
     * @throws DAOException 
     */
@Override
    public void inserir(Aluguel aluguel) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        String sql = "INSERT INTO aluguel (Id_atendente, Id_exemplar, Cpf, Valor) VALUES(?,?,?,?)";
        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            //pstm.setInt(1, aluguel.getIdAluguel());
            pstm.setInt(1, aluguel.getIdAtendente().getIdAtendente());
            pstm.setInt(2, aluguel.getIdExemplar().getIdExemplar());
            pstm.setString(3, aluguel.getCpf().getcpf());
            pstm.setDouble(4, aluguel.getValor());
            pstm.executeUpdate();
            System.out.println("Inserido com sucesso!");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            gc.desconectar(c);
        }

    }	
    @Override
    public void alterar(Aluguel aluguel) throws ConexaoException, DAOException {
            Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "UPDATE Aluguel SET Id_Aluguel=?, Id_exemplar=?, Id_atendente=?, Cpf=?, Valor=? WHERE Id_Aluguel=?";
        PreparedStatement pstm;
        Aluguel alu = new Aluguel();
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1,alu.getIdAluguel());
            pstm.setInt(2,alu.getIdExemplar().getIdExemplar());
            pstm.setInt(3,alu.getIdAtendente().getIdAtendente());
            pstm.setString(4,alu.getCpf().getcpf());
            pstm.setDouble(5,alu.getValor());
            pstm.setInt(6,alu.getIdAluguel());
            pstm.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public void excluir(Aluguel aluguel) throws ConexaoException, DAOException {
                Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "DELETE FROM Aluguel WHERE Id_Aluguel =?";
        PreparedStatement pstm;
        Aluguel alu = new Aluguel();
        
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1,alu.getIdAluguel());
            //pstm.setInt(2,alu.getIdAtendente().getIdAtendente());
            //pstm.setInt(3,alu.getExemplar().getIdExemplar());
            //pstm.setString(4,alu.getCpf().getcpf());
            //pstm.setDouble(5,alu.getValor());
            pstm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "Excluido com sucesso...");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public ArrayList<Aluguel> lista() throws ConexaoException, DAOException {
    Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        ArrayList<Aluguel> lista = new ArrayList();
        String sql = "SELECT * FROM Aluguel";
        Statement stm;
        
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Aluguel alu = new Aluguel();
                alu.setIdAluguel(rs.getInt("Id_Aluguel"));
                alu.setIdAluguel(rs.getInt("Id_atendente"));
                alu.setIdAluguel(rs.getInt("Id_exemplar"));
                alu.setIdAluguel(rs.getInt("Cpf"));
                alu.setValor(rs.getDouble("Valor"));
                lista.add(alu);
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
    public Aluguel consultaAluguel (int idAluguel) throws ConexaoException, DAOException {
         GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        Aluguel alu = null;
        
        String sql = "SELECT * FROM Aluguel WHERE id_Aluguel=?";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, idAluguel);
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                alu = new Aluguel();
                alu.setIdAluguel(rs.getInt("Id_Aluguel"));
                alu.setIdAluguel(rs.getInt("Id_atendente"));
                alu.setIdAluguel(rs.getInt("Id_exemplar"));
                alu.setIdAluguel(rs.getInt("Cpf"));
                alu.setValor(rs.getDouble("Valor"));
            }
            return alu;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }
    }
}
