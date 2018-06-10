/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.fachada;

import java.util.ArrayList;
import static java.util.Collections.list;
import project_poo_ads20181.acessos.DAOUsuario;
import project_poo_ads20181.acessos.DAOUsuarioImplementa;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author meirinaldojunior
 */
public class FachadaUsuario {
    
    public boolean cadastraUsuario(Usuario usuario) throws GeralException{
        DAOUsuarioImplementa u = new DAOUsuarioImplementa();
        
        return true;
    }
    
    public ArrayList<String> listaTipoUsuario() throws GeralException{
        DAOUsuarioImplementa u = new DAOUsuarioImplementa();
        try {
            return u.listaTipos();
        } catch (Exception e) {
            throw new GeralException("Não foi possível listar os tipos de usuários: "+e.getMessage());
        }
        
    }
}
