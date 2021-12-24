package Home.Model;

import javax.persistence.*;


@Entity
@Table(name="r_students")
public class Student {
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="name")
	private String Name;
	@Column(name="CNIC")
	private long cnic;
	@Column(name="email")
	private String Email;
	@Column(name="course")
	private String Course;
	@Column(name="mobile_no")
	private long mobileNo;
	public Student(String name, long cnic, String email, String course, long mobileNo) {
		this.Name = name;
		this.cnic = cnic;
		Email = email;
		this.Course = course;
		this.mobileNo = mobileNo;
	}
	public Student() {
		this.Name ="";
		this.cnic = 0;
		Email = "";
		this.Course = "";
		this.mobileNo = 0;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
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
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		this.Course = course;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + Name + ", cnic=" + cnic + ", Email=" + Email + ", course=" + Course
				+ ", mobileNo=" + mobileNo + "]";
	}
	
}
