package com.jpo.almut.components;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.jpo.almut.containers.JpoTrialBeanFieldGroup;
import com.jpo.almut.model.Trial;
import com.jpo.almut.service.JpoAllergenService;
import com.vaadin.cdi.UIScoped;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
@UIScoped
public class JpoTrialDetailsForm extends AJpoDetailsForm<Trial> {

	@Inject
	JpoTrialBeanFieldGroup trialBeanFieldGroup;
	
	@Inject
	JpoAllergenService allergenService;

	TextField trialname = new TextField("Name");
	TextField comment = new TextField("Comment");
	Button commitButton = new Button("Commit");

	@PostConstruct
	public void init() {
		commitButton.addClickListener(listener -> commit());
		addComponents(trialname, comment, commitButton);
	}

	private void commit() {
		try {
			trialBeanFieldGroup.commit();
			allergenService.updateTrial(trialBeanFieldGroup.getItemDataSource().getBean());
		} catch (CommitException e) {
			e.printStackTrace();
		}
	}

	public void updateItem(Trial trial) {
		trialBeanFieldGroup.setItemDataSource(trial);
		trialBeanFieldGroup.bind(trialname, "Trial Name");
		trialBeanFieldGroup.bind(comment, "Comment");
		trialBeanFieldGroup.setBuffered(true);
		this.setImmediate(true);
	}
}
