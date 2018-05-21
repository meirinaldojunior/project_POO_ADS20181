/*	
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import project_poo_ads20181.acessos.DAOAluguelImplementa;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;
import project_poo_ads20181.acessos.DAOAtendenteImplementa;
import project_poo_ads20181.acessos.DAOAutorImplementa;
import project_poo_ads20181.acessos.DAOCategoriaImplementa;
import project_poo_ads20181.acessos.DAOLivroImplementa;
import project_poo_ads20181.classes.Aluguel;
import project_poo_ads20181.classes.Atendente;
import project_poo_ads20181.classes.Autor;
import project_poo_ads20181.classes.Categoria;
import project_poo_ads20181.classes.Exemplar;
import project_poo_ads20181.classes.Livro;
import project_poo_ads20181.classes.Usuario;
import project_poo_ads20181.erro.DAOException;

/**
 *
 * @author meirinaldojunior
 */
public class Project_POO_ADS20181 {

    /**
     * @param args the command line arguments
     * @throws project_poo_ads20181.erro.ConexaoException
     * @throws project_poo_ads20181.erro.DAOException
     */
    public static void main(String[] args) throws ConexaoException, DAOException {
        
        testaConexao();       
        //inserirLivro();
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
 
>>>>>>> ee5940c5f893c40a2e1116fc01fefa375ccae9f0
        //testaAlterarAutor();
        //testaExcluirAutor();
>>>>>>> 11aef8ccd1aba2fdfecdaf9c96320ece839574b1
    	
        //testaCadastroCategoria();
        //testaAlterarCategoria();  
        //testaExcluirCategoria(); 
        //testaListarCategoria();   
        
        //testaCadastroAtendente();
        //testaExclusaoAtendente();
        //testaEdicaoAtendente();
        //testaListagemAtendente();
        
        //testaInserirAutor();
        //testaExcluirAutor();
        //testaAlterarAutor();
        //testaListarAutor();
        
        testaCadastroAluguel();
        //testaAlterarAluguel();  
        //testaExcluirAluguel(); 
        //testaListarAluguel();   
        
        /**
         * Testes dos mÃ©todos do CRUD DAOAtendente
         * TODO: PRECISAMOS REMOVER QUANDO INCLUIR A GUI
         */
        
    }

    public static void testaCadastroAluguel() throws ConexaoException, DAOException{
            Aluguel alu = new Aluguel();
            //Atendente ate = new Atendente();
            //Exemplar exe = new Exemplar();
            //Usuario usu = new Usuario();
            // ainda sem funcionar
            alu.setIdAluguel(1);
            alu.getIdAtendente().setIdAtendente(2);
            alu.getIdExemplar().setIdExemplar(3);
            alu.getCpf().setCpf("2947.1097");
            alu.setValor(10.00);
            
            DAOAluguelImplementa DAOAddAluguel = new DAOAluguelImplementa(); 
            try{
              DAOAddAluguel.inserir(alu);
              System.out.println("objeto gravado com sucesso");
            }catch(Exception e){
                System.out.println("pau");
            }
  
              
    }    
    private static void testaAlterarAluguel() throws ConexaoException, DAOException{
        Categoria ct = new Categoria();
        ct.setNomeCategoria("Romance");
        ct.setIdCategoria(1);
        DAOCategoriaImplementa cat = new DAOCategoriaImplementa();
        try{
        cat.alterar(ct);
            System.out.println("categoria alterada com sucesso");
    }catch(DAOException dae){
            System.out.println("pau");
    }
    }
    
        private static void testaExcluirAluguel() throws ConexaoException, DAOException {
        Categoria ct = new Categoria();
        ct.setIdCategoria(1);
        DAOCategoriaImplementa Cat = new DAOCategoriaImplementa();
        try {
            Cat.excluir(ct);
			System.out.println("categoria excluida");        
        } catch (Exception e) {
            System.out.println("pau");
        }
    }    

    private static void testaListarAluguel() throws ConexaoException, DAOException{
        DAOCategoriaImplementa  ct = new DAOCategoriaImplementa();
       try{
        ArrayList<Categoria>lista = ct.listar();
        System.out.println("Lista dos nomes da categoria:");
        lista.stream().forEach((cat) -> { 
                System.out.println(cat.getNomeCategoria());
                });
                }catch(DAOException e){
                 System.out.println("pau!! " +e.getMessage());
                }
    }
    
    
        private static void inserirLivro(){
        Livro liv = new Livro();
        Categoria nvCat = new Categoria();
        
        liv.setNomeLivro("A rua de baixo");
        nvCat.setNomeCategoria("Tretas da vida");
        
        DAOLivroImplementa DAOLivro = new DAOLivroImplementa();
                try{
                    DAOLivro.inserir(liv);
                        System.out.println("Dados inseridos com sucesso!");
        }catch(Exception e){
                    System.out.println("Erro ao inserir registro");
        }
    }
    /**
     * MÃ‰TODOS DE TESTE PROVISÃ“RIOS, OS MÃ‰TODOS A SEGUIR SERÃƒO SUBSTITUÃ�DOS
     * QUANDO FOREM IMPLEMENTADOS OS MÃ‰TODOS DE FACHADA E TESTES UNITÃ�RIOS.
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
    public static void testaInserirAutor() throws ConexaoException, DAOException{
            Autor a = new Autor ("valter");
            DAOAutorImplementa dai = new DAOAutorImplementa(); 
            try{
              dai.inserir(a);
              System.out.println("objeto gravado com sucesso");
            }catch(DAOException da){
                System.out.println("pau");
            }
  
              
    }
    private static void TestaAlterarAutor() throws ConexaoException, DAOException{
        Autor a = new Autor();
        a.setNome("julius");
        a.setId(101);
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try{
        dai.alterar(a);
            System.out.println("autor alterado com sucesso");
    }catch(DAOException dae){
            System.out.println("pau");
    }
    }

    private static void testaExcluirAutor() throws ConexaoException, DAOException{
        Autor a = new Autor();
        a.setId(102);
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try{
        dai.excluir(a);
            System.out.println("Autor excluido com sucesso");       
    }catch(DAOException e){
            System.out.println("pau!! " +e.getMessage());
    }
    }
    
      
    private static void testaListarAutor() throws ConexaoException, DAOException{
        DAOAutorImplementa  dai = new DAOAutorImplementa();
       try{
        ArrayList<Autor>lista = dai.listar();
        lista.stream().forEach((a) -> { 
                System.out.println("Autor: " + a.getNome());
                });
                }catch(DAOException e){
                 System.out.println("pau!! " +e.getMessage());
                }
    }

    private static void testaCadastroCategoria() throws ConexaoException, DAOException {
        Categoria ct = new Categoria();
        ct.setNomeCategoria("Geografia");
        DAOCategoriaImplementa DAOAddCategoria = new DAOCategoriaImplementa();
        try {
            DAOAddCategoria.inserir(ct);
            System.out.println("Categoria cadastrada!");
        } catch (Exception e) {
            System.out.println("PAU");
        }
    }
    
    private static void testaAlterarCategoria() throws ConexaoException, DAOException{
        Categoria ct = new Categoria();
        ct.setNomeCategoria("Romance");
        ct.setIdCategoria(1);
        DAOCategoriaImplementa cat = new DAOCategoriaImplementa();
        try{
        cat.alterar(ct);
            System.out.println("categoria alterada com sucesso");
    }catch(DAOException dae){
            System.out.println("pau");
    }
    }
    
        private static void testaExcluirCategoria() throws ConexaoException, DAOException {
        Categoria ct = new Categoria();
        ct.setIdCategoria(1);
        DAOCategoriaImplementa Cat = new DAOCategoriaImplementa();
        try {
            Cat.excluir(ct);
			System.out.println("categoria excluida");        
        } catch (Exception e) {
            System.out.println("pau");
        }
    }    

    private static void testaListarCategoria() throws ConexaoException, DAOException{
        DAOCategoriaImplementa  ct = new DAOCategoriaImplementa();
       try{
        ArrayList<Categoria>lista = ct.listar();
        System.out.println("Lista dos nomes da categoria:");
        lista.stream().forEach((cat) -> { 
                System.out.println(cat.getNomeCategoria());
                });
                }catch(DAOException e){
                 System.out.println("pau!! " +e.getMessage());
                }
    }
        
}