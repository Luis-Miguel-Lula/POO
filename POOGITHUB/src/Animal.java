
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
				return raca;
		}

		public void setRaca(String raca) {
			this.raca = raca;
		}
		public String getTutor() {
			return tutor;
		}

		public void setTutor(String tutor) {
			this.tutor = tutor;
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
		
		@Override
		
		public String toString() {
			return "Nome:" + this.nome +  System.lineSeparator() + "Raca:" + this.raca + System.lineSeparator() + "Idade:" + this.idade; 

		}

	    public void emitirSom() {
	        System.out.println("O animal emite um som.");
	    }
	}


