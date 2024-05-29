public class Fila<E>{

    private class No<T>{
        
        private T info;
        private No<T> proximo;

        public No(T info){
            this.info = info;
        }

        public No<T> getProximo() {
            return proximo;
        }
        public void setProximo(No<T> proximo) {
            this.proximo = proximo;
        }
        public T getInfo() {
            return info;
        }
        public void setInfo(T info) {
            this.info = info;
        }

    }

    private No<E> primeiro;
    private No<E> ultimo;

    public Fila(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean estaVazio(){
        return primeiro == null;
    }

    public void enfileira(E info){
        No<E> novo = new No<E>(info);
        if (estaVazio()){
            primeiro = novo;
        }
        else{
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }

    public E desenfilera(){
        if (estaVazio()) return null;
        No<E> aux = primeiro;
        primeiro = aux.getProximo();
        return aux.getInfo();
    }

    @Override
    public String toString(){
        if (estaVazio()) return "Vazia";
        No<E> aux = primeiro;
        String s = "";
        while (aux != null) {
            s += aux.getInfo() + " ";
            aux = aux.getProximo();
        }
        return s;
    }

}
