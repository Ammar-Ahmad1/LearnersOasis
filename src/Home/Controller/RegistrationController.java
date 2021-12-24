package Home.Controller;
import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import Home.Model.Course;
import Home.Model.Student;
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

public class RegistrationController implements Initializable{
	ObservableList<String> DeptList=FXCollections.observableArrayList();
	@FXML TextField t1;
	@FXML TextField t2;
	@FXML TextField t3;
	@FXML TextField t4;
	@FXML
	private ChoiceBox<String> dept;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty(Environment.HBM2DDL_AUTO,"update");
		properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/learnersoasis");
		Configuration con=new Configuration();
		con.configure().addAnnotatedClass(Course.class);	
		SessionFactory factory=con.buildSessionFactory();
		
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Query query = session.createQuery("select e.CourseNo from Course e");

		List qryResults = query.getResultList();
		DeptList.addAll(qryResults);
		System.out.println(DeptList);
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
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty(Environment.HBM2DDL_AUTO,"update");
		properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/learnersoasis");
		
		Configuration cfg= new Configuration();
		cfg.setProperties(properties);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory=cfg.buildSessionFactory();
		Session session= factory.openSession();
		
		try {
			Transaction tr=session.beginTransaction();
			long tem=Long.parseLong(t3.getText());
			long tem1=Long.parseLong(t4.getText());
			
			Student s=new Student(t1.getText(),tem,t2.getText(),dept.getValue(),tem1);
			session.persist(s);
			System.out.println("saved");
			
			tr.commit();
						
		}catch(Exception e1){
			e1.printStackTrace();
		}finally {
			factory.close();
			session.close();
		}

	}
	

}
