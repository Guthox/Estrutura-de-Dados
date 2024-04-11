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
    public void setUltimaPosicao(int pos) {
        if (pos >= 0 && pos < v.length) {
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length - 1;
        }
    }
 
    public boolean estaCheio () {
        return ultimaPos == v.length-1;
    }
 
    public boolean estaVazio () {
        return ultimaPos == -1;
    }
 
 
    public void adiciona(int elemento) {
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = elemento;
    }
    public void adiciona (double elemento) {
        if (estaCheio())
            redimensiona(v.length*2);
        v[++ultimaPos] = elemento;
    }
    public void adiciona (double elemento, int posicao) {
        if (estaCheio()){
            redimensiona(v.length * 2);
        }
        if (posicao > ultimaPos){
            v[++ultimaPos] = elemento;
            return;
        }
        if (posicao < 0){
            posicao = 0;
        }
        int i;
        ultimaPos++;
        for (i = ultimaPos; i > posicao; i--){
            v[i] = v[i-1];
        }
        v[i] = elemento;
    }
    public double remove() {
        if (estaVazio()) return 0;
        double aux = v[ultimaPos--];
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return aux;
    }
    public double remove(int pos) {
        if (estaVazio() || pos > ultimaPos || pos < 0){
            return 0;
        }
        double aux = v[pos];
        for (int i = pos; i < ultimaPos; i++){
            v[i] = v[i+1];
        }
        ultimaPos--;
        return aux;
    }
    public int remove (double elemento) {
        if (estaVazio()) return 0;
        int cont = 0;
        for (int i=ultimaPos; i>=0; i--) {
            if (v[i] == elemento) {
                //arrasta
                for (int j=i; j<ultimaPos; j++)
                    v[j] = v[j+1];
                ultimaPos--;
                cont++;
            }
        }
        if (v.length >= 10 && ultimaPos <= v.length / 4) {
            redimensiona(v.length/2);
        }
        return cont;
    }
    private void redimensiona(int novaCapacidade) {
        double[] temp = new double[novaCapacidade];
        for (int i = 0; i <= ultimaPos; i++) {
            temp[i] = v[i];
        }
        v = temp;
    }
 
    @Override
    public String toString() {
        String s = "";
        if (estaVazio()) {
            s = s + "vetor vazio";
        }
        else {
            for (int i=0; i <= ultimaPos; i++) {
                s = s + String.format("%.0f ", v[i]);
            }
        }
        return s;
    }
 
    public void preencheVetor () {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            adiciona(r.nextInt(v.length*10)+1);
        }
    }
    public void preencheVetor (int limite) {
        Random r = new Random();
        for (int i=0; i<v.length; i++) {
            adiciona(r.nextInt(limite));
        }
    }
    public int bubbleSort () {
        int cont = 0;
        for (int i=1; i<v.length; i++) {
            for (int j=0; j<v.length-i; j++) {
                cont++;
                if (v[j] > v[j+1]) {
                    double aux = v[j];
                    v[j] = v[j+1];
                    v[j+1] = aux;
                }
            }
        }
        return cont;
    }

    public int contar(int elemento){
        int contador = 0;
        for (int i = 0; i <= ultimaPos; i++){
            if (v[i] == elemento){
                contador++;
            }
        }
        return contador;
    }

    public int removePrimeiraOcorrencia(double valor){
        if (estaVazio()) return -1;
        for (int i = 0; i < ultimaPos; i++){
            if (v[i] == valor){
                // remove(i); 
                for (int j = i; j < ultimaPos; j++){
                    v[j] = v[j+1];
                }
                return i;
            }
        }
        return -1;
    }

    public int removeTodasOcorrencias(double valor){
        if (estaVazio()) return 0;
        int vezes = 0;
        for (int i = 0; i < ultimaPos; i++){
            if (v[i] == valor){
                for (int j = i; j < ultimaPos; j++){
                    v[j] = v[j+1];
                }
                vezes++;
                i--;
                ultimaPos--;
            }
        }
        return vezes;
    }

    public MeuVetor posicoesElementos(double valor){
        MeuVetor vetor = new MeuVetor(1);
        for (int i = 0; i < ultimaPos; i++){
            if (v[i] == valor){
                vetor.adiciona(i);
            }
        }
        return vetor;
    }
 
    public int acharPrimeiro(double valor){
        for (int i = 0; i < ultimaPos; i++){
            if (v[i] == valor){
                return i;
            }
        }
        return -1;
    }
    public void esvaziarLista(){
        ultimaPos = -1;
    }

    public int size(){
        return ultimaPos + 1;
        // int contador = 0;
        // for (int i = 0; i <= ultimaPos; i++){
        //     contador++;
        // }
        // return contador;
    }

    public MeuVetor clone(){
        MeuVetor copia = new MeuVetor(size());
        for (int i = 0; i <= ultimaPos; i++){
            copia.adiciona(v[i]);
        }
        return copia;
    }

    public void compactar(){
        redimensiona(size());
    }

    public MeuVetor mesclar(MeuVetor vetor1, MeuVetor vetor2){
        MeuVetor novo = new MeuVetor(1);
        for (int i = 0; i <= vetor1.getUltimaPos(); i++){
            novo.adiciona(vetor1.getV()[i]);
        }
        for (int i = 0; i <= vetor2.getUltimaPos(); i++){
            novo.adiciona(vetor2.getV()[i]);
        }
        return novo;
    }

    public double somar(){
        double soma = 0;
        for (int i = 0; i <= ultimaPos; i++){
            soma += v[i];
        }
        return soma;
    }

    public double maior(){
        double maior = v[0];
        for (int i = 1; i <= ultimaPos; i++){
            if (v[i] > maior){
                maior = v[i];
            }
        }
        return maior;
    }

    public int encontrarMaior(){
        double maior = v[0];
        int pos = 0;
        for (int i = 1; i <= ultimaPos; i++){
            if (v[i] > maior){
                maior = v[i];
                pos = i;
            }
        }
        return pos;
    }

    public void permutaMenor(){
        double menor = v[0];
        int pos = 0;
        for (int i = 1; i <= ultimaPos; i++){
            if (v[i] < menor){
                menor = v[i];
                pos = i;
            }
        }
        // Fazer permuta
        v[pos] = v[0];
        v[0] = menor;
    }

}
 

// 1. Inserir um elemento em uma determinada posição ************************************************* void adiciona (double elemento, int posicao)
// 2. Verificar quantas vezes um elemento aparece no vetor. ****************************************** int contar(int elemento)
// 3. Remover um elemento de uma determinada posição. ************************************************ double remove(int pos)
// 4. Remover a primeira ocorrência de um determinado elemento. ************************************** int removePrimeiraOcorrencia(double valor)
// 5. Remover todas as ocorrências de um determinado elemento. *************************************** int removeTodasOcorrencias(double valor)
// 6. Criar uma nova instância da classe, com as posições de ocorrência de um determinado elemento. ** MeuVetor posicoesElementos(double valor)
// 7. Devolver o índice da primeira ocorrência de um determinado elemento. *************************** int acharPrimeiro(double valor)
// 8. Devolver o tamanho atual da lista de valores (quantos elementos ela tem). ********************** int size()
// 9. Esvaziar a lista. ****************************************************************************** void esvaziarLista()
// 10. Devolver uma cópia da lista. ****************************************************************** MeuVetor clone()
// 11. Reduzir o vetor ao tamanho dele. ************************************************************** void compactar()
// 12. Receber 2 vetores de entrada e mesclá-los num único vetor. ************************************ MeuVetor mesclar(MeuVetor vetor1, MeuVetor vetor2)
// 13. Somar os elementos do vetor. ****************************************************************** double somar()
// 14. Encontrar o maior elemento armazenado. ******************************************************** double maior()
// 15. Encontrar a posição do maior elemento armazenado. ********************************************* int encontrarMaior()
// 16. Encontrar o menor elemento armazenado e coloca-lo na posição 0 (fazer a troca). *************** void permutaMenor()