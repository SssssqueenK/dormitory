package com.example.dormitory.utils;

import com.example.dormitory.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtil {
    public static void write(HttpServletResponse response, Response data) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        out.write(mapper.writeValueAsString(data));
        out.flush();
        out.close();
    }
}
