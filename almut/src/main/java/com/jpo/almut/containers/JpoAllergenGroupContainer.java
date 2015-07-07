package com.jpo.almut.containers;

import com.jpo.almut.model.Allergengroup;
import com.vaadin.cdi.UIScoped;
import com.vaadin.data.util.BeanItemContainer;

@SuppressWarnings("serial")
@UIScoped
public class JpoAllergenGroupContainer extends BeanItemContainer<Allergengroup>{

	public JpoAllergenGroupContainer()
			throws IllegalArgumentException {
		super(Allergengroup.class);
		// TODO Auto-generated constructor stub
	}

}
