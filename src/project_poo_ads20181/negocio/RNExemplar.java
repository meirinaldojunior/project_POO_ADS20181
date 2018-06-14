/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_poo_ads20181.acessos.DAOExemplar;
import project_poo_ads20181.acessos.DAOExemplarImplementa;
import project_poo_ads20181.classes.Exemplar;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author Hugo
 */
public class RNExemplar {
      /**
     * Verifica se um Exemplar exe está com todos os campos preenchidos (inclusive o ID)
     * @param exe
     * @throws GeralException Se algum atributo obrigatório estiver em branco
     */
    
    DAOExemplar dao = new DAOExemplarImplementa();
    
    public void validaExemplar(Exemplar exe)throws GeralException{
        validarAtributos(exe);
        if (exe.getIdExemplar() < 1){
            throw new GeralException("Número do aluguel inválido!");
        }
    }
    // não valida o ID, apenas as chaves de outras classes
    public void validarAtributos(Exemplar exe)throws GeralException{
        if(exe==null){
            throw new GeralException("Inválido!");
        }
        /*if(alu.getIdAtendente()== null || alu.getIdAtendente() < 1){
            throw new GeralException("Atendente não cadastrado!");
        }
        if(alu.getIdExemplar()==null || alu.getIdExemplar()< 1){
            throw new GeralException("Número do exemplar não cadastrado!");
        }
        if(alu.getIdUsuario() == null || alu.getIdUsuario() < 0){
            throw new GeralException("Usuário inválido!");
        }
        if(alu.getValor() == null || alu.getValor() < 0) {
            throw new GeralException("Valor invalido!");
        }*/
    }

    public void verificaDuplicidadeNome(Exemplar exe)throws GeralException {
        DAOExemplar dao = new DAOExemplarImplementa();
        try{
            if(dao.consultaIdExemplar(exe.getIdExemplar())!=null){
                throw new GeralException("Exemplar ja existe.");
            }
        }
        catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }
        catch(DAOException e){
            throw new GeralException("Erro, contace o Administrador do Sistema.");
        }
    }
    
    public void inserir(Exemplar exe)throws GeralException{
        DAOExemplar dao = new DAOExemplarImplementa();
        try{
            dao.inserir(exe);
        }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
        }
    }
    
    public void alterar(Exemplar exe){
        
    }
    
    public void excluir(Exemplar exe){
        
    }
    
    /**
     * Retorna a lista de exemplares
     * @return 
     */
    public ArrayList<Exemplar> listar() throws GeralException{
        try {
            return dao.lista();
        } catch (ConexaoException ex) {
            throw new GeralException("Erro na conexão: "+ex.getMessage());
        } catch (DAOException ex) {
            throw new GeralException("Erro na DAO: "+ex.getMessage());
        }
    }
    
    /**
     * Listar exemplares por id do livro
     * @param idLivro
     * @return
     * @throws GeralException 
     */
    public ArrayList<Exemplar> listar(int idLivro, int disponibilidade) throws GeralException{
        try {
            return dao.lista(idLivro, disponibilidade);
        } catch (ConexaoException ex) {
            throw new GeralException("Erro na conexão: "+ex.getMessage());
        } catch (DAOException ex) {
            throw new GeralException("Erro na DAO: "+ex.getMessage());
        }
    }
    
}
