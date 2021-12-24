package Home.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import Home.Model.Course;
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

public class CourseController implements Initializable{
	ObservableList<String> DeptList=FXCollections.observableArrayList("ComputerScience","Accounting And Finance","ElectricalEnigeneering");
	@FXML
	private ChoiceBox<String> dept;
	@FXML TextField t1;
	@FXML TextField t2;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initialize();
	}
	@FXML
	public void initialize()
	{
		// TODO Auto-generated method stub
				// dept.setValue("CS");
				dept.getItems().addAll(DeptList);
	}
	@FXML
	public void LoadMain(ActionEvent e) throws IOException
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
	@FXML
	public void InfoGetter(ActionEvent e) throws IOException
	{
		if(!t1.getText().isEmpty())
		{
			if(!t2.getText().isEmpty())
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
					cfg.addAnnotatedClass(Course.class);
					SessionFactory factory=cfg.buildSessionFactory();
					Session session= factory.openSession();
					
					try {
						Transaction tr=session.beginTransaction();
						int d=3;
						if(dept.getValue()=="ComputerScience")
							d=1;
						else if(dept.getValue()=="Accounting And Finance")
							d=2;
						Course s=new Course(t2.getText(),t1.getText(),d);
						session.persist(s);
						System.out.println("saved");
						
						tr.commit();
									
					}catch(Exception e1){
						e1.printStackTrace();
					}finally {

						showAlert(Alert.AlertType.CONFIRMATION, (((Node) e.getSource()).getScene().getWindow()), "Info!", "Info Saved");
						factory.close();
						session.close();
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
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}
