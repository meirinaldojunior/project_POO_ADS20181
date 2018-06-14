
package project_poo_ads20181.fachada;

import java.util.ArrayList;
import project_poo_ads20181.acessos.DAOAutorImplementa;
import project_poo_ads20181.acessos.DAOCategoriaImplementa;
import project_poo_ads20181.acessos.DAOLivroImplementa;
import project_poo_ads20181.classes.Livro;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.negocio.RNLivro;

/**
 *
 * @author Rafael Augusto
 */
public class FachadaLivro {
    //RNLivro rn;
    DAOLivroImplementa dao;
    DAOAutorImplementa daoa;
    DAOCategoriaImplementa daoc;
    
    RNLivro rn = new RNLivro();
    /**
     * CHAMA A VALIDAÇÃO DA REGRA DE NEGÓCIO LIVRO INSERIR.
     * @param L - OBJETO A SER VÁLIDADO
     * @return - RETORNA TRUE SE O DADO FOI INSERIDO NA BASE DE DADOS.
     * @throws GeralException
     * @throws ConexaoException
     * @throws DAOException 
     */
    public boolean inserirRegistro(Livro L) throws GeralException, ConexaoException, DAOException{
        
        rn = new RNLivro();
        dao = new DAOLivroImplementa();
        daoa = new DAOAutorImplementa();
        daoc = new DAOCategoriaImplementa();
        
        rn.validarAtributos(L);
        rn.validarDuplicidadeNome(L);
        rn.idcatautor(L);
        dao.inserir(L);
        return true;
    }
    /**
     * CHAMA A VALIDAÇÃO DA REGRA DE NEGÓCIO LIVRO ALTERAR.
     * @param L - OBJETO A SER VÁLIDADO.
     * @return - RETORNA TRUE SE O DADO FOI INSERIDO NA BASE DE DADOS.
     * @throws GeralException
     * @throws ConexaoException
     * @throws DAOException 
     */
    public boolean alterarRegistro(Livro L) throws GeralException, ConexaoException, DAOException{
        
        rn = new RNLivro();
        dao = new DAOLivroImplementa();
        
        rn.validarAtributos(L);
        rn.validarDuplicidadeNome(L);
        rn.validarID(L);
        dao.alterar(L);
        return true;
    }
    /**
     * CHAMA A VALIDAÇÃO DA REGRA DE NEGÓCIO LIVRO EXCLUIR.
     * @param L - OBJETO A SER VÁLIDADO.
     * @return - RETORNA TRUE SE O DADO FOI INSERIDO NA BASE DE DADOS.
     * @throws GeralException
     * @throws ConexaoException
     * @throws DAOException 
     */
    public boolean excluirRegistro(Livro L) throws GeralException, ConexaoException, DAOException{
        
        rn = new RNLivro();
        dao = new DAOLivroImplementa();
        
        rn.validarID(L);
        dao.excluir(L);
        return true;
    }
    /**
     * CHAMA A VALIDAÇÃO DA REGRA DE NEGÓCIO LIVRO LISTAR.
     * @return - RETORNA A LISTA DA BASE DE DADOS.
     * @throws GeralException
     * @throws ConexaoException
     * @throws DAOException 
     */
    public ArrayList<Livro> listarRegistro() throws GeralException, ConexaoException, DAOException{
        return rn.listarRegistro();
    }
     
    public ArrayList<Livro> listarRegistro(int param) throws GeralException, ConexaoException, DAOException {
      return rn.listarLivros(param);
    }
    
    
}
