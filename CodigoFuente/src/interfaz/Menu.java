package interfaz;

import java.util.Scanner;

import algoritmos.Busqueda;
import algoritmos.TargetAux;
import algoritmos.Ordenar;
import datos.AlmacenBugs;
import datos.GeneradorBugs;
import modelo.Bug;

public class Menu {
    public static void main(String[] args) {
        AlmacenBugs almacenBugs;
        Scanner scan = new Scanner(System.in);
        char tamPersonalizado;
        int tamanio;
        int contador;
        System.out.println("====================================================");
        System.out.println("         SISTEMA DE ADMINISTRACION DE BUGS");
        System.out.println("====================================================");
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
            }while(esPotencia);
            almacenBugs = new AlmacenBugs(tamanio);
            System.out.println("Almacen personalizado creado exitosamente");
        } else 
            almacenBugs = new AlmacenBugs();
        System.out.println();
        System.out.println("Total de bugs activos en el sistema: ["+almacenBugs.getTotalBugs()+"]");
        System.out.println();
        System.out.println("              M E N U  P R I N C I P A L");
        System.out.println();
        System.out.println("Seleccione la operación que desee realizar: ");
        System.out.println("\t·Ingres");

    } 
}
