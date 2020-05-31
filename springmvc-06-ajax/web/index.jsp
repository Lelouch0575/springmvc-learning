<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
    <script>
      function a() {
        $.post({
          url: "${pageContext.request.contextPath}/a1",
          data: {"name":$("#username").val()},
          success: function (data,status) {
            alert(data);
            console.log("data=" + data);
            console.log("status=" + status);
          }
        })
      }
    </script>
  </head>
  <body>
<%--  失去焦点的时候发起一个请求(携带信息)到后台--%>
  username:<input type="text" id="username" onblur="a()">
  </body>
</html>
