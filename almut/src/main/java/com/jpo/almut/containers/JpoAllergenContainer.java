package com.jpo.almut.containers;

import com.jpo.almut.model.Allergen;
import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
public class JpoAllergenContainer extends BeanItemContainer<Allergen>{

	public JpoAllergenContainer()
			throws IllegalArgumentException {
		super(Allergen.class);
		addNestedContainerProperty("allergengroup.name");
	}

}