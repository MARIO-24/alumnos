package ejemplo1;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerNum = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;

        do {
            menuPrincipal();
            System.out.print("Ingrese una opción: ");
            String input = scannerStr.nextLine();

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                continue;
            }
            try {
                switch (opcion) {
                    case 1:
                        agregarAlumnos();
                        break;
                    case 2:
                        listarAlumnos();
                        break;
                    case 3:
                        editarAlumnos();
                        break;
                    case 4:
                        eliminarAlumnos();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
        } while (!salir);
        System.out.println("Fin del programa.");
    }

    private static void menuPrincipal() {
        System.out.println("\nMenú de Opciones");
        System.out.println("================");
        System.out.println("1. Agregar alumno");
        System.out.println("2. Listar alumnos");
        System.out.println("3. Modificar alumno");
        System.out.println("4. Eliminar alumno");
        System.out.println("0. Salir");
        System.out.println();
        System.out.print("Ingrese una opción: ");
    }

    private static void agregarAlumnos() throws SQLException {
        System.out.print("Nombre: ");
        String nombre = scannerStr.nextLine();
        System.out.print("Apellido: ");
        String apellido = scannerStr.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scannerStr.nextLine();
        System.out.print("Correo: ");
        String correo = scannerStr.nextLine();
        System.out.print("Curso: ");
        String curso = scannerStr.nextLine();
        System.out.print("Genero: ");
        String genero = scannerStr.nextLine();

        Alumno alumno = new Alumno(nombre, apellido, telefono, correo, curso, genero);
        GestorAlumnos gestor = new GestorAlumnos();
        gestor.alta(alumno);
        System.out.println("Alumno agregado exitosamente.");

        presioneEnterParaContinuar();
    }

    private static void listarAlumnos() throws SQLException {
        GestorAlumnos gestor = new GestorAlumnos();
        List<Alumno> alumnos = gestor.listar();

        System.out.printf("\n%-4s %-20s %-20s %-15s %-35s %-35s %-35s\n",
                "ID", "Nombre", "Apellido", "Teléfono", "Correo", "Curso", "Género");
        System.out.println("----------------------------------------------------------------------------------------");

        for (Alumno alumno : alumnos) {
            System.out.printf("%-4d %-20s %-20s %-15s %-35s %-35s %-35s\n",
            		alumno.getId(),
            		alumno.getNombre(),
            		alumno.getApellido(),
            		alumno.getTelefono(),
            		alumno.getCorreo(),
            		alumno.getCurso(),
            		alumno.getGenero());
        }

        presioneEnterParaContinuar();
    }

    private static void editarAlumnos() throws SQLException {
        GestorAlumnos gestor = new GestorAlumnos();

        System.out.print("Ingrese el ID del alumno a modificar: ");
        String input = scannerStr.nextLine();
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            presioneEnterParaContinuar();
            return;
        }

        Alumno alumno = gestor.buscarPorId(id);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            presioneEnterParaContinuar();
            return;
        }

        System.out.print("Nuevo Nombre (" + alumno.getNombre() + "): ");
        String nuevoNombre = scannerStr.nextLine();
        System.out.print("Nuevo Apellido (" + alumno.getApellido() + "): ");
        String nuevoApellido = scannerStr.nextLine();
        System.out.print("Nuevo Teléfono (" + alumno.getTelefono() + "): ");
        String nuevoTelefono = scannerStr.nextLine();
        System.out.print("Nuevo Correo (" + alumno.getCorreo() + "): ");
        String nuevoCorreo = scannerStr.nextLine();
        System.out.print("Nuevo Curso (" + alumno.getCurso() + "): ");
        String nuevoCurso = scannerStr.nextLine();
        System.out.print("Nuevo Curso (" + alumno.getGenero() + "): ");
        String nuevoGenero = scannerStr.nextLine();

        boolean actualizado = gestor.modificarAlumno(id,
                nuevoNombre.isEmpty() ? alumno.getNombre() : nuevoNombre,
                nuevoApellido.isEmpty() ? alumno.getApellido() : nuevoApellido,
                nuevoTelefono.isEmpty() ? alumno.getTelefono() : nuevoTelefono,
                nuevoCorreo.isEmpty() ? alumno.getCorreo() : nuevoCorreo,
                nuevoCurso.isEmpty() ? alumno.getCurso() : nuevoCurso,
       			nuevoCurso.isEmpty() ? alumno.getGenero() : nuevoGenero);

        if (actualizado) {
            System.out.println("Alumno actualizado exitosamente.");
        } else {
            System.out.println("No se pudo actualizar el alumno.");
        }

        presioneEnterParaContinuar();
    }

    private static void eliminarAlumnos() throws SQLException {
    	GestorAlumnos gestor = new GestorAlumnos();

        System.out.print("Ingrese el ID del alumno a eliminar: ");
        String input = scannerStr.nextLine();
        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            presioneEnterParaContinuar();
            return;
        }

        boolean eliminado = gestor.eliminarAlumno(id);
        if (eliminado) {
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un alumno con ese ID.");
        }

        presioneEnterParaContinuar();
    }

    private static void presioneEnterParaContinuar() {
        System.out.println("\nPresione Enter para continuar...");
        scannerStr.nextLine();
    }
}