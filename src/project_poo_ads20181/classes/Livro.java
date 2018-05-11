package project_poo_ads20181.classes;

/**
 *
 * @author Rafael Augusto
 */
public class Livro {
  
    private Integer idLivro;
    private String nomeLivro;
    
  /*  public Livro (Integer idLivro, String nomeLivro){
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
    } */
        
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
