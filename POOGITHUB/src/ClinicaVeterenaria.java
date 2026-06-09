
public class ClinicaVeterenaria {

    public static void main(String[] args) {

        Animal[] filaAtendimento = new Animal[2];

        filaAtendimento[0] = new Cachorro("Rex", "Pastor Alemao", 5);
        filaAtendimento[1] = new Gato("Mingau", 2, true);

        for (Animal animal : filaAtendimento) {
            animal.emitirSom();
        }
    }
}
