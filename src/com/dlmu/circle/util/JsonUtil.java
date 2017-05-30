package com.dlmu.circle.util;

import com.dlmu.circle.model.Student;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.List;

/**
 * Created by cf on 2017/5/29.
 */
public class JsonUtil {
    public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception{
        ResultSetMetaData md=rs.getMetaData();
        int num=md.getColumnCount();
        JSONArray jsonArray=new JSONArray();
        while (rs.next()){
            JSONObject mapOfColValues=new JSONObject();
            for(int i=1;i<=num;i++){
                Object o= rs.getObject(i);
                if(o instanceof Date){
                    mapOfColValues.put(md.getColumnName(i), DateUtil.formatDate((Date) o,"yyyy-MM-dd"));
                }else {
                    mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
                }

            }
            jsonArray.add(mapOfColValues);
        }

        return jsonArray;
    }
    public static JSONArray listToJson(List<Student> list)throws Exception{
        JSONArray jsonArray=JSONArray.fromObject(list);
        return jsonArray;
    }
}
