package com.example.teamproject.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamproject.domain.BigGoalCount;
import com.example.teamproject.domain.Goal;
import com.example.teamproject.domain.GoalDTO;

@Mapper
public interface GoalDAO {
	//대목표 저장
	int bigGoalInsert(GoalDTO goalDTO);
	//대목표 불러오기
	ArrayList<Goal> GetBigGoalList(String userId);
	// 대목표 갯수 불러오기
	BigGoalCount getBigGoalCount(String userId);
	
}
