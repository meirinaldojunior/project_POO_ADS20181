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
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author meirinaldojunior
 */
public class DAOLoginImplementa implements DAOLogin {

    @Override
    public Boolean login(String cpf, String senha) throws DAOException, ConexaoException, NoSuchAlgorithmException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();

        Usuario usu = null;

        String sql = "SELECT * FROM Usuario WHERE Cpf=? AND senha=?";

        PreparedStatement pstm;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.setString(2, CriptografaMD5.criptografa(senha));
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            gc.desconectar(c);
        }
        return null;
    }

}
