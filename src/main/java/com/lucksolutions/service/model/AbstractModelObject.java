package com.lucksolutions.service.model;

import java.io.Serializable;

import lombok.Data;

import org.springframework.validation.annotation.Validated;

@Validated
@Data
public abstract class AbstractModelObject implements Serializable {

	private static final long serialVersionUID = 1890059803108653170L;

}
