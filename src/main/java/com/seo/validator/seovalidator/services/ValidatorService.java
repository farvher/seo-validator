package com.seo.validator.seovalidator.services;

import com.seo.validator.seovalidator.dto.model.ItemValidDto;

public interface ValidatorService {

	ItemValidDto validateContent(String content);

	Boolean validateSpecial(String content, String text);
	
	ItemValidDto validateUrl(String url);
	
	String getHtmlContent(String url);

}
