package com.seo.validator.seovalidator.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;


@XmlRootElement(name="sitemapindex", namespace="http://www.sitemaps.org/schemas/sitemap/0.9")
public class Sitemapindex {

	@XmlElement(name="sitemap")
	List<Sitemap>  sitemap;

	@XmlTransient
	public List<Sitemap> getSitemap() {
		return sitemap;
	}

	public void setSitemap(List<Sitemap> sitemap) {
		this.sitemap = sitemap;
	}

	
	
	
	
	
}
