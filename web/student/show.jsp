<%--
  Created by IntelliJ IDEA.
  User: cf
  Date: 2017/5/29
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学生信息管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var url;
        function searchStudent() {
            $('#dg').datagrid('load',{
                stuNo:$('#s_stuNo').val(),
                stuName:$('#s_stuName').val(),
                sex:$('#s_sex').combobox('getValue')
            });
        }
        function printStudent() {
            var selectedRows=$("#dg").datagrid('getSelections');
            if(selectedRows.length==0){
                $.messager.alert("系统提示","请选择要打印的数据！");
                return;
            }
            var strIds=[];
            for(var i=0;i<selectedRows.length;i++){
                strIds.push(selectedRows[i].stuId);
            }
            var ids=strIds.join(",");
            $.messager.confirm("系统提示","您确认要打印这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
                if(r){
                    $.post("${pageContext.request.contextPath}/student/transPDF.do",{Ids:ids},function(result){
                        if(result.success){
                            $.messager.alert("系统提示","打印成功");
                            $("#dg").datagrid("reload");
                        }else{
                            $.messager.alert('系统提示',"打印失败");
                        }
                    },"json");
                }
            });
        }


    </script>
</head>
<body style="margin: 5px;">
<table id="dg" title="学生信息" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true" url="${pageContext.request.contextPath}/student/show.do" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true"></th>
        <th field="stuId" width="50" align="center">编号</th>
        <th field="stuNo" width="100" align="center">学号</th>
        <th field="stuName" width="100" align="center">姓名</th>
        <th field="sex" width="100" align="center">性别</th>
        <th field="email" width="150" align="center">Email</th>
        <th field="stuDesc" width="250" align="center">学生备注</th>
    </tr>
    </thead>
</table>

<div id="tb">
    <div>
        <a href="javascript:printStudent()" class="easyui-linkbutton" iconCls="icon-print" plain="true">打印pdf</a>
    </div>
    <div>
        &nbsp;学号：&nbsp;<input type="text" name="s_stuNo" id="s_stuNo" size="10" value="${s_student.stuNo}"/>
        &nbsp;姓名：&nbsp;<input type="text" name="s_stuName" id="s_stuName" size="10" value="${s_student.stuName}"/>
        &nbsp;性别：&nbsp;<select class="easyui-combobox" name="s_sex" id="s_sex" editable="false" panelHeight="auto">
        <option value="">--请选择--</option>
        <option value="男">男</option>
            <option value="女">女</option>
    </select>
        <a href="javascript:searchStudent()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>

</div>

</body>
</html>
