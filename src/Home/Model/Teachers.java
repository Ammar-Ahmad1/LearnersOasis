package Home.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="teachers")
public class Teachers {
	@Id
	@Column(name="T_id")
	private int T_id;
	@Column(name="name")
	private String Name;
	@Column(name="CNIC")
	private long cnic;
	@Column(name="dept_id")
	private int d_id;
	
	public Teachers() {
		T_id = 0;
		Name = "";
		this.cnic = 0;
		d_id = 0;	
	}
	public Teachers( String name, long cnic, int d) {
		
		Name = name;
		this.cnic = cnic;
		d_id = d;
	}
	

	public int getT_id() {
		return T_id;
	}

	public String getName() {
		return Name;
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
	public int getCourse() {
		return d_id;
	}
	public void setCourse(int d) {
		d_id=d;
	}
	
	@Override
	public String toString() {
		return "Teachers [T_id=" + T_id + ", Name=" + Name + ", cnic=" + cnic + ", dept=" + d_id + "]";
	}

}
