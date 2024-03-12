package interface_rede;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Amizade;
import br.edu.ifg.Postagem;
import br.edu.ifg.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PesquisarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputNomeUsuario;
	private Map<Integer, ArrayList<Amizade>> amigosMap = new HashMap<Integer, ArrayList<Amizade>>();
	private Usuario usuario;
	private Usuario usuarioPesquisado;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private   Map<Integer, ArrayList<Postagem>> postagemMap = new HashMap<Integer, ArrayList<Postagem>>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarUsuario frame = new PesquisarUsuario(null,null,null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PesquisarUsuario(Usuario usuario, Map<Integer, ArrayList<Amizade>> amigosMap, ArrayList<Usuario> usuarios,Map<Integer, ArrayList<Postagem>> postagemMap) {
		this.usuario = usuario;
		this.amigosMap = amigosMap;
		this.usuarios = usuarios;
		this.postagemMap=postagemMap;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1540, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelPesquisa = new JLabel("Pesquisar usuário");
		labelPesquisa.setFont(new Font("Tahoma", Font.BOLD, 40));
		labelPesquisa.setBounds(222, 38, 656, 60);
		contentPane.add(labelPesquisa);
		
		JLabel labelNomeUsuario = new JLabel("Nome de Usuário");
		labelNomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelNomeUsuario.setBounds(444, 226, 193, 31);
		contentPane.add(labelNomeUsuario);
		
		inputNomeUsuario = new JTextField();
		inputNomeUsuario.setBounds(719, 227, 370, 37);
		contentPane.add(inputNomeUsuario);
		inputNomeUsuario.setColumns(10);
		
		JButton botaoPesquisar = new JButton("Pesquisar");
		botaoPesquisar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputNomeUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nome de usuário vazio!" );
				}else {
					for(Usuario umUsuario : usuarios) {
						if(inputNomeUsuario.getText().equals(umUsuario.getNomeUsuario())) {
						usuarioPesquisado=umUsuario;
						}
					}
				}
				
				if(usuarioPesquisado==null) {
					JOptionPane.showMessageDialog(null,"Usuário não existe!" );
				}else {
				dispose();
				PerfilUsuario perfil= new PerfilUsuario(usuarioPesquisado,usuario, amigosMap, usuarios, postagemMap);
				perfil.setVisible(true);
				}
			}
		});
		botaoPesquisar.setBounds(856, 369, 150, 37);
		contentPane.add(botaoPesquisar);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home(usuario, amigosMap, postagemMap, usuarios);
				home.setVisible(true);
			}
		});
		botaoVoltar.setBounds(566, 369, 85, 37);
		contentPane.add(botaoVoltar);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);
	}
}
