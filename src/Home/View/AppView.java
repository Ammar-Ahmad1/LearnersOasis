package Home.View;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AppView implements Initializable {
	@FXML
	public ChoiceBox<String> dept;
	@FXML TextField t1;
	@FXML TextField t2;
	@FXML TextField t3;
	@FXML TextField t4;
	@FXML
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
	
	ObservableList<String> getDepartments() {
		return FXCollections.observableArrayList("ComputerScience","Accounting And Finance","ElectricalEnigeneering");	
	}
	
	public void setData(ObservableList<String> list)
	{
		dept.getItems().addAll(list);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
