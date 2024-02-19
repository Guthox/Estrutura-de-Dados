public class QuickSort {
    
    public static void quickSort(int lista[]){
        quickSort(lista, 0, lista.length-1);
    }

    private static void quickSort(int lista[], int left, int right){
        if (left < right){
            int index = partition(lista, left, right);
            quickSort(lista, left, index - 1);
            quickSort(lista, index + 1, right);
        }
    }

    private static int partition(int[] lista, int left, int right){
        int pivot = lista[left];
        int index = left;

        for (int i = left + 1; i <= right; i++){
            if (lista[i] <= pivot){
                index++;
                swap(lista, index, i);
            }
        }
        swap(lista, left, index);
        return index;
    }

    private static void swap(int[] lista, int x, int y){
        int aux = lista[x];
        lista[x] = lista[y];
        lista[y] = aux;
    }

}
