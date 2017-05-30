package com.dlmu.circle.dao.Impl;

import com.dlmu.circle.dao.studentDao;
import com.dlmu.circle.model.PageBean;
import com.dlmu.circle.model.Student;
import com.dlmu.circle.util.StringUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cf on 2017/5/29.
 */
@Repository("studentDao")
public class studentDaoImpl implements studentDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> show(PageBean pageBean, Student s_student){
        StringBuffer sb=new StringBuffer("select * from t_student");
        if(s_student!=null){
            if(StringUtil.isNotEmpty(s_student.getStuNo())){
                sb.append(" and stuNo like '%"+s_student.getStuNo()+"%'");
            }
            if(StringUtil.isNotEmpty(s_student.getStuName())){
                sb.append(" and stuName like '%"+s_student.getStuName()+"%'");
            }
            if(StringUtil.isNotEmpty(s_student.getSex())){
                sb.append(" and sex = '"+s_student.getSex()+"'");
            }
        }
        if(pageBean!=null){
            sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
        }
        final List<Student> studentList=new ArrayList<Student>();
        jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                    Student student=new Student();
                    student.setStuId(rs.getInt("id"));
                    student.setStuName(rs.getString("stuName"));
                    student.setEmail(rs.getString("email"));
                    student.setStuDesc(rs.getString("stuDesc"));
                    student.setSex(rs.getString("sex"));
                    student.setStuNo(rs.getString("stuNo"));
                studentList.add(student);
            }
        });
        return studentList;
    }

    @Override
    public int count(Student s_student) {
        StringBuffer sb=new StringBuffer("select count(*) from t_student");
        if(s_student!=null){
            if(StringUtil.isNotEmpty(s_student.getStuNo())){
                sb.append(" and stuNo like '%"+s_student.getStuNo()+"%'");
            }
            if(StringUtil.isNotEmpty(s_student.getStuName())){
                sb.append(" and stuName like '%"+s_student.getStuName()+"%'");
            }
            if(StringUtil.isNotEmpty(s_student.getSex())){
                sb.append(" and sex = '"+s_student.getSex()+"'");
            }
        }
        return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
    }

    @Override
    public List<Student> loadByIds(String Ids) {
        String sql="select * from t_student where id in("+Ids+")";
        final List<Student> studentList=new ArrayList<Student>();
        jdbcTemplate.query(sql, new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                Student student=new Student();
                student.setStuId(rs.getInt("id"));
                student.setStuName(rs.getString("stuName"));
                student.setEmail(rs.getString("email"));
                student.setStuDesc(rs.getString("stuDesc"));
                student.setSex(rs.getString("sex"));
                student.setStuNo(rs.getString("stuNo"));
                studentList.add(student);
            }
        });
        return studentList;
    }
}
