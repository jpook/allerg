package com.jpo.almut.containers;

import com.jpo.almut.model.Trial;
import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class JpoTrialContainer extends BeanItemContainer<Trial>{

	public JpoTrialContainer()
			throws IllegalArgumentException {
		super(Trial.class);
//		addNestedContainerProperty("allergengroup.name");
	}

}