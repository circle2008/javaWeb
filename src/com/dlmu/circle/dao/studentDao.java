package com.dlmu.circle.dao;

import com.dlmu.circle.model.PageBean;
import com.dlmu.circle.model.Student;

import java.util.List;

/**
 * Created by cf on 2017/5/29.
 */
public interface studentDao {
    public List<Student> show(PageBean pageBean, Student s_student);
    public int count(Student s_student);
    public List<Student> loadByIds(String Ids);
}
