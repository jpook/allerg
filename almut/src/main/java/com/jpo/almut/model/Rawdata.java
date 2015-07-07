package com.jpo.almut.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the rawdata database table.
 * 
 */
@Entity
@NamedQuery(name="Rawdata.findAll", query="SELECT r FROM Rawdata r")
public class Rawdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp created;

	private String createdby;

	private Timestamp modified;

	private String modifiedby;

	private BigDecimal value;

	//bi-directional many-to-one association to Allergen
	@ManyToOne
	@JoinColumn(name="allergenid")
	private Allergen allergen;

	//bi-directional many-to-one association to Horse
	@ManyToOne
	@JoinColumn(name="horseid")
	private Horse horse;

	//bi-directional many-to-one association to Trial
	@ManyToOne
	@JoinColumn(name="trialid")
	private Trial trial;

	public Rawdata() {
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

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Allergen getAllergen() {
		return this.allergen;
	}

	public void setAllergen(Allergen allergen) {
		this.allergen = allergen;
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