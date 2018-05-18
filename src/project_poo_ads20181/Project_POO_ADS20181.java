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
import project_poo_ads20181.acessos.DAOAutorImplementa;
import project_poo_ads20181.classes.Atendente;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author meirinaldojunior
 */
public class Project_POO_ADS20181 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ConexaoException, DAOException {
        
        testaConexao();
        testaAlterarAutor();
        
        /**
         * Testes dos métodos do CRUD DAOAtendente
         * TODO: PRECISAMOS REMOVER QUANDO INCLUIR A GUI
         */
        
        //testaCadastroAtendente();
        //testaExclusaoAtendente();
        //testaEdicaoAtendente();
        //testaListagemAtendente();

    }

    
    /**
     * MÉTODOS DE TESTE PROVISÓRIOS, OS MÉTODOS A SEGUIR SERÃO SUBSTITUÍDOS
     * QUANDO FOREM IMPLEMENTADOS OS MÉTODOS DE FACHADA E TESTES UNITÁRIOS.
     */
    private static void testaCadastroAtendente() {
        Atendente atendente = new Atendente();
        atendente.setCpf("12345678901");
        atendente.setNome("Darth Vader");
        DAOAtendenteImplementa DAOAddAten = new DAOAtendenteImplementa();
        try {
            DAOAddAten.inserir(atendente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + e.getMessage());
        }
    }

    private static void testaExclusaoAtendente() {
        Atendente atendente = new Atendente();
        atendente.setIdAtendente(1);
        DAOAtendenteImplementa DAOExcAten = new DAOAtendenteImplementa();
        try {
            DAOExcAten.excluir(atendente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        }
    }

    private static void testaEdicaoAtendente() {
        Atendente atUpt = new Atendente();
        atUpt.setCpf("99999999");
        atUpt.setNome("Novo nome");
        atUpt.setIdAtendente(2);
        DAOAtendenteImplementa DAOUpdtAten = new DAOAtendenteImplementa();
        try {
            DAOUpdtAten.alterar(atUpt);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    private static void testaListagemAtendente() {
        DAOAtendenteImplementa DAOListAten = new DAOAtendenteImplementa();
        try {
            for(Atendente at : DAOListAten.listar()){
                System.out.println("ID: "+at.getIdAtendente()+
                                   " | Nome: "+at.getNome()+
                                   " | CPF: "+at.getCpf());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
    }

    private static void testaConexao() {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c;
        try {
            c = gc.conectar();
            gc.desconectar(c);
            System.out.println("CONECTOU");
        } catch (ConexaoException ex) {
            System.out.println("PAU NA CONEXAO: " + ex.getMessage());
        }
        
        }
    public static void TestaInserirAutor() throws ConexaoException, DAOException{
            Autor a = new Autor ("valter");
            DAOAutorImplementa dai = new DAOAutorImplementa(); 
            try{
              dai.inserir(a);
              System.out.println("objeto gravado com sucesso");
            }catch(DAOException da){
                System.out.println("pau");
            }
  
              
    }
    private static void testaAlterarAutor() throws ConexaoException, DAOException{
        Autor a = new Autor();
        Autor b = new Autor("bob");
        b.setId(520);
        a.setNome("julius");
        a.setId(b.getId());
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try{
        dai.alterar(b);
            System.out.println("autor alterado com sucesso");
    }catch(DAOException dae){
            System.out.println("pau");
    }
    }
}

