public class MeuVetor {
    private int[] v;
    private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new int[capacidade];
        ultimaPos = -1;
    }

    //métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }
    public int[] getV() {
        return v;
    }

    //métodos modificadores
    public void setUltimaPos (int pos) {
        if (pos >= 0 && pos < v.length) {
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length - 1;
        }
    }
    public boolean estaCheio (){
        return ultimaPos == v.length-1;
    }
    public boolean estaVazio(){
        return ultimaPos == -1;
    }
    // public boolean add (int elemento) {
    //     if (estaCheio())
    //         return false;
    //     ultimaPos++;
    //     v[ultimaPos] = elemento;
    //     return true;
    // }

    public void add(int elemento){
        if(estaCheio()){
            redimensiona(v.length*2);
        }
        ultimaPos++;
        v[ultimaPos] = elemento;
    }

    public int remove(){
        if(estaVazio()) return 0;
        int temporario = v[ultimaPos];
        ultimaPos--;
        if (v.length >= 10 && ultimaPos <= v.length/4){
            redimensiona(v.length/2);
        }
        return temporario;
    }

    private void redimensiona(int novaCapacidade){
        int[] temp = new int[novaCapacidade];
        for (int i = 0; i <= ultimaPos; i++){
            temp[i] = v[i];
        }
        v = temp;
    }

    @Override
    public String toString() {
        String s = "";
        if (estaVazio()) {
            s = s + "esta vazio";
        }
        else {
            for (int i=0; i<=ultimaPos; i++) {
                s = s + v[i] + " ";
            }
        }
        s = s + "\n";
        return s;
    }
}