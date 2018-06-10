/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.negocio;

import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.funcao.ValidaCPF;

/**
 *
 * @author meirinaldojunior
 */
public class RNUsuario {

    public boolean validaUsuario(Usuario usuario) throws GeralException {
        if (usuario.getNome().isEmpty() || usuario.getSenha().isEmpty() || usuario.getcpf().isEmpty()) {
            throw new GeralException("Os campos não podem ficar em branco");
        } else {
            for (int i = 0; i < usuario.getNome().length(); i++) {
                if (!Character.isAlphabetic((usuario.getNome().charAt(i)))) {
                    throw new GeralException("Nome invalido!");
                }
            }
            if (!ValidaCPF.isValid(usuario.getcpf())) {
                throw new GeralException("CPF inválido");
            }
        }
        return true;
    }
    
}
