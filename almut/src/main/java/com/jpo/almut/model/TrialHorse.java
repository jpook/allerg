package com.jpo.almut.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the trial_horse database table.
 * 
 */
@Entity
@Table(name="trial_horse")
@NamedQuery(name="TrialHorse.findAll", query="SELECT t FROM TrialHorse t")
public class TrialHorse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp created;

	private String createdby;

	private Timestamp modfied;

	private String modifiedby;

	//bi-directional many-to-one association to Horse
	@ManyToOne
	@JoinColumn(name="horseid")
	private Horse horse;

	//bi-directional many-to-one association to Trial
	@ManyToOne
	@JoinColumn(name="trialid")
	private Trial trial;

	public TrialHorse() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getModfied() {
		return this.modfied;
	}

	public void setModfied(Timestamp modfied) {
		this.modfied = modfied;
	}

	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Horse getHorse() {
		return this.horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public Trial getTrial() {
		return this.trial;
	}

	public void setTrial(Trial trial) {
		this.trial = trial;
	}

}