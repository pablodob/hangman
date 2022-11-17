package ahorcado;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;

public class MyWindow extends JFrame {
	
	private List <JButton> buttons;
	
	private Icon icono;
	private Word my_word;
	
	public MyWindow() {
		
		my_word = new Word();
		
		Dimension d = new Dimension(800,600);
		setMinimumSize(d);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		JPanel panel_letras = new JPanel();
		ct.setLayout(new BorderLayout());
		ct.add(panel_letras, BorderLayout.SOUTH);
		panel_letras.setLayout(new GridLayout(3,9));
		
		buttons = new ArrayList <>();
		
		JLabel imagen = new JLabel();
		ChangeImage(my_word.getAttemnt(), imagen);
		ct.add(imagen, BorderLayout.CENTER);
		
		JLabel label = new JLabel(my_word.getWord());
		Font font = new Font("Arial", Font.BOLD, 40);
		label.setFont(font);
		label.setHorizontalAlignment(NORMAL);
		ct.add(label, BorderLayout.NORTH);		
		
		for (int i=0;i<26;i++) {
			JButton button = new JButton();
			button.setText(String.valueOf((char)('A'+i)));
			button.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					char letter = button.getText().charAt(0);
					my_word.insert_char(letter);
					button.setEnabled(false);
					label.setText(my_word.getWord());
					ChangeImage(my_word.getAttemnt(), imagen);
					if(my_word.isWin()) {
						JOptionPane.showMessageDialog(null, "Esa es la palabra... Ganaste!");
						dispose();
					}
					if(my_word.isLoser()) {
						JOptionPane.showMessageDialog(null, "Perdiste! La palabra era: " + my_word.getWordvisible());
						dispose();
					}
				}
			});
			panel_letras.add(button);
			buttons.add(button);
		}
		
		JButton button = new JButton();
		button.setText(String.valueOf((char)('Ñ')));
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				char letter = button.getText().charAt(0);
				my_word.insert_char(letter);
				button.setEnabled(false);
				label.setText(my_word.getWord());
				ChangeImage(my_word.getAttemnt(), imagen);
				if(my_word.isWin()) {
					JOptionPane.showMessageDialog(null, "Esa es la palabra... Ganaste!");
					dispose();
				}
				if(my_word.isLoser()) {
					JOptionPane.showMessageDialog(null, "Perdiste!");
					dispose();
				}
			}
		});
		panel_letras.add(button);
		buttons.add(button);
		
		for (JButton jButton : buttons) {
			panel_letras.add(jButton);
		}
	}
	
	private void ChangeImage(int intento, JLabel img) {
		switch (intento) {
		case 0:
			icono = new ImageIcon((new ImageIcon(this.getClass().getResource("/ahorcado/0.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			img.setIcon(icono);
			break;
		case 1:
			icono = new ImageIcon((new ImageIcon(this.getClass().getResource("/ahorcado/1.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			img.setIcon(icono);
			break;
		case 2:
			icono = new ImageIcon((new ImageIcon(this.getClass().getResource("/ahorcado/2.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			img.setIcon(icono);
			break;
		case 3:
			icono = new ImageIcon((new ImageIcon(this.getClass().getResource("/ahorcado/3.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			img.setIcon(icono);
			break;
		case 4:
			icono = new ImageIcon((new ImageIcon(this.getClass().getResource("/ahorcado/4.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			img.setIcon(icono);
			break;
		case 5:
			icono = new ImageIcon((new ImageIcon(this.getClass().getResource("/ahorcado/5.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			img.setIcon(icono);
			break;
		case 6:
			icono = new ImageIcon((new ImageIcon(this.getClass().getResource("/ahorcado/6.png")).getImage().getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH)));
			img.setIcon(icono);
			break;
		}
	}
	
	/* obsolete
	private void DisableAllButton() {
		for (JButton jButton : buttons) {
			jButton.setEnabled(false);
		}
	}*/
}
