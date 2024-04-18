public class Pilha {
   
    private class No{

        private int info;
        private No proximo;

        public No(int info){
            setInfo(info);
        }

        public void setInfo(int info) {
            this.info = info;
        }
        public int getInfo() {
            return info;
        }
        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
        public No getProximo() {
            return proximo;
        }

    }

    private No topo;

    public boolean estaVazio(){
        return topo == null;
    }

    public void push(int info){
        No novo = new No(info);
        if (estaVazio()){
            topo = novo;
            return;
        }
        novo.setProximo(topo);
        topo = novo;
    }

    public int pop(){
        int aux = topo.getInfo();
        topo = topo.getProximo();
        return aux;
    }

    public int peek(){
        return topo.getInfo();
    }

    @Override
    public String toString(){
        if (estaVazio()) return "Vazio";
        String dados = "";
        No aux = topo;
        while (aux != null) {
            dados += aux.getInfo() + "\n";
            aux = aux.getProximo();
        }
        return dados;
    }

}
