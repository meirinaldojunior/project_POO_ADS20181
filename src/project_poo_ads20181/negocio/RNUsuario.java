/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import project_poo_ads20181.acessos.DAOUsuario;
import project_poo_ads20181.acessos.DAOUsuarioImplementa;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.funcao.ValidaCPF;

/**
 *
 * @author meirinaldojunior
 */
public class RNUsuario {

    DAOUsuarioImplementa u;

    public RNUsuario() {
        u = new DAOUsuarioImplementa();
    }

    public boolean validaCadastro(Usuario usuario) throws GeralException, ConexaoException {

        //valida se usuário se campos está vazio
        if (usuario.getNome().isEmpty() || usuario.getSenha().isEmpty() || usuario.getcpf().isEmpty()) {
            throw new GeralException("Os campos não podem ficar em branco");
        } else {
            //valida o nome
            for (int i = 0; i < usuario.getNome().length(); i++) {
                if (!Character.isAlphabetic((usuario.getNome().charAt(i)))) {
                    throw new GeralException("Nome invalido!");
                }
            }
            //valida o CPF
            if (!ValidaCPF.isValid(usuario.getcpf())) {
                throw new GeralException("CPF inválido");
            }

            //verifica duplicidade de registro
            try {
                if (u.consultaCpf(usuario.getcpf()) != null) {
                    throw new GeralException("Já existe um usuário com este CPF");
                }
            } catch (DAOException ex) {
                throw new GeralException("Falha ao consultar duplicidade de registro");
            }

        }
        return true;
    }
    
    public boolean validaEdicao(Usuario usuario) throws GeralException, ConexaoException {

        //valida se usuário se campos está vazio
        if (usuario.getNome().isEmpty() || usuario.getcpf().isEmpty()) {
            throw new GeralException("Os campos não podem ficar em branco");
        } else {
            //valida o nome
            for (int i = 0; i < usuario.getNome().length(); i++) {
                if (!Character.isAlphabetic((usuario.getNome().charAt(i)))) {
                    throw new GeralException("Nome invalido!");
                }
            }
            //valida o CPF
            if (!ValidaCPF.isValid(usuario.getcpf())) {
                throw new GeralException("CPF inválido");
            }

            //verifica duplicidade de registro
            try {
                if (u.consultaCpf(usuario.getcpf()) == null) {
                    throw new GeralException("O usuário que você está alterando não existe");
                }
            } catch (DAOException ex) {
                throw new GeralException("Falha ao consultar registro");
            }

        }
        return true;
    }

    public void inserir(Usuario usuario) throws GeralException {
        try {
            u.inserir(usuario);
        } catch (ConexaoException ex) {
            throw new GeralException("Problema interno no sistema, tente novamente em uma hora.");
        } catch (DAOException ex) {
            throw new GeralException("Problema ao processar sua requisição, o suporte foi avisado do problema.");
        }
    }

    public ArrayList<Usuario> listarUsuarios() throws GeralException {
        try {
            return u.lista();
        } catch (ConexaoException ex) {
            throw new GeralException("Problema interno no sistema, tente novamente em uma hora.");
        } catch (DAOException ex) {
            throw new GeralException("Problema ao processar sua requisição, o suporte foi avisado do problema.");
        }
    }
    
    public Boolean alterar(Usuario usuario) throws GeralException{
        DAOUsuario dao = new DAOUsuarioImplementa();
        try {
            dao.alterar(usuario);
        } catch (Exception e) {
            throw new GeralException("Falha ao editar este usuário, fomos informados e estamos tratado... "+e.getMessage());
        }
        return true;
    }
    
    public Boolean excluir(Usuario usuario) throws GeralException{
        DAOUsuario dao = new DAOUsuarioImplementa();
        try {
            dao.excluir(usuario);
            return true;
        } catch (ConexaoException ex) {
            throw new GeralException("Problema ao processar sua requisição, verifique sua conexão e tente novamente. "+ex.getMessage());
        } catch (DAOException ex) {
            throw new GeralException("Erro na instrução. "+ex.getMessage());
        }
    }

}
