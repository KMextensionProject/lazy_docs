package com.gratex.docs.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.gratex.docs.enums.Resources;
import com.gratex.docs.utils.DocxUtils;

@Service
public class DocsService {

	public void example(HttpServletResponse response, Map<String, String> data) {
		try {
			Object card = data.get("option_card");
			Object bonus = data.get("option_bonus");
			
			if (card == null && bonus == null) {
				throw new RuntimeException("One of these fields must be filled");
			} else if (card != null && bonus != null) {
				throw new RuntimeException("Only one of these fields must be filled");
			} else if (card != null) {
				data.put("option_card", "X");
				data.put("option_bonus", " ");
			} else {
				data.put("option_card", " ");
				data.put("option_bonus", "X");
			}
			
			data.put("date", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY")));
			DocxUtils.generateDocx(response, Resources.VYBER_SPOSOBU_STRAVOVANIA, "moj_dokument.docx", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
