package project_poo_ads20181.classes;

/**
 *
 * @author Rafael Augusto
 */
public class Livro {
  
    private int idLivro;
    private String nomeLivro;
    private Categoria nomeCategoria;
    private Autor idAutor,nome;
    
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
    
    public void setIdAutor (Autor id){
        this.idAutor = id;
    }
    public Autor getIdAutor(){
        return this.idAutor;
    }
    
    public void setNomeAutor(Autor Nome){
        this.nome = Nome;
    }
    public Autor getNomeAutor(){
        return this.nome;
    }
  
    
    
}
