/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181.acessos;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project_poo_ads20181.classes.Login;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.funcao.CriptografaMD5;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author meirinaldojunior
 */
public class DAOLoginImplementa implements DAOLogin{
    
    public Login login(String cpf, String senha) throws DAOException, ConexaoException, NoSuchAlgorithmException {
        Connection c = GerenciadorConexaoMySql.getInstancia().conectar();        
        Login usuarioLogado = null;
        
        

        String sql = "SELECT * FROM Usuario WHERE Cpf = ? AND Senha = ?";
        PreparedStatement stm;

        try {
            stm = c.prepareStatement(sql);
            stm.setString(1, cpf);
            stm.setString(2, CriptografaMD5.criptografa(senha));
            ResultSet rs = stm.executeQuery(sql);
                        
            Usuario u = new Usuario();
            
            while(rs.next()){
                u.setIdUsuario(rs.getInt("Id_Usuario"));
                u.setNome(rs.getString("Nome"));
                u.setCpf(rs.getString("Cpf"));
                u.setTipoUsuario(rs.getInt("Tipo"));
            }
            
            usuarioLogado.setUsuarioLogado(u);
            
            return usuarioLogado;

        } catch (SQLException e) {
            System.out.println("ERRO " + e);
            throw new DAOException();
        } finally {
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        }
    }

    
}
