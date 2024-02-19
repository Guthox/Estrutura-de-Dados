// Lista simples ordenada utilizando array
// Igual a lista simples só o algoritimo de ordenação é rodado a cada modificação.

import java.util.Arrays;

public class Lista {
    
    private int[] valores;
    private int[] aux;
    private int indice = 0;

    public Lista(){
        valores = new int[1];
    }

    public void adicionarFim(int valor){
        resize();
        valores[indice] = valor;
        indice++;
        sortLista();
    }

    public void adicionarInicio(int valor){
        resize();
        aux = valores.clone();
        for (int i = 0; i < valores.length - 1; i++){
            valores[i+1] = aux[i];
        }
        aux = null;
        valores[0] = valor;
        indice++;
        sortLista();
    }

    private void resize(){
        if (valores.length == indice){
            aux = valores.clone();
            valores = new int[valores.length * 2];
            for (int i = 0; i < aux.length; i++){
                valores[i] = aux[i];
            }
            aux = null;
            return;
        }
        if (valores.length / 2 > indice){
            aux = valores.clone();
            valores = new int[valores.length / 2];
            for (int i = 0; i < valores.length; i++){
                valores[i] = aux[i];
            }
            aux = null;
            resize();
        }
    }

    public void printarDescricao(){
        System.out.println("Tamanho: " + this.valores.length);
        System.out.println("Indice: " + this.indice);
    }

    public void printarValores(){
        if (this.indice == 0){
            System.out.println("Lista vazia.");
            printarDescricao();
            return;
        }
        
        for (int i = 0; i < indice; i++){
            System.out.print(valores[i] + " ");
        }
        System.out.println();
        printarDescricao();
    }

    public void esvaziarLista(){
        valores = new int[1];
        indice = 0;
        aux = null;
    }

    public void removerValor(int valor){
        aux = new int[valores.length];
        int novoIndice = 0;
        int indiceAntigo = indice;
        for (int i = 0; i < indiceAntigo; i++){
            if (valores[i] != valor){
                aux[novoIndice] = valores[i];
                novoIndice++;
            }
            else{
                indice--;
            }
        }
        valores = aux.clone();
        aux = null;
        indice--;
        resize();
        indice++;
        sortLista();
    }

    public void sortLista(){
        // Bubble Sort
        for (int i = 0; i < indice; i++){
            boolean finalizado = true;
            for (int j = 0; j < indice - 1 - i; j++){
                if (valores[j] > valores[j+1]){
                    int auxiliar = valores[j];
                    valores[j] = valores[j+1];
                    valores[j+1] = auxiliar;
                    finalizado = false;
                }
            }
            if (finalizado){
                break;
            }
        }
    }
}
