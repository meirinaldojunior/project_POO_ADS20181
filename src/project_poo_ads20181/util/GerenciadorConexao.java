package project_poo_ads20181.util;

import java.sql.Connection;
import java.sql.Statement;
import project_poo_ads20181.erro.ConexaoException;

public interface GerenciadorConexao {
    
    /**
     * Estabelece uma conexao com o BD
     * @return Objeto de conexao com o BD
     */
    public Connection conectar()throws ConexaoException;
    
    /**
     * Encerra uma conexao ativa
     * @param c Objeto com a conexao a ser fechada
     */
    public void desconectar(Connection c)throws ConexaoException;

    public Statement createStatement();
}
