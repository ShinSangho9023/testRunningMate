package com.example.teamproject.controller;

import java.util.ArrayList;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teamproject.domain.BigGoalCount;
import com.example.teamproject.domain.Goal;
import com.example.teamproject.domain.GoalDTO;
import com.example.teamproject.domain.SmallGoalDTO;
import com.example.teamproject.service.GoalService;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@RestController
public class TestController {
	
	@Autowired
	GoalService service;
	
	
	    @GetMapping
	    public String index() {
	        return "/build/index.html";
	    }
	
	
	
	@GetMapping("/api")
	public String test() {
		log.debug("서버 진입 확인");
		return "목표 확인";
	}
	
	
	// 대목표 저장하기
	@PostMapping("/api/goal")
    public ResponseEntity<String> goal(@RequestBody GoalDTO goalDTO ) 
	{
    	 try 
    	 {
    		 //등록 성공 시
    		 log.debug("들어온 값 확인 {}", goalDTO);
    		 int i = service.bigGoalInsert(goalDTO);
    		 log.debug("컨트롤러 저장 확인");
    		 return ResponseEntity.ok("User registered successfully");       
    	} 
    	catch (Exception e) 
    	{
    		// 등록 실패 시
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
    	}
    }
	
	//대목표 전체 불러오기
	@GetMapping("/api/BigGoals")
	public ArrayList<Goal> GetBigGoalList(@RequestParam String userId) {
		log.debug("들어온 값 확인 {}", userId);
		
		ArrayList<Goal> list = new ArrayList<>();	
		list = service.GetBigGoalList(userId);
		
		log.debug("DB에서 불러온 대목표 배열 확인 {}", list);
		return list;
	}
	
	// 대목표 갯수 불러오기
	@GetMapping("/api/BigGoalCount")
	public BigGoalCount getBigGoalCount(@RequestParam String userId) {
	    // 서비스로부터 대목표 갯수를 가져옵니다.
		log.debug("대목표 갯수 함수/ 넘어온 아이디 {}", userId);
	    BigGoalCount bigGoalCount = service.getBigGoalCount(userId);
	    
	    // 가져온 결과를 반환합니다.
	    return bigGoalCount;
	}
	
	@GetMapping("/api/user/smallGoals")
	public String GetSmallGoalList(@RequestParam String userId, String bigGoalName, int key) {
		
		SmallGoalDTO smallGoal = new SmallGoalDTO();
		log.debug("소목표에서 값 넘어오는 지 확인 {}, {}, {}", userId, bigGoalName, key);
		smallGoal.setUserId(userId);
		smallGoal.setBigGoalName(bigGoalName);
		smallGoal.setKey(key);
		
		log.debug("소목표 확인 {}", smallGoal);
		//service.GetSmallGoalList(smallGoal);
		
		return "값 넘어감";
	}
	
	
}
