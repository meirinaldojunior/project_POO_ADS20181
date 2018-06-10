package project_poo_ads20181.classes;

/**
 *
 * @author Hugo Felipe
 */
public class Usuario {

    private Integer idUsuario;
    private String cpf;
    private String nome;
    private String senha;
    private int tipo;

    public Usuario() {
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;

    }

    public String getcpf() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return this.idUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }
    
    public void setTipoUsuario(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return this.tipo;
    }

}
