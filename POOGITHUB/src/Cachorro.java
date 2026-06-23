public class Cachorro extends Animal {

    private String raca;

    public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Cachorro(String nome, String raca, int idade) {
        super(nome, idade);
        this.raca = raca;
    }

    @Override
    public void emitirSom() {
        System.out.println("AU AU!");
    }

	public String toString() {
		return "Nome:" + nome +  System.lineSeparator() + "Raca:" + raca + System.lineSeparator() + "Idade:" + idade + System.lineSeparator(); 
	}
}