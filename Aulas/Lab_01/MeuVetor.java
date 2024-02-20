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
    public boolean add (int elemento) {
        if (estaCheio())
            return false;
        ultimaPos++;
        v[ultimaPos] = elemento;
        return true;
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
