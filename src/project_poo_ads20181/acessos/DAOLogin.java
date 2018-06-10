/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.acessos;

import java.security.NoSuchAlgorithmException;
import project_poo_ads20181.classes.Login;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author meirinaldojunior
 */
public interface DAOLogin  {
    
    public Login login(String cpf, String senha) throws DAOException, ConexaoException, NoSuchAlgorithmException;
    
}
