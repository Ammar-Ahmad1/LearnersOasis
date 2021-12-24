package Home.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="a_students")
public class Student_App {
	@Id
	@Column(name="A_ID")
	private int id;
	@Column(name="name")
	private String Name;
	@Column(name="CNIC")
	private long cnic;
	@Column(name="email")
	private String Email;
	@Column(name="department")
	private int dept;
	@Column(name="mobile_no")
	private long mobileNo;
	public Student_App() {

		Name = "";
		this.cnic = 0;
		Email = "";
		this.dept = 0;
		this.mobileNo = 0;
	}
	public Student_App(String name, long cnic, String email, int dept, long mobileNo) {
	
		Name = name;
		this.cnic = cnic;
		Email = email;
		this.dept = dept;
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return Name;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getCnic() {
		return cnic;
	}
	public void setCnic(long cnic) {
		this.cnic = cnic;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString() {
		return "Student_App [Name=" + Name + ", cnic=" + cnic + ", Email=" + Email + ", dept=" + dept + ", mobileNo="
				+ mobileNo + "]";
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration con=new Configuration();
		con.configure().addAnnotatedClass(Student_App.class);	
		SessionFactory factory=con.buildSessionFactory();
		Session session=factory.openSession();
		Transaction trans=session.beginTransaction();
		
		try {
			
			Student_App s=new Student_App("afra",3420274632015L,"i190678@nu.edu.pk",1,3006243714L);
			
			session.save(s);
			trans.commit();
			
			//Student_App temp=session.get(Student_App.class,5);
			//System.out.println(temp.toString());
			// flag=temp.getDept();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			factory.close();
			session.close();
		}

	}
*/
}