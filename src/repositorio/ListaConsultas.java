package repositorio;

import entidades.Consultas;
import entidades.Paciente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaConsultas {

    private static List<Consultas> listaConsultas = new ArrayList<>();

    public ListaConsultas() {
    }

    public ListaConsultas(List<Consultas> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    public static void addConsulta(Consultas consulta) {
        listaConsultas.add(consulta);
    }

    public static void listarConsultas() {
        for (int i = 0; i < listaConsultas.size(); i++) {
            System.out.println("ID da consulta: " + i);
            System.out.println("Nome do nutricionista: " + listaConsultas.get(i).getNomeNutricionista());
            System.out.println("Nome do paciente: " + listaConsultas.get(i).getNomePaciente());
            System.out.println("Data e Hora da consulta: " + listaConsultas.get(i).getDataHora());
            System.out.print("Consulta ja foi realizada? ");
            if (listaConsultas.get(i).getConsultaRealizada()){
                System.out.print("Sim");
            } else {
                System.out.print("Não");
            }
        }
    }

    public static Consultas buscarPorId(int id) {
        if (id >= 0 && id < listaConsultas.size()) {
            return listaConsultas.get(id);
        } else {
            return null;
        }
    }

    public static void removerConsulta(int id, Scanner scan) {
        buscarPorId(id);
        System.out.print("ID da consulta: " + id);
        System.out.println("Você tem certeza que deseja remover essa consulta?");
        System.out.println("1 - Confirmar");
        System.out.println("2 - Cancelar");
        int confirmar = scan.nextInt();
        if (confirmar == 1) {
            listaConsultas.remove(id);

            System.out.println("A consulta com o ID: " + id);
            System.out.println("Foi removida.");
            System.out.println("1 - voltar");
            int voltar = scan.nextInt();
        }
    }

    public static void alterarDadosConsulta(Scanner scan) {
        System.out.println("Digite o ID da consulta que deseja alterar os dados:");
        int id = scan.nextInt();
        while (true) {
            if (id >= 0 && id < listaConsultas.size()) {
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
        Consultas consulta = buscarPorId(id);
        if (consulta == null) {
            System.out.print("Você voltou para a tela inicial.");
            return;
        }
        System.out.println("Consulta com o ID: " + id + "Foi selecionada");

        if (consulta != null) {
            System.out.println("Digite o nome do nutricionista:");
            scan.nextLine();
            String nomeNutricionista = scan.nextLine();
            consulta.setNomeNutricionista(nomeNutricionista);

            System.out.println("Digite o nome do paciente:");
            scan.nextLine();
            String nomePaciente = scan.nextLine();
            consulta.setNomePaciente(nomePaciente);

            System.out.println("Digite a data e a hora no formato 'dd/MM/yyyy HH:mm':");
            scan.nextLine();
            String dataHoraString = scan.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraString, formatter);

            System.out.println("A consulta ja foi realizada?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int consultaRealizada = scan.nextInt();
            if (consultaRealizada == 1) {
                consulta.setConsultaRealizada(true);
            } else if (consultaRealizada == 2) {
                consulta.setConsultaRealizada(false);
            }

            System.out.println("Dados da consulta alterados com sucesso!");
            System.out.println("1 - Voltar");
            int voltar = scan.nextInt();
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static List<Consultas> getListaConsultas() {
        return listaConsultas;
    }

    public static void setListaConsultas(List<Consultas> listaConsultas) {
        ListaConsultas.listaConsultas = listaConsultas;
    }
}
