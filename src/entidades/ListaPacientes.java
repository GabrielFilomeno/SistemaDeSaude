package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPacientes {
    private static List<Paciente> listaPacientes = new ArrayList<>();

    public static List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public static void addPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    public static void removerPaciente(int id) {
        listaPacientes.remove(id);
    }

    public static void listarPacientes() {
        for(int i = 0; i < listaPacientes.size(); i++) {
            System.out.println("ID: " + i + " - Nome: " + listaPacientes.get(i).getNome());
        }
    }

    public static Paciente buscarPorId(int id) {
        if (id >= 0 && id < listaPacientes.size()) {
            return listaPacientes.get(id);
        } else {
            System.out.println("ID inválido. Por favor, tente novamente.");
            return null;
        }
    }

    public static void alterarDados(Scanner scan) {
        System.out.println("Digite o ID do paciente que deseja alterar:");
        int id = scan.nextInt();
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            System.out.println("Digite o novo nome:");
            String nome = scan.next();
            paciente.setNome(nome);

            System.out.println("Digite a nova idade:");
            int idade = scan.nextInt();
            paciente.setIdade(idade);

            System.out.println("Digite o novo peso:");
            double peso = scan.nextDouble();
            paciente.setPeso(peso);

            System.out.println("Digite a nova altura:");
            double altura = scan.nextDouble();
            paciente.setAltura(altura);

            System.out.println("Digite a nova pressão arterial:");
            double pressaoArterial = scan.nextDouble();
            paciente.setPressaoArterial(pressaoArterial);

            System.out.println("Digite a nova frequência cardíaca:");
            int frequenciaCardiaca = scan.nextInt();
            paciente.setFrequenciaCardiaca(frequenciaCardiaca);

            System.out.println("Digite a nova dieta alimentar:");
            String dietaAlimentar = scan.next();
            paciente.setDietaAlimentar(dietaAlimentar);

            System.out.println("Quantas atividades físicas você deseja adicionar?");
            int numAtividades = scan.nextInt();
            List<String> atividadesFisicas = new ArrayList<>();
            for (int i = 0; i < numAtividades; i++) {
                System.out.println("Digite a atividade física " + (i + 1) + ":");
                String atividade = scan.next();
                atividadesFisicas.add(atividade);
            }
            paciente.setAtividadesFisicas(atividadesFisicas);

            System.out.println("Dados do paciente atualizados com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }


}