package interface_rede;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Amizade;
import br.edu.ifg.Postagem;
import br.edu.ifg.Rede;
import br.edu.ifg.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class PerfilUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					Perfil frame = new Perfil(null,null,null,null,null);
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
	public PerfilUsuario(Usuario usuarioPesquisado,Usuario usuario, Map<Integer, ArrayList<Amizade>> amigosMap, ArrayList<Usuario> usuarios,Map<Integer, ArrayList<Postagem>> postagemMap) {
		this.usuario = usuario;
		this.amigosMap = amigosMap;
		this.usuarios = usuarios;
		this.postagemMap=postagemMap;
		this.usuarioPesquisado=usuarioPesquisado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1540, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Perfil Amigo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(222, 10, 515, 49);
		contentPane.add(lblNewLabel);
		
		JTextPane textoUsuario = new JTextPane();
		textoUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		textoUsuario.setEditable(false);
		textoUsuario.setBounds(232, 69, 667, 82);
		textoUsuario.setText("Nome de completo: "+usuarioPesquisado.getNomeCompleto()+"\n\nNome de Usuário: "+usuarioPesquisado.getNomeUsuario());
		contentPane.add(textoUsuario);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 185, 1384, 508);
		contentPane.add(scrollPane);
		
		JPanel panelPostagens = new JPanel();
		scrollPane.setViewportView(panelPostagens);
		panelPostagens.setLayout(new GridLayout(0, 1, 5, 5));
		
		
		
		ArrayList<Postagem> postagem =Rede.visualizarPostagens(postagemMap, usuarioPesquisado.getId());
		int i=0;
		if(postagem==null) {
			JLabel labelPostagem = new JLabel("Sem postagens!");
			labelPostagem.setBounds(185, 60+i, 800, 13);
			labelPostagem.setFont(new Font("Arial", Font.BOLD, 45));
			panelPostagens.add(labelPostagem);
		}else {
		for(Postagem umaPostagem : postagem) {
			JLabel labelPostagem = new JLabel(umaPostagem.getConteudo());
			labelPostagem.setFont(new Font("Arial", Font.BOLD, 45));
			labelPostagem.setBounds(185, 60+i, 800, 13);
			panelPostagens.add(labelPostagem);
			i+=10;
		}
		}
		
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home(usuario, amigosMap, postagemMap, usuarios);
				home.setVisible(true);
			}
		});
		botaoVoltar.setBounds(751, 703, 85, 37);
		contentPane.add(botaoVoltar);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);
	}
}
