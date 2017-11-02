package com.seo.validator.seovalidator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seo.validator.seovalidator.services.ValidatorService;

@Controller
public class ValidatorContentController {

	@Autowired
	ValidatorService validatorService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String VALID_PAGE_VIEW = "valid-page";
	
	private static final String REDIRECT ="redirect:";

	
	public String viewValidatePage(Model m) {
		return VALID_PAGE_VIEW;
	}

	@PostMapping("/html-content")
	public String validatePage(@RequestParam String url,RedirectAttributes ra, Model m) {
		ra.addFlashAttribute("content", validatorService.getHtmlContent(url));
		return REDIRECT + "/valid-page";
	}

}
