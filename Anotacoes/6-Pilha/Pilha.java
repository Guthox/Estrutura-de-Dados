// Exemplo de pilha

public class Pilha{

    public int valor;
    public Pilha proximo;

    public Pilha(){
        this.proximo = null;
    }

    public void printarTodos(){
        System.out.println("Valor: " + this.valor);
        System.out.println("Proximo: " + this.proximo);
        if (this.proximo != null){
            this.proximo.printarTodos();
        }
    }

}