package com.gratex.docs.utils;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;

public class DocxUtils {

	public static void generateDocx(HttpServletResponse response, String template, String outputFileName, Map<String, String> dataSource) throws Exception {
		InputStream iStream = DocxUtils.class.getClassLoader().getResourceAsStream(template);
		WordprocessingMLPackage WProcessor = WordprocessingMLPackage.load(iStream);
		MainDocumentPart mainDocPart = WProcessor.getMainDocumentPart();
		VariablePrepare.prepare(WProcessor);
		mainDocPart.variableReplace(dataSource);
		ServletOutputStream oStream = response.getOutputStream();
		addDocxHeaders(response, outputFileName);
		WProcessor.save(oStream);
	}
	
	private static void addDocxHeaders(HttpServletResponse response, String outputFileName) {
		response.addHeader("Content-Type", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		response.addHeader("Content-Disposition", "attachment;filename=" + outputFileName);
	}
	
}
