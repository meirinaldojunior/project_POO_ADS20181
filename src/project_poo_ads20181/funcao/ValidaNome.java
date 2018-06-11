/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.funcao;

import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author meirinaldojunior
 */
public class ValidaNome {

    public static boolean valida(String st) throws GeralException {

        
    if (st.length() < 5 || st.length() > 50)
    {
        throw new GeralException("Nome invalido");
    }
    
    
    if(st.indexOf(" ") == -1)
    {
        throw new GeralException("O nome deve contre o seu nome e sobrenome");
    }
    
    if(st.substring(0,st.indexOf(" ")).length() < 2 || st.substring(st.lastIndexOf(" ") + 1).length() < 2)
    {
        throw new GeralException("O nome e o sobrenome deve contrer pelo menos 2 caracteres");
    }
        return true;
    }
}
