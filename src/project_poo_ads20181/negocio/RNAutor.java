/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import project_poo_ads20181.classes.Autor;
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
        if(a.getId()==null || a.getId()< 1){
            throw new GeralException("Produto invalido!");
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
        }
     }
     
}



