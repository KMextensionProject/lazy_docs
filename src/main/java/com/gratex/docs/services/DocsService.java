package com.gratex.docs.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.gratex.docs.dtos.GastroDTO;
import com.gratex.docs.enums.Resources;
import com.gratex.docs.exceptions.IncompleteFormException;
import com.gratex.docs.utils.DocxUtils;
import com.gratex.docs.utils.StringMap;

@Service
public class DocsService {

	public void example(HttpServletResponse response, GastroDTO gastro) {
		validateGastroData(gastro);

		StringMap data = gastro.getAsMap();
		addDateFields(data);
		resolveOption(data);
		try {
			DocxUtils.generateDocx(response, Resources.VYBER_SPOSOBU_STRAVOVANIA, "Volba_stravovania.docx", data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void validateGastroData(GastroDTO gastro) {
		if (Objects.isNull(gastro)
				|| gastro.getFullName().isBlank()
				|| gastro.getAddress().isBlank()
				|| gastro.getBirthDate().isBlank()) {
			throw new IncompleteFormException("IncompleteForm");
		}
	}

	private void addDateFields(StringMap gastroMap) {
		// it will always be the next year and due to posting deadline, it cannot be contemporary year
		String nextYear = String.valueOf(LocalDate.now().getYear() + 1);
		gastroMap.put("year", nextYear);

		String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
		gastroMap.put("date", today);
	}

	private void resolveOption(StringMap gastroMap) {
		String option = gastroMap.get("option");

		switch (option) {
		case "option_card":
			gastroMap.put("option_1", "X");
			gastroMap.put("option_2", "  ");
			break;	
		case "option_bonus":
			gastroMap.put("option_1", "  ");
			gastroMap.put("option_2", "X");
			break;
		}
	}
}
