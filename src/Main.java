import entidades.*;
import repositorio.ListaConsultas;
import repositorio.ListaFuncionarios;
import repositorio.ListaNutricionistas;
import repositorio.ListaPacientes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static repositorio.ListaConsultas.listarConsultas;
import static repositorio.ListaFuncionarios.listarFuncionarios;
import static repositorio.ListaNutricionistas.getListaNutricionista;
import static repositorio.ListaNutricionistas.listarNutricionista;
import static repositorio.ListaPacientes.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        cli(scan);
    }

    public static void cli(Scanner scan) {
        while (true) {
            int escolha;
            System.out.println("Escolha uma ação digitando o número correspondente.");
            System.out.println("""
                    -----Área de pacientes.-----
                    1 - Cadastrar paciente.
                    2 - Listar pacientes.
                    3 - Alterar dados de um paciente.
                    4 - Monitorar dados de um paciente.
                    5 - Registar atividade para um paciente.
                    6 - Remover paciente.
                                        
                    -----Área de funcionarios.-----
                                        
                    7 - Cadastro de funcionario.
                    8 - Cadastro de nutricionista.
                    9 - Listar Funcionarios.
                                        
                    -----Área de consultas
                                        
                    10 - Criar consulta.
                    11 - Listar consultas.
                    12 - Realizar consultas.
                                        
                    -----Sair-----
                    13 - Fechar programa.
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
                    telaCadastroFuncionario();
                    continue;

                case 8:
                    telaCadastroNutricionista();
                    continue;

                case 9:
                    telaListarFuncionarios();
                    continue;

                case 10:
                    telaCriarConsulta();
                    continue;

                case 11:
                    telaListarConultas();
                    continue;

                case 12:
                    telaRealizarConsultas(scan);
                    continue;

                case 13:
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

                if (digitarNovamente != 1) {
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

                if (digitarNovamente != 1) {
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

                if (digitarNovamente != 1) {
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

    public static void telaCadastroFuncionario() {
        Funcionario funcionario = new Funcionario();
        System.out.println("Digite o nome do funcionario:");
        scan.nextLine();
        String nomeFuncionario = scan.nextLine();

        System.out.println("Digite a idade do funcionario:");
        int idadeFuncionario = scan.nextInt();

        System.out.println("Digite o salario do funcionario:");
        double salarioFuncionario = scan.nextDouble();

        System.out.println("Digite o endereço do funcionario:");
        System.out.println("Logradouro: ");
        scan.nextLine();
        String logradouro = scan.nextLine();
        System.out.println("Estado: ");
        scan.nextLine();
        String estado = scan.nextLine();
        System.out.println("Cidade: ");
        scan.nextLine();
        String cidade = scan.nextLine();
        System.out.println("Numero: ");
        int numero = scan.nextInt();
        System.out.println("cep: ");
        String cep = scan.next();
        Endereco endereco = new Endereco(logradouro, estado, cidade, numero, cep);


        funcionario.setNome(nomeFuncionario);
        funcionario.setIdade(idadeFuncionario);
        funcionario.setSalario(salarioFuncionario);
        funcionario.setEndereco(endereco);

        ListaFuncionarios.addFuncionario(funcionario);

        System.out.println("O funcionario foi cadastrado com sucesso!");
        System.out.println("1 - Voltar");
        int voltar = scan.nextInt();
    }

    public static void telaCadastroNutricionista() {
        Nutricionista nutricionista = new Nutricionista();

        System.out.println("Digite o nome do nutricionista:");
        scan.nextLine();
        String nomeNutricionista = scan.nextLine();

        boolean nomeExisteNutri = true;

        while (nomeExisteNutri) {
            if (getListaNutricionista().isEmpty()) {
                        nutricionista.setNome(nomeNutricionista);
                        nomeExisteNutri = false;
                    } else {
                for (Nutricionista nutri : getListaNutricionista()) {
                    if (nutri.getNome().equals(nomeNutricionista)) {
                        System.out.println("Esse nome ja existe, digite outro.");
                    } else {
                        nutricionista.setNome(nomeNutricionista);
                        nomeExisteNutri = false;
                    }
                }
            }
            if (!nomeExisteNutri) {
                break;
            } else {
                System.out.println("1 - Digitar novamente");
                System.out.println("2 - Voltar");
                int escolha = scan.nextInt();

                System.out.println("Digite novamente.");
                scan.nextLine();
                nomeNutricionista = scan.nextLine();

                if (escolha == 2) {
                    cli(scan);
                    break;
                }
            }
        }

        System.out.println("Digite a idade do nutricionista:");
        int idadeNutricionista = scan.nextInt();

        System.out.println("Digite o salario do nutricionista:");
        double salarioNutricionista = scan.nextDouble();

        System.out.println("Digite o endereço do nutricionista:");
        System.out.println("Logradouro: ");
        scan.nextLine();
        String logradouro = scan.nextLine();
        System.out.println("Estado: ");
        scan.nextLine();
        String estado = scan.nextLine();
        System.out.println("Cidade: ");
        scan.nextLine();
        String cidade = scan.nextLine();
        System.out.println("Numero: ");
        int numero = scan.nextInt();
        System.out.println("cep: ");
        String cep = scan.next();
        Endereco endereco = new Endereco(logradouro, estado, cidade, numero, cep);

        System.out.println("Quantos certificados você deseja adicionar?");
        int numCertificados = scan.nextInt();
        List<String> listaCertificacoes = new ArrayList<>();
        for (int i = 0; i < numCertificados; i++) {
            System.out.print("Digite o certificado " + (i + 1) + ":");
            String certificado = scan.next();
            listaCertificacoes.add(certificado);
        }

        System.out.println("Digite o numero de consultas nutricionista:");
        scan.nextLine();
        int numeroConsultas = scan.nextInt();

        System.out.println("Digite o tempo de experiência do nutricionista:");
        scan.nextLine();
        int tempoExperiencia = scan.nextInt();


        nutricionista.setIdade(idadeNutricionista);
        nutricionista.setSalario(salarioNutricionista);
        nutricionista.setEndereco(endereco);
        nutricionista.setCertificacoes(listaCertificacoes);
        nutricionista.setNumeroConsultas(numeroConsultas);
        nutricionista.setTempoExperiencia(tempoExperiencia);

        ListaNutricionistas.addNutricionista(nutricionista);
        ListaFuncionarios.addFuncionario(nutricionista);

        System.out.println("O nutricionista foi cadastrado com sucesso!");
        System.out.println("1 - Voltar");
        int voltar = scan.nextInt();
    }

    public static void telaListarFuncionarios() {
        System.out.println("Listagem de Funcionarios.");
        System.out.println();
        listarFuncionarios();
        listarNutricionista();
        System.out.println();
        System.out.println("1 - Voltar");
        int voltar = scan.nextInt();
    }

    public static void telaCriarConsulta() {
        Consultas consulta = new Consultas();
        System.out.println("Digite o nome do nutricionista:");
        scan.nextLine();
        String nomeNutricionista = scan.nextLine();
        boolean nomeExisteNutri = true;

        while (nomeExisteNutri) {

            for (Nutricionista nutricionista : getListaNutricionista()) {
                if (nutricionista.getNome().equals(nomeNutricionista)) {
                    nomeExisteNutri = false;
                    break;
                }
            }
            if (nomeExisteNutri == true) {
                System.out.println("Nutricionista não encontrado.");
                System.out.println("1 - Digitar novamente");
                System.out.println("2 - Voltar");
                int escolha = scan.nextInt();

                System.out.println("Digite novamente.");
                scan.nextLine();
                nomeNutricionista = scan.nextLine();

                if (escolha == 2) {
                    cli(scan);
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println("Digite o nome do paciente:");
        String nomePaciente = scan.nextLine();
        boolean nomeExistePaci = true;

        while (nomeExistePaci) {

            for (Paciente paciente : getListaPacientes()) {
                if (paciente.getNome().equals(nomePaciente)) {
                    nomeExistePaci = false;
                    break;
                }
            }
            if (nomeExistePaci == true) {
                System.out.println("Paciente não encontrado.");
                System.out.println("1 - Digitar novamente");
                System.out.println("2 - Voltar");
                int escolha = scan.nextInt();

                System.out.println("Digite novamente.");
                scan.nextLine();
                nomePaciente = scan.nextLine();

                if (escolha == 2) {
                    cli(scan);
                    break;
                }
            } else {
                break;
            }
        }

        System.out.println("Digite a data e a hora no formato 'dd/MM/yyyy HH:mm':");
        scan.nextLine();
        String dataHoraString = scan.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraString, formatter);


        consulta.setNomeNutricionista(nomeNutricionista);
        consulta.setNomePaciente(nomePaciente);
        consulta.setDataHora(dataHora);
        consulta.setConsultaRealizada(false);
        ListaConsultas.addConsulta(consulta);

        System.out.println("Consulta cadastrada com sucesso!");
        System.out.println("1 - Voltar");
        int voltar = scan.nextInt();
    }

    public static void telaListarConultas() {
        System.out.println("Listagem de consultas.");
        System.out.println();
        listarConsultas();
        System.out.println();
        System.out.println("1 - Voltar");
        int voltar = scan.nextInt();
    }

    public static void telaRealizarConsultas(Scanner scan) {
        System.out.println("Digite o id da consulta que deseja realizar");
        int id = scan.nextInt();
        Consultas consulta = ListaConsultas.buscarPorId(id);
        System.out.println("Marcar consulta como realizada?");
        System.out.println("1 - Confirmar");
        System.out.println("2 - Cancelar");
        int confirmar = scan.nextInt();
        if (confirmar == 1) {
            consulta.setConsultaRealizada(true);
        }
    }

    public static void sair() {
        System.out.println("sair");
    }
}
