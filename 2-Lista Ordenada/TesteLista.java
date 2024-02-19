import java.util.Scanner;

public class TesteLista {
    public static void main(String[] args){

        Lista lista = new Lista();

        int op, valor;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1- Adicionar valor\n" +
            "2- Consultar toda a lista\n" + 
            "3- Remover da lista\n" + 
            "4- Esvaziar a lista\n" + 
            "5- Sair");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o valor para ser adicionado: ");
                    valor = scanner.nextInt();
                    lista.adicionarFim(valor);
                    break;
                case 2:
                    lista.printarValores();
                    break;
                case 3:
                    System.out.println("Digite o valor para ser removido: ");
                    valor = scanner.nextInt();
                    lista.removerValor(valor);
                    break;
                case 4:
                    lista.esvaziarLista();
                    System.out.println("Lista esvaziada");
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
