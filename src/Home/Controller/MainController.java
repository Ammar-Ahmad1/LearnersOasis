package Home.Controller;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@FXML
	TextField tfText;
	private Thread dateThread;
    private DateFormat df = new SimpleDateFormat("hh:mm:ss");
    
    boolean isRunning = true;
    private final StringProperty twoWayInput = new SimpleStringProperty("");
    public void Dispose()
    {
     isRunning = false;

    }

    public String getTwoWayInput()
    {
        return twoWayInput.get();
    }

    public StringProperty twoWayInputProperty()
    {
        return twoWayInput;
    }

    public void setTwoWayInput(String twoWayInput)
    {
        this.twoWayInput.set(twoWayInput);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 tfText.textProperty().bindBidirectional(twoWayInputProperty());

	        dateThread = new Thread(this::handleThread);
	        dateThread.start();
	}
	private void handleThread()
    {
        while (isRunning)
        {
            String dateStr = ("current time: " + df.format(new Date()));

            //Switches to the GUI thread
            Platform.runLater(() -> {
                setTwoWayInput(dateStr);
            });


            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException iex)
            {

            }
        }
    }
	public void LoadAchievement(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/acheivements.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Acheivements");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadAC(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/calender.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Academic Calendar");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	public void LoadAdmin(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Admin.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Admin Portal");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadAdmission(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/admission.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Addmission schedule");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadAO(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/ApplyOnline.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Application portal");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	public void LoadAU(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/AboutUs.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS About US");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadTF(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/tutionfees.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Fees Structure");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadFaculty(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Faculty.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Faculty Information");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadTeacher(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Teacher.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Teachers Searching Portal");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	
	public void LoadStudent(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Student.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Studenty Searching Portal");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	public void LoadSociety(ActionEvent e) throws IOException
	{
		FXMLLoader fxmlLoader = new
		           FXMLLoader(getClass().getResource("/Society.fxml"));
		          Parent root2;
		           root2 = (Parent)fxmlLoader.load();
		          Stage stage = new Stage();
		          stage.setScene(new Scene(root2));
		           stage.setTitle("Learners OASIS Societies Information");
		        stage.show();
		        ((Node)(e.getSource())).getScene().getWindow().hide();
	}
	public void loadFB(ActionEvent e) throws IOException
	{
		try {
	        String url = "https://www.google.com";
	        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	    } catch (java.io.IOException a) {
	        System.out.println(a.getMessage());
	    }
	}
	
	public void loadLB(ActionEvent e) throws IOException
	{
		try {
	        String url = "https://learningoasisschool.com/";
	        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
	    } catch (java.io.IOException a) {
	        System.out.println(a.getMessage());
	    }
	}
}
