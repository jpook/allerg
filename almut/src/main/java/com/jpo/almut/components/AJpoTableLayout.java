package com.jpo.almut.components;

import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;

import com.jpo.almut.layouts.JpoTableLayout;
import com.jpo.almut.service.JpoAllergenService;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;

public abstract class AJpoTableLayout<T, S extends AJpoDetailsForm<T>> extends JpoTableLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6699108636389320888L;

	protected Button addButton = new Button();
	protected Class<T> clazz;
	protected Table table = new Table();
	protected Map<String,String> headerMapping;
	
	@Inject
	JpoAllergenService service;
	
	public abstract void createClazz();
	public abstract S getDetails();
	public abstract BeanItemContainer<T> getBeanItemContainer();
	public abstract Object[] getVisibleColumns();
	public abstract void createHeaderMapping();
	
	protected void init() {
		createClazz();
		createHeaderMapping();
		addButton.setCaptionAsHtml(true);
		addButton.setCaption(FontAwesome.ALIGN_CENTER.getHtml());
		addButton.addClickListener(event -> addItem(event));
		setSizeFull();

		addComponents(addButton, table, getDetails());
		table.setColumnReorderingAllowed(true);
		table.setImmediate(true);
		table.setSelectable(true);
		table.setSizeFull();
		table.setContainerDataSource(getBeanItemContainer());
		table.setVisibleColumns(getVisibleColumns());
		if (headerMapping != null) {
			for (String mapping : headerMapping.keySet()) {
				table.setColumnHeader(mapping,headerMapping.get(mapping));
			}
		}

		table
				.addValueChangeListener(event -> changeSelection(event));

	}
	
	private void addItem(ClickEvent event) {
		Object itemId = service.createEntity(clazz);
		getBeanItemContainer().addItem(itemId);
		table.select(itemId);
		table.setVisible(false);
		table.setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	private void changeSelection(ValueChangeEvent event) {
		getDetails().updateItem((T) table
				.getValue());
	}
	
	public void addItems(Collection<T> collection) {
		getBeanItemContainer().addAll(collection);
	}
}
