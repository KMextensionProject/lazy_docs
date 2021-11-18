package com.gratex.docs.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gratex.docs.dtos.GastroDTO;
import com.gratex.docs.services.DocsService;

@Controller
public class DocsController {

	@Autowired
	private DocsService docsService;

	@GetMapping(path = "/forms/gastro")
	public String gastroForm() {
		return "zranica";
	}

	@PostMapping(path = "/gastro")
	public void example(HttpServletResponse response, GastroDTO input) {
		docsService.example(response, input);
	}

}
