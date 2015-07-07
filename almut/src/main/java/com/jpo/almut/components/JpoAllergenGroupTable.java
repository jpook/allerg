package com.jpo.almut.components;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.jpo.almut.containers.JpoAllergenGroupContainer;
import com.jpo.almut.layouts.JpoTableLayout;
import com.jpo.almut.model.Allergengroup;
import com.jpo.almut.service.JpoAllergenService;
import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
@UIScoped
public class JpoAllergenGroupTable extends JpoTableLayout {

	@Inject
	JpoAllergenGroupContainer allergenGroupContainer;

	@Inject
	JpoAllergenService service;

	Button addButton = new Button();
	Table allergenGroupTable = new Table("Allergen Groups");

	@Inject
	JpoAllergenGroupDetailsForm allergenGroupDetailsForm;

	@PostConstruct
	public void init() {
		addButton.setCaptionAsHtml(true);
		addButton.setCaption(FontAwesome.ALIGN_CENTER.getHtml());
		addButton.addClickListener(event -> addAllergenGroup(event));
		setSizeFull();

		addComponents(addButton, allergenGroupTable, allergenGroupDetailsForm);
		System.out.println("setting container properties");
		allergenGroupTable.setColumnReorderingAllowed(true);
		allergenGroupTable.setImmediate(true);
		allergenGroupTable.setSelectable(true);
		allergenGroupTable.setSizeFull();
		allergenGroupTable.setContainerDataSource(allergenGroupContainer);
		allergenGroupTable.setVisibleColumns((Object[]) new String[] { "id",
				"name", "description" });
		allergenGroupTable.setColumnHeader("id", "Identifier");
		allergenGroupTable.setColumnHeader("name", "Group Name");
		allergenGroupTable.setColumnHeader("description", "Description");

		allergenGroupTable
				.addValueChangeListener(event -> changeSelection(event));

	}

	private void changeSelection(ValueChangeEvent event) {
		allergenGroupDetailsForm.updateItem((Allergengroup) allergenGroupTable
				.getValue());
	}

	private void addAllergenGroup(ClickEvent event) {
		Object itemId = service.createAllergenGroup();
		allergenGroupContainer.addItem(itemId);
		allergenGroupTable.select(itemId);
		allergenGroupTable.setVisible(false);
		allergenGroupTable.setVisible(true);
	}

	public void addItems(Collection<Allergengroup> collection) {
		allergenGroupContainer.addAll(collection);
	}

}
