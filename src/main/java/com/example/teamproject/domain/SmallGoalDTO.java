package com.example.teamproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmallGoalDTO {
	
	private String userId;
	private String bigGoalName;
	private int key;
	
}
