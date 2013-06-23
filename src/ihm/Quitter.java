package ihm;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quitter extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton oui = new JButton("Oui");
	private JButton non = new JButton("Non");
	private JPanel framePanel = new JPanel(new FlowLayout());
	private ActionListener listen = new ButtonListener(this);
	private JLabel message = new JLabel("Voulez-vous vraiment quitter ?");
	private JPanel panelButtons = new JPanel();
	
	private MenuPrincipal menuPrincipal;

	
	public Quitter(MenuPrincipal menuPrincipal){
		this.menuPrincipal = menuPrincipal;
		
		oui.setPreferredSize(new Dimension(100,30));
		non.setPreferredSize(new Dimension(100,30));
		
		panelButtons.setLayout(new GridLayout(1,2,50,0));
		panelButtons.add(oui);
		panelButtons.add(non);
		framePanel.add(this.message);
		framePanel.add(panelButtons);
		
		oui.addActionListener(listen);
		non.addActionListener(listen);
		
		this.setResizable(false);
		this.setBounds(200, 200, 350, 100);
		this.setVisible(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Confirmation");
		this.getContentPane().add(framePanel);
	}

	class ButtonListener implements ActionListener{
		Quitter quit;
		
		public ButtonListener(Quitter q){
			quit = q;
		}
		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(oui)){
				System.exit(0);
			} else if(e.getSource().equals(non)){
				quit.dispose();
				menuPrincipal.enable();
				menuPrincipal.toFront();
			}
		
		}
	}
	
}
