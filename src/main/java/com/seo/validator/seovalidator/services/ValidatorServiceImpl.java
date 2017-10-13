package com.seo.validator.seovalidator.services;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.seo.validator.seovalidator.dto.model.ItemValidDto;

@Service
public class ValidatorServiceImpl implements ValidatorService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ItemValidDto validateContent(String content) {

		ItemValidDto contentValidDto = new ItemValidDto();

		return null;
	}

	@Override
	public Boolean validateSpecial(String content, String text) {
		return content.contains(text);
	}

	private Document convertHTMLToDocument(String url) {

		try {
			Document document = Jsoup.connect(url).get();
			document.outputSettings().prettyPrint(false);
			document.outputSettings().charset("ASCII");
			return document;
		} catch (IOException io) {
			logger.error("io error: ", io);
		} catch (Exception ex) {
			logger.error("error: ", ex);

		}
		return null;
	}

	@Override
	public ItemValidDto validateUrl(String url) {
		Document document = convertHTMLToDocument(url);
		return null;
	}

}
