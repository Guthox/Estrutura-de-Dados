import java.util.Random;

public class MeuVetor {
    private double[] v;
    private int ultimaPos;

    public MeuVetor (int capacidade) {
        v = new double[capacidade];
        ultimaPos = -1;
    }

    //métodos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }
    public double[] getV() {
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

    public void add(double elemento){
        if(estaCheio()){
            redimensiona(v.length*2);
        }
        ultimaPos++;
        v[ultimaPos] = elemento;
    }

    public void add(int elemento){
        if(estaCheio()){
            redimensiona(v.length*2);
        }
        ultimaPos++;
        v[ultimaPos] = elemento;
    }

    public void resetar(){
        ultimaPos = -1;
    }

    public double remove(){
        if(estaVazio()) return 0;
        double temporario = v[ultimaPos];
        ultimaPos--;
        if (v.length >= 10 && ultimaPos <= v.length/4){
            redimensiona(v.length/2);
        }
        return temporario;
    }

    private void redimensiona(int novaCapacidade){
        double[] temp = new double[novaCapacidade];
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
                s = s + String.format("%.0f ", v[i]);
            }
        }
        s = s + "\n";
        return s;
    }

    public void preencherVetor(){
        Random random = new Random();
        for (int i = 0; i < v.length; i++){
            add(random.nextInt(v.length * 10));
        }
    }

    public void preencherVetor(int capacidade){
        Random random = new Random();
        for (int i = 0; i < capacidade; i++){
            add(random.nextInt(v.length * 10));
        }
    }
}
