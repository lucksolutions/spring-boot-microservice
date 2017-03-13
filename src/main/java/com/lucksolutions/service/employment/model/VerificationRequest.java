package com.lucksolutions.service.employment.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.lucksolutions.service.model.AbstractModelObject;

import lombok.Getter;
import lombok.Setter;

public class VerificationRequest extends AbstractModelObject {


	private static final long serialVersionUID = -6373869410947994045L;
	
	@Getter
	@Setter
	@Min(100000000) // 9 Digits
	@Max(9999999999L) // 10 Digits
	@NotNull
	private Integer alienNumber;
}
