package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroController {

	public static String local_arq = "//home//derekwillyan//Área de Trabalho//Banco de Dados//banco_de_dados.txt";
	
	@FXML
	private TextField nome;
	@FXML
	private TextField email;
	@FXML
	private PasswordField senha;
	@FXML
	private Button cadastrar;
	
	@FXML
	public void onbtnCadastrar() {
		
		String name = nome.getText();
		String emaill = email.getText();
		String password = senha.getText();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(local_arq, true))){
			
			bw.write(String.format("%s, %s, %s", name, emaill, password));
			bw.newLine();
			
		}catch(IOException e) {
			
			e.getStackTrace();
			
			
		}
		
		nome.setText("");
		email.setText("");
		senha.setText("");
		JOptionPane.showMessageDialog(null, String.format("CADASTRO REALIZADO!!!!"), null, JOptionPane.INFORMATION_MESSAGE);
		Main.mudarcena("login");
		
	}
	
}
