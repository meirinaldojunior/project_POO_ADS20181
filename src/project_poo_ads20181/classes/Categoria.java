package project_poo_ads20181.classes;

public class Categoria {

    private Integer idCategoria;
    private String nomeCategoria;
    
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
    
  /*  public Categoria (String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    } */
        
    public Categoria(String string) {
		// TODO Auto-generated constructor stub
	}

	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public void setNomeCategoria (String nomeCategoria){
        this.nomeCategoria = nomeCategoria;    
        }    
    
    public String getNomeCategoria(){
        return this.nomeCategoria;
    }
}
