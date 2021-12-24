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
@Table(name="department")
public class Department {
	@Id
	@Column(name="d_id")
	private int DID;
	@Column(name="name")
	private String Dname;
	public Department() {
		DID=0;
		Dname="";
	}
	public Department( String dname) {

		Dname = dname;
	}
	

	public int getDID() {
		return DID;
	}

	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	
	@Override
	public String toString() {
		return "Department [DID=" + DID + ", Dname=" + Dname + "]";
	}
			
						

}
