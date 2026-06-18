import java.util.ArrayList;
import java.util.Scanner; 
import java.util.List;

public class PetShopRepositorio {

	private final ArrayList<Animal> animais = new ArrayList<>();

	/** Adiciona um animal à lista. */
	public void adicionar(Animal a) {
		animais.add(a);
	}

	/**
	 * Busca um animal pelo nome (case-insensitive).
	 * 
	 * @return o Animal encontrado, ou null se não existir.
	 */
	public Animal buscarPorNome(String nome) { 
		for(Animal c: animais) { 
			if(c.getNome().equalsIgnoreCase(nome)) { 
				return c; 
				
			}		
		}
        return null; 
    }

	/**
	 * Remove o animal com o nome informado.
	 * 
	 * @return true se encontrou e removeu, false caso contrário.
	 */
	public boolean remover(String nome) {
		Animal object = buscarPorNome(nome);
		animais.remove(object);
		return true;
	}

	/** Retorna a lista completa de animais cadastrados (cópia defensiva). */
	public ArrayList<String> listarTodos() {
	    ArrayList<String> lista = new ArrayList<>();
	    
	    for (Animal c : animais) {
	        lista.add(c.exibirDados() + System.lineSeparator() );
	    }
	    
	    return lista;
	}

	/** Quantidade de animais cadastrados no repositório. */
	public int quantidade() {
		return 0;
	}
	//Atualização de dados
	public boolean atualizarDados(String nomeBusca,String novaRaca, int novaIdade, String novoTutor, int telefone) {
	    for (int i = 0; i < animais.size(); i++) {
	        Animal petAtual = animais.get(i);
	        if (petAtual.getNome().equalsIgnoreCase(nomeBusca)) {
	            petAtual.setRaca(novaRaca);
	            petAtual.setIdade(novaIdade);
	            petAtual.setTutor(novoTutor);
	            return true;
	        }
	    }
	    return false; 
	}
}