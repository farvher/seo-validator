package com.seo.validator.seovalidator.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class Sitemap {
	@XmlElement
	public String loc;
	@XmlElement
	public String lastmod;
	
	@XmlTransient
	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	@XmlTransient
	public String getLastmod() {
		return lastmod;
	}

	public void setLastmod(String lastmod) {
		this.lastmod = lastmod;
	}

	@Override
	public String toString() {
		return "ClassPojo [loc = " + loc + ", lastmod = " + lastmod + "]";
	}
}
