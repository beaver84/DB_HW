package me.devkuka.tutorial.config;

import lombok.extern.slf4j.Slf4j;
import me.devkuka.tutorial.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenProvider jwtTokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        final String token = request.getHeader("jwt");
        log.info("preHandle: " + token);
        if (!jwtTokenProvider.validateToken(token)) {
            throw new AuthenticationException("권한이 없습니다");
        }
        request.setAttribute("userID", jwtTokenProvider.getAuthentication(token));
        return true;
    }
}