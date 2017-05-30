package com.dlmu.circle.controller;

import com.dlmu.circle.model.PageBean;
import com.dlmu.circle.model.Student;
import com.dlmu.circle.service.studentService;
import com.dlmu.circle.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by cf on 2017/5/29.
 */
@Controller
@RequestMapping("/student")
public class studentController {
    @Resource
    private studentService studentService;
    @RequestMapping("/show")
    public void show(Student s_student, HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "page",required = false)String page, @RequestParam(value = "rows",required = false)String rows) throws Exception {
        HttpSession session=request.getSession();
        if(StringUtil.isNotEmpty(page)){
            session.setAttribute("s_student",s_student);
        }else {
            s_student=(Student) session.getAttribute("s_student");
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        List<Student>studentList=studentService.show(pageBean,s_student);
        int total=studentService.count(s_student);
        JSONObject result=new JSONObject();
        JSONArray jsonArray= JsonUtil.listToJson(studentList);
        result.put("rows", jsonArray);
        result.put("total", total);
        ReponseUtil.write(response,result);
    }
    @RequestMapping("/transPDF")
    public void transPDF(@RequestParam(value = "Ids",required = false)String Ids,HttpServletResponse response) throws Exception {
        if(Ids!=null){
            JSONObject result=new JSONObject();
            List<Student> studentList=studentService.loadByIds(Ids);
            String[] tableHeadContent=new String[]{"编号","学号","姓名","性别","邮箱","备注"};
            PdfUtil.createNormalTable("D:/pdftest/"+ DateUtil.formatDate(new Date(),"yyyy-MM-dd-HH-mm-ss")+"数据文档.pdf",studentList,tableHeadContent);
            result.put("success", "true");
            ReponseUtil.write(response,result);
        }
    }
}
