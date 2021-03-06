/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import project_poo_ads20181.acessos.DAOLogin;
import project_poo_ads20181.acessos.DAOLoginImplementa;
import project_poo_ads20181.classes.Login;
import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author meirinaldojunior
 */
public class RNLogin {

    DAOLoginImplementa dao = new DAOLoginImplementa();

    public boolean valida(String login, String senha) throws GeralException {
        if (!login.isEmpty() && !login.isEmpty()) {
            return true;
        } else {
            throw new GeralException("Os campos não podm ficar em branco...");
        }
    }
    
    public boolean isLogado(Login login) throws GeralException{
        if(login != null){
            return true;
        }else{
            throw new GeralException("Login ou senha não encontrado.");
        }
    }

    public boolean login(String login, String senha) throws GeralException {
        try {
            return dao.login(login, senha);
        } catch (Exception e) {
            throw new GeralException("Erro no login ou senha...");
        }
    }

}
