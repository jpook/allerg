package com.jpo.almut.components;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.jpo.almut.containers.JpoTrialContainer;
import com.jpo.almut.model.Trial;
import com.vaadin.cdi.UIScoped;
import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
@UIScoped
public class JpoTrialTable extends AJpoTableLayout<Trial, JpoTrialDetailsForm> {
	
	@Inject
	JpoTrialContainer trialContainer;

	@Inject
	JpoTrialDetailsForm trialDetailsForm;

	@PostConstruct
	public void init() {
		super.init();

	}

	public void createClazz() {
		this.clazz = Trial.class;
	}

	@Override
	public JpoTrialDetailsForm getDetails() {
		return trialDetailsForm;
	}

	@Override
	public BeanItemContainer<Trial> getBeanItemContainer() {
		return trialContainer;
	}

	@Override
	public Object[] getVisibleColumns() {
		return (Object[]) new String[] { "id", "trialname", "trialnumber" };
	}

	@Override
	public void createHeaderMapping() {
		headerMapping = new HashMap<String, String>();
		headerMapping.put("id", "Identifier");
		headerMapping.put("trialname", "Trial Name");
		headerMapping.put("trialnumber", "Number");
	}
}
