package com.jpo.almut.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="AllergenValue.findAll", query="SELECT a FROM AllergenValue a")
public class AllergenValue {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;

	Integer pos;
	Integer time;
	Integer counts1;
	Double rawCpm1;
	Double corCpm1;
	Double sigma;

	public AllergenValue() {
		super();
	}

	public AllergenValue(Integer pos, Integer time, Integer counts1,
			Double rawCpm1, Double corCpm1, Double sigma) {
		super();
		this.pos = pos;
		this.time = time;
		this.counts1 = counts1;
		this.rawCpm1 = rawCpm1;
		this.corCpm1 = corCpm1;
		this.sigma = sigma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getCounts1() {
		return counts1;
	}

	public void setCounts1(Integer counts1) {
		this.counts1 = counts1;
	}

	public Double getRawCpm1() {
		return rawCpm1;
	}

	public void setRawCpm1(Double rawCpm1) {
		this.rawCpm1 = rawCpm1;
	}

	public Double getCorCpm1() {
		return corCpm1;
	}

	public void setCorCpm1(Double corCpm1) {
		this.corCpm1 = corCpm1;
	}

	public Double getSigma() {
		return sigma;
	}

	public void setSigma(Double sigma) {
		this.sigma = sigma;
	}

}
