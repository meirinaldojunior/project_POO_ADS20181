package project_poo_ads20181.classes;

public class Exemplar {

	private int idExemplar;
	private Categoria idCategoria;
        private Autor id;
        private Livro idLivro;
        
	public void setIdExemplar (int idExemplar){
        this.idExemplar = idExemplar;  
        }
        public int getIdExemplar(){
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
