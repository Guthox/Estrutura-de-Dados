public class Fila {
    
    private class No{

        private int info;
        private No proximo;

        public No(int info){
            setInfo(info);
        }

        public void setInfo(int info) {
            this.info = info;
        }
        public void setProximo(No proximo) {
            this.proximo = proximo;
        }
        public int getInfo() {
            return info;
        }
        public No getProximo() {
            return proximo;
        }

    }

    private No primeiro;
    private No ultimo;
    
    public boolean estaVazio(){
        return primeiro == null;
    }

    public void adicionar(int info){
        No novo = new No(info);
        if (estaVazio()){
            primeiro = novo;
            ultimo = novo;
            return;
        }
        ultimo.setProximo(novo);
        ultimo = novo;
    }

    public int remover(){
        int aux = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        return aux;
    }

    public int peek(){
        return primeiro.getInfo();
    }

    @Override
    public String toString(){
        if (estaVazio()) return "Vazio";
        No aux = primeiro;
        String dados = "";
        while (aux != null) {
            dados += aux.getInfo() + " ";
            aux = aux.getProximo();
        }
        return dados;
    }

}
