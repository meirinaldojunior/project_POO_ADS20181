/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author meirinaldojunior
 */
public class RNLogin {
    
    public boolean valida(String login, String senha) throws GeralException{
        if(!login.isEmpty() && !login.isEmpty()){
            return true;
        }else{
            throw new GeralException("Os campos não podm ficar em branco...");
        }
    }
    
}
