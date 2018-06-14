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
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

public class DAOAluguelImplementa implements DAOAluguel {

    /**
     * Implementa DAO Inserir, Excluir, atendente, alterar e listar Aluguel
     *
     * @param aluguel
     * @throws ConexaoException
     * @throws DAOException
     */
    
    public void inserir(Aluguel aluguel) throws ConexaoException, DAOException, GeralException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        String sql = "INSERT INTO aluguel ( Id_atendente, Id_exemplar, Id_Usuario, Valor) VALUES(?,?,?,?)";
        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, aluguel.getIdAtendente());
            pstm.setInt(2, aluguel.getIdExemplar());
            pstm.setInt(3, aluguel.getIdUsuario());
            pstm.setDouble(4, aluguel.getValor());
            pstm.executeUpdate();
            System.out.println("Aluguel inserido com sucesso!");
        } catch (SQLException e) {
            throw new GeralException(e.getMessage());
            
        } finally {
            gc.desconectar(c);
        }

    }

    @Override
    public void alterar(Aluguel aluguel) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        String sql = "UPDATE aluguel SET Id_atendente=?, Id_exemplar=?, Id_Usuario=?, Valor=? WHERE Id_Aluguel =?";

        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, aluguel.getIdAtendente());
            pstm.setInt(2, aluguel.getIdExemplar());
            pstm.setInt(3, aluguel.getIdUsuario());
            pstm.setDouble(4, aluguel.getValor());
            pstm.setInt(5, aluguel.getIdAluguel());
            pstm.executeUpdate();
            System.out.println("Aluguel alterado com sucesso!");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            gc.desconectar(c);
        }
    }

    @Override
    public void excluir(Aluguel aluguel) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "DELETE FROM aluguel WHERE Id_Aluguel =?";
        PreparedStatement pstm;

        try {
            pstm = c.prepareStatement(sql);

            pstm.setInt(1, aluguel.getIdAluguel());

            pstm.executeUpdate();
            System.out.println("Aluguel excluído com sucesso!");
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
        String sql = "SELECT * FROM aluguel";
        Statement stm;

        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Aluguel alu = new Aluguel();
                alu.setIdAluguel(rs.getInt("Id_Aluguel"));
                alu.setValor(rs.getDouble("Valor"));
                lista.add(alu);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("ERRO " + e);
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public Aluguel consultaAluguel(Integer idAluguel) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        Aluguel alu = null;

        String sql = "SELECT * FROM Aluguel WHERE id_Aluguel=?";

        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, idAluguel);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                alu = new Aluguel();
                alu.setIdAluguel(rs.getInt("Id_Aluguel"));
                alu.setIdAluguel(rs.getInt("Id_atendente"));
                alu.setIdAluguel(rs.getInt("Id_exemplar"));
                alu.setIdAluguel(rs.getInt("Id_Usuario"));
                alu.setValor(rs.getDouble("Valor"));
            }
            return alu;

        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            gc.desconectar(c);
        }
    }

    @Override
    public Aluguel get(Integer idAluguel) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        Aluguel alu = null;

        String sql = "SELECT Id_Aluguel , Id_atendente , Id_exemplar , Id_Usuario,  Valor FROM aluguel WHERE Id_Aluguel=?";

        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, idAluguel);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                alu = new Aluguel();
                alu.setIdAluguel(rs.getInt("Id_Aluguel"));
                alu.setIdAluguel(rs.getInt("Id_atendente"));
                alu.setIdAluguel(rs.getInt("Id_exemplar"));
                alu.setIdAluguel(rs.getInt("Id_Usuario"));
                alu.setValor(rs.getDouble("Valor"));
            }

            return alu;

        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            gc.desconectar(c);
        }
    }

    public boolean checkID(Aluguel alu) throws DAOException, ConexaoException {

        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "SELECT Id_Aluguel FROM aluguel WHERE Id_Aluguel=?";

        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, alu.getIdAluguel());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                return true;
            }

            return false;

        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

}
