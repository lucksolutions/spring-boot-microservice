package com.lucksolutions.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse extends AbstractModelObject {

	private static final long serialVersionUID = 1781118757654270972L;

	@Getter
	@Setter
	private String code;

	@Getter
	@Setter
	private String message;

}
