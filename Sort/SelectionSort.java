public class SelectionSort {
    
    public static void selectionSort(int[] lista){
        int menor = 0;
        for (int i = 0; i < lista.length; i++){
            menor = i;
            for (int j = i; j < lista.length; j++){
                if (lista[j] < lista[menor]){
                    menor = j;
                }
            }
            swap(lista, i, menor);
        }
    }

    private static void swap(int[] lista, int x, int y){
        int aux = lista[x];
        lista[x] = lista[y];
        lista[y] = aux;
    }

}
