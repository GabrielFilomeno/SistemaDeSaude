package entidades;

import java.util.ArrayList;
import java.util.List;

public class Nutricionista extends Funcionario {

    private List<String> certificacoes = new ArrayList<>();
    private int numeroConsultas;
    private int tempoExperiencia;

    public Nutricionista() {
    }

    public Nutricionista(String nome,
                         int idade,
                         Endereco endereco,
                         double salario,
                         List<String> certificacoes,
                         int numeroConsultas,
                         int tempoExperiencia) {

        super(nome, idade, endereco, salario);
        this.certificacoes = certificacoes;
        this.numeroConsultas = numeroConsultas;
        this.tempoExperiencia = tempoExperiencia;
    }

    public void verificarNomeExistente(){

    }

    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }
}
