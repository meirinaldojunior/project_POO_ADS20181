package project_poo_ads20181.classes;

public class Exemplar {

	private Integer idExemplar;
	private Categoria idCategoria = new Categoria();
        private Autor id = new Autor();
        private Livro idLivro = new Livro();
        
	public void setIdExemplar (Integer idExemplar){
        this.idExemplar = idExemplar;  
        }
        public Integer getIdExemplar(){
        return this.idExemplar;
    }
        public void setIdCategoria (Categoria idCategoria){
        this.idCategoria = idCategoria;  
        }
        public Categoria getIdCategoria(){
        return this.idCategoria;
    }
        public void setId (Autor id){
        this.id = id;  
        }
        public Autor getId(){
        return this.id;
    }
        public void setIdLivro (Livro idLivro){
        this.idLivro = idLivro;  
        }
        public Livro getIdLivro(){
        return this.idLivro;
    }

    }
