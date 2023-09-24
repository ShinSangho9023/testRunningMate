package com.example.teamproject.domain;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BigGoalCount {
	private int ongoing_count;
	private int completed_count;
	private int overdue_count;
}
