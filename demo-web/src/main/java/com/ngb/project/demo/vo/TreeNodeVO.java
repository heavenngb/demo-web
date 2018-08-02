package com.ngb.project.demo.vo;

import java.util.List;

public class TreeNodeVO {
	private String id;
	private String text;
	private String state;
	private String checked;
	private String attributes;
	private List<? extends TreeNodeVO> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public List<? extends TreeNodeVO> getChildren() {
		return children;
	}

	public void setChildren(List<? extends TreeNodeVO> children) {
		this.children = children;
	}

}