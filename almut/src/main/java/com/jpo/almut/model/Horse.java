package com.jpo.almut.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the horse database table.
 * 
 */
@Entity
@NamedQuery(name="Horse.findAll", query="SELECT h FROM Horse h")
public class Horse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String breed;

	private String comment;

	private Timestamp created;

	private String createdby;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	private String horseid;

	private Timestamp modified;

	private String modifiedby;

	private String name;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="personid")
	private Person person;

	//bi-directional many-to-one association to Vet
	@ManyToOne
	@JoinColumn(name="vetid")
	private Vet vet;

	//bi-directional many-to-one association to Rawdata
	@OneToMany(mappedBy="horse")
	private List<Rawdata> rawdata;

	//bi-directional many-to-one association to TrialHorse
	@OneToMany(mappedBy="horse")
	private List<TrialHorse> trialHorses;

	public Horse() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBreed() {
		return this.breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHorseid() {
		return this.horseid;
	}

	public void setHorseid(String horseid) {
		this.horseid = horseid;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Vet getVet() {
		return this.vet;
	}

	public void setVet(Vet vet) {
		this.vet = vet;
	}

	public List<Rawdata> getRawdata() {
		return this.rawdata;
	}

	public void setRawdata(List<Rawdata> rawdata) {
		this.rawdata = rawdata;
	}

	public Rawdata addRawdata(Rawdata rawdata) {
		getRawdata().add(rawdata);
		rawdata.setHorse(this);

		return rawdata;
	}

	public Rawdata removeRawdata(Rawdata rawdata) {
		getRawdata().remove(rawdata);
		rawdata.setHorse(null);

		return rawdata;
	}

	public List<TrialHorse> getTrialHorses() {
		return this.trialHorses;
	}

	public void setTrialHorses(List<TrialHorse> trialHorses) {
		this.trialHorses = trialHorses;
	}

	public TrialHorse addTrialHors(TrialHorse trialHors) {
		getTrialHorses().add(trialHors);
		trialHors.setHorse(this);

		return trialHors;
	}

	public TrialHorse removeTrialHors(TrialHorse trialHors) {
		getTrialHorses().remove(trialHors);
		trialHors.setHorse(null);

		return trialHors;
	}

}