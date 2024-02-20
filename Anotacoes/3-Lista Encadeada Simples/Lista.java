// Exemplo de lista dinámica simplesmente encadiada.
// Não ordenada

public class Lista {
    
    public int valor;
    public Lista proximaLista;

    public Lista(){
        this.proximaLista = null;
    }

    public void printarValores(){
        System.out.println("Valor: " + this.valor);
        System.out.println("Proxima Lista: " + this.proximaLista);
    }

    public void printarTodos(){
        printarValores();
        System.out.println("**********");
        if (this.proximaLista != null){
            proximaLista.printarTodos();
        }
    }

}
