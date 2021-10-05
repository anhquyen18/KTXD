package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("TrangChu.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Bài tập về nhà KTXD");
			Image icon = new Image("F:\\Programming\\LearnJavaFX\\KTXD1\\Logo.png");
			stage.getIcons().add(icon);
			stage.setOnCloseRequest(event -> {
				event.consume();
				logout(stage);
			});
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void logout(Stage stage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		
		alert.setTitle("Thoát");
		alert.setHeaderText("Bạn có thực sự muốn thoát?");
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage.close();
		}
	}
}
