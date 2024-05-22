package repositorio;

import entidades.Paciente;

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

    public static void removerPaciente(int id, Scanner scan) {
        String nomePaciente;
        System.out.println();
        System.out.println("Esse é o paciente a ser removido:");
        System.out.print("ID: " + id);
        System.out.println(" - Nome: " + listaPacientes.get(id).getNome());
        System.out.println("1 - Confirmar");
        System.out.println("2 - Cancelar");
        int confirmar = scan.nextInt();
        if (confirmar == 1) {
            nomePaciente = listaPacientes.get(id).getNome();
            listaPacientes.remove(id);

            System.out.println("O paciente");
            System.out.print("ID: " + id);
            System.out.println(" - Nome: " + nomePaciente);
            System.out.println("Foi removido.");
            System.out.println("1 - voltar");
            int voltar = scan.nextInt();
        }
    }

    public static void listarPacientes() {
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println("ID: " + i + " - Nome: " + listaPacientes.get(i).getNome());
        }
    }

    public static Paciente buscarPorId(int id, Scanner scan) {
        if (id >= 0 && id < listaPacientes.size()) {
            return listaPacientes.get(id);
        } else {
                return null;
            }
    }

    public static void alterarDados(Scanner scan) {
        System.out.println("Digite o ID do paciente que deseja alterar os dados:");
            int id = scan.nextInt();
        while (true) {
            if (id >= 0 && id < listaPacientes.size()) {
            break;
            } else {
                System.out.println("ID invalido.");
                System.out.println("1 - Digite novamente.");
                System.out.println("2 - Voltar");
                int digitarNovamente = scan.nextInt();

                if (digitarNovamente != 1){
                    System.out.println("Você voltou para tela inicial.");
                    break;
                }
            }
            System.out.println();
            System.out.println("Digite o ID novamente.");
            id = scan.nextInt();
        }
            Paciente paciente = buscarPorId(id, scan);
        if (paciente == null) {
            System.out.print("Você voltou para a tela inicial.");
            return;
        }
        System.out.println("Paciente selecionado: ");
        System.out.println("ID: " + id + " - Nome: " + paciente.getNome());

        if (paciente != null) {
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

            System.out.println("Dados do paciente atualizados com sucesso!");
            System.out.println("1 - Voltar");
            int voltar = scan.nextInt();
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }


}
