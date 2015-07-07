package com.jpo.almut;

import javax.inject.Inject;

import com.jpo.almut.components.JpoAllergenGroupTable;
import com.jpo.almut.components.JpoAllergenTable;
import com.jpo.almut.components.JpoTrialTable;
import com.jpo.almut.layouts.JpoAllergenValueUploadTabLayout;
import com.jpo.almut.service.JpoAllergenService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("com.jpo.almut.MyAppWidgetset")
@CDIUI("")
public class MyUI extends UI {

	@Inject
	JpoTrialTable trialTable;
	
	@Inject
	JpoAllergenGroupTable allergenGroupTable;
	
	@Inject
	JpoAllergenTable allergenTable;

	@Inject
	JpoAllergenValueUploadTabLayout allergenValueUploadTabLayout;
	
	@Inject
	JpoAllergenService service;
	
	TabSheet mainTabSheet = new TabSheet() ;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		setContent(mainTabSheet);
		final VerticalLayout trialTableLayout = new VerticalLayout();
		trialTableLayout.setMargin(true);
		trialTableLayout.addComponent(trialTable);
		trialTable.addItems(service.findAllTrials());
		
		final VerticalLayout allergenGroupTabLayout = new VerticalLayout();
		allergenGroupTabLayout.setMargin(true);
		allergenGroupTabLayout.addComponent(allergenGroupTable);
		allergenGroupTable.addItems(service.findAllAllergenGroups());
		
		final VerticalLayout allergenTabLayout = new VerticalLayout();
		allergenTabLayout.setMargin(true);
		allergenTabLayout.addComponent(allergenTable);
		allergenTable.addItems(service.findAllAllergens());
		
		mainTabSheet.addTab(trialTableLayout,"Trials");
		mainTabSheet.addTab(allergenGroupTabLayout,"Allergen Groups");
		mainTabSheet.addTab(allergenTabLayout,"Allergens");
		
		mainTabSheet.addTab(allergenValueUploadTabLayout,"Upload Allergen Values");
	}

}
