import java.util.Arrays;
import java.util.Random;

public class ArrayFactory {

    public static int[] gerarLista(int size){
        final int SIZE = size;
        final int UPPER_LIMIT = 100 + 1;

        Random randomizer = new Random();
        int[] lista = new int[SIZE];
        for (int i = 0; i < SIZE; i++){
            lista[i] = randomizer.nextInt(UPPER_LIMIT);
        }
        return lista;
    }

    public static void printarLista(int[] lista){
        for (int item : lista){
            System.out.print(item + " ");
        }
        System.out.print("\n");
    }

    private static boolean verificarSort(int[] lista, boolean reverso){
        int[] listaCopy = lista.clone();
        if (reverso == true){
            listaCopy = reverseSort(listaCopy);
        }
        else{
            Arrays.sort(listaCopy);
        }
        if (Arrays.equals(lista, listaCopy)){
            System.out.println("Ordenado");
            return true;
        }
        else{
            System.out.println("Não ordenado");
            return false;
        }
    }

    private static int[] reverseSort(int[] lista){
        int[] listaCopy = lista.clone();
        Arrays.sort(listaCopy);
        for (int i = 0; i < listaCopy.length / 2; i++){
            int aux = listaCopy[listaCopy.length - 1 - i];
            listaCopy[listaCopy.length - 1 - i] = listaCopy[i];
            listaCopy[i] = aux;
        }
        return listaCopy;
    }

    public static void verificarSortReverso(int[] lista){
        verificarSort(lista, true);
    }

    public static void verificarSort(int[] lista){
        verificarSort(lista, false);
    }

}
