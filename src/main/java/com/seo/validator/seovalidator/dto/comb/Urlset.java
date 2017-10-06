package com.seo.validator.seovalidator.dto.comb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="urlset",namespace="http://www.sitemaps.org/schemas/sitemap/0.9")
public class Urlset {


	@XmlElement
	List<Url> url;

	@XmlTransient
	public List<Url> getUrl() {
		return url;
	}

	public void setUrl(List<Url> url) {
		this.url = url;
	}
	
	
	
}
