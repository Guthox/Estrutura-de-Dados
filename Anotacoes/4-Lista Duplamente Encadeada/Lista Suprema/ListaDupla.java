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
        return true;
    }

    // add(int index, Tipo info)

    // addAll(Lista<Tipo> lista)

    // addAll(int index, Lista<Tipo> lista)

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
    }

    // Mesmo que add(Tipo info)
    public void addLast(Tipo info){
        add(info);
    }

    public void clear(){
        primeiro = null;
        ultimo = null;
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
        return primeiro.getInfo();
    }

    public Tipo get(int index){
        No<Tipo> aux = primeiro;
        for (int i = 0; i < index; i++){
            aux = aux.getProximo();
        }
        return aux.getInfo();
    }

    public Tipo getFirst(){
        return primeiro.getInfo();
    }

    public Tipo getLast(){
        return ultimo.getInfo();
    }

    // indexOf()

    // lastIndexOf()

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

    // poll()

    // pollFirst()

    // pollLast()

    // pop()

    // push()

    // remove()

    // remove(Tipo info)

    // removeFirst()

    // removeFirstOccurrence(Tipo info)

    // removeLast()
    
    // removeLastOccurrence(Tipo info)

    // set(int index, Tipo info)

    public int size(){
        if (primeiro == null){
            return 0;
        }
        int tamanho = 0;
        No<Tipo> aux = primeiro;
        while (aux != null){
            tamanho++;
            aux = aux.getProximo();
        }
        return tamanho;
    }

    // spliterator()

    // toArray()

    @Override
    public String toString(){
        if (size() == 0){
            return "";
        }
        String dados = "";
        No<Tipo> aux = primeiro;
        while (aux != null){
            dados += aux.getInfo() + " ";
            aux = aux.getProximo();
        }
        return dados;
    }

}




