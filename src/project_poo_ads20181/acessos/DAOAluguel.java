package project_poo_ads20181.acessos;

/**
 *
 * @author Meirinaldo
 */
import java.util.ArrayList;
import project_poo_ads20181.classes.Aluguel;
import project_poo_ads20181.classes.AluguelRelacionamento;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;

public interface DAOAluguel {

    public void inserir(Aluguel aluguel) throws ConexaoException, DAOException, GeralException;

    public void alterar(Aluguel aluguel) throws ConexaoException, DAOException;

    public void excluir(Aluguel aluguel) throws ConexaoException, DAOException;

    public ArrayList<Aluguel> lista() throws ConexaoException, DAOException;

    public ArrayList<AluguelRelacionamento> listarForegein() throws ConexaoException, DAOException;

    Aluguel consultaAluguel(Integer idAluguel) throws ConexaoException, DAOException;

    public Aluguel get(Integer idAluguel) throws ConexaoException, DAOException;

    public boolean checkID(Aluguel alu) throws DAOException, ConexaoException;
}
