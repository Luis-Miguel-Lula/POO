
	public class Animal {

	    protected String nome;
	    protected int idade;
	    protected String raca; 
	    protected String tutor; 
	    protected int telefone; 
	    
	    

	    public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
		}
		 public String getRaca() {
				return nome;
			}

		public void setRaca(String nome) {
			this.nome = nome;
		}
		public String getTutor() {
			return nome;
		}

			public void setTutor(String nome) {
				this.nome = nome;
			}
			 public int getTelefone(){
					return telefone ;
				}

				public void setTelefone(int telefone)  {       
					this.telefone = telefone;
				}

		public Animal(String nome, int idade) {
	        this.nome = nome;
	        this.idade = idade;
	    }
		
		public String exibirDados() {
			return "Nome:" + nome +  System.lineSeparator() + "Raca:" + raca + System.lineSeparator() + "Idade:" + idade + System.lineSeparator() + "Tutor:" + tutor +  System.lineSeparator() + "Telefone: " + telefone; 

		}

	    public void emitirSom() {
	        System.out.println("O animal emite um som.");
	    }
	}


