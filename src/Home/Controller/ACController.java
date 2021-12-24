package Home.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Home.View.ACView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ACController  {

	ACView obj=new ACView();
	
	
	public void LoadMain(ActionEvent e) throws IOException
	{
		obj.LoadMain(e);
	}

}
