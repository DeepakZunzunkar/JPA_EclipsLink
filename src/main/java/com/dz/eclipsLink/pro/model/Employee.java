package com.dz.eclipsLink.pro.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.dz.eclipsLink.pro.utility.Constant.Gender;

@Entity
@Table(name="AdpEmployee",schema="EMPRDEV")
public class Employee {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long eid;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
//    @Enumerated(EnumType.STRING)
    @Column(name="GENDER")
    private String gender;

//    @Enumerated(EnumType.STRING)
    @Column(name="STATUS")
    private String status;

    @Embedded
    	@AttributeOverrides({
    		@AttributeOverride(name="createdOn",column=@Column(name="CREATEDON",updatable= false))
    	})
    private BaseProperties baseProperties;
    
    @Temporal(TemporalType.DATE)
    private Date birthDate;
//    
//    @Transient
//    private Integer age;

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
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


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BaseProperties getBaseProperties() {
		return baseProperties;
	}

	public void setBaseProperties(BaseProperties baseProperties) {
		this.baseProperties = baseProperties;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

//	public Integer getAge() {
//		return age;
//	}
//
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
//				+ ", status=" + status + ", baseProperties=" + baseProperties + ", birthDate=" + birthDate + ", age="
//				+ age + "]";
//	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", status=" + status + ", baseProperties=" + baseProperties + "]";
	}
    
	
}
