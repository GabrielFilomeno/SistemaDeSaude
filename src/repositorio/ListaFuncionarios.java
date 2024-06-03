package repositorio;

import entidades.Consultas;
import entidades.Endereco;
import entidades.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaFuncionarios {

    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    public ListaFuncionarios() {
    }

    public ListaFuncionarios(List<Consultas> listaConsultas) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public static void addFuncionario(Funcionario funcionario) {
        listaFuncionarios.add(funcionario);
    }

    public static String toString(Endereco endereco) {

        return "Logradouro: " + endereco.getLogradouro() +
                " / Estado: " + endereco.getEstado() +
                " / Cidade: " + endereco.getCidade() +
                " / Numero: " + endereco.getNumero() +
                " / CEP: " + endereco.getCep();
    }

    public static void listarFuncionarios() {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            System.out.println("ID do funcionario: " + i);
            System.out.println("Nome do funcionario: " + listaFuncionarios.get(i).getNome());
            System.out.println("Idade do funcionario: " + listaFuncionarios.get(i).getIdade());
            System.out.println("Salario do funcionario: " + listaFuncionarios.get(i).getSalario());
            System.out.println("Endereço do funcionario: " + toString(listaFuncionarios.get(i).getEndereco()));
            System.out.println("-------------------------------------------");
        }
    }

    public static Funcionario buscarPorId(int id) {
        if (id >= 0 && id < listaFuncionarios.size()) {
            return listaFuncionarios.get(id);
        } else {
            return null;
        }
    }

    public static void removerFuncionario(int id, Scanner scan) {
        buscarPorId(id);
        System.out.print("ID do funcionario: " + id + " - Nome do funcionario: " + listaFuncionarios.get(id).getNome());
        System.out.println("Você tem certeza que deseja remover esse funcionario?");
        System.out.println("1 - Confirmar");
        System.out.println("2 - Cancelar");
        int confirmar = scan.nextInt();
        if (confirmar == 1) {
            System.out.println("O funcionario com o ID: " + id + " - Nome do funcionario: " + listaFuncionarios.get(id).getNome());

            listaFuncionarios.remove(id);

            System.out.println("Foi removido.");
            System.out.println("1 - voltar");
            int voltar = scan.nextInt();
        }
    }

    public static void alterarDadosFuncionario(Scanner scan) {
        System.out.println("Digite o ID do funcionario que deseja alterar os dados:");
        int id = scan.nextInt();
        while (true) {
            if (id >= 0 && id < listaFuncionarios.size()) {
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
        Funcionario funcionario = buscarPorId(id);
        if (funcionario == null) {
            System.out.print("Você voltou para a tela inicial.");
            return;
        }
        System.out.println("Funcionario com o ID: " + id + "Foi selecionado");

        if (funcionario != null) {
            System.out.println("Digite o nome do funcionario:");
            scan.nextLine();
            String nomeFuncionario = scan.nextLine();
            funcionario.setNome(nomeFuncionario);

            System.out.println("Digite a idade do funcionario:");
            int idadeFuncionario = scan.nextInt();
            funcionario.setIdade(idadeFuncionario);

            System.out.println("Digite o salario do funcionario:");
            double salarioFuncionario = scan.nextDouble();
            funcionario.setSalario(salarioFuncionario);

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
            funcionario.setEndereco(endereco);

            System.out.println("Dados do funcionario alterados com sucesso!");
            System.out.println("1 - Voltar");
            int voltar = scan.nextInt();
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public static void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        ListaFuncionarios.listaFuncionarios = listaFuncionarios;
    }

}
