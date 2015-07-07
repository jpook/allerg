package com.jpo.almut.layouts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.jpo.almut.process.file.JpoCounterFileProcessor;
import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

public class JpoUploadCounterReceiver implements Receiver, SucceededListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7056015828983658358L;
	File tempFile;
	@Inject
	JpoCounterFileProcessor counterFileProcessor;

	@PostConstruct
	public void init() {

	}

	@Override
	public void uploadSucceeded(SucceededEvent event) {
		System.out.println("succeeded upload !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		process();
	}

	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		FileOutputStream fos = null;

		try {
			tempFile = new File("c:/tmp/uploads/" + filename);
			fos = new FileOutputStream(tempFile);
		} catch (FileNotFoundException e) {
			new Notification("Could not open file<br/>", e.getMessage(),
					Notification.Type.ERROR_MESSAGE).show(Page.getCurrent());
			return null;
		}
		return fos;
	}

	void process() {
		counterFileProcessor.process(tempFile.getAbsolutePath());
	}

}
