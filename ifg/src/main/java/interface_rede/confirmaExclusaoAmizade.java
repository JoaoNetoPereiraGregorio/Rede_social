package interface_rede;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class confirmaExclusaoAmizade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirmaExclusaoAmizade frame = new confirmaExclusaoAmizade();
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
	public confirmaExclusaoAmizade() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setPreferredSize(new Dimension(500, 500));
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        
	        JScrollPane scroll = new JScrollPane();
	        scroll.setPreferredSize(new Dimension(464, 439));

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(0, 1, 10, 10));
	        
	        for(int i = 0; i < 15; i++)
	        {
	            panel.add(gerarButton());
	        }
	        scroll.setViewportView(panel);
	        contentPane.add(scroll);
	        
	        pack();
	    }
	    
	    public JButton gerarButton() {
	        
	        int qtButton=0;
			qtButton++;
	        JButton NewButton = new JButton(String.valueOf(qtButton));
	        return NewButton;
	    }
}
