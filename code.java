import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import com.deepl.api.TextResult;
import com.deepl.api.Tradutor;
import com.deepl.api.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Tradutor {

	private static JLabel texto1;
	private static JLabel texto2;

	public static void main(String[] args) {

		JFrame window = new JFrame("Polylingo");
		ImageIcon icone = new ImageIcon("C:/Users/Administrator/Documents/Meus Aplicativos/Tradutor - Programa/Tradutor/tradutor.png");
		JTextField campo = new JTextField(10);
		texto1 = new JLabel("Digite a palavra que deseja tradução");
		texto2 = new JLabel("");
		JButton botom = new JButton("Tradução");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.getContentPane().setBackground(Color.black);
		window.setIconImage(icone.getImage());
		window.setResizable(false);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		window.setLayout(null);
		window.add(campo);
		window.add(texto1);
		window.add(botom);
		texto1.setForeground(Color.white);
		texto1.setFont(new Font("Verdana", Font.PLAIN, 15));
		texto1.setBounds(120, 100, 400, 30);
		campo.setBounds(50, 150, 400, 30);
		botom.setBounds(200, 200, 100, 30);
		

		botom.addActionListener(new java.awt.event.ActionListener() {
			

			public void actionPerformed(java.awt.event.ActionEvent evt) {

				try {
					String mensagem = campo.getText();
					if(mensagem == null || mensagem.trim().isEmpty()) {
						JOptionPane.showMessageDialog(window, "Favor digitar algo");
						return;
					}
						
					API api = new API();
					String traducao = api.traduzirTexto(mensagem);
					texto2.setText("<html><p style=\"width:300px\">"+ traducao +"</p></html>");
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(window, "Erro ao traduzir o texto.");
				}

			}
		

		});
		
		window.add(texto2);
		texto2.setFont(new Font("Verdana", Font.PLAIN, 10));
		texto2.setBounds(30,350,400,100);
		texto2.setForeground(Color.WHITE);
		texto2.setVerticalAlignment(SwingConstants.TOP);
		
		
	}
}
