package com.dlmu.circle.service.Impl;

import com.dlmu.circle.dao.studentDao;
import com.dlmu.circle.model.PageBean;
import com.dlmu.circle.model.Student;
import com.dlmu.circle.service.studentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cf on 2017/5/29.
 */
@Service("studentService")
public class studentServiceImpl implements studentService {
    @Resource
    private studentDao studentDao;
    @Override
    public List<Student> show(PageBean pageBean, Student s_student) {
        return studentDao.show(pageBean,s_student);
    }

    @Override
    public int count(Student s_student) {
        return studentDao.count(s_student);
    }

    @Override
    public List<Student> loadByIds(String Ids) {
        return studentDao.loadByIds(Ids);
    }
}
