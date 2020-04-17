package com.example.dormitory.filter;

import com.example.dormitory.dto.Response;
import com.example.dormitory.utils.JsonUtil;
import com.example.dormitory.utils.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");
        JwtTokenUtil tokenUtil;
        try {
            tokenUtil = new JwtTokenUtil(token);
        } catch (ExpiredJwtException e) {
            JsonUtil.write((HttpServletResponse) servletResponse, Response.errorToken("登录已失效，请重新登录!"));
            return;
        } catch (Exception e) {
            JsonUtil.write((HttpServletResponse) servletResponse, Response.errorToken("请先登录!"));
            return;
        }
        String username = tokenUtil.getUsername();
        String authorities = tokenUtil.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, servletResponse);
    }
}
