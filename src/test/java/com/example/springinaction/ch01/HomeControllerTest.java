package com.example.springinaction.ch01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class) // HomeController의 웹 페이지 테스트, 스프링 MVC 형태로 테스트가 실행되도록 한다.
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc; // 실제 서버를 시작하는 대신 스프링 MVC의 모의 메커니즘을 사용, MockMvc 객체를 주입(연결)

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // GET / 을 수행
                .andExpect(status().isOk()) // HTTP 200이 되어야 함
                .andExpect(view().name("home")) // home 뷰가 있어야 함
                .andExpect(content().string(containsString("Welcome to..."))); // 콘텐츠에 "Welcome to..."가 포함 되어야 함
    }
}
