package com.example.One.to.one.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
//	sinh tự tăng trường ID
	@GeneratedValue(strategy = GenerationType.IDENTITY)
// id trong table Instructor ở SQL	
//	Colum là đặt tên cho bảng trong CSDL
	@Column(name = "id")
	private int id;
// first_name trong table Instructor ở SQL
	@Column(name = "first_name")
	private String firstName;
// last_name trong table Instructor ở SQL	
	@Column(name = "last_name")
	private String lastName;
// email trong table Instructor ở SQL
	@Column(name = "email")
	private String email;
// sử dụng One to one
//	Khai báo quan hệ 1 với 1 
	// cascade = CascadeType.ALL: xử lý toàn bộ, tức là tương tác cả 2 bảng 
	@OneToOne(cascade = CascadeType.ALL)
//	Join vào bảng nào ( với tên trường nào trong bảng )
	@JoinColumn(name = "instructor_detail_id")
//	instructorDetail: là biến ở instructor detail
	private InstructorDetail instructorDetail;

//	dùng để tự động build object
	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
}