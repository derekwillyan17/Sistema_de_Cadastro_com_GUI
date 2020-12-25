package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private TextField email;
	@FXML
	private PasswordField senha;
	@FXML
	private Button login;
	@FXML
	private Button cadastrar;
	
	@FXML
	public void onbtnLogin() {
		
		String email1 = this.email.getText();
		String senha1 = this.senha.getText();
		
		try (BufferedReader br = new BufferedReader(new FileReader(CadastroController.local_arq))){
			
			String line = br.readLine();
			
			if(line == null) {
				
				JOptionPane.showMessageDialog(null, String.format("EMAIL OU SENHA INCORRETOS!!!!"),null,JOptionPane.INFORMATION_MESSAGE);
				
			} else {
				
				int aux1 = 0, aux2 = 0;
				
				while(line != null){
					
					String[] dados = line.split(", ");
					
					if(email1.equals(dados[1]) && senha1.equals(dados[2])) {
						
						JOptionPane.showMessageDialog(null, String.format("SUCESSO!!!!"),null,JOptionPane.INFORMATION_MESSAGE);
						
					} else {
						
						aux1 += 1;
						
					}
					
					aux2 += 1;
					line = br.readLine();
			
				}
				
				if (aux1 == aux2) {
					
					JOptionPane.showMessageDialog(null, String.format("EMAIL OU SENHA INCORRETOS!!!!"),null, JOptionPane.INFORMATION_MESSAGE);
					
				}
			
			}
			
		} catch(IOException e) {
			
			e.getStackTrace();			
			
		}
		
		email.setText("");
		senha.setText("");
		
	}
	
	@FXML
	public void onbtnCadastro() {
		
		Main.mudarcena("cadastro");
		
	}
	
}
