package algoritmos;

import modelo.Bug;
import datos.GeneradorBugs;

import java.util.ArrayList;
import java.util.List;

public class Ordenar {

     // MÉTODOS COUNTING SORT MÉTODOS COUNTING SORT MÉTODOS COUNTING SORT 
    public static void showByPrioridad(List<Bug>list){// tipo 1 por prioridad
        countingSort(list, GeneradorBugs.prioridadMaxima, 1);
    }

    public static void showByNivelDeSeguridad(List<Bug>list){// tipo 2 por prioridad
        countingSort(list, GeneradorBugs.nivelSeguridadMax, 2);
    } 

    // funcionaría bien se se añadieran atributos extras a la clase Bug que fueran de tipo int 
    private static void countingSort(List<Bug>list, int max, int tipo){
        if (list == null || list.isEmpty()) return;
        int[] cuenta= new int[max+1];
        for(int i=0;i<list.size();i++){
            cuenta[selector(list.get(i),tipo)]++;
        }
        for (int i = 1; i <= max; i++) {
            cuenta[i] += cuenta[i - 1];
        }
        Bug[] ordenado= new Bug[list.size()];
        for(int i=list.size()-1;i>-1;i--){
            int key = selector(list.get(i), tipo);
            ordenado[cuenta[key]-1]=list.get(i);
            cuenta[key]--;
        }
        for(Bug i : ordenado){
            System.out.println(i);
        }
    }
    private static int selector(Bug bug, int tipo){
        if(tipo==1) return porPrioridad(bug);// tipo 1 por prioridad
        if(tipo==2) return porNivelSeguridad(bug); // tipo 2 por seguridad
        return -1;
        
    }
    private static int porPrioridad(Bug bug){
        return bug.getPrioridad();
    }

    private static int porNivelSeguridad(Bug bug){
        return bug.getNivelSeguridad();
    }

    

   
    

    





    // Métodos QuickSort Métodos QuickSort Métodos QuickSort Métodos QuickSort
    public static void showByTitulo(List<Bug>list){
        prequickSort(list, 1);
        
    }
    public static void orderByTitulo(List<Bug>list){ // si ordenada la lista
        if (list == null || list.isEmpty()) return;
        quickSort(list, 0, list.size() - 1, 1);
    }
    public static void showByEquipoEncargado(List<Bug>list){
        prequickSort(list, 2);
    }

    public static void showByCategoria(List<Bug>list){
        prequickSort(list, 3);
    }

    private static void prequickSort(List<Bug>list, int tipo){
        if (list == null || list.isEmpty()) return;
        List<Bug> copia= new ArrayList<>(list);
        quickSort(copia, 0, copia.size() - 1, tipo);
        
        for(Bug i: copia){
            System.out.println(i);
        }
    }
    private static void quickSort(List<Bug>list,int inicio, int fin, int tipo){
        if(inicio<fin){
            int index = partition(list, inicio, fin, tipo);
            quickSort(list, inicio, index - 1, tipo);
            quickSort(list, index + 1, fin, tipo);
        }

    }

    private static int partition(List<Bug>list,int inicio, int fin,int tipo){
        String pivot = selectorQuick(list.get(fin), tipo);
        int i= inicio-1;
        for(int j=inicio;j<=fin-1;j++){
            int aux= selectorQuick(list.get(j), tipo).compareTo(pivot);
            if(aux<=0){
                i=i+1;
                Bug helper= list.get(i);
                list.set(i, list.get(j));
                list.set(j,helper);
            }
        }
        Bug helper= list.get(fin);
        list.set(fin, list.get(i+1));
        list.set(i+1,helper);
        return i+1;
    }
    private static String selectorQuick(Bug bug, int tipo){
        if(tipo==1) return porTitulo(bug);// tipo 1 por título
        if(tipo==2) return porEquipoEncargado(bug); // tipo 2 por Equipo encargado
        if(tipo==3) return porCategoria(bug); // Tipo 3 por Categoria
        return "~"; // algo simplemente para retornar algo diferente a void
    }
    private static String porTitulo(Bug bug){
        return bug.getTitulo();
    }
    private static String porEquipoEncargado(Bug bug){
        return bug.getEquipoEncargado();
    }
    private static String porCategoria(Bug bug){
        return bug.getCategoria();
    }



    

    

    





// Métodos Merge Sort Métodos Merge Sort Métodos Merge Sort Métodos Merge Sort Métodos Merge Sort
    
    public static void showByFechaReporte(List<Bug>list){
        preMergeSort(list, 1);
    }
    public static void showByID(List<Bug>list){
        preMergeSort(list, 2);
    }
    
    private static void preMergeSort(List<Bug>list, int tipo){
        if (list == null || list.isEmpty()) return;
        List<Bug> copia = new ArrayList<>(list);
        mergeSort(copia, 0, copia.size()-1,tipo);
        for(Bug i : copia){
            System.out.println(i);
        }
    }
    private static void mergeSort(List<Bug> arr, int left, int right, int tipo) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid,tipo);
            mergeSort(arr, mid + 1, right,tipo);

            merge(arr, left, mid, right,tipo);
        }
    }
    
    private static void merge(List<Bug> arr, int left, int mid, int right, int tipo) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Bug L[] = new Bug[n1];
        Bug R[] = new Bug[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(left+i);
        
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(mid + 1 + j);

        int i = 0, j = 0;
    
        int k = left;
        while (i < n1 && j < n2) {
            String aux1= selectorMerge(L[i], tipo);
            String aux2= selectorMerge(R[j], tipo);
            int com = aux1.compareTo(aux2);
            if (com <= 0) {
                arr.set(k,L[i]);
                i++;
            } else {
                arr.set(k,R[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            arr.set(k,R[j]);
            j++;
            k++;
        }
        
    }
    private static String selectorMerge(Bug bug, int tipo){
        if(tipo==1) return porFechaDeReporte(bug);// tipo 1 por fecha de reporte
        if(tipo==2) return porID(bug); // tipo 2 por ID
        return "~"; // algo simplemente para retornar algo diferente a void, aunque nunca debería pasar
        
    }
    private static String porFechaDeReporte(Bug bug){ // tipo 1
        return bug.getFechaReporte();
    }
    private static String porID(Bug bug){ // tipo 2
        return bug.getId();
    }
}
