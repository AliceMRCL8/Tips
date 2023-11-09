package application;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//public class VueController implement initialisable {
public class VueController {
	@FXML
	private Button btnCalcul;
	@FXML
	private TextField intBill;
	@FXML
	private TextField intTips;
	@FXML
	private TextField intNbrPeople;
	@FXML
	private Label totalParPers;
	@FXML
	private Label totalTipsPers;
	@FXML
	private Label Erreur;
	@FXML
	private TextField date;
	

	
	@FXML
	public void ClickMe(ActionEvent e) {
		float b =0;
		float t =0;
		float n =0;
		try {
			b = Float.parseFloat(intBill.getText());
			t = Float.parseFloat(intTips.getText());
			n = Float.parseFloat(intNbrPeople.getText());
			zero (b,t,n);
			negatif (b,t,n);

			//creation + calcul des nombres
			float tpp = (b+(b/t))/n;
			float ttp = (b/t)/n;
			//transformer les float en string
			String tpp1 = Float.toString(tpp);
			String ttp1 = Float.toString(ttp);
			//afficher les strings
			totalParPers.setText(tpp1+" €");
			totalTipsPers.setText(ttp1+" €");
			
			WriteFichier(date,b,t,n);
			
		}catch(NumberFormatException e1) {
			Erreur.setText("rentrer des numeros");
		}catch(IllegalStateException e1) {
			Erreur.setText(e1.getMessage());
		}
	
	}
	
	public void zero(float t,float b,float c) 
		throws IllegalStateException {
			if ((t == 0)||(b == 0 )||(c == 0)) {
				throw new IllegalStateException
				("les champs doivent etre supérieur à 0");

			}
		}
	
	public void negatif (float t,float b,float c) 
		throws IllegalStateException {
			if ((t <= 0)||(b <= 0 )||(c <= 0)) {
				throw new IllegalStateException
				("les champs ne peuvent pas etre négatif");
				}
		}
	
	public static void WriteFichier(TextField date,float t,float b,float c) {
		try {
				FileWriter writer = new FileWriter("monFichier.txt");
				writer.write(date.getText() +";"+ b +";"+ t +";"+c);
				writer.write("\n");
				writer.close();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
	}

	
	
}
