package com.jpo.almut.layouts;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.vaadin.cdi.UIScoped;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

@UIScoped
public class JpoAllergenValueUploadTabLayout extends VerticalLayout implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6742478919954495032L;

	@Inject
	JpoUploadCounterReceiver jpoUploadCounterReceiver;

	@PostConstruct
	public void init() {
		setSizeFull();
		Upload upload = new Upload("Upload Counter File",
				jpoUploadCounterReceiver);
		upload.setButtonCaption("Upload start");
		upload.addSucceededListener(jpoUploadCounterReceiver);
		addComponent(upload);
	}
}
