public class Cachorro extends Animal {

    private String raca;

    public Cachorro(String nome, String raca, int idade) {
        super(nome, idade);
        this.raca = raca;
    }

    @Override
    public void emitirSom() {
        System.out.println("AU AU!");
    }
}