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
import project_poo_ads20181.erro.GeralException;
import project_poo_ads20181.funcao.CriptografaMD5;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author meirinaldojunior
 */
public class DAOLoginImplementa implements DAOLogin {
    
    
    public Boolean login(String cpf, String senha) throws GeralException, DAOException, ConexaoException, NoSuchAlgorithmException {
        
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        String sql = "SELECT * FROM Usuario WHERE Cpf=? AND Senha=?";

        PreparedStatement pstm;
        
        System.err.println(cpf);
        System.err.println(CriptografaMD5.criptografa(senha));
        
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.setString(2, CriptografaMD5.criptografa(senha));
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                // salva o ID do usuário atual em uma variável ambiente
                System.setProperty("id_usuario_atendente", rs.getString("Id_Usuario"));
                return true;
            }
        } catch (SQLException e) {
           throw new GeralException("Erro na instrução SQL: "+e.getMessage());
        } finally {
            gc.desconectar(c);
        }
        return null;
    }

}
