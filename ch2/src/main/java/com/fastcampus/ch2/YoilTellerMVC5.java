package com.fastcampus.ch2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

//생년월일을 입력하면 요일을 알려주는 프로그램 
@Controller
public class YoilTellerMVC5 { // http://localhost:8080/ch2/getYoilMVC?year=2021&month=10&day=1
	
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
    @RequestMapping("/getYoilMVC5") // http://localhost/ch2/getYoilMVC5
//    	public String main(@ModelAttribute("myDate") MyDate date, Model model) { // 아래와 동일 
    	public String main(@ModelAttribute MyDate date, Model model) {
        
    	// 1. 유효성 검사
    	if(!isValid(date))
    		return "yoilError";
    	
    	// 2. 요일 계산
//    	char yoil = getYoil(date);
        
    	// 3. 계산한 결과를 모델에 저장
//    	model.addAttribute("myDate", date);
//    	model.addAttribute("yoil", yoil);
    	
    	// 4. 작업 결과를 보여줄 View의 이름을 반환
        return "yoil"; //	/WEB-INF/views/yoil.jsp
    }

	private boolean isValid(MyDate date) {
		return isValid(date.getYear(), date.getMonth(), date.getDay());
	}

	private @ModelAttribute("yoil") char getYoil(MyDate date) {
		return getYoil(date.getYear(), date.getMonth(), date.getDay());
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

