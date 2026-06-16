
		public class Cliente {
		    private String tutor; 
			private String telefone; 
			public Cliente(String nome,String telefone){ 
				if(nome != "") { 
					this.tutor = nome; 
				}else { 
					System.out.println("o nome não pode ser vazio ou nulo");
					System.exit(0);
				}
				this.telefone = telefone; 
			}
			public void setNome(String nome) {
				if(nome != "") { 
					this.tutor = nome; 
				}else { 
					System.out.println("o nome não pode ser vazio ou nulo");
				}
			}
			public String getNome() {
				return tutor;
			}
			public void setTelefone(String telefone) {
				this.telefone = telefone;
			}
			

			public String getTelefone() {
				return telefone;
			}

		    public String exibirInformacoes() { 
		    	return "Tutor: " + tutor + System.lineSeparator() + "Telefone: " + telefone;

			}
			
		       



	}


