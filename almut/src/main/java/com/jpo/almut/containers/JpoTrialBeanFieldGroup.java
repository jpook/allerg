package com.jpo.almut.containers;

import com.jpo.almut.model.Trial;
import com.vaadin.data.fieldgroup.BeanFieldGroup;

@SuppressWarnings("serial")
public class JpoTrialBeanFieldGroup extends
		BeanFieldGroup<Trial> {

	public JpoTrialBeanFieldGroup() {
		super(Trial.class);
	}

}
