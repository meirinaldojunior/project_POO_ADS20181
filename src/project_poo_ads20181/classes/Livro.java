package project_poo_ads20181.classes;

/**
 *
 * @author Rafael Augusto
 */
public class Livro {
  
    private Integer idLivro;
    private String nomeLivro;
    private Categoria nomeCategoria;
    private Autor idAutor;
    
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

    public void setCategoria(Categoria nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    }
    public Categoria getCategoria(){
        return this.nomeCategoria;
    }
    
  
    
    
}
