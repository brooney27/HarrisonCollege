package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCSTUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Hcstudent.findAll", query="SELECT h FROM Hcstudent h")
public class Hcstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCSTUDENT_STUDENTID_GENERATOR", sequenceName="HCSTUDENT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCSTUDENT_STUDENTID_GENERATOR")
	private long studentid;

	private BigDecimal entryyear;

	private String major;

	//bi-directional many-to-many association to Hcsection
	@ManyToMany
	@JoinTable(
		name="HCENROLLMENT"
		, joinColumns={
			@JoinColumn(name="STUDENTID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="COURSEID")
			}
		)
	private List<Hcsection> hcsections;

	//bi-directional one-to-one association to Hcuser
	@OneToOne(mappedBy="hcstudent")
	private Hcuser hcuser;

	public Hcstudent() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public BigDecimal getEntryyear() {
		return this.entryyear;
	}

	public void setEntryyear(BigDecimal entryyear) {
		this.entryyear = entryyear;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<Hcsection> getHcsections() {
		return this.hcsections;
	}

	public void setHcsections(List<Hcsection> hcsections) {
		this.hcsections = hcsections;
	}

	public Hcuser getHcuser() {
		return this.hcuser;
	}

	public void setHcuser(Hcuser hcuser) {
		this.hcuser = hcuser;
	}

}