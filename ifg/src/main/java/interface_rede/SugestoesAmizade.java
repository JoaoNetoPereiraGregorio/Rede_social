package interface_rede;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Amizade;
import br.edu.ifg.Postagem;
import br.edu.ifg.Rede;
import br.edu.ifg.Usuario;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class SugestoesAmizade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Map<Integer, ArrayList<Amizade>> amigosMap = new HashMap<Integer, ArrayList<Amizade>>();
	private Usuario usuario;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private   Map<Integer, ArrayList<Postagem>> postagemMap = new HashMap<Integer, ArrayList<Postagem>>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SugestoesAmizade frame = new SugestoesAmizade(null,null,null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SugestoesAmizade(Usuario usuario, Map<Integer, ArrayList<Amizade>> amigosMap, ArrayList<Usuario> usuarios,Map<Integer, ArrayList<Postagem>> postagemMap) throws SQLException {
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

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home(usuario, amigosMap, postagemMap, usuarios);
				home.setVisible(true);
			}
		});
		botaoVoltar.setBounds(680, 682, 85, 37);
		contentPane.add(botaoVoltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 75, 1033, 571);
		contentPane.add(scrollPane);

		JPanel textoAreaAmigos = new JPanel();
		scrollPane.setViewportView(textoAreaAmigos);
		textoAreaAmigos.setLayout(new GridLayout(0, 2, 10, 10));
		

//		JButton botaoFazer = new JButton("New button");
//		botaoFazer.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		botaoFazer.setBounds(711, 62, 85, 21);
//		textoAreaAmigos.add(botaoFazer);

		ArrayList<Usuario> naoAmigos = Rede.sugestoesAmizade(usuarios, amigosMap, usuario.getId());
		if (naoAmigos == null) {
			textoAreaAmigos.setFont(new Font("Arial", Font.BOLD, 45));
			textoAreaAmigos.setForeground(Color.BLACK);
			JLabel labelSemAmigo = new JLabel("Sem sugestões!");
			labelSemAmigo.setBounds(200, 150, 800, 200);
			labelSemAmigo.setFont(new Font("Arial", Font.BOLD, 45));
			textoAreaAmigos.add(labelSemAmigo);
			

		} else {
		//	textoAreaAmigos.setFont(new Font("Arial", Font.PLAIN, 25));
			int l = 0;
			int b = 0;
			for (Usuario item : naoAmigos) {
				JLabel labelAmigo = new JLabel("          Nome de Usuário:  " + item.getNomeUsuario());
				labelAmigo.setBounds(30, 43 + l, 500, 58);
				labelAmigo.setFont(new Font("Arial", Font.BOLD, 15));
				textoAreaAmigos.add(labelAmigo);
				JButton botaoFazer = new JButton("Fazer");
				botaoFazer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Rede.addAmizade(usuarios, amigosMap, usuario.getId(), item.getId());
							JOptionPane.showMessageDialog(null,
									"Você fez amizade com " + item.getNomeUsuario());
							dispose();
							SugestoesAmizade sugestoes= new SugestoesAmizade(usuario, amigosMap, usuarios, postagemMap);
							sugestoes.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				botaoFazer.setBounds(900, 60 + b, 150,15);
				textoAreaAmigos.add(botaoFazer);
				
				l += 60;
				b += 60;

			}
			// textoAreaAmigos.setText(msg);

		}
		

		JLabel lblNewLabel = new JLabel("Sugestões de Amizade");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(222, 10, 828, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);

	}
}
