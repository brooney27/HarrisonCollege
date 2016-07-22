package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCSECTION database table.
 * 
 */
@Entity
@NamedQuery(name="Hcsection.findAll", query="SELECT h FROM Hcsection h")
public class Hcsection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCSECTION_CRN_GENERATOR", sequenceName="HCSECTION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCSECTION_CRN_GENERATOR")
	private long crn;

	private String building;

	private String daysofweek;

	private BigDecimal roomnumber;

	private BigDecimal starttime;

	//bi-directional many-to-one association to Hccourse
	@ManyToOne
	@JoinColumn(name="COURSEID")
	private Hccourse hccourse;

	//bi-directional many-to-many association to Hcstudent
	@ManyToMany(mappedBy="hcsections")
	private List<Hcstudent> hcstudents;

	//bi-directional many-to-one association to Hcinstructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private Hcinstructor hcinstructor;

	public Hcsection() {
	}

	public long getCrn() {
		return this.crn;
	}

	public void setCrn(long crn) {
		this.crn = crn;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDaysofweek() {
		return this.daysofweek;
	}

	public void setDaysofweek(String daysofweek) {
		this.daysofweek = daysofweek;
	}

	public BigDecimal getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomnumber(BigDecimal roomnumber) {
		this.roomnumber = roomnumber;
	}

	public BigDecimal getStarttime() {
		return this.starttime;
	}

	public void setStarttime(BigDecimal starttime) {
		this.starttime = starttime;
	}

	public Hccourse getHccourse() {
		return this.hccourse;
	}

	public void setHccourse(Hccourse hccourse) {
		this.hccourse = hccourse;
	}

	public List<Hcstudent> getHcstudents() {
		return this.hcstudents;
	}

	public void setHcstudents(List<Hcstudent> hcstudents) {
		this.hcstudents = hcstudents;
	}

	public Hcinstructor getHcinstructor() {
		return this.hcinstructor;
	}

	public void setHcinstructor(Hcinstructor hcinstructor) {
		this.hcinstructor = hcinstructor;
	}

}