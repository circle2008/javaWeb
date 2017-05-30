<%--
  Created by IntelliJ IDEA.
  User: cf
  Date: 2017/5/29
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript">
    $(function () {
      var dataTree=[{
        text:"全部信息",
        children:[{
          text:"学生信息管理",
          attributes:{
            url:"${pageContext.request.contextPath}/student/show.jsp"
          }
        }]

      }];
      //实例化树菜单
      $("#tree").tree({
                data:dataTree,
                lines:true,
                onClick:function (node) {
                  if(node.attributes){
                    openTab(node.text,node.attributes.url)
                  }
                }
              }
      )
      //实例化tab
      function openTab(text,url) {
        //判断标签页是否被打开
        if($("#tabs").tabs('exists',text)){
          //如果存在，则自动选中
          $("#tabs").tabs('select',text)
        }else {
          var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"><iframe>";
          $("#tabs").tabs('add',{
            title:text,
            closable:true,
            content:content
          });
        }

      }

    });
  </script>
</head>
<body class="easyui-layout">
<div region="north" style="height: 80px;background-color: #E0EDFF">
  <div align="left" style="width: 80%;float: left"><img src="images/main1.jpg"></div>


</div>
<div region="center">
  <div class="easyui-tabs" fit="true" border="false" id="tabs">
    <div title="首页" >
      <div align="center" style="padding-top: 100px;"><font size="5">design by</font><font color="red" size="10">Circle</font></div>
    </div>
  </div>
</div>
<div region="west" style="width: 150px;" title="导航菜单" split="true">
  <ul id="tree"></ul>
</div>
 <div data-options="region:'south'" style="height:25px;" align="center">
  design by circle
</div>
    
</body>
</html>
