package com.fastcampus.ch2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

//생년월일을 입력하면 요일을 알려주는 프로그램 
@Controller
public class YoilTellerMVC2 { // http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
    @RequestMapping("/getYoilMVC2") 
//    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	public String main(@RequestParam(required=true) int year, 
    			@RequestParam(required=true) int month, 
    			@RequestParam(required=true) int day, 
    			Model model) throws IOException {
        
    	// 1. 유효성 검사
    	if(!isValid(year, month, day))
    		return "yoilError";
    	
    	// 2. 요일 계산
    	char yoil = getYoil(year, month, day);
        
    	// 3. 계산한 결과를 모델에 저장
    	model.addAttribute("year", year);
    	model.addAttribute("month", month);
    	model.addAttribute("day", day);
    	model.addAttribute("yoil", yoil);
    	
        return "yoil"; //	/WEB-INF/views/yoil.jsp
    }

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
	
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);   // 일요일:1, 월요일:2, ... 
	}
}

