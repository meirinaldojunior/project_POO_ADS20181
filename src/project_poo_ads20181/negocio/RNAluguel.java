/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import java.util.ArrayList;
import project_poo_ads20181.classes.Aluguel;
import project_poo_ads20181.acessos.DAOAluguel;
import project_poo_ads20181.acessos.DAOAluguelImplementa;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;


/**
 *
 * @author Hugo
 */
public class RNAluguel {
  /**
     * Verifica se um aluguel alu está com todos os campos preenchidos (inclusive o ID)
     * @param alu
     * @throws GeralException Se algum atributo obrigatório estiver em branco
     */
    public void validaAluguel(Aluguel alu)throws GeralException{
        validarAtributos(alu);
        if (alu.getIdAluguel()== null || alu.getIdAluguel() < 1){
        throw new GeralException("Número do aluguel inválido!");
        }
    }
    // não valida o ID, apenas as chaves de outras classes
    public void validarAtributos(Aluguel alu)throws GeralException{
        if(alu==null){
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
        }*/
        if(alu.getValor() == null || alu.getValor() < 0) {
            throw new GeralException("Valor invalido!");
        }
    }

    public void verificaDuplicidadeNome(Aluguel aluguel)throws GeralException{
        DAOAluguel dao = new DAOAluguelImplementa();
        try{
            if(dao.consultaAluguel( aluguel.getIdAluguel() )!=null){
                throw new GeralException("Produto ja existe.");
            }
        }
        catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }
        catch(DAOException e){
            throw new GeralException("Erro, contace o Administrador do Sistema.");
        }
    }
    
    public void inserir(Aluguel aluguel)throws GeralException{
        DAOAluguel dao = new DAOAluguelImplementa();
        try{
            dao.inserir(aluguel);
        }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
        }
    }
    
    public void alterar(Aluguel alu){
        
    }
    
    public void excluir(Aluguel alu){
        
    }
    
    /**
     * Retorna a lista de produtos
     * @return 
     */
    public ArrayList<Aluguel> listar(){
        return null;
    }
    
    public Aluguel get(Integer idAluguel){
        return null;
    }
    
}