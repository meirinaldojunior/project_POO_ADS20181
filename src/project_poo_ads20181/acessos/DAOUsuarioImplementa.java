package project_poo_ads20181.acessos;

/**
 *
 * @author Hugo Felipe
 */
import java.security.NoSuchAlgorithmException;
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
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.funcao.CriptografaMD5;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;
import sun.security.provider.MD5;

public class DAOUsuarioImplementa implements DAOUsuario {

    /**
     * Implementa DAO Inserir, Excluir, atendente, alterar e listar Usuarios
     *
     * @param a recebe objeto usuario
     * @throws ConexaoException
     * @throws DAOException
     */
    @Override
    public boolean inserir(Usuario usuario) throws ConexaoException, DAOException, GeralException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        String sql = "INSERT INTO Usuario (Cpf, Nome, Senha, Tipo)VALUES(?,?,?,?)";

        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, usuario.getcpf());
            pstm.setString(2, usuario.getNome());
            pstm.setString(3, CriptografaMD5.criptografa(usuario.getSenha()));
            pstm.setInt(4, usuario.getTipo());
            pstm.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            throw  new GeralException("Erro na operação: "+e.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            throw  new GeralException("Erro ao realizar a criptografia");
        } finally {
            gc.desconectar(c);
        }
    }

    @Override
    public void alterar(Usuario usuario) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "UPDATE Usuario SET Cpf=?, Nome=? WHERE Cpf=?";
        PreparedStatement pstm;
        Usuario usu = new Usuario();
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, usu.getcpf());
            pstm.setString(2, usu.getNome());
            pstm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "Alterado com sucesso...");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public void excluir(Usuario usuario) throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        String sql = "DELETE FROM Usuario WHERE Cpf=?";
        PreparedStatement pstm;
        Usuario usu = new Usuario();
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, usu.getcpf());
            pstm.setString(2, usu.getNome());
            pstm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "Alterado com sucesso...");
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    @Override
    public ArrayList<Usuario> lista() throws ConexaoException, DAOException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();
        ArrayList<Usuario> lista = new ArrayList();
        String sql = "SELECT * FROM Usuario";
        Statement stm;

        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setIdUsuario(rs.getInt("Id_Usuario"));
                usu.setCpf(rs.getString("Cpf"));
                usu.setNome(rs.getString("Nome"));
                usu.setTipoUsuario(rs.getInt("Tipo"));
                lista.add(usu);
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
    public Usuario consultaCpf(String cpf) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        Usuario usu = null;

        String sql = "SELECT * FROM Usuario WHERE Cpf=?";

        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usu = new Usuario();
                usu.setCpf(rs.getString("Cpf"));
                usu.setNome(rs.getString("Nome"));
            }
            return usu;
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            gc.desconectar(c);
        }
    }

    public ArrayList<String> listaTipos() throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        ArrayList<String> lista = new ArrayList();

        String sql = "SELECT * FROM Usuario_tipo";

        Statement stm;
        
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                lista.add(rs.getString("tipo_usuario"));
            }
            
            return lista;
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            gc.desconectar(c);
        }
    }

}
