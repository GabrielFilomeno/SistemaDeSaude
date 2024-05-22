import repositorio.ListaPacientes;
import entidades.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static repositorio.ListaPacientes.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int escolha;
            System.out.println("Escolha uma ação digitando o número correspondente.");
            System.out.println("""
                    1 - Cadastrar paciente.
                    2 - Listar pacientes.
                    3 - Alterar dados de um paciente.
                    4 - Monitorar dados de um paciente.
                    5 - Registar atividade para um paciente.
                    6 - Remover paciente.
                    7 - Fechar programa.
                    """);
            System.out.println();
            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    telaCadastro();
                    continue;

                case 2:
                    telaListarPacientes();
                    continue;

                case 3:
                    telaAlterarPaciente();
                    continue;

                case 4:
                    telaMonitorarPaciente();
                    continue;

                case 5:
                    telaRegistrarAtividade();
                    continue;

                case 6:
                    telaRemover();
                    continue;

                case 7:
                    sair();
                    System.out.println();
                    break;

                default:
                    System.out.println("Número incorreto, volte e tente novamente.");
                    System.out.println();
                    System.out.println("1 - Voltar");
                    int voltar = scan.nextInt();
                    continue;
            }
            break;
        }
    }

    public static void telaCadastro() {
        Paciente paciente = new Paciente();
        System.out.println("Cadastre um novo paciente.");
        System.out.println();

        System.out.print("Nome do paciente: ");
        scan.nextLine();
        String nomePaciente = scan.nextLine();
        System.out.print("Idade do paciente: ");
        int idadePaciente = scan.nextInt();

        System.out.print("Peso do paciente: ");
        double pesoPaciente = scan.nextDouble();

        System.out.print("Altura do paciente: ");
        double alturaPaciente = scan.nextDouble();

        System.out.print("Pressão arterial: ");
        double pressaoPaciente = scan.nextDouble();

        System.out.print("Frequencia cardiaca: ");
        double frenqueciaCardiacaPaciente = scan.nextDouble();

        System.out.print("Digite a dieta do paciente: ");
        scan.nextLine();
        String dietaPaciente = scan.nextLine();

        System.out.println("Quantas atividades físicas você deseja adicionar?");
        int numAtividades = scan.nextInt();
        List<String> atividadesFisicas = new ArrayList<>();
        for (int i = 0; i < numAtividades; i++) {
            System.out.print("Digite a atividade física " + (i + 1) + ":");
            String atividade = scan.next();
            atividadesFisicas.add(atividade);
        }
        paciente.setAtividadesFisicas(atividadesFisicas);

        paciente.setNome(nomePaciente);
        paciente.setIdade(idadePaciente);
        paciente.setPeso(pesoPaciente);
        paciente.setAltura(alturaPaciente);
        paciente.setPressaoArterial(pressaoPaciente);
        paciente.setFrequenciaCardiaca(frenqueciaCardiacaPaciente);
        paciente.setDietaAlimentar(dietaPaciente);
        paciente.setAtividadesFisicas(atividadesFisicas);
        addPaciente(paciente);
    }

    public static void telaListarPacientes() {
        System.out.println("Listagem de pacientes.");
        System.out.println();
        listarPacientes();
        System.out.println();
        System.out.println("1 - Voltar");
        int voltar = scan.nextInt();
    }

    public static void telaAlterarPaciente() {
        ListaPacientes.alterarDados(scan);
    }

    public static void telaMonitorarPaciente() {
        System.out.print("Digite o id do paciente:");
        System.out.println();
        int id = scan.nextInt();
        while (true) {
            if (id >= 0 && id < getListaPacientes().size()) {
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

        System.out.println("ID - " + id);
        System.out.println("Nome - " + paciente.getNome());
        System.out.println("Idade - " + paciente.getIdade());
        System.out.println("Peso - " + paciente.getPeso());
        System.out.println("Altura - " + paciente.getAltura());
        System.out.println("Pressão arterial - " + paciente.getPressaoArterial());
        System.out.println("Frequencia cardiaca - " + paciente.getFrequenciaCardiaca());
        System.out.println("Dieta alimentar - " + paciente.getDietaAlimentar());
        System.out.println("Atividades fisicas: " + paciente.getAtividadesFisicas());

        System.out.println("1 - voltar");
        int voltar = scan.nextInt();
    }

    public static void telaRegistrarAtividade() {
        System.out.println();
        System.out.print("Digite o id do paciente:");
        int id = scan.nextInt();
        while (true) {
            if (id >= 0 && id < getListaPacientes().size()) {
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

        System.out.println("Digite a nova atividade física.");
        scan.nextLine();
        String atividadesFisicas = scan.nextLine();
        System.out.println();
        paciente.addAtividadesFisicas(atividadesFisicas);
        System.out.println("Atividade: " + atividadesFisicas + " salva com sucesso.");
        System.out.println("1 - Voltar");
        int voltar = scan.nextInt();
    }

    public static void telaRemover() {
        System.out.print("Digite o id do paciente que deseja remover: ");
        int id = scan.nextInt();
        while (true) {
            if (id >= 0 && id < getListaPacientes().size()) {
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
        ListaPacientes.removerPaciente(id, scan);
        System.out.println("");
    }

    public static void sair() {
        System.out.println("sair");
    }
}
