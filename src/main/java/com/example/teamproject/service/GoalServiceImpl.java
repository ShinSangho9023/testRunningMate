package com.example.teamproject.service;

import java.util.ArrayList; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.dao.GoalDAO;
import com.example.teamproject.domain.BigGoalCount;
import com.example.teamproject.domain.Goal;
import com.example.teamproject.domain.GoalDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GoalServiceImpl implements GoalService {

	@Autowired
	GoalDAO dao;

	
	// 대목표 저장
	@Override
	public int bigGoalInsert(GoalDTO goalDTO) 
	{
		log.debug("임플 쪽 값 확인 {}", goalDTO);
		int i = dao.bigGoalInsert(goalDTO);
		log.debug("임플 쪽 값 돌아가는 거  확인");
		return i;
	}
	
	//대목표 불러오기
	@Override
	public ArrayList<Goal> GetBigGoalList(String userId) {
		ArrayList<Goal> list = new ArrayList<>();	
		
		list = dao.GetBigGoalList(userId);
		
		return list;
	}

	// 대목표 갯수 불러오기
	@Override
	public BigGoalCount getBigGoalCount(String userId) {
		BigGoalCount BigGoalCount = new BigGoalCount();
		BigGoalCount = dao.getBigGoalCount(userId);
		return BigGoalCount;
	}
	
	
	
	
	
	
	
}
