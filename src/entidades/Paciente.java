package entidades;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private double pressaoArterial;
    private double frequenciaCardiaca;
    private String dietaAlimentar;
    private List<String> atividadesFisicas = new ArrayList<>();

    public double calcularImc(){
        double imc = peso / (altura * altura);
        return imc;
    }

    public void monitoramentoPaciente() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("Pressão arterial: " + pressaoArterial);
        System.out.println("Frequencia cardiaca: " + frequenciaCardiaca);
        System.out.println("Dieta alimentar: " + dietaAlimentar);
        System.out.println("Atividades fisica: " + atividadesFisicas);
        System.out.println("IMC : " + calcularImc());
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getPressaoArterial() {
        return pressaoArterial;
    }

    public double getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public String getDietaAlimentar() {
        return dietaAlimentar;
    }

    public List<String> getAtividadesFisicas() {
        return atividadesFisicas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPressaoArterial(double pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public void setFrequenciaCardiaca(double frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public void setDietaAlimentar(String dietaAlimentar) {
        this.dietaAlimentar = dietaAlimentar;
    }

    public void setAtividadesFisicas(List<String> atividadesFisicas) {
        this.atividadesFisicas = atividadesFisicas;
    }

    public void addAtividadesFisicas(String atividadesFisicas) {
        this.atividadesFisicas.add(atividadesFisicas);
    }
}
