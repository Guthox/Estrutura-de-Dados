import java.util.NoSuchElementException;

public class ListaDupla<Tipo>{
    
    public class No<Tipo2>{

        private Tipo2 info;
        private No<Tipo2> proximo;
        private No<Tipo2> anterior;
        
        public No (Tipo2 info){
            setAnterior(null);
            setProximo(null);
            setInfo(info);
        }

        public void setInfo(Tipo2 info){
            this.info = info;
        }
        public void setAnterior(No<Tipo2> anterior){
            this.anterior = anterior;
        }
        public void setProximo(No<Tipo2> proximo){
            this.proximo = proximo;
        }
        
        public Tipo2 getInfo(){
            return info;
        }
        public No<Tipo2> getAnterior(){
            return anterior;
        }
        public No<Tipo2> getProximo(){
            return proximo;
        }
        
    }

    private No<Tipo> primeiro;
    private No<Tipo> ultimo;
    private int tamanho = 0;

    public ListaDupla (){
        primeiro = null;
        ultimo = null;
    }

    public boolean add(Tipo info){
        No<Tipo> novo = new No<Tipo>(info);
        if (size() == 0){
            primeiro = novo;
        }
        else{
            ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
        }
        ultimo = novo;
        tamanho++;
        return true;
    }

    public void add(int index, Tipo info){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            addFirst(info);
            return;
        }

        No<Tipo> aux = primeiro;
        for (int i = 0; i < index; i++){
            aux = aux.getProximo();
        }

        if (aux == ultimo){
            addLast(info);
            return;
        }
        No<Tipo> novo = new No<Tipo>(info);
        aux.getAnterior().setProximo(novo);
        novo.setAnterior(aux.getAnterior());
        novo.setProximo(aux);
        aux.setAnterior(novo);
        tamanho++;
    }

    public boolean addAll(ListaDupla<Tipo> lista){
        if (lista.size() == 0){
            throw new NullPointerException();
        }

        No<Tipo> aux = lista.primeiro;
        while (aux != null) {
            addLast(aux.getInfo());
            aux = aux.getProximo();
            tamanho++;
        }
        return true;
    }

    public boolean addAll(int index, ListaDupla<Tipo> lista){
        if (lista.size() == 0){
            throw new NullPointerException();
        }
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        No<Tipo> aux = lista.primeiro;
        while (aux != null) {
            add(index, aux.getInfo());
            aux = aux.getProximo();
            index++;
            tamanho++;
        }
        return true;
    }

    public void addFirst(Tipo info){
        No<Tipo> novo = new No<Tipo>(info);
        if (size() == 0){
            ultimo = novo;
        }
        else{
            primeiro.setAnterior(novo);
            novo.setProximo(primeiro);
        }
        primeiro = novo;
        tamanho++;
    }

    public void addLast(Tipo info){
        add(info);
    }

    public void clear(){
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public ListaDupla<Tipo> clone(){
        ListaDupla<Tipo> copia = new ListaDupla<>();
        if (size() == 0){
            return copia;
        }
        No<Tipo> aux = primeiro;
        while (aux != null){
            copia.add(aux.getInfo());
            aux = aux.getProximo();
        }
        return copia;
    }

    public boolean contains(Tipo info){
        if (size() == 0){
            return false;
        }
        No<Tipo> aux = primeiro;
        while (aux != null) {
            if (aux.getInfo().equals(info)){
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    // descendingIterator

    public Tipo element(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return primeiro.getInfo();
    }

    public Tipo get(int index){

        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        No<Tipo> aux = primeiro;
        for (int i = 0; i < index; i++){
            aux = aux.getProximo();
        }
        return aux.getInfo();
    }

    public Tipo getFirst(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return primeiro.getInfo();
    }

    public Tipo getLast(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        return ultimo.getInfo();
    }

    public int indexOf(Tipo info){
        if (size() == 0){
            return -1;
        }

        No<Tipo> aux = primeiro;
        int pos = 0;
        while (aux != null) {
            if (aux.getInfo().equals(info)){
                return pos;
            }
            pos++;
            aux = aux.getProximo();
        }
        return -1;
    }

    public int lastIndexOf(Tipo info){
        if (size() == 0){
            return -1;
        }

        No<Tipo> aux = primeiro;
        int pos = -1;
        int contador = 0;
        while (aux != null) {
            if (aux.getInfo().equals(info)){
                pos = contador;
            }
            contador++;
            aux = aux.getProximo();
        }
        return pos;
    }

    // listIterator(int index)

    public boolean offer(Tipo info){
        return add(info);
    }

    public boolean offerFirst(Tipo info){
        addFirst(info);
        return true;
    }

    public boolean offerLast(Tipo info){
        addLast(info);
        return true;
    }

    public Tipo peek(){
        if (size() == 0){
            return null;
        }
        return primeiro.getInfo();
    }

    public Tipo peekFirst(){
        return peek();
    }

    public Tipo peekLast(){
        if (size() == 0){
            return null;
        }
        return ultimo.getInfo();
    }

    public Tipo poll(){
        if (size() == 0){
            return null;
        }
        return removeFirst();
    }

    public Tipo pollFirst(){
        return poll();
    }

    public Tipo pollLast(){
        if (size() == 0){
            return null;
        }
        return removeLast();
    }

    public Tipo pop(){
        return removeFirst();
    }

    public void push(Tipo info){
        addFirst(info);
    }

    public Tipo remove(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        Tipo valor = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null){
            ultimo = null;
        }
        else{
            primeiro.setAnterior(null);
        }
        tamanho--;
        return valor;
    }

    public Tipo remove(int index){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        if (index == 0){
            return removeFirst();
        }

        No<Tipo> aux;
        if (index * 2 > tamanho){
            aux = ultimo;
            for (int i = 0; i < (tamanho - 1) - index; i++){
                aux = aux.getAnterior();
            }
        }
        else{
            aux = primeiro;
            for (int i = 0; i < index; i++){
                aux = aux.getProximo();
            }
        }

       
        Tipo info = aux.getInfo();
        if (aux == ultimo){
            return removeLast();
        }

        aux.getAnterior().setProximo(aux.getProximo());
        aux.getProximo().setAnterior(aux.getAnterior());
        this.tamanho--;
        return info;
    }

    public Tipo removeFirst(){
        return remove();
    }

    public boolean removeFirstOccurrence(Tipo info){
        int index = indexOf(info);
        if (index == -1){
            return false;
        }
        remove(index);
        return true;
    }

    public Tipo removeLast(){
        if (size() == 0){
            throw new NoSuchElementException();
        }

        Tipo info = ultimo.getInfo();

        ultimo = ultimo.getAnterior();
        if (ultimo == null){ 
            primeiro = null;
        }
        else{
            ultimo.setProximo(null);
        }
        tamanho--;
        return info;
    }
    
    public boolean removeLastOccurrence(Tipo info){
        int index = lastIndexOf(info);
        if (index == -1){
            return false;
        }
        remove(index);
        return true;
    }

    public Tipo set(int index, Tipo info){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }

        Tipo oldInfo;
        No<Tipo> aux = primeiro;
        for (int i = 0; i < index; i++){
            aux = aux.getProximo();
        }
        oldInfo = aux.getInfo();
        aux.setInfo(info);
        return oldInfo;

    }

    public int size(){
        return tamanho;
    }

    // spliterator()

    // toArray()

    @Override
    public String toString(){
        if (size() == 0){
            return "[]";
        }
        String dados = "[";
        No<Tipo> aux = primeiro;
        while (aux != ultimo){
            dados += aux.getInfo() + ", ";
            aux = aux.getProximo();
        }
        dados += ultimo.getInfo() + "]";
        return dados;
    }

}




