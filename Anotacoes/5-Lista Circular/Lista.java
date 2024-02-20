// Lista duplamente encadeada circular

public class Lista {
    
    public Lista anteriorLista;
    public int valor;
    public Lista proximaLista;

    public Lista(){
        this.anteriorLista = null;
        this.proximaLista = null;
    }

    public void printarValores(){
        System.out.println("Lista anterior: " + this.anteriorLista);
        System.out.println("Valor: " + this.valor);
        System.out.println("Proxima lista: " + this.proximaLista);
    }

    public void printarTodos(Lista inicioLista){
        printarValores();
        System.out.println("**********");
        if (this.proximaLista != inicioLista && this.proximaLista != null){
            this.proximaLista.printarTodos(inicioLista);
        }
    }

}
