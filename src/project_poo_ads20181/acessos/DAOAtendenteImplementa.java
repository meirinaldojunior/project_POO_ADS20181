package project_poo_ads20181.acessos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import project_poo_ads20181.classes.Atendente;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author Meirinaldo
 */
public class DAOAtendenteImplementa implements DAOAtendente {

    /**
     * Implementa DAO Inserir atendente
     * @param a recebe objeto atendente
     * @throws ConexaoException
     * @throws DAOException 
     */
    @Override
    public void inserir(Atendente a) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "INSERT INTO Atendente (Nome, Cpf) VALUES(?, ?)";
        PreparedStatement pstm = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getCpf());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso...");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }

    }

    /**
     * Implementa DAO Alterar atendente
     * @param a recebe objeto atendente
     * @throws ConexaoException
     * @throws DAOException 
     */
    @Override
    public void alterar(Atendente a) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "UPDATE Atendente SET Nome=?, Cpf=? WHERE Id_atendente=?";
        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getCpf());
            pstm.setInt(3, a.getIdAtendente());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso...");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    /**
     * Implementa DAO Listar atendentes
     * @return @throws ConexaoException
     * @throws DAOException
     */
    @Override
    public ArrayList<Atendente> listar() throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        ArrayList<Atendente> lista = new ArrayList();
        String sql = "select * from Atendente";
        Statement stm;
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Atendente a = new Atendente();
                a.setIdAtendente(rs.getInt("Id_atendente"));
                a.setNome(rs.getString("Nome"));
                a.setCpf(rs.getString("Cpf"));
                lista.add(a);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("ERRO "+e);
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    /**
     * Implementa DAO Excluir atendente
     * @param a recebe objeto atendente
     * @throws ConexaoException
     * @throws DAOException 
     */
    @Override
    public void excluir(Atendente a) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "DELETE FROM Atendente WHERE Id_atendente = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, a.getIdAtendente());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso...");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);

        }
    }
}
