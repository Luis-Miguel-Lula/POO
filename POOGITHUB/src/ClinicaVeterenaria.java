
public class ClinicaVeterenaria {

		public static void main(String[] args) {
			   Cachorro Cachorro1 = new Cachorro("", "Caramelo", 17); 
			   Cachorro Cachorro2 = new Cachorro("Verstarppen", "Caramelo", 15); 
			   Cliente Cliente1 = new Cliente("Mike", "Iphone"); 
			   Cliente Cliente2 = new Cliente("Bolsonaro", "Samgsung"); 
		       Cachorro1.setDono(Cliente1); 
		       Cachorro2.setDono(Cliente2);
		       System.out.printf(" O nome do tutor" +Cachorro1.getDono().getNome());
		       System.out.println();
		       Cachorro1.exibirDados();
		       System.out.println(); 
		       Cachorro2.exibirDados();
		       System.out.println();
		       System.out.printf("Total de Cachorros:" +Cachorro.getTotalCachorro());
		      
		      
		 
		      
		       

		}

	}

