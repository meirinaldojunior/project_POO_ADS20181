/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import java.util.ArrayList;
import project_poo_ads20181.classes.Categoria;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.negocio.RNCategoria;

/**
 *
 * @author Hugo
 */
public class FachadaCategoria {
        private RNCategoria rnc;
    
    public FachadaCategoria(){
    rnc = new RNCategoria();
    }
    
    public void salvarCategoria(Categoria ct) throws GeralException, DAOException{
        rnc.validarAtributos(ct);
        rnc.verificaDuplicidadeNome(ct);
        rnc.inserir(ct);
        
    }
    public void alterarCategoria(Categoria ct) throws GeralException, DAOException{
        rnc.validarAtributos(ct);
        rnc.verificaDuplicidadeNome(ct);
        rnc.alterar(ct);
    }
    public void excluirCategoria(Categoria ct) throws GeralException, DAOException, ConexaoException{
        rnc.excluir(ct);
    }
    public ArrayList<Categoria> listarCategoria() throws ConexaoException, DAOException, GeralException{
    return rnc.listar();
    }
    public Categoria buscarPorId(int id) throws ConexaoException, DAOException, GeralException{
        Categoria ct = rnc.buscaPorId(id);
        rnc.validarAtributos(ct);
        rnc.verificaDuplicidadeNome(ct);
        rnc.validaCategoria(ct);
        return ct;
    }
    public boolean checkId(Categoria ct) throws DAOException, ConexaoException, GeralException{
        boolean checkid = rnc.checkid(ct);
        return checkid;
    }
}
