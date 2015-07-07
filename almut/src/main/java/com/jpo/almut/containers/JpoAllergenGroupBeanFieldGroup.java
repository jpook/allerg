package com.jpo.almut.containers;

import com.jpo.almut.model.Allergengroup;
import com.vaadin.data.fieldgroup.BeanFieldGroup;

@SuppressWarnings("serial")
public class JpoAllergenGroupBeanFieldGroup extends
		BeanFieldGroup<Allergengroup> {

	public JpoAllergenGroupBeanFieldGroup() {
		super(Allergengroup.class);
	}

}
