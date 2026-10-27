package interfaz;

import java.util.Scanner;

import algoritmos.Busqueda;
import algoritmos.TargetAux;
import algoritmos.Ordenar;
import datos.AlmacenBugs;
import datos.GeneradorBugs;
import modelo.Bug;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class Menu {
    public static void main(String[] args) {
        AlmacenBugs almacenBugs;
        Scanner scan = new Scanner(System.in);
        char tamPersonalizado;
        int tamanio;
        System.out.println("========================================================");
        System.out.println("            SISTEMA DE ADMINISTRACION DE BUGS");
        System.out.println("========================================================");
        System.out.println();
        System.out.println("¿Desea personalizar el tamaño del almacen? (estandar 1024) (Y/N)");
        tamPersonalizado = scan.nextLine().charAt(0);
        if(tamPersonalizado == 'y' || tamPersonalizado == 'Y'){
            System.out.println("Ingrese el tamaño de almacen. ADVERTENCIA: debe ser potencia de dos");
            boolean esPotencia = false;
            do{
                while (!scan.hasNextInt()) {
                    System.out.println("Error: Ingrese un numero entero valido.");
                    scan.next();
                }
                tamanio = scan.nextInt();
                scan.nextLine();
                if (tamanio > 0 && (tamanio & (tamanio - 1)) == 0) {
                    esPotencia = true;
                } else {
                    System.out.println("Error: " + tamanio + " no es potencia de dos. Intente nuevamente:");
                }
            }while(!esPotencia);
            almacenBugs = new AlmacenBugs(tamanio);
            System.out.println("\t-Almacen personalizado creado exitosamente-");
            System.out.println("Ingrese el número de bugs con los que desea poblar inicialmente el almacen");
            int inicial;
            do{
                inicial = Read.intReader();
                if(inicial >= tamanio || inicial < 0)
                    System.out.println("Error: Ingrese una cantidad dentro del rango elegido");
            }while(inicial >= tamanio || inicial < 0);
            almacenBugs.poblarInicial(inicial);
        } else {
            almacenBugs = new AlmacenBugs();
            almacenBugs.poblarInicial(200);
        }
        System.out.println();
        System.out.println("Total de bugs activos en el sistema: ["+almacenBugs.getTotalBugs()+"]");
        System.out.println();
        System.out.println("                 M E N U  P R I N C I P A L");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("\t1. Ingresar bug");
        System.out.println("\t2. Eliminar bug");
        System.out.println("\t3. Buscar bugs");
        System.out.println("\t4. Listar bugs");
        System.out.println("\t5. Contar bugs");
        System.out.println("\t6. Salir");
        System.out.println("Seleccione la operación que desee realizar: ");
        int seleccion = Read.intReader();
        System.out.println();
        switch(seleccion) {
            case 1 -> {
                String titulo;
                int prioridad;
                int seguridad;
                String equipoEncargado;
                String categoria;
                String estado;
                String fecha;
                System.out.println("-----------------INGRESO DE UN NUEVO BUG-----------------");
                System.out.println("- Escriba el titulo del bug:");
                titulo = scan.nextLine();
                System.out.println("- Escriba la prioridad del bug:");
                System.out.println("\t1 -> Baja");
                System.out.println("\t2 -> Media");
                System.out.println("\t3 -> Alta");
                do{
                    prioridad = Read.intReader();
                    if(prioridad < 1 || prioridad > 3)
                        System.out.println("Error: Ingrese un valor dentro del rango admitido");
                }while(prioridad < 1 || prioridad > 3);
                System.out.println("- Escriba el nivel de seguridad del bug (1-5)");
                do{
                    seguridad = Read.intReader();
                    if(seguridad < 1 || seguridad > 5)
                        System.out.println("Error: Ingrese un nivel de seguridad dentro del rango");
                }while(seguridad < 1 || seguridad > 5);
                System.out.println("- Escriba el equipo encargado de su revision");
                equipoEncargado = scan.nextLine();
                System.out.println("- Escriba la categoria del bug");
                categoria = scan.nextLine();
                System.out.println("- Escriba el estado del bug:");
                estado = scan.nextLine();
                System.out.println("Ingresa la fecha de registro. Formato YYYY-MM-DD");
                fecha = Read.dateReader();
                almacenBugs.agregarBug(new Bug(titulo, prioridad, seguridad, equipoEncargado, categoria, estado, fecha));
                System.out.println("               BUG INGRESADO EXITOSAMENTE");
            }
        case 2 -> {
            System.out.println("------------------ELIMINACION DE UN BUG------------------");
        }
        }
    } 
}
