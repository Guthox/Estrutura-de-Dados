import java.util.Scanner;

public class TesteLista {
    public static void main(String[] args){

        Lista inicioLista = null;
        Lista fimLista = null;
        Lista lista;
        int valor;

        while (true)
        {
            System.out.println("1- Adicionar no fim\n" +
            "2- Adicionar no inicio\n" +
            "3- Consultar toda a lista\n" + 
            "4- Remover da lista\n" + 
            "5- Esvaziar a lista\n" + 
            "6- Sair");
            
            Scanner scanner = new Scanner(System.in);
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o valor a ser adicionado: ");
                    valor = scanner.nextInt();
                    lista = new Lista();
                    lista.valor = valor;
                    if (inicioLista == null && fimLista == null){ // Se a lista estiver vazia
                        inicioLista = lista;
                        fimLista = lista;
                    }
                    else{ // Se tiver elementos na lista
                        lista.anteriorLista = fimLista; 
                        fimLista.proximaLista = lista;
                        fimLista = lista;
                    }
                    break;
                case 2:
                    System.out.println("Digite o valor a ser adicionado: ");
                    valor = scanner.nextInt();
                    lista = new Lista();
                    lista.valor = valor;
                    if (inicioLista == null && fimLista == null){ // Se a lista estiver vazia
                        inicioLista = lista; 
                        fimLista = lista;
                    }
                    else{ // Se tiver elementos na lista
                        inicioLista.anteriorLista = lista;
                        lista.proximaLista = inicioLista;
                        inicioLista = lista;
                    }
                    break;
                case 3:
                    if (inicioLista == null){
                        System.out.println("Lista vazia.");
                    }
                    else{
                        inicioLista.printarTodos();
                    }
                    break;
                case 4:
                    if (inicioLista == null){
                        System.out.println("Lista vazia.");
                        break;
                    }
                    System.out.println("Digite o valor a ser removido: ");
                    valor = scanner.nextInt();
                    
                    Lista aux = inicioLista;
                    while (true) {
                        if (aux.valor == valor){ // Se for o valor
                            if (aux.anteriorLista == null){ // Se for o primeiro elemento
                                if (aux.proximaLista == null){ // Se for o primeiro e ultimo elemento
                                    inicioLista = null;
                                    fimLista = null;
                                    aux = null;
                                    break;
                                }
                                else{ // Se não for o ultimo mas é o primeiro
                                    inicioLista = aux.proximaLista;
                                    aux.proximaLista.anteriorLista = null;
                                }
                            }
                            else{ // Se não for o primeiro elemento
                                if (aux.proximaLista == null){ // se for o ultimo
                                    aux.anteriorLista.proximaLista = null;
                                    break;
                                }
                                // Se nao for o ultimo
                                aux.proximaLista.anteriorLista = aux.anteriorLista;
                                aux.anteriorLista.proximaLista = aux.proximaLista;
                            }
                        } 
                        if (aux.proximaLista == null){
                            break;
                        }
                        aux = aux.proximaLista;
                    }
                    break;
                case 5:
                    inicioLista = null;
                    fimLista = null;
                    System.out.println("Lista esvaziada.");
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }    
}
