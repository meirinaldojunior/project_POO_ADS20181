package project_poo_ads20181.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import project_poo_ads20181.erro.ConexaoException;
 
public class GerenciadorConexaoMySql implements GerenciadorConexao{
    private final String URL;
    private final String USU;
    private final String SEN;
    private static GerenciadorConexaoMySql instancia;
    
     public GerenciadorConexaoMySql(String URL ,String USU,String SEN){
     this.URL = URL;
     this.USU = USU;
     this.SEN = SEN ;
     
     }   
    private GerenciadorConexaoMySql(){
        ResourceBundle rb = ResourceBundle.getBundle("project_poo_ads20181.util.banco");
        URL = rb.getString("url");
        USU = rb.getString("usuario");
        SEN = rb.getString("senha");
    }
    
    public static GerenciadorConexaoMySql getInstancia(){
        if(instancia==null) instancia = new GerenciadorConexaoMySql();
        return instancia;
    }
    
    @Override
    public Connection conectar()throws ConexaoException {
        Connection c = null;
        
        try{
            c = DriverManager.getConnection(URL, USU, SEN);
        }catch(SQLException e){
            System.out.println(e);
            throw new ConexaoException();
        }
        
        return c;
    }

    @Override
    public void desconectar(Connection c)throws ConexaoException {
        try {
            c.close();
        } catch (SQLException ex) {
            throw new ConexaoException();
        }
    }

    @Override
    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
