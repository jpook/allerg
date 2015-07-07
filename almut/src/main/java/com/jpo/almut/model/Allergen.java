package com.jpo.almut.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the allergen database table.
 * 
 */
@Entity
@NamedQuery(name="Allergen.findAll", query="SELECT a FROM Allergen a")
public class Allergen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String abbreviation;

	private int allergenOrder;

	private Timestamp created;

	private String createdby;

	private String description;

	private Timestamp modified;

	private String modifiedby;

	private String name;

	//bi-directional many-to-one association to Allergengroup
	@ManyToOne
	@JoinColumn(name="allergengroupid")
	private Allergengroup allergengroup;

	//bi-directional many-to-one association to Dilution
	@OneToMany(mappedBy="allergen")
	private List<Dilution> dilutions;

	//bi-directional many-to-one association to Rawdata
	@OneToMany(mappedBy="allergen")
	private List<Rawdata> rawdata;

	//bi-directional many-to-one association to TrialAllergen
	@OneToMany(mappedBy="allergen")
	private List<TrialAllergen> trialAllergens;

	//bi-directional many-to-one association to Unit
	@OneToMany(mappedBy="allergen")
	private List<Unit> units;

	public Allergen() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public int getAllergenOrder() {
		return this.allergenOrder;
	}

	public void setAllergenOrder(int allergenOrder) {
		this.allergenOrder = allergenOrder;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Allergengroup getAllergengroup() {
		return this.allergengroup;
	}

	public void setAllergengroup(Allergengroup allergengroup) {
		this.allergengroup = allergengroup;
	}

	public List<Dilution> getDilutions() {
		return this.dilutions;
	}

	public void setDilutions(List<Dilution> dilutions) {
		this.dilutions = dilutions;
	}

	public Dilution addDilution(Dilution dilution) {
		getDilutions().add(dilution);
		dilution.setAllergen(this);

		return dilution;
	}

	public Dilution removeDilution(Dilution dilution) {
		getDilutions().remove(dilution);
		dilution.setAllergen(null);

		return dilution;
	}

	public List<Rawdata> getRawdata() {
		return this.rawdata;
	}

	public void setRawdata(List<Rawdata> rawdata) {
		this.rawdata = rawdata;
	}

	public Rawdata addRawdata(Rawdata rawdata) {
		getRawdata().add(rawdata);
		rawdata.setAllergen(this);

		return rawdata;
	}

	public Rawdata removeRawdata(Rawdata rawdata) {
		getRawdata().remove(rawdata);
		rawdata.setAllergen(null);

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
		trialAllergen.setAllergen(this);

		return trialAllergen;
	}

	public TrialAllergen removeTrialAllergen(TrialAllergen trialAllergen) {
		getTrialAllergens().remove(trialAllergen);
		trialAllergen.setAllergen(null);

		return trialAllergen;
	}

	public List<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public Unit addUnit(Unit unit) {
		getUnits().add(unit);
		unit.setAllergen(this);

		return unit;
	}

	public Unit removeUnit(Unit unit) {
		getUnits().remove(unit);
		unit.setAllergen(null);

		return unit;
	}

}