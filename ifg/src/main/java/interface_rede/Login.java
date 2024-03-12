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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Amizade;
import br.edu.ifg.Postagem;
import br.edu.ifg.Rede;
import br.edu.ifg.Usuario;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputNomeUsuario;
	private JTextField inputSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1540, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));

		setContentPane(contentPane);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Map<Integer, ArrayList<Amizade>> amigosMap = new HashMap<Integer, ArrayList<Amizade>>();
		Map<Integer, ArrayList<Postagem>> postagemMap = new HashMap<Integer, ArrayList<Postagem>>();
		try {
			Rede.preencheUsuarios(usuarios);
			Rede.preenchePostagemMap(postagemMap);
			Rede.preencheAmigosMap(amigosMap, usuarios);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.setLayout(null);
		
		
		
		inputNomeUsuario = new JTextField();
		inputNomeUsuario.setBounds(719, 227, 370, 37);
		getContentPane().add(inputNomeUsuario);
		inputNomeUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome Usuário:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(442, 222, 170, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(442, 345, 170, 37);
		getContentPane().add(lblNewLabel_1);
		
		inputSenha = new JTextField();
		inputSenha.setBounds(719, 349, 370, 37);
		getContentPane().add(inputSenha);
		inputSenha.setColumns(10);
		
		JButton botaoLogin = new JButton("Login");
		botaoLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inputNomeUsuario.getText().isEmpty() && inputSenha.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Nome de Usuário ou Senha Vazios!" );
				}else {
				
				String nomeUsuario= inputNomeUsuario.getText();
				String senha= inputSenha.getText();
				Usuario usuario= Rede.realizaLogin(usuarios, nomeUsuario, senha);
				if(usuario==null) {
					JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
				}else {
					Home home= new Home(usuario, amigosMap, postagemMap,usuarios);
					home.setVisible(true);
					setVisible(false);
				}
				}
			}
		});
		botaoLogin.setBounds(431, 503, 146, 37);
		getContentPane().add(botaoLogin);
		
		JButton botaoCadastro = new JButton("Fazer Cadastro");
		botaoCadastro.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroUsuario cadastroUsuario= new CadastroUsuario(usuarios);
				cadastroUsuario.setVisible(true);
				dispose();
			    
			}
		});
		botaoCadastro.setBounds(948, 503, 184, 37);
		getContentPane().add(botaoCadastro);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_2.setBounds(222, 38, 571, 94);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(653, 306, 269, 0);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(431, 306, 706, 42);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);
	}
}
