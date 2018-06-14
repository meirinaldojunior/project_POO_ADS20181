/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import java.util.ArrayList;
import project_poo_ads20181.classes.Aluguel;
import project_poo_ads20181.classes.AluguelRelacionamento;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.classes.Exemplar;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.negocio.RNAluguel;
import project_poo_ads20181.negocio.RNExemplar;

/**
 *
 * @author Meirinaldo
 */
public class FachadaAluguel {

    private RNAluguel rnAlu;
    private RNExemplar rnExem;

    public FachadaAluguel() {
        rnAlu = new RNAluguel();
        rnExem = new RNExemplar();
    }

    /**
     * Efetua todas as verificacoes e salva os dados no BD
     *
     * @param alu Objeto contendo todos os dados, exceto ID
     * @throws GeralException Caso ocorra algum erro na validacao
     * @throws project_poo_ads20181.erro.DAOException
     */
    public void salvarAluguel(Aluguel alu) throws GeralException, DAOException {
        rnAlu.validarAtributos(alu);
        rnAlu.inserir(alu);
        
        //altera disponibilidade do exemplar
        Exemplar exemp = new Exemplar();
        exemp.setIdExemplar(alu.getIdExemplar());
        exemp.setdisponibilidade(0);
        rnExem.alterarDisponibilidade(exemp);
    }

    public void alterarAluguel(Aluguel alu) throws GeralException, DAOException {
        rnAlu.validarAtributos(alu);
        //rnAlu.verificaDuplicidadeNome(alu);
        rnAlu.alterar(alu);
    }

    public void excluirAluguel(Aluguel alu) throws GeralException, DAOException, ConexaoException {
        rnAlu.excluir(alu);
        
        Exemplar ex = new Exemplar();
        ex.setIdExemplar(alu.getIdExemplar());
        ex.setdisponibilidade(1);
        rnExem.alterarDisponibilidade(ex);
    }

    public ArrayList<Aluguel> listarAluguel() throws ConexaoException, DAOException, GeralException {
        return rnAlu.listar();
    }
    
    public ArrayList<AluguelRelacionamento> listarAluguelForegein() throws ConexaoException, DAOException, GeralException {
        return rnAlu.listarForegein();
    }

    public Aluguel consultaAluguel(Integer idAluguel) throws ConexaoException, DAOException, GeralException {
        Aluguel alu = rnAlu.consultaAluguel(idAluguel);
        rnAlu.validarAtributos(alu);
        rnAlu.verificaDuplicidadeNome(alu);
        rnAlu.validaAluguel(alu);
        return alu;
    }

    public boolean checkID(Aluguel alu) throws DAOException, ConexaoException, GeralException {
        boolean checkid = rnAlu.checkID(alu);
        return checkid;
    }
}
