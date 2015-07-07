package com.jpo.almut.process.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.inject.Inject;

import com.jpo.almut.model.AllergenValue;
import com.jpo.almut.service.JpoAllergenService;

public class JpoCounterFileProcessor {

	@Inject
	JpoAllergenService service;

	public List<AllergenValue> fileList;

	public JpoCounterFileProcessor() {
		super();
	}

	public JpoCounterFileProcessor(List<AllergenValue> fileList) {
		super();
		this.fileList = fileList;
	}

	public List<AllergenValue> getFileList() {
		return fileList;
	}

	public void setFileList(List<AllergenValue> fileList) {
		this.fileList = fileList;
	}

	public void addAllergenValue(AllergenValue allergenValue) {
		if (fileList == null)
			fileList = new ArrayList<AllergenValue>();
		fileList.add(allergenValue);
	}

	public void process(String fileName) {
		System.out.println("Filename : " + fileName);
		Scanner s = null;
		try {
			s = new Scanner((Readable) (new BufferedReader(new FileReader(
					fileName))));
			s.useLocale(Locale.US);
			boolean notHeader = false;
			while (s.hasNext()) {
				String currentLine = s.nextLine().trim();

				if (notHeader) {
					if (!currentLine.matches("^[\\D*].*$||^$")) {
						String[] values = currentLine.split("\\s+");
						if (values != null) {
							if (values.length != 6) {
								System.out.println("ERROR : wrong length");
								// TODO : create notification
							} else {
								AllergenValue currentValue = new AllergenValue(
										Integer.parseInt(values[0]),
										Integer.parseInt(values[1]),
										Integer.parseInt(values[2]),
										Double.parseDouble(values[3]),
										Double.parseDouble(values[4]),
										Double.parseDouble(values[5]));
								addAllergenValue(currentValue);
							}
						} else
							System.out.println("ERROR : values are null");
					}
				} else {
					notHeader = currentLine
							.matches("^\\s*POS\\s*TIME\\s*COUNTS1\\s*RAW\\s*CPM1\\s*COR\\.CPM1\\s*SIGMA\\s*$");

				}
			}
			System.out.println("Save allergen values");
			service.saveAllergenValueList(fileList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
