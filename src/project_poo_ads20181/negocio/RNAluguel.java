/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_poo_ads20181.classes.Aluguel;
import project_poo_ads20181.acessos.DAOAluguel;
import project_poo_ads20181.acessos.DAOAluguelImplementa;
import project_poo_ads20181.classes.AluguelRelacionamento;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author Meirinaldo
 */
public class RNAluguel {

    DAOAluguel dao = new DAOAluguelImplementa();

    /**
     * Verifica se um aluguel alu está com todos os campos preenchidos
     * (inclusive o ID)
     *
     * @param alu
     * @throws GeralException Se algum atributo obrigatório estiver em branco
     */
    public void validaAluguel(Aluguel alu) throws GeralException {
        validarAtributos(alu);
        if (alu.getIdAluguel() == null || alu.getIdAluguel() < 1) {
            throw new GeralException("Número do aluguel inválido!");
        }
    }

    // não valida o ID, apenas as chaves de outras classes
    public void validarAtributos(Aluguel alu) throws GeralException {
        if (alu == null) {
            throw new GeralException("Informações inválidas!");
        }
        if (alu.getValor() == null || alu.getValor() < 0) {
            throw new GeralException("Valor invalido!");
        }
    }

    public void verificaDuplicidadeNome(Aluguel aluguel) throws GeralException {

        try {
            if (dao.consultaAluguel(aluguel.getIdAluguel()) != null) {
                throw new GeralException("Aluguel já existe.");
            }
        } catch (ConexaoException e) {
            throw new GeralException("Contacte o Administrador do Sistema. " + e);
        } catch (DAOException e) {
            throw new GeralException("Erro, contacte o Administrador do Sistema. " + e);
        }
    }

    public void inserir(Aluguel aluguel) throws GeralException {

        try {
            dao.inserir(aluguel);
        } catch (ConexaoException e) {
            throw new GeralException("Erro na conexão, contacte o Administrador do Sistema... " + e.getMessage());
        } catch (DAOException e) {
            throw new GeralException("Erro na instrução do DAO. Contacte o Administrador do Sistema... " + e.getMessage());
        }
    }

    public void alterar(Aluguel alu) {

    }

    public void excluir(Aluguel alu) throws GeralException {
        try {
            dao.excluir(alu);
        } catch (ConexaoException ex) {
            throw new GeralException("Erro na conexão, contacte o administrador: "+ex.getMessage());
        } catch (DAOException ex) {
            throw new GeralException("Erro na instrução SQL, contacte o administrador: "+ex.getMessage());
        }
    }

    /**
     * Retorna a lista de produtos
     *
     * @return
     */
    public ArrayList<Aluguel> listar() {
        return null;
    }
    
    public ArrayList<AluguelRelacionamento> listarForegein() throws GeralException, GeralException {
        try {
            return dao.listarForegein();
        } catch (ConexaoException ex) {
            throw new GeralException("Erro na conexão, contacte o Administrador do Sistema... " + ex.getMessage());
        } catch (DAOException ex) {
            throw new GeralException("Erro na instrução do DAO. Contacte o Administrador do Sistema... " + ex.getMessage());
        }
    }

    public Aluguel get(Integer idAluguel) {
        return null;
    }

    public Aluguel consultaAluguel(Integer idAluguel) throws ConexaoException, DAOException, GeralException {
        try {
            Aluguel consultaAluguel = dao.consultaAluguel(idAluguel);
            return consultaAluguel;
        } catch (ConexaoException e) {
            throw new GeralException("Contacte o Administrador do Sistema.");
        } catch (DAOException e) {
            throw new GeralException("Erro, favor contate o Administrador do Sistema.");
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
