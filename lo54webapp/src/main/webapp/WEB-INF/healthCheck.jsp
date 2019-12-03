<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lo54.lo54ecole.entity.CourseSession" %>
<%@ page import="com.lo54.lo54ecole.entity.Location" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>HealthCheck</title>
</head>

<body>
<h1>HealthCheck</h1>

<%
    ArrayList<String> listResponse = (ArrayList<String>)
            request.getAttribute("listResponse");
    if(listResponse!=null){
        for(String healthCheck : listResponse){
            out.println("<p>"+healthCheck+"</p><br/>");
        }
    }
%>


</body>
</html>