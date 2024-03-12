package interface_rede;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Amizade;
import br.edu.ifg.Postagem;
import br.edu.ifg.Usuario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private  Map<Integer, ArrayList<Amizade>> amigosMap = new HashMap<Integer, ArrayList<Amizade>>();
	private   Map<Integer, ArrayList<Postagem>> postagemMap = new HashMap<Integer, ArrayList<Postagem>>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(null,null,null,null);
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
	public Home(Usuario usuario, Map<Integer, ArrayList<Amizade>> amigosMap, Map<Integer, ArrayList<Postagem>> postagemMap,ArrayList<Usuario> usuarios) {
		this.usuario=usuario;
		this.amigosMap=amigosMap;
		this.postagemMap=postagemMap;
		this.usuarios=usuarios;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1540, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JButton botaoCriarPostagem = new JButton("Criar Postagem");
		botaoCriarPostagem.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoCriarPostagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarPostagem criarPostagem= new CriarPostagem(usuario, amigosMap, postagemMap,usuarios);
				criarPostagem.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		botaoCriarPostagem.setBounds(394, 170, 166, 37);
		getContentPane().add(botaoCriarPostagem);
		
		JButton botaoVisualizarAmigos = new JButton("Visualizar Amigos");
		botaoVisualizarAmigos.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoVisualizarAmigos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Amigos amigos= new Amigos(usuario, amigosMap,usuarios,postagemMap);
				amigos.setVisible(true);
			}
		});
		botaoVisualizarAmigos.setBounds(394, 298, 186, 37);
		contentPane.add(botaoVisualizarAmigos);
		
		JButton botaoSugestao = new JButton("Sugestões de Amizade");
		botaoSugestao.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoSugestao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SugestoesAmizade sugestoes;
				try {
					sugestoes = new SugestoesAmizade(usuario, amigosMap, usuarios, postagemMap);
					sugestoes.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		botaoSugestao.setBounds(394, 234, 228, 37);
		contentPane.add(botaoSugestao);
		
		JButton botaoPesquisar = new JButton("Pesquisar Usuário");
		botaoPesquisar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PesquisarUsuario pesquisar = new PesquisarUsuario(usuario, amigosMap, usuarios, postagemMap);
				pesquisar.setVisible(true);
			}
		});
		botaoPesquisar.setBounds(394, 362, 177, 37);
		contentPane.add(botaoPesquisar);
		
		JButton botaoPerfil = new JButton("Perfil");
		botaoPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Perfil perfil= new Perfil(usuario, usuario, amigosMap, usuarios, postagemMap);
				perfil.setVisible(true);
			}
		});
		botaoPerfil.setBounds(394, 426, 85, 37);
		contentPane.add(botaoPerfil);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		botaoSair.setBounds(394, 554, 85, 37);
		contentPane.add(botaoSair);
		
		JButton botaoFeed = new JButton("Feed");
		botaoFeed.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Feed feed= new Feed(usuario, amigosMap, usuarios, postagemMap);
				feed.setVisible(true);
			}
		});
		botaoFeed.setBounds(394, 490, 85, 37);
		contentPane.add(botaoFeed);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(222, 55, 278, 35);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(394, 220, 256, 12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(394, 284, 256, 12);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(394, 348, 256, 12);
		contentPane.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(394, 412, 256, 12);
		contentPane.add(separator_1_1_1);
		
		JSeparator separator_1_1_2 = new JSeparator();
		separator_1_1_2.setBounds(394, 476, 256, 12);
		contentPane.add(separator_1_1_2);
		
		JSeparator separator_1_1_3 = new JSeparator();
		separator_1_1_3.setBounds(394, 540, 256, 12);
		contentPane.add(separator_1_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);
	}
}
