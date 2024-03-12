package interface_rede;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Amizade;
import br.edu.ifg.Postagem;
import br.edu.ifg.Rede;
import br.edu.ifg.Usuario;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Feed extends JFrame {

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
					Feed frame = new Feed(null,null,null,null);
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
	public Feed(Usuario usuario, Map<Integer, ArrayList<Amizade>> amigosMap, ArrayList<Usuario> usuarios,Map<Integer, ArrayList<Postagem>> postagemMap) {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 111, 1243, 561);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.BOLD, 20));
		textPane.setBounds(1000, 60, 800, 13);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		ArrayList<String> feed=	Rede.feed(usuario,postagemMap, usuarios);
		 Collections.shuffle(feed);
		 String texto="";
			for(String postagem:feed) {
				texto+=postagem;
			}
			textPane.setText(texto);
		
		JLabel lavelFeed = new JLabel("Feed");
		lavelFeed.setFont(new Font("Tahoma", Font.BOLD, 40));
		lavelFeed.setBounds(222, 38, 287, 38);
		contentPane.add(lavelFeed);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home(usuario, amigosMap, postagemMap, usuarios);
				home.setVisible(true);
			}
		});
		botaoVoltar.setBounds(746, 692, 85, 37);
		contentPane.add(botaoVoltar);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);
	}
}
