package com.seo.validator.seovalidator.dto.model;

import java.util.List;

public class ItemValidDto {

	String itemName;

	String itemId;

	String itemClass;

	Boolean approved;

	List<ChildItemValidDto> subItems;

}
