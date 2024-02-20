public class Teste {
    public static void main(String[] args) {
        MeuVetor v1 = new MeuVetor(10);
        System.out.println("ultima posicao depois de instanciar: " + v1.getUltimaPos());
        v1.setUltimaPos(27);
        System.out.println("ultima posicao depois do 27: " + v1.getUltimaPos());
        System.out.println(v1);

        if (v1.add(12)){
            System.out.println("elemento inserido com sucesso");
        }
        else {
            System.out.println("vetor esta cheio!");
        }
    }
}
