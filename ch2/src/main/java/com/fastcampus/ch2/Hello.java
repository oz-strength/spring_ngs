package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	//2. URL과 메서드를 연결
	@RequestMapping("/hello")
	public void main() {
		System.out.println("Hello");
	}
}
