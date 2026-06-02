
		public class Cliente {
		    private String nome; 
			private String telefone; 
			public Cliente(String nome,String telefone){ 
				if(nome != "") { 
					this.nome = nome; 
				}else { 
					System.out.println("o nome não pode ser vazio ou nulo");
					System.exit(0);
				}
				this.telefone = telefone; 
			}
			public void setNome(String nome) {
				if(nome != "") { 
					this.nome = nome; 
				}else { 
					System.out.println("o nome não pode ser vazio ou nulo");
				}
			}
			public String getNome() {
				return nome;
			}
			public void setTelefone(String telefone) {
				this.telefone = telefone;
			}
			

			public String getTelefone() {
				return telefone;
			}

		    public void exibirInformacoes() { 
				System.out.println("Seu nome:" +nome);
				System.out.println("Seu telefone:" +telefone);
			}
			
		       



	}


