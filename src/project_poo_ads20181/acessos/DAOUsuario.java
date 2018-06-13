package project_poo_ads20181.acessos;

/**
 *
 * @author Hugo Felipe
 */
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;

public interface DAOUsuario {

    public boolean inserir(Usuario usuario) throws ConexaoException, DAOException, GeralException;

    public void alterar(Usuario usuario) throws ConexaoException, DAOException, GeralException;

    public void alterarSenha(Usuario usuario) throws ConexaoException, DAOException, GeralException, NoSuchAlgorithmException;

    public void excluir(Usuario usuario) throws ConexaoException, DAOException;

    public ArrayList<Usuario> lista() throws ConexaoException, DAOException;
    
    public ArrayList<Usuario> lista(int param) throws ConexaoException, DAOException;

    Usuario consultaCpf(String cpf) throws ConexaoException, DAOException;
    

}
