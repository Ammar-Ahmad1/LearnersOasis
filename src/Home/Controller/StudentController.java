package Home.Controller;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import Home.Model.Course;
import Home.Model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
class InvalidNumber  extends Exception  
{  
    public InvalidNumber (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
}  

public class StudentController implements Initializable {

	@FXML
	TextField t1;
	@FXML
	TextField t2;
	@FXML
	TextField t3;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void InfoSetter(ActionEvent e) throws InvalidNumber
	{
		String text1=t1.getText();
		if(!text1.matches("^[0-9]*$"))
			throw new InvalidNumber("String doesnot contains numbers");
			
		int number = 0;
		try{
             number = Integer.parseInt(text1);
            System.out.println(number); // output = 25
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		Properties properties = new Properties();
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty(Environment.HBM2DDL_AUTO,"update");
		properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/learnersoasis");
		Configuration con=new Configuration();
		
		con.configure().addAnnotatedClass(Student.class);
		con.configure().addAnnotatedClass(Course.class);
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		Query query = session.createQuery("select s.Name ,d.CourseNo  from Student s,Course d where s.Course=d.CourseNo and s.id = '"+ number+"'");
		List qryResults = query.getResultList();
		Iterator iter=qryResults.iterator();
		Object[] obj = null;
		while(iter.hasNext())
		{
		     obj=(Object[]) iter.next();
			
		}
		t2.setText((String) obj[0]);
		t3.setText((String) obj[1]);
		
		
		
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

}
