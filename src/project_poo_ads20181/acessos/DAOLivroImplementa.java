
package project_poo_ads20181.acessos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import project_poo_ads20181.classes.Livro;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.util.GerenciadorConexao;
import project_poo_ads20181.util.GerenciadorConexaoMySql;

/**
 *
 * @author Rafael Augusto
 */
public class DAOLivroImplementa implements DAOLivro{

    
    /**
     * MÉTODO USADO PARA INSERIR O REGISTRO NA BASE DE DADOS.
     * @param livro - OBJETO QUE SERÁ INSERIDO.
     * @throws ConexaoException
     * @throws DAOException 
     */
    @Override
    public void inserir(Livro livro) throws ConexaoException, DAOException {
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        String sql = "INSERT INTO Livro (Nome_livro,Id_Categoria,Id_Autor) VALUES (?,?,?)";
        PreparedStatement pstm;
        
        try {
             pstm = c.prepareStatement(sql);
             pstm.setString(1, livro.getNomeLivro());
             pstm.setInt(2,livro.getCat().getIdCategoria());
             pstm.setInt(3,livro.getAutor().getId());
             pstm.executeUpdate();
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }     
    }
    /**
     * MÉTODO USADO PARA ALTERAR O REGISTRO NA BASE DE DADOS.
     * @param livro - OBJETO QUE SERA INSERIDO.
     * @throws ConexaoException
     * @throws DAOException 
     */
    @Override
    public void alterar(Livro livro) throws ConexaoException, DAOException {
        
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        String sql = "UPDATE Livro SET Nome_livro=?, Id_Categoria=?, Id_Autor=? WHERE Id_livro =?";
        
        PreparedStatement pstm;
        try {
             pstm = c.prepareStatement(sql);
             pstm.setString(1, livro.getNomeLivro());
             pstm.setInt(2,livro.getCat().getIdCategoria());
             pstm.setInt(3,livro.getAutor().getId());
             pstm.setInt(4,livro.getIdLivro());
             pstm.executeUpdate();
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        } 
    }
    /**
     * MÉTODO USADO PARA EXCLUIR O REGISTRO NA BASE DE DADOS.
     * @param livro - OBJETO A SER INSERIDO.
     * @throws ConexaoException
     * @throws DAOException 
     */
    @Override
    public void excluir(Livro livro) throws ConexaoException, DAOException {
        
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
               
        String sql = "DELETE FROM Livro WHERE Id_livro =?";
        
        PreparedStatement pstm;
        try {
             pstm = c.prepareStatement(sql);
             pstm.setInt(1,livro.getIdLivro());
             pstm.execute();
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        } 
    
    }
    /**
     * MÉTODO USADO PARA LISTAR OS REGISTRO DA BASE DE DADOS.
     * @return - RETORNA A LISTA DE DADOS.
     * @throws ConexaoException
     * @throws DAOException 
     */
    @Override
    public ArrayList<Livro> lista() throws ConexaoException, DAOException {
        
       Connection c = GerenciadorConexaoMySql.getInstancia().conectar();  
        ArrayList<Livro> lista = new ArrayList();
        
        String sql ="SELECT * FROM Livro";
        Statement stm;
        try{
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
              Livro  a = new Livro();
                a.setIdLivro(rs.getInt("Id_livro"));
                a.setNomeLivro(rs.getString("Nome_livro"));
                a.getCat().setIdCategoria(rs.getInt("Id_Categoria"));
                a.getAutor().setId(rs.getInt("Id_Autor")); 
                
                lista.add(a);
            }
             return lista;
             
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            GerenciadorConexaoMySql.getInstancia().desconectar(c);
        } 
    
       
    }
    /**
     * MÉTODO USADO PARA CONSULTAR O NOME REGISTRO NA BASE DE DADOS.
     * @param livro - OBJETO A SER PESQUISADO NA BASE DE DADOS.
     * @return - RETORNA O ID E O NOME DO LIVRO
     * @throws DAOException
     * @throws ConexaoException 
     */
    public Livro consultarNome (Livro livro) throws DAOException,ConexaoException{
        
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
         Livro liv = null;
        
        String sql = "SELECT Id_livro, Nome_livro FROM Livro WHERE Nome_livro=?";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setString(1, livro.getNomeLivro());
            ResultSet rs = pstm.executeQuery();
            
            if(rs.next()){
                liv = new Livro();
                liv.setIdLivro(rs.getInt("Id_livro") );
                liv.setNomeLivro(rs.getString("Nome_livro") );
                
            }
            
            return liv;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }
 
    }
    /**
     * METODO USADO PARA CHECAR SE O ID É EXISTENTE NA BASE DE DADOS!
     * @param livro - OBJETO A SER CHECADO.
     * @return - RETORNA TRUE, SE EXISTIR.
     * @throws DAOException
     * @throws ConexaoException 
     */
    
    
    public boolean checkID (Livro livro) throws DAOException,ConexaoException{
        
        GerenciadorConexao gc;
        gc = GerenciadorConexaoMySql.getInstancia();
        Connection c = gc.conectar();
        
        String sql = "SELECT Id_livro FROM Livro WHERE Id_livro=?";
        
        PreparedStatement pstm;
        try{
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, livro.getIdLivro());
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                return true;
            }
            
            return false;
            
        }catch(SQLException e){
            throw new DAOException();
        }finally{
            gc.desconectar(c);
        }
    
    
    }
    
}
