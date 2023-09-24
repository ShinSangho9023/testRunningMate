package com.example.teamproject.service;

import java.util.ArrayList;

import com.example.teamproject.domain.BigGoalCount;
import com.example.teamproject.domain.Goal;
import com.example.teamproject.domain.GoalDTO;
import com.example.teamproject.domain.SmallGoalDTO;

public interface GoalService {
	//대목표 저장
	int bigGoalInsert(GoalDTO goalDTO);
	// 대목표 불러오기
	ArrayList<Goal> GetBigGoalList(String userId);
	// 대목표 갯수 불러오기
	BigGoalCount getBigGoalCount(String userId);
	// 소목표 불러오기
	void GetSmallGoalList(SmallGoalDTO smallGoal);

}
