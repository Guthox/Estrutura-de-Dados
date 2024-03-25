public class No {
    
    private int info;
    private No anterior;
    private No proximo;

    public No(int info){
        setInfo(info);
        setAnterior(null);
        setProximo(null);
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public void setInfo(int info) {
        this.info = info;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }
    public int getInfo() {
        return info;
    }
    public No getProximo() {
        return proximo;
    }

}
