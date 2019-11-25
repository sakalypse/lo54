<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lo54.lo54ecole.entity.CourseSession" %>
<%@ page import="com.lo54.lo54ecole.entity.Location" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription</title>
</head>

<body>
<%
    CourseSession courseSession = (CourseSession) request.getAttribute("courseSession");
    Boolean inscriptionValide = (Boolean) request.getAttribute("inscriptionValide");

    if(inscriptionValide == null || inscriptionValide == false)
        out.println("Inscription invalide");
    else{
%>

<h1>Inscription au cours :
    <% out.println(courseSession.getCourse_code().getTitle()); %>
    validé </h1>

<%
    }

%>
<a href="/">Returner à la liste des cours</a>
</body>
</html>