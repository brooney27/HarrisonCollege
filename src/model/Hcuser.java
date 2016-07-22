package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HCUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Hcuser.findAll", query="SELECT h FROM Hcuser h")
public class Hcuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCUSER_ID_GENERATOR", sequenceName="HCUSER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCUSER_ID_GENERATOR")
	private long id;

	private String email;

	private String firstname;

	private String hashedpass;

	private String lastname;

	private String salt;

	private BigDecimal usertype;

	//bi-directional one-to-one association to Hcinstructor
	@OneToOne
	@PrimaryKeyJoinColumn(name="INSTRUCTORID")
	private Hcinstructor hcinstructor;

	//bi-directional one-to-one association to Hcstudent
	@OneToOne
	@PrimaryKeyJoinColumn(name="STUDENTID")
	private Hcstudent hcstudent;

	public Hcuser() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getHashedpass() {
		return this.hashedpass;
	}

	public void setHashedpass(String hashedpass) {
		this.hashedpass = hashedpass;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public BigDecimal getUsertype() {
		return this.usertype;
	}

	public void setUsertype(BigDecimal usertype) {
		this.usertype = usertype;
	}

	public Hcinstructor getHcinstructor() {
		return this.hcinstructor;
	}

	public void setHcinstructor(Hcinstructor hcinstructor) {
		this.hcinstructor = hcinstructor;
	}

	public Hcstudent getHcstudent() {
		return this.hcstudent;
	}

	public void setHcstudent(Hcstudent hcstudent) {
		this.hcstudent = hcstudent;
	}

}