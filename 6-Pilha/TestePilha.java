import java.util.Scanner;

public class TestePilha {
    public static void main(String[] args) {
        
        int op, valor;
        Scanner scanner = new Scanner(System.in);
        Pilha topo = null;
        Pilha aux = null;

        while (true){
            System.out.println("1- Inserir na pilha\n" +
            "2- Consultar Pilha\n" + 
            "3- Remover da pilha\n" + 
            "4- Esvaziar pilha\n" + 
            "5- Sair");

            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o valor para ser adicionado na pilha: ");
                    valor = scanner.nextInt();
                    if (topo == null){ // se for o primeiro elemento.
                        topo = new Pilha();
                        topo.valor = valor;
                        break;
                    }
                    // Se não for o primeiro
                    aux = new Pilha();
                    aux.valor = valor;
                    aux.proximo = topo;
                    topo = aux;
                    aux = null;
                    break;
                case 2:
                    if (topo == null){
                        System.out.println("Pilha vazia.");
                        break;
                    }
                    topo.printarTodos();
                    break;
                case 3:
                    if (topo == null){
                        System.out.println("Pilha vazia.");
                        break;
                    }
                    topo = topo.proximo;
                    break;
                case 4:
                    topo = null;
                    System.out.println("Pilha esvaziada.");
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        }

    }
}