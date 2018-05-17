/*	
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181;

import java.sql.Connection;
import javax.swing.JOptionPane;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;
import project_poo_ads20181.acessos.DAOAtendenteImplementa;
import project_poo_ads20181.classes.Atendente;

/**
 *
 * @author meirinaldojunior
 */
public class Project_POO_ADS20181 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        testaConexao();
        
        //Tenta inserir um atendente
        Atendente atendente = new Atendente();
        DAOAtendenteImplementa dao = new DAOAtendenteImplementa();
        try {
            dao.inserir(atendente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: "+e.getMessage());
        }
        
        
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
