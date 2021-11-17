package com.gratex.docs.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gratex.docs.services.DocsService;

@Controller
public class DocsController {

	@Autowired
	private DocsService docsService;
	
	@PostMapping(path = "/callio", consumes = "application/json")
	public void example(HttpServletResponse response, @RequestBody Map<String, String> input) {
		docsService.example(response, input);
	}

}
