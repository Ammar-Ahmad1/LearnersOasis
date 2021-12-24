package Home.Model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@Column(name="course_no")
	private String CourseNo;
	@Column(name="name")
	private String Name;
	@Column(name="dept_id")
	private int dept;
	public Course() {
		CourseNo = "";
		Name = "";
		this.dept = 0;	
	}
	public Course(String courseNo, String name, int dept) {
		CourseNo = courseNo;
		Name = name;
		this.dept = dept;
	}

	public String getCourseNo() {
		return CourseNo;
	}
	public void setCourseNo(String courseNo) {
		CourseNo = courseNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Course [CourseNo=" + CourseNo + ", Name=" + Name + ", dept=" + dept + "]";
	}
	


}
