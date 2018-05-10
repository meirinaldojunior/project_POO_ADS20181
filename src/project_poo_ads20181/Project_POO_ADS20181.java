/*	
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181;

import java.sql.Connection;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;
//import projeto.erro.DAOException;
//import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import projeto.acesso.DAOProduto;
//import projeto.acesso.DAOProdutoImpl;
//import projeto.basica.Produto;

/**
 *
 * @author meirinaldojunior
 */
public class Project_POO_ADS20181 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    }
    private static void testaConexao(){
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c;
        try {
            c = gc.conectar();
            gc.desconectar(c);
            System.out.println("CONECTOU");
        } catch (ConexaoException ex) {
            System.out.println("PAU NA CONEXAO");
        }
    }
    
} 
