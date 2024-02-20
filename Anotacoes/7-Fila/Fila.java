// Exemplo de fila

public class Fila {
    
    public int valor;
    public Fila proximo;

    public Fila(){
        proximo = null;
    }

    public Fila(int valor){
        this.valor = valor;
        proximo = null;
    }

    public void printarTodos(){
        System.out.println("Valor: " + this.valor);
        System.out.println("Proximo: " + this.proximo);
        if (this.proximo != null){
            this.proximo.printarTodos();
        }
    }

}
