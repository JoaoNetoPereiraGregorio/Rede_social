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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Amizade;
import br.edu.ifg.Postagem;
import br.edu.ifg.Rede;
import br.edu.ifg.Usuario;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CriarPostagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  Usuario usuario;
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
					CriarPostagem frame = new CriarPostagem(null,null,null,null);
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
	public CriarPostagem(Usuario usuario, Map<Integer, ArrayList<Amizade>> amigosMap, Map<Integer, ArrayList<Postagem>> postagemMap,ArrayList<Usuario> usuarios) {
		this.usuario=usuario;
		this.amigosMap=amigosMap;
		this.postagemMap=postagemMap;
		this.usuarios=usuarios;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1540, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(439, 294, 663, 240);
		getContentPane().add(scrollPane);
		
		JTextArea inputConteudo = new JTextArea();
		inputConteudo.setWrapStyleWord(true);
		inputConteudo.setLineWrap(true);
		scrollPane.setViewportView(inputConteudo);
		
		JLabel lblNewLabel = new JLabel("Postagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(222, 55, 287, 49);
		getContentPane().add(lblNewLabel);
		
		JButton botaoCriaPostagem = new JButton("Criar Postagem");
		botaoCriaPostagem.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoCriaPostagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputConteudo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o conteúdo da postagem!");
					JOptionPane.showMessageDialog(null, usuario.getId());
				}else {
					try {
						Rede.adicionaPostagem(postagemMap, usuario.getId(), inputConteudo.getText());
						JOptionPane.showMessageDialog(null, "Postagem Criada!");
						dispose();
						Home home = new Home(usuario, amigosMap, postagemMap,usuarios);
						home.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
				
		});
		botaoCriaPostagem.setBounds(687, 598, 184, 37);
		getContentPane().add(botaoCriaPostagem);
		
		JLabel lblNewLabel_1 = new JLabel("Conteúdo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(439, 225, 184, 49);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);
	}

}
