package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCINSTRUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Hcinstructor.findAll", query="SELECT h FROM Hcinstructor h")
public class Hcinstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCINSTRUCTOR_INSTRUCTORID_GENERATOR", sequenceName="HCINSTRUCTOR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCINSTRUCTOR_INSTRUCTORID_GENERATOR")
	private long instructorid;

	private String department;

	private BigDecimal officenumber;

	//bi-directional many-to-one association to Hcsection
	@OneToMany(mappedBy="hcinstructor")
	private List<Hcsection> hcsections;

	//bi-directional one-to-one association to Hcuser
	@OneToOne(mappedBy="hcinstructor")
	private Hcuser hcuser;

	public Hcinstructor() {
	}

	public long getInstructorid() {
		return this.instructorid;
	}

	public void setInstructorid(long instructorid) {
		this.instructorid = instructorid;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigDecimal getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(BigDecimal officenumber) {
		this.officenumber = officenumber;
	}

	public List<Hcsection> getHcsections() {
		return this.hcsections;
	}

	public void setHcsections(List<Hcsection> hcsections) {
		this.hcsections = hcsections;
	}

	public Hcsection addHcsection(Hcsection hcsection) {
		getHcsections().add(hcsection);
		hcsection.setHcinstructor(this);

		return hcsection;
	}

	public Hcsection removeHcsection(Hcsection hcsection) {
		getHcsections().remove(hcsection);
		hcsection.setHcinstructor(null);

		return hcsection;
	}

	public Hcuser getHcuser() {
		return this.hcuser;
	}

	public void setHcuser(Hcuser hcuser) {
		this.hcuser = hcuser;
	}

}