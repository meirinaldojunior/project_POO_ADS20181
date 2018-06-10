/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import java.util.ArrayList;
import project_poo_ads20181.acessos.DAOAutorImplementa;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author valte
 */
public class RNAutor {
      /**
     * Verifica se um Autor a está com todos os campos preenchidos (inclusive o ID)
     * @param a Objeto com TODOS os atributos preenchidos
     * @throws GeralException Se algum atributo obrigatório estiver em branco
     */
    public void validaAutor(Autor a)throws GeralException{
        validarAtributos(a);
     if(a.getId()==null || a.getId()<1){
         throw new GeralException(" Autor invalido");
        }
    }
    /**
     * verifica se os atributos sao validos menos o Id
     * @param a
     * @throws GeralException 
     */
     public void validarAtributos(Autor a)throws GeralException{
        if(a==null){
            throw new GeralException(" Autor invalido");
        }
        if(a.getNome()==null || a.getNome().trim().isEmpty()){
            throw new GeralException("Nome invalido!");
        } for (int i = 0; i < a.getNome().length(); i++) {
          if (!Character.isAlphabetic((a.getNome().charAt(i)))) {
              throw new GeralException("Nome invalido!"); 
          }
     }
 
}
     
    public void verificaDuplicidadeNome(Autor a)throws GeralException, DAOException {
    DAOAutorImplementa dai = new DAOAutorImplementa();
    try{
    if(dai.consultaNome(a.getNome())!= null){
    throw new GeralException("Nome inválido");
    }
    }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
    }
           
    }
    public void inserir(Autor a)throws GeralException, DAOException{
    DAOAutorImplementa dai = new DAOAutorImplementa();
    try{
    dai.inserir(a);
    }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
    }
          }
  public void alterar(Autor a) throws GeralException, DAOException{
  DAOAutorImplementa dai = new DAOAutorImplementa();
  try{
  dai.alterar(a);
  }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
              } 
        }
  
 public void excluir(Autor a) throws GeralException, DAOException, ConexaoException{
     
     DAOAutorImplementa dai = new DAOAutorImplementa();
     try{
         
         dai.excluir(a);
     }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
              } 
 }
 
public ArrayList<Autor>listar() throws ConexaoException, DAOException, GeralException{
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try{
            ArrayList<Autor> listar = dai.listar();
            return listar;
        }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
        }
    
    }
 public Autor buscaPorId (int id) throws ConexaoException, DAOException, GeralException{
     DAOAutorImplementa dai = new DAOAutorImplementa();
     try{
         Autor buscaPorId = dai.buscaPorId(id);
         return buscaPorId;
     }catch(ConexaoException e){
            throw new GeralException("Contacte o ADM.");
        }catch(DAOException e){
            throw new GeralException("BUG.");
 }
    
 }
 }


