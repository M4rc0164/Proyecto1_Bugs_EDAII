package algoritmos;

import modelo.Bug;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Contar {

    public static void countAndShowcountByTitulo(List<Bug> lista, String titulo) {
        List<Bug> imprimir = new LinkedList<>();
        for (Bug i : lista) {
            if (Objects.equals(i.getTitulo(), titulo)) {
                imprimir.add(i);
            }
        }
        System.out.println("Se encontraron " + imprimir.size() + " elementos que coinciden");
        for (Bug i : imprimir) {
            System.out.println(i);
        }
    }

    public static int countByTitulo(List<Bug> lista, String titulo) {
        int aux = 0;
        for (Bug i : lista) {
            if (Objects.equals(i.getTitulo(), titulo)) {
                aux++;
            }
        }
        return aux;
    }

    public static void countAndShowcountByPrioridad(List<Bug> lista, int prioridad) {
        List<Bug> imprimir = new LinkedList<>();
        for (Bug i : lista) {
            if (i.getPrioridad() == prioridad) {
                imprimir.add(i);
            }
        }
        System.out.println("Se encontraron " + imprimir.size() + " elementos que coinciden");
        for (Bug i : imprimir) {
            System.out.println(i);
        }
    }

    public static int countByPrioridad(List<Bug> lista, int prioridad) {
        int aux = 0;
        for (Bug i : lista) {
            if (i.getPrioridad() == prioridad) {
                aux++;
            }
        }
        return aux;
    }

    public static void countAndShowcountByEquipoEncargado(List<Bug> lista, String equipo) {
        List<Bug> imprimir = new LinkedList<>();
        for (Bug i : lista) {
            if (Objects.equals(i.getEquipoEncargado(), equipo)) {
                imprimir.add(i);
            }
        }
        System.out.println("Se encontraron " + imprimir.size() + " elementos que coinciden");
        for (Bug i : imprimir) {
            System.out.println(i);
        }
    }

    public static int countByEquipoEncargado(List<Bug> lista, String equipo) {
        int aux = 0;
        for (Bug i : lista) {
            if (Objects.equals(i.getEquipoEncargado(), equipo)) {
                aux++;
            }
        }
        return aux;
    }

    public static void countAndShowcountByNivelSeguridad(List<Bug> lista, int seguridad) {
        List<Bug> imprimir = new LinkedList<>();
        for (Bug i : lista) {
            if (i.getNivelSeguridad() == seguridad) {
                imprimir.add(i);
            }
        }
        System.out.println("Se encontraron " + imprimir.size() + " elementos que coinciden");
        for (Bug i : imprimir) {
            System.out.println(i);
        }
    }

    public static int countByNivelSeguridad(List<Bug> lista, int seguridad) {
        int aux = 0;
        for (Bug i : lista) {
            if (i.getNivelSeguridad() == seguridad) {
                aux++;
            }
        }
        return aux;
    }

    public static void countAndShowcountByCategoria(List<Bug> lista, String categoria) {
        List<Bug> imprimir = new LinkedList<>();
        for (Bug i : lista) {
            if (Objects.equals(i.getCategoria(), categoria)) {
                imprimir.add(i);
            }
        }
        System.out.println("Se encontraron " + imprimir.size() + " elementos que coinciden");
        for (Bug i : imprimir) {
            System.out.println(i);
        }
    }

    public static int countByCategoria(List<Bug> lista, String categoria) {
        int aux = 0;
        for (Bug i : lista) {
            if (Objects.equals(i.getCategoria(), categoria)) {
                aux++;
            }
        }
        return aux;
    }

    public static void countAndShowcountByEstado(List<Bug> lista, String estado) {
        List<Bug> imprimir = new LinkedList<>();
        for (Bug i : lista) {
            if (Objects.equals(i.getEstado(), estado)) {
                imprimir.add(i);
            }
        }
        System.out.println("Se encontraron " + imprimir.size() + " elementos que coinciden");
        for (Bug i : imprimir) {
            System.out.println(i);
        }
    }

    public static int countByEstado(List<Bug> lista, String estado) {
        int aux = 0;
        for (Bug i : lista) {
            if (Objects.equals(i.getEstado(), estado)) {
                aux++;
            }
        }
        return aux;
    }

    public static void countAndShowcountByFecha(List<Bug> lista, String fecha) {
        List<Bug> imprimir = new LinkedList<>();
        for (Bug i : lista) {
            if (Objects.equals(i.getFechaReporte(), fecha)) {
                imprimir.add(i);
            }
        }
        System.out.println("Se encontraron " + imprimir.size() + " elementos que coinciden");
        for (Bug i : imprimir) {
            System.out.println(i);
        }
    }

    public static int countByFecha(List<Bug> lista, String fecha) {
        int aux = 0;
        for (Bug i : lista) {
            if (Objects.equals(i.getFechaReporte(), fecha)) {
                aux++;
            }
        }
        return aux;
    }
}