package com.lucksolutions.service.model;

import lombok.Getter;
import lombok.Setter;

public class Error extends AbstractModelObject {

	private static final long serialVersionUID = 1781118757654270972L;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String message;

}
