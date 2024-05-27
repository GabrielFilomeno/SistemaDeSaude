package entidades;

public class Endereco {

    private String logradouro;
    private String Estado;
    private String cidade;
    private String numero;
    private String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, String estado, String cidade, String numero, String cep) {
        this.logradouro = logradouro;
        Estado = estado;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getNumero() {
        return numero;
    }

    public String getCep() {
        return cep;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
