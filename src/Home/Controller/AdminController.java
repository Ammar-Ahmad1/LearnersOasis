package Home.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Home.Model.AuthTypes;
import Home.View.AdminView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AdminController  {

	AdminView obj=new AdminView();
	
	@FXML
	TextField user;
	@FXML
	TextField pass;
	@FXML
	Label l1;
	@FXML
	GridPane gridPane;
	@FXML
	void CheckingLogin(ActionEvent e) throws IOException
	{
		String text1=user.getText();
		String text2=pass.getText();
		AuthTypes a=login(text1,text2);
		
		if(a==AuthTypes.LoginSucces)
		{
			obj.loginLoad(e);
		}
		else if(a==AuthTypes.PasswordFailed)
		{
			obj.showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "LogIn Error!", "Please enter correct password");
		}
		else if(a== AuthTypes.UserNameFailed)
		{
			obj.showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "LogIn Error!", "Please enter correct userName");
			
		}
			
		
		
	}
	
	public AuthTypes login(String username, String password) {
		if("afrasyab".equals(username)||"ammar".equals(username)||"abdullah".equals(username))
		{
			if("1234".equals(password))
			{
				return AuthTypes.LoginSucces;
			}
			else
			{
				return AuthTypes.PasswordFailed;
			}
		}
		else
		{
			return AuthTypes.UserNameFailed;
		}
	}
	
	 
	public void LoadMain(ActionEvent e) throws IOException
	{
		obj.LoadMain(e);
	}
	
	public void LoadRF(ActionEvent e) throws IOException
	{
		obj.LoadRF(e);
	}
	public void LoadCA(ActionEvent e) throws IOException
	{
		obj.LoadCA(e);
	}
	
	public void LoadAS(ActionEvent e) throws IOException
	{
		obj.LoadAS(e);
	}

	public void LoadLogout(ActionEvent e) throws IOException
	{
		obj.LoadLogout(e);
	}
	
	
}
