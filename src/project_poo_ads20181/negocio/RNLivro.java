
package project_poo_ads20181.negocio;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import project_poo_ads20181.acessos.DAOAutorImplementa;
import project_poo_ads20181.acessos.DAOCategoriaImplementa;
import project_poo_ads20181.acessos.DAOLivroImplementa;
import project_poo_ads20181.classes.Livro;
import project_poo_ads20181.erro.ConexaoException;
import project_poo_ads20181.erro.DAOException;
import project_poo_ads20181.erro.GeralException;

/**
 *
 * @author Rafael Augusto
 */
public class RNLivro {
    
    DAOLivroImplementa l;
    
    public RNLivro() {
        l = new DAOLivroImplementa();
    }
    
    public void validarID(Livro L) throws GeralException, DAOException, ConexaoException{
        DAOLivroImplementa dao = new DAOLivroImplementa();
        
        if(L.getIdLivro() == null || L.getIdLivro() < 1){
            throw new GeralException("Código de Registro inexistente!");
        }
            if(!dao.checkID(L)){
                throw new GeralException("ID não cadastrado!");
            }
    }
    
    public void validarAtributos(Livro L) throws GeralException{
        if(L.getNomeLivro().equals("") || L.getNomeLivro().trim().isEmpty()){
            throw new GeralException("Nome do livro invalido!");
        }
            if(L.getNomeLivro().length() > 50){
                throw new GeralException("Excedido o tamanho máximo de 50 caracter! ");   
            }
                if(L.getCat().getIdCategoria() <= 0){
                    throw new GeralException("Categoria não cadastrada na base de dados!");
                 }
                        if(L.getAutor().getId() <= 0){
                            throw new GeralException ("Autor não cadastrado na base de dados!");
                        }
    }
    
    public void validarDuplicidadeNome(Livro L) throws GeralException{
        
        DAOLivroImplementa dao = new DAOLivroImplementa();
        
            try{
                    if(dao.consultarNome(L).equals(L.getNomeLivro())){
                        
                            throw new GeralException("Este Registro já existe!");
                            }
            }                   catch(Exception e){
            
                                }  
    }
    
    public void inserirRegistro(Livro livro) throws GeralException, DAOException, ConexaoException{
         
        DAOLivroImplementa dao = new DAOLivroImplementa();
          
            try{
                    dao.inserir(livro);   
            }
            catch(ConexaoException e){
                throw new GeralException("Falha ao registrar, contate o Administrador!");
            }
                    catch(DAOException e){
                           throw new GeralException("BUG, contate o Administrador!");
                    }
     } 
    
    public void excluirRegistro(Livro livro) throws GeralException, DAOException, ConexaoException{
                
            DAOLivroImplementa dao = new DAOLivroImplementa();
            
        
                try{
                    if(livro.getIdLivro() == null){
                        JOptionPane.showMessageDialog(null,"Selecione um registro na lista para que seja deletado!");
                    }
                
                dao.excluir(livro);
                
                }
                        catch(ConexaoException e){
                            throw new GeralException("Falha ao excluir, contate o Administrador!");
                        }
                                catch(DAOException e){
                                    throw new GeralException("BUG, contate o Administrador!");
                                }
    }
    
    public void alterarRegistro(Livro livro) throws GeralException, DAOException, ConexaoException{
                
            DAOLivroImplementa dao = new DAOLivroImplementa();
        
                try{
                
                dao.alterar(livro);
                
                }
                        catch(ConexaoException e){
                            throw new GeralException("Falha na alteração, contate o Administrador!");
                        }
                                catch(DAOException e){
                                    throw new GeralException("BUG, contate o Administrador!");
                                }
    }
    
    public ArrayList<Livro> listarRegistro() throws GeralException, DAOException, ConexaoException{
                
            DAOLivroImplementa dao = new DAOLivroImplementa();
        
               try{

                    return dao.lista();
                
                }
                       catch(ConexaoException e){
                          throw new GeralException("Falha ao listar, contate o Administrador!");
                       }
                                catch(DAOException e){
                                   throw new GeralException("BUG, contate o Administrador!");
                               }
               
                            
    }
    
    public boolean idcatautor(Livro livro) throws DAOException, ConexaoException{
        DAOCategoriaImplementa daoc = new DAOCategoriaImplementa();
        DAOAutorImplementa daoa = new DAOAutorImplementa();
        
      if(!daoc.checkID(livro.getCat())){
          JOptionPane.showMessageDialog(null,"A Categoria não existe!");
   
    }
      if(!daoa.checkID(livro.getAutor())){
                JOptionPane.showMessageDialog(null,"O Autor não existe!");
      }
      return true;
    }
    public ArrayList<Livro> listarLivros(int param) throws GeralException {
        try {
            return l.lista(param);
        } catch (ConexaoException ex) {
            throw new GeralException("Problema interno no sistema, tente novamente em uma hora.");
        } catch (DAOException ex) {
            throw new GeralException("Problema ao processar sua requisição, o suporte foi avisado do problema.");
        }
    }
}
