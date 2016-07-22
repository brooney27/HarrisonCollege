package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCCOURSE database table.
 * 
 */
@Entity
@NamedQuery(name="Hccourse.findAll", query="SELECT h FROM Hccourse h")
public class Hccourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCCOURSE_COURSEID_GENERATOR", sequenceName="HCCOURSE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCCOURSE_COURSEID_GENERATOR")
	private long courseid;

	private String coursename;

	private BigDecimal coursenumber;

	private BigDecimal credits;

	private String description;

	private String subject;

	//bi-directional many-to-one association to Hcsection
	@OneToMany(mappedBy="hccourse")
	private List<Hcsection> hcsections;

	public Hccourse() {
	}

	public long getCourseid() {
		return this.courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public BigDecimal getCoursenumber() {
		return this.coursenumber;
	}

	public void setCoursenumber(BigDecimal coursenumber) {
		this.coursenumber = coursenumber;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Hcsection> getHcsections() {
		return this.hcsections;
	}

	public void setHcsections(List<Hcsection> hcsections) {
		this.hcsections = hcsections;
	}

	public Hcsection addHcsection(Hcsection hcsection) {
		getHcsections().add(hcsection);
		hcsection.setHccourse(this);

		return hcsection;
	}

	public Hcsection removeHcsection(Hcsection hcsection) {
		getHcsections().remove(hcsection);
		hcsection.setHccourse(null);

		return hcsection;
	}

}