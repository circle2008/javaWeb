package com.dlmu.circle.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by cf on 2017/5/29.
 */
public class ReponseUtil {
    public static void write(HttpServletResponse response, Object o)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
