public class TestSort {
    public static void main(String[] args) {
        
        int[] numeros = ArrayFactory.gerarLista(100000);
        // ArrayFactory.printarLista(numeros);

        long start = System.nanoTime();

        // BubbleSort.bubbleSort(numeros);
        // SelectionSort.selectionSort(numeros);
        // QuickSort.quickSort(numeros);

        long end = System.nanoTime();
        long duration = (end - start) / 1000000;

        System.out.println(duration + " ms");
        
        // ArrayFactory.printarLista(numeros);
        ArrayFactory.verificarSort(numeros);
    }
}
