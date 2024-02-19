public class BubbleSort {

    public static void bubbleSort(int[] lista){
        boolean finalizado = true;
        for (int i = 0; i < lista.length - 1; i++){
            finalizado = true;
            for (int j = 0; j < lista.length - 1 - i; j++){
                if (lista[j] > lista[j+1]){
                    swap(lista, j, j+1);
                    finalizado = false;
                }
            }
            if (finalizado){
                break;
            }
        }
    }

    private static void swap(int[] lista, int x, int y){
        int aux = lista[x];
        lista[x] = lista[y];
        lista[y] = aux;
    }

}
