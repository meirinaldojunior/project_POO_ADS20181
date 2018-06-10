/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import javax.swing.JFrame;
import project_poo_ads20181.acessos.DAOLoginImplementa;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.funcao.CriptografaMD5;
import project_poo_ads20181.negocio.RNLogin;

/**
 *
 * @author meirinaldojunior
 */
public class FachadaLogin {

    private RNLogin rnl;

    public FachadaLogin() {
        rnl = new RNLogin();
    }

    public boolean logar(String login, String senha) throws GeralException{
        if (rnl.valida(login, senha)) {
            try {
                DAOLoginImplementa l = new DAOLoginImplementa();
                return (l.login(login, senha));
            } catch (Exception e) {
                throw new GeralException("Login ou senha inválido...");
            }
        }
        return false;
    }

}
