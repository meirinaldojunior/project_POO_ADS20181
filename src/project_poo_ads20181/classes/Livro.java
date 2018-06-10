package project_poo_ads20181.classes;

/**
 *
 * @author Rafael Augusto
 */
public class Livro {
  
    private Integer idLivro;
    private String nomeLivro;
    private Categoria cat = new Categoria();
    private Autor autor = new Autor();
    
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
    
    public void setCat(Categoria categoria){
        this.cat = categoria;
    }
    
    public Categoria getCat(){
        return cat;
    }
    
    public void setAutor(Autor autor){
        this.autor = autor;
    }
    
    public Autor getAutor(){
        return autor;
    }
    
}
