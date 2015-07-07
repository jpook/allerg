package com.jpo.almut.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the allergengroup database table.
 * 
 */
@Entity
@NamedQuery(name="Allergengroup.findAll", query="SELECT a FROM Allergengroup a")
public class Allergengroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int allergenGroupOrder;

	private Timestamp created;

	private String createdby;

	private String description;

	private Timestamp modified;

	private String modifiedby;

	private String name;

	//bi-directional many-to-one association to Allergen
	@OneToMany(mappedBy="allergengroup")
	private List<Allergen> allergens;

	public Allergengroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAllergenGroupOrder() {
		return this.allergenGroupOrder;
	}

	public void setAllergenGroupOrder(int allergenGroupOrder) {
		this.allergenGroupOrder = allergenGroupOrder;
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

	public List<Allergen> getAllergens() {
		return this.allergens;
	}

	public void setAllergens(List<Allergen> allergens) {
		this.allergens = allergens;
	}

	public Allergen addAllergen(Allergen allergen) {
		getAllergens().add(allergen);
		allergen.setAllergengroup(this);

		return allergen;
	}

	public Allergen removeAllergen(Allergen allergen) {
		getAllergens().remove(allergen);
		allergen.setAllergengroup(null);

		return allergen;
	}

}