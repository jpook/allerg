package com.jpo.almut.components;

import com.vaadin.ui.FormLayout;

@SuppressWarnings("serial")
public abstract class AJpoDetailsForm<T> extends FormLayout {
	public abstract void updateItem(T t); 
}
