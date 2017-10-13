package com.seo.validator.seovalidator.dto.model;

import java.util.List;

public class ItemValidDto {

	String itemName;
	
	String itemValue;

	String itemId;

	String itemClass;

	Boolean approved;

	List<ChildItemValidDto> subItems;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemClass() {
		return itemClass;
	}

	public void setItemClass(String itemClass) {
		this.itemClass = itemClass;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public List<ChildItemValidDto> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<ChildItemValidDto> subItems) {
		this.subItems = subItems;
	}

	
}
