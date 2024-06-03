package repositorio;

import entidades.Consultas;
import entidades.Endereco;
import entidades.Funcionario;
import entidades.Nutricionista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaNutricionistas {

    private static List<Nutricionista> listaNutricionista = new ArrayList<>();

    public ListaNutricionistas(){

    }

    public ListaNutricionistas(List<Consultas> listaConsultas) {
        this.listaNutricionista = listaNutricionista;
    }

    public static void addNutricionista(Nutricionista nutricionista) {
        listaNutricionista.add(nutricionista);
    }


    public static String toString(Endereco endereco) {

        return "Logradouro: " + endereco.getLogradouro() +
                " / Estado: " + endereco.getEstado() +
                " / Cidade: " + endereco.getCidade() +
                " / Numero: " + endereco.getNumero() +
                " / CEP: " + endereco.getCep();
    }

    public static void listarNutricionista() {
        for (int i = 0; i < listaNutricionista.size(); i++) {
            System.out.println("ID do nutricionista: " + i);
            System.out.println("Nome do nutricionista: " + listaNutricionista.get(i).getNome());
            System.out.println("Idade do nutricionista: " + listaNutricionista.get(i).getIdade());
            System.out.println("Salario do nutricionista: " + listaNutricionista.get(i).getSalario());
            System.out.println("Endereço do nutricionista: " + toString(listaNutricionista.get(i).getEndereco()));
            System.out.println("Certificações do nutricionista: " + listaNutricionista.get(i).getCertificacoes());
            System.out.println("Numero de consultas do nutricionista: " + listaNutricionista.get(i).getNumeroConsultas());
            System.out.println("Tempo de experiência do nutricionista: " + listaNutricionista.get(i).getTempoExperiencia());
            System.out.println("-------------------------------------------");
        }
    }

    public static Nutricionista buscarPorId(int id) {
        if (id >= 0 && id < listaNutricionista.size()) {
            return listaNutricionista.get(id);
        } else {
            return null;
        }
    }

    public static void removerNutricionista(int id, Scanner scan) {
        buscarPorId(id);
        System.out.print("ID do nutricionista: " + id + " - Nome do nutricionista: " + listaNutricionista.get(id).getNome());
        System.out.println("Você tem certeza que deseja remover esse nutricionista?");
        System.out.println("1 - Confirmar");
        System.out.println("2 - Cancelar");
        int confirmar = scan.nextInt();
        if (confirmar == 1) {
            System.out.println("O nutricionista com o ID: " + id + " - Nome do nutricionista: " + listaNutricionista.get(id).getNome());

            listaNutricionista.remove(id);

            System.out.println("Foi removido.");
            System.out.println("1 - voltar");
            int voltar = scan.nextInt();
        }
    }

    public static void alterarDadosNutricionista(Scanner scan) {
        System.out.println("Digite o ID do nutricionista que deseja alterar os dados:");
        int id = scan.nextInt();
        while (true) {
            if (id >= 0 && id < listaNutricionista.size()) {
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
        Nutricionista nutricionista = buscarPorId(id);
        if (nutricionista == null) {
            System.out.print("Você voltou para a tela inicial.");
            return;
        }
        System.out.println("Nutricionista com o ID: " + id + "Foi selecionado");

        if (nutricionista != null) {
            System.out.println("Digite o nome do nutricionista:");
            scan.nextLine();
            String nomeNutricionista = scan.nextLine();
            nutricionista.setNome(nomeNutricionista);

            System.out.println("Digite a idade do nutricionista:");
            int idadeNutricionista = scan.nextInt();
            nutricionista.setIdade(idadeNutricionista);

            System.out.println("Digite o salario do nutricionista:");
            double salarioNutricionista = scan.nextDouble();
            nutricionista.setSalario(salarioNutricionista);

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
            nutricionista.setEndereco(endereco);

            System.out.println("Digite o novo certificado: ");
            String novoCertificado = scan.next();
            List<String> novaListaCertificacoes = nutricionista.getCertificacoes();
            novaListaCertificacoes.add(novoCertificado);
            nutricionista.setCertificacoes(novaListaCertificacoes);

            System.out.println("Digite o numero de consultas nutricionista:");
            scan.nextLine();
            int numeroConsultas = scan.nextInt();
            nutricionista.setNumeroConsultas(numeroConsultas);

            System.out.println("Digite o tempo de experiência do nutricionista:");
            scan.nextLine();
            int tempoExperiencia = scan.nextInt();
            nutricionista.setTempoExperiencia(tempoExperiencia);

            System.out.println("Dados do nutricionista alterados com sucesso!");
            System.out.println("1 - Voltar");
            int voltar = scan.nextInt();
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static List<Nutricionista> getListaNutricionista() {
        return listaNutricionista;
    }

    public static void setListaNutricionista(List<Nutricionista> listaNutricionista) {
        ListaNutricionistas.listaNutricionista = listaNutricionista;
    }

}
