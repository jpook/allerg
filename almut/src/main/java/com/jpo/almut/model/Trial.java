package com.jpo.almut.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the trial database table.
 * 
 */
@Entity
@NamedQuery(name="Trial.findAll", query="SELECT t FROM Trial t")
public class Trial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String comment;

	private Timestamp created;

	private String createdby;

	@Column(name="date_of_trial")
	private Timestamp dateOfTrial;

	private Timestamp modified;

	private String modifiedby;

	private String trialname;

	private String trialnumber;

	//bi-directional many-to-one association to Rawdata
	@OneToMany(mappedBy="trial")
	private List<Rawdata> rawdata;

	//bi-directional many-to-one association to TrialAllergen
	@OneToMany(mappedBy="trial")
	private List<TrialAllergen> trialAllergens;

	//bi-directional many-to-one association to TrialHorse
	@OneToMany(mappedBy="trial")
	private List<TrialHorse> trialHorses;

	public Trial() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getDateOfTrial() {
		return this.dateOfTrial;
	}

	public void setDateOfTrial(Timestamp dateOfTrial) {
		this.dateOfTrial = dateOfTrial;
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

	public String getTrialname() {
		return this.trialname;
	}

	public void setTrialname(String trialname) {
		this.trialname = trialname;
	}

	public String getTrialnumber() {
		return this.trialnumber;
	}

	public void setTrialnumber(String trialnumber) {
		this.trialnumber = trialnumber;
	}

	public List<Rawdata> getRawdata() {
		return this.rawdata;
	}

	public void setRawdata(List<Rawdata> rawdata) {
		this.rawdata = rawdata;
	}

	public Rawdata addRawdata(Rawdata rawdata) {
		getRawdata().add(rawdata);
		rawdata.setTrial(this);

		return rawdata;
	}

	public Rawdata removeRawdata(Rawdata rawdata) {
		getRawdata().remove(rawdata);
		rawdata.setTrial(null);

		return rawdata;
	}

	public List<TrialAllergen> getTrialAllergens() {
		return this.trialAllergens;
	}

	public void setTrialAllergens(List<TrialAllergen> trialAllergens) {
		this.trialAllergens = trialAllergens;
	}

	public TrialAllergen addTrialAllergen(TrialAllergen trialAllergen) {
		getTrialAllergens().add(trialAllergen);
		trialAllergen.setTrial(this);

		return trialAllergen;
	}

	public TrialAllergen removeTrialAllergen(TrialAllergen trialAllergen) {
		getTrialAllergens().remove(trialAllergen);
		trialAllergen.setTrial(null);

		return trialAllergen;
	}

	public List<TrialHorse> getTrialHorses() {
		return this.trialHorses;
	}

	public void setTrialHorses(List<TrialHorse> trialHorses) {
		this.trialHorses = trialHorses;
	}

	public TrialHorse addTrialHors(TrialHorse trialHors) {
		getTrialHorses().add(trialHors);
		trialHors.setTrial(this);

		return trialHors;
	}

	public TrialHorse removeTrialHors(TrialHorse trialHors) {
		getTrialHorses().remove(trialHors);
		trialHors.setTrial(null);

		return trialHors;
	}

}