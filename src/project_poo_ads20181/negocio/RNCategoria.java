/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import java.util.ArrayList;
import project_poo_ads20181.acessos.DAOCategoriaImplementa;
import project_poo_ads20181.classes.Categoria;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author Hugo
 */
public class RNCategoria {
    
    public void validaCategoria(Categoria ct)throws GeralException{
        validarAtributos(ct);
     if(ct.getIdCategoria()==null || ct.getIdCategoria()<1){
         throw new GeralException("Categoria inválida!");
        }
    }
    
         public void validarAtributos(Categoria ct)throws GeralException{
        if(ct==null){
            throw new GeralException("Categoria inválida!");
        }
        if(ct.getNomeCategoria()==null || ct.getNomeCategoria().trim().isEmpty()){
            throw new GeralException("Nome da categoria inválido!");
        }
        for (int i = 0; i < ct.getNomeCategoria().length(); i++) {
          if (!Character.isAlphabetic((ct.getNomeCategoria().charAt(i)))) {
          throw new GeralException("Nome da categoria inválido!");
          }
    }
}
    public void verificaDuplicidadeNome(Categoria ct)throws GeralException, DAOException, ConexaoException {
    DAOCategoriaImplementa dai = new DAOCategoriaImplementa();
    try{
    if(dai.consultaNome(ct.getNomeCategoria())!= null){
    throw new GeralException("Nome já existe!");
    }
    }catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }catch(DAOException e){
            throw new GeralException("Erro. Favor contactar Administrador do Sistema.");
    }
           
    }
    
    public void inserir(Categoria ct)throws GeralException, DAOException{
    DAOCategoriaImplementa dai = new DAOCategoriaImplementa();
    try{
    dai.inserir(ct);
    }catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }catch(DAOException e){
            throw new GeralException("Erro. Favor contactar Administrador do Sistema.");
    }
          }
  public void alterar(Categoria ct) throws GeralException, DAOException{
  DAOCategoriaImplementa dai = new DAOCategoriaImplementa();
  try{
  dai.alterar(ct);
  }catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }catch(DAOException e){
            throw new GeralException("Erro. Favor contactar Administrador do Sistema.");
    }
          }
 public void excluir(Categoria ct) throws GeralException, DAOException, ConexaoException{
     
     DAOCategoriaImplementa dai = new DAOCategoriaImplementa();
      boolean checkID = dai.checkID(ct);
     try{
         if(checkID == true){
         dai.excluir(ct);}
     }catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }catch(DAOException e){
            throw new GeralException("Erro. Favor contactar Administrador do Sistema.");
    }
          }
 
public ArrayList<Categoria>listar() throws ConexaoException, DAOException, GeralException{
        DAOCategoriaImplementa dai = new DAOCategoriaImplementa();
        try{
            ArrayList<Categoria> listar = dai.listar();
            return listar;
        }catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }catch(DAOException e){
            throw new GeralException("Erro. Favor contactar Administrador do Sistema.");
    }
          }
 public Categoria buscaPorId (int id) throws ConexaoException, DAOException, GeralException{
DAOCategoriaImplementa dai = new DAOCategoriaImplementa();
     try{
         Categoria buscaPorId = dai.consultaIdCategoria(id);
         return buscaPorId;
     }catch(ConexaoException e){
            throw new GeralException("Contacte o Administrador do Sistema.");
        }catch(DAOException e){
            throw new GeralException("Erro. Favor contactar Administrador do Sistema.");
    }
          }
}