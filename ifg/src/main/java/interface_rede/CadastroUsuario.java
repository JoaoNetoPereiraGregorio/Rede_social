package interface_rede;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.ifg.Rede;
import br.edu.ifg.Usuario;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class CadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inputNomeCompleto;
	private JTextField inputNomeUsuario;
	private JTextField inputSenha;
	private ArrayList<Usuario> usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario(null);
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
	public CadastroUsuario(ArrayList<Usuario> usuarios) {
		this.usuarios=usuarios;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1540, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNomeCompleto = new JLabel("Nome Completo");
		labelNomeCompleto.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelNomeCompleto.setBounds(439, 225, 229, 32);
		getContentPane().add(labelNomeCompleto);

		JLabel labelNomeUsuario = new JLabel("Nome Usuário");
		labelNomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelNomeUsuario.setBounds(439, 347, 243, 32);
		getContentPane().add(labelNomeUsuario);

		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelSenha.setBounds(439, 463, 266, 44);
		getContentPane().add(labelSenha);

		inputNomeCompleto = new JTextField();
		inputNomeCompleto.setBounds(719, 227, 370, 37);
		getContentPane().add(inputNomeCompleto);
		inputNomeCompleto.setColumns(10);

		inputNomeUsuario = new JTextField();
		inputNomeUsuario.setBounds(719, 349, 370, 37);
		getContentPane().add(inputNomeUsuario);
		inputNomeUsuario.setColumns(10);

		inputSenha = new JTextField();
		inputSenha.setBounds(719, 471, 370, 37);
		getContentPane().add(inputSenha);
		inputSenha.setColumns(10);

		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (inputNomeCompleto.getText().isEmpty() && inputNomeUsuario.getText().isEmpty()
						&& inputSenha.getText().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Nome completo, nome de usuário ou senha Vazios!");
				} else {
					
						try {
							 Rede.cadastraUsuario(usuarios, inputNomeCompleto.getText(), inputNomeUsuario.getText(),
									inputSenha.getText());
							 
									JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
									dispose();
									Login login;
									login = new Login();
									login.setVisible(true);
									
									
								
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
					}
				
				
			}
		});
		botaoCadastrar.setBounds(668, 590, 123, 37);
		getContentPane().add(botaoCadastrar);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(222, 55, 308, 49);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(431, 306, 706, 42);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(431, 432, 706, 42);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\joaon\\Downloads\\if (2).png"));
		lblNewLabel_3.setBounds(10, 10, 92, 138);
		contentPane.add(lblNewLabel_3);
	}
}
