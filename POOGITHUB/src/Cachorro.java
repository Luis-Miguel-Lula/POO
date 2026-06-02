
	public class Cachorro {
		 private String nome; 
	     private String raca; 
		 private Cliente dono; 
		 private int idade; 
		 private static int totalCachorro; 
		 private boolean faminto = true;  
		 public Cachorro(String nome,String raca, int idade) { 
			 if (nome != "") { 
					this.nome = nome;
			 }else { 
					System.out.println("Voce nao tem dono");
					System.exit(0);
			 }
			 this.raca = raca; 
			 if(idade>= 0) { 
					this.idade = idade; 
			 }else { 
					System.out.println("Invalido idade negativa");	
			 }
			 totalCachorro++; 
		 }
		 
		 public String getNome() {
				return nome;
		 }
		public void setNome(String nome) {
			if (nome != "") { 
				this.nome = nome;
			}else { 
				System.out.println("Voce nao tem dono");
			}
		}
			public String getRaca() {
				return raca;
			}
			public void setRaca(String raca) {
				this.raca = raca;
			}
			public Cliente getDono() {
				return dono;
			}
			public void setDono(Cliente dono) {
				this.dono = dono;
			}
			public int getIdade() {
				return idade;
			}
			public void setIdade(int idade) {
				if(idade>= 0) { 
					this.idade = idade; 
				}else { 
					System.out.println("Invalido idade negativa");
				}
			} 
			public static int getTotalCachorro() { 
				return totalCachorro; 
			}
			public void setTotalCachorro(int totalCachorro) {
				Cachorro.totalCachorro = totalCachorro;
			}
			public boolean isFaminto() {
				return faminto;
			}
			public void setFaminto(boolean faminto) {
				this.faminto = faminto;
			}
		 public void comer() { 
			 if (faminto = true) { 
				 System.out.printf("O " +nome+ " comeu!");
				 faminto = false; 
			 }else{ 
				 System.out.printf(nome+ " ja esta satisfeito"); 
			 }
		 }
		 public void latir() { 
			 System.out.printf("O " +raca+ " chamado " +nome+ " diz: au au!");
		 }
		 public void exibirDados() { 
			 System.out.printf("Nome:" + this.nome);
			 System.out.println();
           System.out.printf("Raca:" + this.raca);
           System.out.println();
           System.out.printf("Idade:" + this.idade);
           System.out.println();
           System.out.printf("Fome:" + this.faminto);
		 }

	}
		



