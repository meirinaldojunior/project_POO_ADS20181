/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import java.util.ArrayList;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.negocio.RNAutor;

/**
 *
 * @author valter
 */
public class FachadaAutor {
    private RNAutor rna;
    
    public FachadaAutor(){
    rna = new RNAutor();
    }
    /**
     * Efetua todas as verificacoes e salva os dados no BD
     * @param a Objeto contendo todos os dados, exceto ID
     * @throws GeralException Caso ocorra algum erro na validacao
     * @throws project_poo_ads20181.erro.DAOException
     */
    public void salvarAutor(Autor a) throws GeralException, DAOException{
        rna.validarAtributos(a);
        rna.verificaDuplicidadeNome(a);
        rna.inserir(a);
        
    }
    public void alterarAutor(Autor a) throws GeralException, DAOException{
        rna.validarAtributos(a);
        rna.verificaDuplicidadeNome(a);
        rna.alterar(a);
    }
    public void excluirAutor(Autor a) throws GeralException, DAOException, ConexaoException{
        rna.validarAtributos(a);
        rna.verificaDuplicidadeNome(a);
        rna.validaAutor(a);
        rna.excluir(a);
    }
    public ArrayList<Autor> listarAutor() throws ConexaoException, DAOException, GeralException{
    return rna.listar();
    }
    public Autor buscarPorId(int id) throws ConexaoException, DAOException, GeralException{
        Autor a = rna.buscaPorId(id);
        rna.validarAtributos(a);
        rna.verificaDuplicidadeNome(a);
        rna.validaAutor(a);
        return a;
    }
}
