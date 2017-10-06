package com.seo.validator.seovalidator.dto.comb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="url")
public class Url {

	@XmlElement
	String loc;
	
	@XmlElement
	String lastmod;
	
	@XmlElement
	String changefreq;
	
	@XmlElement
	String priority;

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
	
	@XmlTransient
	public String getChangefreq() {
		return changefreq;
	}

	public void setChangefreq(String changefreq) {
		this.changefreq = changefreq;
	}

	@XmlTransient
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	
	
}
