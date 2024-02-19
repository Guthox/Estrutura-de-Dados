import java.util.Scanner;

public class TesteFila {
    public static void main(String[] args) {
        
        int valor, op;
        Fila inicioFila = null;
        Fila aux;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1- Adicionar na fila\n" + 
            "2- Consultar fila\n" +
            "3- Remover da fila\n" +
            "4- Esvaziar Fila\n" +
            "5- Sair");

            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o número para adicionar: ");
                    valor = scanner.nextInt();
                    if (inicioFila == null){ // Se for o primeiro item da fila
                        aux = new Fila();
                        aux.valor = valor;
                        inicioFila = aux;
                        aux = null;
                        break;
                    }
                    // Se não for o primeiro
                    aux = inicioFila;
                    while (aux.proximo != null){ // Acha o ultimo da fila
                        aux = aux.proximo;
                    }
                    aux.proximo = new Fila(valor);
                    aux = null;
                    break;
                case 2:
                    if (inicioFila == null){
                        System.out.println("Fila vazia.");
                        break;
                    }
                    inicioFila.printarTodos();
                    break;
                case 3:
                    if (inicioFila == null){
                        break;
                    }
                    if (inicioFila.proximo != null){
                        inicioFila = inicioFila.proximo;
                    }
                    break;
                case 4:
                    inicioFila = null;
                    System.out.println("Fila esvaziada.");
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }
}
