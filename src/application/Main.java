package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage stage;
	public static Scene loginScene, cadastroScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {

			stage = primaryStage;
			
			Parent FXMLlogin = FXMLLoader.load(getClass().getResource("/GUI/Login.fxml"));
			loginScene = new Scene(FXMLlogin);
			
			Parent FXMLcadastro = FXMLLoader.load(getClass().getResource("/GUI/Cadastro.fxml"));
			cadastroScene = new Scene(FXMLcadastro);
			
			primaryStage.setScene(loginScene);
			primaryStage.show();
			primaryStage.setTitle("Acesso - Login");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void mudarcena(String op) {

		switch(op) {
		
			case "login":
				stage.setScene(loginScene);
				stage.show();
				stage.setTitle("Acesso - Login");
				
				break;
			case "cadastro":
				stage.setScene(cadastroScene);
				stage.show();
				stage.setTitle("Cadastro");
				break;
			default:
				break;
		
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
