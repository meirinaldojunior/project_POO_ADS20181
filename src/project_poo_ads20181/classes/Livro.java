package project_poo_ads20181.classes;

/**
 *
 * @author Rafael Augusto
 */
public class Livro {
  
    private int idLivro;
    private String nomeLivro;
    private Categoria cat;
    private Autor a;
    
        public Livro (String nomeLivro){
        this.nomeLivro = nomeLivro;
    } 
        public Livro(){
            
        }
        
    public void setIdLivro (Integer idlivro){
        this.idLivro = idlivro;
        
        }
    public Integer getIdLivro(){
        return this.idLivro;
    }
    
    public void setNomeLivro (String NomeLivro){
        this.nomeLivro = NomeLivro;
    }
    public String getNomeLivro(){
        return this.nomeLivro;
    }
    
}
