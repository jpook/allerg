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


/**
 * The persistent class for the dilution database table.
 * 
 */
@Entity
@NamedQuery(name="Dilution.findAll", query="SELECT d FROM Dilution d")
public class Dilution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Timestamp created;

	private String createdby;

	private double dilution;

	private Timestamp modified;

	private String modifiedby;

	private int unitid;

	//bi-directional many-to-one association to Allergen
	@ManyToOne
	@JoinColumn(name="allergenid")
	private Allergen allergen;

	public Dilution() {
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

	public double getDilution() {
		return this.dilution;
	}

	public void setDilution(double dilution) {
		this.dilution = dilution;
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

	public int getUnitid() {
		return this.unitid;
	}

	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}

	public Allergen getAllergen() {
		return this.allergen;
	}

	public void setAllergen(Allergen allergen) {
		this.allergen = allergen;
	}

}