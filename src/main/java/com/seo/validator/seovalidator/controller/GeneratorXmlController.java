package com.seo.validator.seovalidator.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeneratorXmlController {

	public static final String GENERATOR_VIEW = "generator";

	@GetMapping("/generator")
	public String index() {
		return GENERATOR_VIEW;
	}

	@RequestMapping(value="/generator",produces = MediaType.APPLICATION_XML_VALUE ,method = RequestMethod.POST)
	@ResponseBody
	public String generatorXml(HttpServletResponse response, String urls, String priority, String lastmod,
			String changefreq) {
		response.setContentType("application/xml");
		return generateXml(urls.split(",|\r\n"), lastmod, changefreq, priority);

	}

	private String generateXml(String[] urls, String lastmod, String changefreq, String priority) {
		StringBuilder str = new StringBuilder();
		str.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">");
		for (String u : urls) {
			str.append("<url>");
			str.append("<loc>");
			str.append(u);
			str.append("</loc>");
			str.append("<lastmod>");
			str.append(lastmod);
			str.append("</lastmod>");
			str.append("<changefreq>");
			str.append(changefreq);
			str.append("</changefreq>");
			str.append("<priority>");
			str.append(priority);
			str.append("</priority>");
			str.append("</url>");
		}

		str.append("</urlset>");
		return str.toString();
	}

}
