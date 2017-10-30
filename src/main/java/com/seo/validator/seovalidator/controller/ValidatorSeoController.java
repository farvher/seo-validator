package com.seo.validator.seovalidator.controller;

import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.seo.validator.seovalidator.dto.Sitemap;
import com.seo.validator.seovalidator.dto.Sitemapindex;
import com.seo.validator.seovalidator.dto.comb.Url;
import com.seo.validator.seovalidator.dto.comb.Urlset;

@Controller
public class ValidatorSeoController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final static String INDEX = "index";

	private static final String URL_VIEW = "url";

	private static final String NO_RESULTS = "No tenemos inmuebles que coincidan con su";

	@GetMapping(value = "/")
	public String index() {

		return INDEX;
	}

	@PostMapping(value = "/get-sitemaps")
	public String getSitemaps(@RequestParam String urlSitemap, Model model) {

		URI url;
		try {
			url = new URI(urlSitemap);
			RestTemplate restTemplate = new RestTemplate();

			Sitemapindex response = restTemplate.getForObject(url, Sitemapindex.class);
			model.addAttribute("sitemaps", response);
		} catch (URISyntaxException e) {
			model.addAttribute("error", "error");
		}

		return INDEX;
	}

	@GetMapping("/get-urls/http://{host:.*}/{url:.*}/view")
	public String getUrl(@PathVariable String url, @PathVariable String host, Model model) {
		try {
			URI uri = new URI("http://" + host + "/" + url);
			RestTemplate restTemplate = new RestTemplate();
			Urlset response = restTemplate.getForObject(uri, Urlset.class);
			model.addAttribute("urlset", response);
			model.addAttribute("count", response.getUrl().size());
			model.addAttribute("sitemap", url);
		} catch (URISyntaxException e) {
			model.addAttribute("error", "error");
		}
		return URL_VIEW;
	}

	@PostMapping("/process")
	@ResponseBody
	public boolean processUrl(@RequestParam String url) {
		try {
			URI uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			String response = restTemplate.getForObject(uri, String.class);
			return response.contains(NO_RESULTS);
		} catch (Exception e) {
			System.out.print("error url:" + url);
		}

		return false;
	}

	@PostMapping("/manual-process")
	public String processManualUrl(@RequestParam String ambiente, @RequestParam String urls, Model m) {
		List<String> procesadas = new ArrayList<>();
		for (String url : urls.split(",|\r\n")) {
			try {
				url = url.startsWith("/")?url.substring(1):url;
				URI uri = new URI(ambiente+url.trim());
				RestTemplate restTemplate = new RestTemplate();
				String response = restTemplate.getForObject(uri, String.class);
				boolean sinResultados = response.contains(NO_RESULTS);
				procesadas.add(url + (sinResultados ? " Sin resultados"
						: " OK"));

			} catch (Exception e) {
				System.out.print("error url:" + url);
				procesadas.add(url + " Exception "+e.getMessage() );
			}
		}
		m.addAttribute("urlsManuales", procesadas);
		m.addAttribute("ambiente",ambiente);
		m.addAttribute("urls",urls);
		return INDEX;
	}

	@GetMapping("/test")
	public String test(Model model) {
		Sitemapindex sitemapindex = new Sitemapindex();
		List<Sitemap> sitemaps = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Sitemap s = new Sitemap();
			s.setLastmod("2017/07/30");
			s.setLoc("http://location/" + i);
			sitemaps.add(s);
		}
		sitemapindex.setSitemap(sitemaps);
		String result;
		StringWriter sw = new StringWriter();
		try {
			JAXBContext carContext = JAXBContext.newInstance(Sitemapindex.class);
			Marshaller carMarshaller = carContext.createMarshaller();
			carMarshaller.marshal(sitemapindex, sw);
			result = sw.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("result", result);
		return INDEX;
	}

	@GetMapping("/test2")
	public String test2(Model model) {
		Urlset urlset = new Urlset();
		List<Url> urls = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			Url ur = new Url();
			ur.setChangefreq("daily");
			ur.setPriority("0.8");
			ur.setLastmod("2017/09/10");
			ur.setLoc("www.prueba.com/" + i);
			urls.add(ur);

		}

		urlset.setUrl(urls);
		String result;
		StringWriter sw = new StringWriter();
		try {
			JAXBContext carContext = JAXBContext.newInstance(Urlset.class);
			Marshaller carMarshaller = carContext.createMarshaller();
			carMarshaller.marshal(urlset, sw);
			result = sw.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("result", result);
		return URL_VIEW;
	}

}
