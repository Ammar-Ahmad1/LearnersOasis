package Home.Controller;
import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import Home.Model.Student_App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
class InvalidInput  extends Exception  
{  
    public InvalidInput (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  

public class AppController implements Initializable{

	@FXML
	private ChoiceBox<String> dept;
	@FXML TextField t1;
	@FXML TextField t2;
	@FXML TextField t3;
	@FXML TextField t4;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initialize();
	}
	
	ObservableList<String> getDepartments() {
		return FXCollections.observableArrayList("ComputerScience","Accounting And Finance","ElectricalEnigeneering");	
	}
	@FXML
	public void initialize()
	{
		
		dept.getItems().addAll(getDepartments());
	}
	
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
	
	@FXML
	public void InfoGetter(ActionEvent e) throws IOException,SQLException,InvalidInput,InvalidNumber
	{
		String text1=t1.getText();
		if(!text1.matches("^[a-z]*$"))
			throw new InvalidInput("String doesnot contains Alphabets");
		String text2=t3.getText();
		if(!text2.matches("^[0-9]*$"))
			throw new InvalidInput("CNIC doesnot contains Numbers");
		String text3=t4.getText();
		if(!text3.matches("^[0-9]*$"))
			throw new InvalidInput("Mobile# doesnot contains Numbers");
		
		//dept.setValue("");
		System.out.print(t1.getText().isEmpty()&&t2.getText().isEmpty()&&t3.getText().isEmpty()&&t4.getText().isEmpty());
		if(!(t1.getText().isEmpty()&&t2.getText().isEmpty()&&t3.getText().isEmpty()&&t4.getText().isEmpty()))
		{
			if(!t2.getText().isEmpty())
			{
				if(!t3.getText().isEmpty())
				{
					if(!t4.getText().isEmpty())
					{
						if(dept.getValue()!=null)
						{
							Properties properties = new Properties();
							properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
							properties.setProperty(Environment.HBM2DDL_AUTO,"update");
							properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
							properties.setProperty(Environment.USER, "root");
							properties.setProperty(Environment.PASS, "");
							properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/learnersoasis");
							
							Configuration cfg= new Configuration();
							cfg.setProperties(properties);
							cfg.addAnnotatedClass(Student_App.class);
							SessionFactory factory=cfg.buildSessionFactory();
							Session session= factory.openSession();
							
							try {
								int d=3;
								if(dept.getValue()=="ComputerScience")
									d=1;
								else if(dept.getValue()=="Accounting And Finance")
									d=2;
								Transaction tr=session.beginTransaction();
								long tem=Long.parseLong(t3.getText());
								long tem1=Long.parseLong(t4.getText());
								
								Student_App s=new Student_App(t1.getText(),tem,t2.getText(),d,tem1);
								session.persist(s);
								System.out.println("saved");
								
								tr.commit();
											
							}catch(Exception e1){
								e1.printStackTrace();
							}finally {
								factory.close();
								session.close();
								showAlert(Alert.AlertType.CONFIRMATION, (((Node) e.getSource()).getScene().getWindow()), "Info!", "Info Saved");
							}
						}
						else
						{
								showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
								
								
						}
							
						}
						else
						{
							showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
							
							
						}
						
					}
					else
					{
						showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
						
						
					}
					
				}
				else
				{
					showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
					
					
				}
				
			}
			else
			{
				showAlert(Alert.AlertType.ERROR, (((Node) e.getSource()).getScene().getWindow()), "Info Error!", "Please enter All information");
				
				
			}
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		dept.setValue("");
		}
		


				
	
	
	 private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.initOwner(owner);
	        alert.show();
	    }
}
