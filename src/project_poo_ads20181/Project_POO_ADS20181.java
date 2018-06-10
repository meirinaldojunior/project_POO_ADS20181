/*	
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_poo_ads20181;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import jdk.nashorn.internal.ir.TryNode;
import project_poo_ads20181.acessos.DAOAluguelImplementa;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;
import project_poo_ads20181.acessos.DAOAtendenteImplementa;
import project_poo_ads20181.acessos.DAOAutorImplementa;
import project_poo_ads20181.acessos.DAOCategoriaImplementa;
import project_poo_ads20181.acessos.DAOExemplarImplementa;
import project_poo_ads20181.acessos.DAOLivroImplementa;
import project_poo_ads20181.acessos.DAOUsuarioImplementa;
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

        //testaConexao();  
        //inserirLivro();
        //testaCadastroCategoria(); //ok
        //testaAlterarCategoria();  //ok
        //testaExcluirCategoria();  //ok
        //testaListarCategoria();   //ok
        //testaCadastroAluguel(); //ok
        //testaAlterarAluguel();  //ok
        //testaExcluirAluguel();  //ok
        //testaListarAluguel();   //ok
        //testaCadastroExemplar(); //ok
        //testaAlterarExemplar();  //ok
        //testaExcluirExemplar();  //ok
        //testaListarExemplar();   //ok
        //testaCadastroAtendente();
        //testaExclusaoAtendente();
        //testaEdicaoAtendente();
        //testaListagemAtendente();
        //testaInserirAutor();
        //testaExcluirAutor();
        //testaAlterarAutor();
        //testaListarAutor();
        //testaConsultaNomeAutor();
        //testaBuscaPorId();

        /**
         * Testes dos mÃ©todos do CRUD DAOAtendente TODO: PRECISAMOS REMOVER
         * QUANDO INCLUIR A GUI
         */
    }

    public static void testaCadastroAluguel() throws ConexaoException, DAOException {
        Aluguel alu = new Aluguel();

        alu.getIdAluguel();
        alu.getIdAtendente().setIdAtendente(12);
        alu.getIdExemplar().setIdExemplar(2);
        alu.getIdUsuario().setIdUsuario(2);
        alu.setValor(20.00);

        DAOAluguelImplementa DAOAddAluguel = new DAOAluguelImplementa();
        try {
            DAOAddAluguel.inserir(alu);
            System.out.println("objeto gravado com sucesso");
        } catch (DAOException e) {
            System.out.println("pau");
        }

    }

    private static void testaAlterarAluguel() throws ConexaoException, DAOException {

        Aluguel alu = new Aluguel();
        Atendente ate = new Atendente();
        Exemplar exe = new Exemplar();
        Usuario usu = new Usuario();

        alu.setIdAtendente(ate);
        alu.setIdExemplar(exe);
        alu.setIdUsuario(usu);
        alu.setValor(100.53);
        alu.setIdAluguel(17);

        ate.setIdAtendente(11);
        exe.setIdExemplar(2);
        usu.setIdUsuario(1);

        DAOAluguelImplementa DAOAltAluguel = new DAOAluguelImplementa();

        try {
            DAOAltAluguel.alterar(alu);
            System.out.println("aluguel alterado com sucesso");
        } catch (DAOException e) {
            System.out.println("erro");
        }
    }

    private static void testaExcluirAluguel() throws ConexaoException, DAOException {
        Aluguel alu = new Aluguel();

        alu.setIdAluguel(19);

        DAOAluguelImplementa DAOExcAlu = new DAOAluguelImplementa();
        try {
            DAOExcAlu.excluir(alu);
            System.out.println("Aluguel excluido");
        } catch (DAOException e) {
            System.out.println("Erro");
        }
    }

    private static void testaListarAluguel() throws ConexaoException, DAOException {
        DAOAluguelImplementa DAOListAlu = new DAOAluguelImplementa();
        try {
            ArrayList<Aluguel> lista = DAOListAlu.lista();
            System.out.println("Lista de Alugueis:");
            lista.stream().forEach((alu) -> {
                System.out.println(alu.getIdAluguel());
            });
        } catch (DAOException e) {
            System.out.println("pau!! " + e.getMessage());
        }
    }

    public static void testaCadastroExemplar() throws ConexaoException, DAOException {
        Exemplar exe = new Exemplar();

        exe.getIdExemplar();
        exe.getIdLivro().setIdLivro(2);
        exe.getIdCategoria().setIdCategoria(4);
        exe.getId().setId(104);

        DAOExemplarImplementa DAOAddExe = new DAOExemplarImplementa();
        try {
            DAOAddExe.inserir(exe);
            System.out.println("objeto gravado com sucesso");
        } catch (DAOException e) {
            System.out.println("pau");
        }

    }

    private static void testaAlterarExemplar() throws ConexaoException, DAOException {

        Exemplar exe = new Exemplar();
        Livro liv = new Livro();
        Categoria cat = new Categoria();
        Autor aut = new Autor();

        exe.setIdExemplar(13);
        exe.setIdLivro(liv);
        exe.setIdCategoria(cat);
        exe.setId(aut);

        liv.setIdLivro(3);
        cat.setIdCategoria(5);
        aut.setId(105);

        DAOExemplarImplementa DAOAltExe = new DAOExemplarImplementa();

        try {
            DAOAltExe.alterar(exe);
            System.out.println("Exemplar alterado com sucesso");
        } catch (DAOException e) {
            System.out.println("erro");
        }
    }

    private static void testaExcluirExemplar() throws ConexaoException, DAOException {
        Exemplar exe = new Exemplar();

        exe.setIdExemplar(1);

        DAOExemplarImplementa DAOExcExe = new DAOExemplarImplementa();
        try {
            DAOExcExe.excluir(exe);
            System.out.println("Aluguel excluido");
        } catch (DAOException e) {
            System.out.println("Erro");
        }
    }

    private static void testaListarExemplar() throws ConexaoException, DAOException {
        DAOExemplarImplementa DAOListExe = new DAOExemplarImplementa();
        try {
            ArrayList<Exemplar> lista = DAOListExe.lista();
            System.out.println("Lista de Exemplares:");
            lista.stream().forEach((exe) -> {
                System.out.println(exe.getIdExemplar());
            });
        } catch (DAOException e) {
            System.out.println("pau!! " + e.getMessage());
        }
    }

    private static void inserirLivro() {
        Livro liv = new Livro();
        Categoria nvCat = new Categoria();

        liv.setNomeLivro("A rua de baixo");
        nvCat.setNomeCategoria("Tretas da vida");

        DAOLivroImplementa DAOLivro = new DAOLivroImplementa();
        try {
            DAOLivro.inserir(liv);
            System.out.println("Dados inseridos com sucesso!");
        } catch (Exception e) {
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
            for (Atendente at : DAOListAten.listar()) {
                System.out.println("ID: " + at.getIdAtendente()
                        + " | Nome: " + at.getNome()
                        + " | CPF: " + at.getCpf());
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
            System.out.println("Conexão não pode ser estabelecida: " + ex.getMessage());
        }

    }

    public static void testaInserirAutor() throws ConexaoException, DAOException {
        Autor a = new Autor("valter");
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try {
            dai.inserir(a);
            System.out.println("objeto gravado com sucesso");
        } catch (DAOException da) {
            System.out.println("não foi possivel gravar o objeto");
        }

    }

    private static void TestaAlterarAutor() throws ConexaoException, DAOException {
        Autor a = new Autor();
        a.setNome("julius");
        a.setId(101);
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try {
            dai.alterar(a);
            System.out.println("autor alterado com sucesso");
        } catch (DAOException dae) {
            System.out.println("operação não concluida");
        }
    }

    private static void testaExcluirAutor() throws ConexaoException, DAOException {
        Autor a = new Autor();
        a.setId(102);
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try {
            dai.excluir(a);
            System.out.println("Autor excluido com sucesso");
        } catch (DAOException e) {
            System.out.println("exclusão não concluida " + e.getMessage());
        }
    }
    

    private static void testaListarAutor() throws ConexaoException, DAOException {
        DAOAutorImplementa dai = new DAOAutorImplementa();
        try {
            ArrayList<Autor> lista = dai.listar();
            lista.stream().forEach((a) -> {
                System.out.println("Autor: " + a.getNome());
                System.out.println("Id: "+ a.getId());
            });
            
        } catch (DAOException e) {
            System.out.println("Autor não pode ser adicionado a lista " + e.getMessage());
        }
    }

    public static Autor testaBuscaPorId(int id) throws ConexaoException {
        DAOAutorImplementa dai = new DAOAutorImplementa();
        Autor a = new Autor();
        try {
            

            a = dai.buscaPorId(id);

            if (a != null) {
                System.out.println("Autor encontrado" + a.getNome());
            }
            
        } catch (DAOException e) {
            System.out.println("busca não obteve resultados");
        }
            
        
        return a;
    }

        private static Autor testaConsultaNomeAutor(String a) throws ConexaoException, DAOException {
        DAOAutorImplementa dai = new DAOAutorImplementa();
        Autor at = new Autor();
        try{
         at = dai.consultaNome(a);
         if(at != null){
             System.out.println("nome invalido");  
         }
        }catch(DAOException e){
                 
                 }
        return at;
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

    private static void testaAlterarCategoria() throws ConexaoException, DAOException {
        Categoria ct = new Categoria();
        ct.setNomeCategoria("Romance");
        ct.setIdCategoria(6);
        DAOCategoriaImplementa cat = new DAOCategoriaImplementa();
        try {
            cat.alterar(ct);
            System.out.println("categoria alterada com sucesso");
        } catch (DAOException dae) {
            System.out.println("pau");
        }
    }

    private static void testaExcluirCategoria() throws ConexaoException, DAOException {
        Categoria ct = new Categoria();
        ct.setIdCategoria(6);
        DAOCategoriaImplementa Cat = new DAOCategoriaImplementa();
        try {
            Cat.excluir(ct);
            System.out.println("categoria excluida");
        } catch (Exception e) {
            System.out.println("pau");
        }
    }

    private static void testaListarCategoria() throws ConexaoException, DAOException {
        DAOCategoriaImplementa ct = new DAOCategoriaImplementa();
        try {
            ArrayList<Categoria> lista = ct.listar();
            System.out.println("Lista dos ids da categoria:");
            lista.stream().forEach((cat) -> {
                System.out.println(cat.getIdCategoria());
            });
        } catch (DAOException e) {
            System.out.println("pau!! " + e.getMessage());
        }
    }

}
