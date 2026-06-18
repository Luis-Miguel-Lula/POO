import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaPetShop extends JFrame {

	private final PetShopRepositorio repositorio = new PetShopRepositorio();

	// ── Campos do formulário ───────────────────────────────
	private final JTextField campNome = new JTextField(10);
	private final JTextField campRaca = new JTextField(10);
	private final JTextField campIdade = new JTextField(3); 
	private final JTextField campTutor = new JTextField(10); 
	private final JTextField campTelefone = new JTextField(10); 


	// ── Área de resultado ──────────────────────────────────
	private final JTextArea areaResultado = new JTextArea(12, 50);

	// ── Botões ─────────────────────────────────────────────
	private final JButton btnCadastrar = new JButton("Cadastrar");
	private final JButton btnBuscar = new JButton("Buscar"); 
	private final JButton btnAtualizar = new JButton("Atualizar");
	private final JButton btnRemover = new JButton("Remover"); 
	private final JButton btnListar = new JButton("Listar todos"); 

	// ── Construtor ─────────────────────────────────────────
	public TelaPetShop() {
		super("Pet Shop — Gerenciador de Animais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// O JFrame usa BorderLayout por padrão
		setLayout(new BorderLayout(8, 8));

		add(criarPainelFormulario(), BorderLayout.NORTH);
		add(criarAreaResultado(), BorderLayout.CENTER);
		add(criarPainelBotoes(), BorderLayout.SOUTH);

		configurarListeners();

		setSize(900, 600);
		pack();
		setLocationRelativeTo(null); // centraliza na tela

		setVisible(true);
	}

	// ── Painel Norte: formulário ───────────────────────────
	private JPanel criarPainelFormulario() {
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
		painel.setBorder(BorderFactory.createTitledBorder("Dados do Pet e Tutor"));

		painel.add(new JLabel("Nome:"));
		painel.add(campNome);
		painel.add(new JLabel("Raca:")); 
        painel.add(campRaca); 
        painel.add(new JLabel("Idade:")); 
        painel.add(campIdade); 
        painel.add(new JLabel("Tutor:")); 
        painel.add(campTutor); 
        painel.add(new JLabel("Telefone(Apenas 8 digitos e escreva numeros):")); 
        painel.add(campTelefone); 
		return painel;
	}
	
	

	// ── Centro: área de texto com scroll ──────────────────
	private JScrollPane criarAreaResultado() {
		areaResultado.setEditable(false);
		areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
		areaResultado.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
		exibirTexto("Bem-vindo ao sistema do Pet Shop!\n"
				+ "Preencha os campos acima e use os botões para gerenciar os pets.\n");
		return new JScrollPane(areaResultado);
	}

	// ── Painel Sul: botões ─────────────────────────────────
	private JPanel criarPainelBotoes() {
		JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
		painel.add(btnCadastrar);
		painel.add(btnBuscar); 
		painel.add(btnAtualizar);	
		painel.add(btnRemover);	
		painel.add(btnListar); 
		return painel; 
	}

	// ── ActionListeners ────────────────────────────────────
	private void configurarListeners() {

		// ---- CADASTRAR ----
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campNome.getText().trim();
				String raca = campRaca.getText().trim();
                int idade = Integer.parseInt(campIdade.getText());
                String tutor = campTutor.getText().trim(); 
                String telefone = campTelefone.getText();
                
				if (nome.isEmpty()) {
					exibirTexto("ERRO: O campo Nome é obrigatório.");
					return;
				}
				if (raca.isEmpty()) { 
					raca = "Indefinida";
                } 

				Cachorro novo = new Cachorro(nome, raca, idade);
				Cliente c1 = new Cliente(tutor,telefone); 

				repositorio.adicionar(novo);
				exibirTexto("Pet cadastrado com sucesso!\n\n" + novo.exibirDados() + c1.exibirInformacoes()); 
				limparCampos(); 
			} 
		}); 
		
		//---BUSCAR---- 
		btnBuscar.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				String nome = campNome.getText().trim(); 
				if(nome.isEmpty()) {
					exibirTexto("Seu nome esta vazio para a busca");
				}
				exibirTexto( repositorio.buscarPorNome(nome).exibirDados() ); 
			 
				
			}
			
		}); 
		//---ATUALIZAR--- 
		btnAtualizar.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) {                                            
		        try {
		            String nome = campNome.getText().trim();
		            String novaRaca = campRaca.getText().trim();
		            String novoTutor = campTutor.getText().trim();
		            String textoIdade = campIdade.getText().trim();
		            String textoTelefone = campTelefone.getText().trim();
		            
		            // Valida se algum campo textual ou numérico está completamente vazio
		            if (nome.isEmpty() || novaRaca.isEmpty() || novoTutor.isEmpty() || textoIdade.isEmpty() || textoTelefone.isEmpty()) {
		                JOptionPane.showMessageDialog(TelaPetShop.this, "Por favor, preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
		                return;
		            }

		            // Conversão e validação específica da Idade
		            int novaIdade;
		            try {
		                novaIdade = Integer.parseInt(textoIdade);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(TelaPetShop.this, "O campo Idade deve conter apenas números inteiros válidos!", "Erro de Digitação", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            // Conversão e validação específica do Telefone
		            int telefone;
		            try {
		                telefone = Integer.parseInt(textoTelefone);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(TelaPetShop.this, "O campo Telefone deve conter apenas números!\nNota: Não use espaços, traços ou números muito longos.", "Erro de Digitação", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            // Executa a atualização no repositório
		            boolean sucesso = repositorio.atualizarDados(nome, novaRaca, novaIdade, novoTutor, telefone);
		            
		            if (sucesso) {
		                JOptionPane.showMessageDialog(TelaPetShop.this, "Cadastro do pet modificado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		                limparCampos(); 
		            } else {
		                JOptionPane.showMessageDialog(TelaPetShop.this, "Nenhum pet encontrado com o nome: " + nome, "Erro", JOptionPane.ERROR_MESSAGE);
		            }

		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(TelaPetShop.this, "Ocorreu um erro inesperado: " + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
 
		
		//----REMOVER----
		btnRemover.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
		        String nome = campNome.getText().trim();
		        
		        if (nome.isEmpty()) {
		            exibirTexto("O nome está vazio!");
		        } else {
		            Animal animalEncontrado = repositorio.buscarPorNome(nome); 
		            
		            if (animalEncontrado != null) { 
		                repositorio.remover(nome); 
		                exibirTexto("Animal \"" + nome + "\" removido com sucesso!");
		                limparCampos();
		            } else {
		                exibirTexto("Nenhum animal encontrado com o nome: " + nome);
		            }
		        }
		    }
		    });


		//---LISTAR TODOS---
		btnListar.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) { 
				ArrayList<String> lista = repositorio.listarTodos();
				exibirTexto(String.join("",lista)); 
	   }
			}); 
	}

			

	// ── Métodos auxiliares ─────────────────────────────────

	/** Exibe texto na área de resultado, substituindo o conteúdo anterior. */
	private void exibirTexto(String texto) {
		areaResultado.setText(texto);
	}

	/** Limpa todos os campos do formulário. */
	private void limparCampos() {
		campNome.setText("");
		campRaca.setText("");
		campIdade.setText(""); 
		campTutor.setText("");
		campTelefone.setText("");
		campNome.requestFocus();
	}

}

