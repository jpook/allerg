package com.jpo.almut.components;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.jpo.almut.containers.JpoAllergenGroupBeanFieldGroup;
import com.jpo.almut.model.Allergengroup;
import com.jpo.almut.service.JpoAllergenService;
import com.vaadin.cdi.UIScoped;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
@UIScoped
public class JpoAllergenGroupDetailsForm extends FormLayout {

	@Inject
	JpoAllergenGroupBeanFieldGroup allergenGroupBeanFieldGroup;
	
	@Inject
	JpoAllergenService allergenService;

	TextField name = new TextField("Name");
	TextField description = new TextField("Description");
	Button commitButton = new Button("Commit");

	@PostConstruct
	public void init() {
		commitButton.addClickListener(listener -> commit());
		addComponents(name, description, commitButton);
	}

	private void commit() {
		try {
			allergenGroupBeanFieldGroup.commit();
			allergenService.update(allergenGroupBeanFieldGroup.getItemDataSource().getBean());
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateItem(Allergengroup allergengroup) {
		allergenGroupBeanFieldGroup.setItemDataSource(allergengroup);
		allergenGroupBeanFieldGroup.bind(name, "name");
		allergenGroupBeanFieldGroup.bind(description, "description");
		allergenGroupBeanFieldGroup.setBuffered(true);
		this.setImmediate(true);
	}
}
