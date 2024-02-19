import java.util.Scanner;

public class TesteLista {
    public static void main(String args[]){

        Lista inicioLista = null;
        Lista fimLista = null;

        // Teste Lista Simples Encadiada
        Lista lista = new Lista();

        int valor;
        int op;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1- Adicionar no fim\n" +
            "2- Adicionar no inicio\n" +
            "3- Consultar toda a lista\n" + 
            "4- Remover da lista\n" + 
            "5- Esvaziar a lista\n" + 
            "6- Sair");
            op = scanner.nextInt();

            switch(op){
                case 1: // Adiciona no final da lista
                    System.out.println("Digite o valor: ");
                    valor = scanner.nextInt();
                    if (inicioLista == null){ // Se a lista estiver vazia
                        lista.valor = valor;
                        inicioLista = lista;
                        fimLista = lista;
                    }
                    else{
                        Lista novaLista = new Lista();
                        novaLista.valor = valor;
                        fimLista.proximaLista = novaLista;
                        fimLista = novaLista; // A outra lista não é apagada pois fimLista é um ponteiro
                    }
                    break;
                case 2: // Adiciona no inicio da lista
                    System.out.println("Digite o valor: ");
                    valor = scanner.nextInt();
                    if (inicioLista == null){ // Se a lista estiver vazia
                        lista.valor = valor;
                        inicioLista = lista;
                        fimLista = lista;
                    }
                    else{
                        Lista novaLista = new Lista();
                        novaLista.valor = valor;
                        novaLista.proximaLista = inicioLista;
                        inicioLista = novaLista; // A outra lista não é apagada pois inicioLista é um ponteiro
                    }
                    break;
                case 3:
                    if (inicioLista != null){
                        inicioLista.printarTodos();
                    }
                    else{
                        System.out.println("Lista vazia");
                    }   
                    break;
                case 4:
                    if (inicioLista == null){
                        System.out.println("Lista vazia");
                        continue;
                    }
                    System.out.println("Digite o valor a ser removido da lista.");
                    valor = scanner.nextInt();
                    boolean comeco = true;
                    boolean manterAnt = false; // Usado para manter quando o proximo valor é removido
                    Lista aux, anterior;
                    
                    aux = inicioLista;
                    anterior = null;
                    
                    while (aux != null){
                        if (aux.valor == valor){
                            if (comeco){
                                if (aux.proximaLista != null){ // Se a lista tive mais de um elemento
                                    inicioLista = aux.proximaLista;
                                }
                                else{ // se a lista tiver só um elemento e que esse elemento é o valor pra ser removido
                                    inicioLista = null;
                                    break;
                                }
                            }
                            else{ // nao é o começo
                                anterior.proximaLista = aux.proximaLista;
                                manterAnt = true;
                            }
                        }
                        comeco = false;
                        if (manterAnt == false){
                            anterior = aux;
                        }
                        manterAnt = false;
                        aux = aux.proximaLista;
                        if (inicioLista == aux){
                            comeco = true;
                        }
                    }
                    inicioLista.printarTodos();
                    break;
                case 5:
                    inicioLista = null;
                    System.out.println("Lista esvaziada.");
                    break;
                case 6:
                    if (inicioLista != null){
                        inicioLista.printarTodos();
                    }
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }
}
