/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;
import project_poo_ads20181.acessos.DAOLoginImplementa;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
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

    public boolean logar(String login, String senha) throws GeralException {
        rnl.valida(login, senha);
        return rnl.login(login, senha);
    }

}
