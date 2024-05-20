package entidades;

import java.util.ArrayList;
import java.util.List;

public class ListaPacientes {

    private static List<Paciente> listaPacientes = new ArrayList<>();

    public static List<Paciente> listarPacientes(){

        return listaPacientes;
    }

}
