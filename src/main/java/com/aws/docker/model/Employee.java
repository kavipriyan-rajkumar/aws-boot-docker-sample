package com.aws.docker.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Employee implements Serializable{
	private static final long serialVersionUID = -55385105304036305L;
	private Long employeeId;
	private String employeeName;
}
