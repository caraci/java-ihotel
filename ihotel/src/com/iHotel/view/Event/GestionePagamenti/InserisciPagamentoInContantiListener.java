/**
 * 
 */
package com.iHotel.view.Event.GestionePagamenti;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Classe che ha il compito di gestire l'evento click sul bottone "Aggiungi pagamento in contanti"
 * nella classe VFG_gestionePagamento
 * @author Alessandro
 *
 */
public class InserisciPagamentoInContantiListener extends MouseAdapter {
	
	//Costruttore
	public InserisciPagamentoInContantiListener(){
		
	}
	/**
	 * Metodo che va ad assegnare una form di inseriemnto alla dialog. Con questa form verranno 
	 * presi in input i dati riguardanti il pagamneto, come la data e l'importo
	 * 
	 * NB va completata la parte di logica
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		JTextField importo = new JTextField();
		JTextField data = new JTextField();
		
		final JComponent[] inputs = new JComponent[] {
				new JLabel("Importo:"),
				importo,
				new JLabel("Data:"),
				data
		};
		JOptionPane.showMessageDialog(null, inputs, "Inserimento pagamento in contanti", JOptionPane.PLAIN_MESSAGE);
		System.out.println("Importo: " +
				importo.getText() + ", " +"Data: "+
				data.getText());
	}
	

}
