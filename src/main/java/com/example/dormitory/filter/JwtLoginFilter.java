package com.example.dormitory.filter;

import com.example.dormitory.dto.Response;
import com.example.dormitory.dto.TokenDto;
import com.example.dormitory.dto.User;
import com.example.dormitory.utils.JsonUtil;
import com.example.dormitory.utils.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {
    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        User user = new ObjectMapper().readValue(httpServletRequest.getInputStream(), User.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        String auth = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        User user = (User) authResult.getPrincipal();
        String token = JwtTokenUtil.createToken(user.getUsername(), auth);
        TokenDto tokenDto = new TokenDto(token,user);
        JsonUtil.write(response, Response.success(tokenDto));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        JsonUtil.write(response, Response.error("账号或密码错误!!"));
    }
}
