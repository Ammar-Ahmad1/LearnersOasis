package Home.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AdminView implements Initializable {

	
	@FXML
	public void loginLoad(ActionEvent e) throws IOException
	{
		
		FXMLLoader fxmlLoader = new
		FXMLLoader(getClass().getResource("/AdminMenu.fxml"));
        Parent root2;
        root2 = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.setTitle("Creative Campus Teacher");
        stage.show();
        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner); 
        alert.show();
    }
	
	public void LoadMain(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Main.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Creative Campus Teacher");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadRF(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Registration.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Creative Campus Teacher");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadCA(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Course.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Creative Campus Teacher");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadAS(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/AppliedStudents.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Creative Campus Teacher");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadLogout(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Admin.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Creative Campus Teacher");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
