package entidades;

import java.time.LocalDateTime;

public class Consultas {

    private String nomeNutricionista;
    private String nomePaciente;
    private LocalDateTime dataHora;
    private Boolean consultaRealizada;

    public Consultas() {
    }

    public Consultas(String nomeNutricionista,
                     String nomePaciente,
                     LocalDateTime dataHora,
                     Boolean consultaRealizada) {

        this.nomeNutricionista = nomeNutricionista;
        this.nomePaciente = nomePaciente;
        this.dataHora = dataHora;
        this.consultaRealizada = consultaRealizada;
    }

    public String getNomeNutricionista() {
        return nomeNutricionista;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Boolean getConsultaRealizada() {
        return consultaRealizada;
    }

    public void setNomeNutricionista(String nomeNutricionista) {
        this.nomeNutricionista = nomeNutricionista;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setConsultaRealizada(Boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }
}
