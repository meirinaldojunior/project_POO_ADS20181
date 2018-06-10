/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import java.util.ArrayList;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.negocio.RNUsuario;

/**
 *
 * @author meirinaldojunior
 */
public class FachadaUsuario {

    RNUsuario rn = new RNUsuario();

    public boolean cadastra(Usuario usuario) throws GeralException, ConexaoException {
        rn.validaCadastro(usuario);
        rn.inserir(usuario);
        return true;
    }

    public ArrayList<Usuario> listarUsuarios() throws GeralException {
        return rn.listarUsuarios();
    }

    public ArrayList<Usuario> listaTipoUsuario() throws GeralException {
        return rn.listarUsuarios();
    }
    
    public Boolean altera(Usuario usuario) throws GeralException, ConexaoException{
        rn.validaEdicao(usuario);
        rn.alterar(usuario);
        return true;
    }
    
}
