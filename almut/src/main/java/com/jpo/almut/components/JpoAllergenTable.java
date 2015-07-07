package com.jpo.almut.components;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.jpo.almut.containers.JpoAllergenContainer;
import com.jpo.almut.layouts.JpoTableLayout;
import com.jpo.almut.model.Allergen;
import com.jpo.almut.service.JpoAllergenService;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class JpoAllergenTable extends JpoTableLayout {
	@Inject
	JpoAllergenContainer allergenContainer;

	@Inject
	JpoAllergenService service;

	Button addButton = new Button();
	Table allergenTable = new Table("Allergens");

	@PostConstruct
	public void init() {
		addButton.setCaptionAsHtml(true);
		addButton.setCaption(FontAwesome.ALIGN_CENTER.getHtml());
		addButton.addClickListener(event -> addAllergen(event));
		setSizeFull();
		addComponents(addButton, allergenTable);
		allergenTable.setColumnReorderingAllowed(true);
		allergenTable.setImmediate(true);
		allergenTable.setSelectable(true);
		allergenTable.setSizeFull();
		allergenTable.setContainerDataSource(allergenContainer);
		allergenTable.setVisibleColumns((Object[])new String[] { "id", "name",
				"description", "allergengroup.name" });

		allergenTable.setColumnHeader("id", "Identifier");
		allergenTable.setColumnHeader("name", "Group Name");
		allergenTable.setColumnHeader("description", "Description");
		allergenTable.setColumnHeader("allergengroup.name", "Allergen Group");
	}

	private void addAllergen(ClickEvent event) {
		Object itemId = service.createAllergenGroup();
		allergenContainer.addItem(itemId);
		allergenTable.select(itemId);
		allergenTable.setVisible(false);
		allergenTable.setVisible(true);
	}

	public void addItems(Collection<Allergen> collection) {
		allergenContainer.addAll(collection);
	}

}
