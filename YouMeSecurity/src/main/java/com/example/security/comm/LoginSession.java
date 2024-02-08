package com.example.security.comm;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@Log4j2
public class LoginSession {


    @GetMapping("/session")
    public String doSession(HttpServletRequest req) {

/* setSession
1.getSession() = getSession(true)
-> HttpSession 값이 존재하면 현재 HttpSession을 반환, 존재하지 않으면 새로운 세션을 생성
2.getSession(false)
-> HttpSession 값이 존재하면 현재 HttpSession을 반환, 존재하지 않으면 null 을 반환
*/

        HttpSession session = req.getSession();

// 세션 ID 가져오기
        String strSessionId = session.getId();
        System.out.println("session ID : " + strSessionId);

// 세션의 값을 배열에 넣는다.
        Enumeration<String> names = session.getAttributeNames();

// Enumeration 추출
        String strSession = "";
        while (names.hasMoreElements()) {
            strSession = names.nextElement();
            //System.out.println(strSession + " : " + session.getAttribute(strSession));
            log.info("sessionName={}, sessionAttribute={}", strSession, session.getAttribute(strSession));
        }

        return strSessionId;
    }

}
