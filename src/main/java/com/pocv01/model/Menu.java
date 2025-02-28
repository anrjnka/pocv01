package com.pocv01.model;

import java.util.List;

public class Menu {
	private String title;
	private String url;
	private String icon;
	private List<MenuItems> items;
	
	
	public List<MenuItems> getItems() {
		return items;
	}
	public void setItems(List<MenuItems> items) {
		this.items = items;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	
	
}