/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import java.util.ArrayList;
import project_poo_ads20181.classes.Exemplar;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.negocio.RNExemplar;

/**
 *
 * @author Hugo
 */
public class FachadaExemplar {
    
    RNExemplar rn = new RNExemplar();
    
    /**
     * Lista todos exemplares
     * @return
     * @throws GeralException 
     */
    
    public ArrayList<Exemplar> listar() throws GeralException{
        return rn.listar();
    }
    
    /**
     * Lista exemplares por id do livro
     * @param idLivro
     * @return
     * @throws GeralException 
     */
    
    public ArrayList<Exemplar> listar(int idLivro) throws GeralException{
        return rn.listar();
    }
    
}
