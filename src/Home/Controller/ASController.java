package Home.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import Home.Model.Department;
import Home.Model.Student_App;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ASController implements Initializable {
	
	@FXML TableView<Student_App> Student;
	@FXML TableView<String> dpt;
	@FXML TableColumn<Student_App,Integer> SID;
	@FXML TableColumn<Student_App,String> Name;
	@FXML TableColumn<Student_App,Long> Cnic;
	@FXML TableColumn<Student_App,Long> MobNo;
	@FXML TableColumn<Student_App,String> EID;
	@FXML TableColumn<String,String> Dept;
	public ObservableList<Student_App> data=FXCollections.observableArrayList();
	public ObservableList<String> data1=FXCollections.observableArrayList();
	/*
	public ObservableList<Students> list = FXCollections.observableArrayList(
			new Students(1, "Nava", "nava", 2),
			new Students(2, "Fahim", "fahim", 9),
			new Students(3, "Shariful", "Islam", 25)
			);
	*/
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty(Environment.HBM2DDL_AUTO,"update");
		properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/learnersoasis");
		Configuration con=new Configuration();
		
		con.configure().addAnnotatedClass(Student_App.class);
		con.configure().addAnnotatedClass(Department.class);
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		
		/*Configuration con1=new Configuration();
		con.configure().addAnnotatedClass(Department.class);	
		SessionFactory factory1=con1.buildSessionFactory();
		Session session1=factory1.openSession();
		Transaction trans1=session1.beginTransaction();*/
		
		Query query = session.createQuery(" from Student_App ");
		
		//Query query1=session1.createQuery(" from Department e");
	
		List qryResults = query.getResultList();
		
		Query query1=session.createQuery("select e.dept from Student_App e");
		
		List qryResults1 = query1.getResultList();
		//System.out.println(qryResults1);
		data.addAll(qryResults);
		SID.setCellValueFactory(new PropertyValueFactory<Student_App,Integer>("id"));
		Name.setCellValueFactory(new PropertyValueFactory<Student_App,String>("Name"));
		Cnic.setCellValueFactory(new PropertyValueFactory<Student_App,Long>("cnic"));
		MobNo.setCellValueFactory(new PropertyValueFactory<Student_App,Long>("mobileNo"));
		EID.setCellValueFactory(new PropertyValueFactory<Student_App,String>("Email"));
		Dept.setCellValueFactory(c->(new ReadOnlyStringWrapper(c.getValue())));
		Iterator iter=qryResults.iterator();
		Iterator iter1=qryResults1.iterator();
		while(iter1.hasNext()) {
		Department temp=session.get(Department.class,(int)iter1.next());
		System.out.println(temp.getDname());
		data1.add(temp.getDname());
		}
		Student.getItems().setAll((data));
		dpt.getItems().setAll(data1);
		
		
		
	//	List qryResults1 = query1.getResultList();
		//System.out.println(qryResults);
	//	System.out.println(qryResults1);
		
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
		
}
