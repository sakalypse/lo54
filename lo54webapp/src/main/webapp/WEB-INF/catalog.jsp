<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lo54.lo54ecole.entity.CourseSession" %>
<%@ page import="com.lo54.lo54ecole.entity.Location" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Liste sessions</title>
</head>

<body>
<h1>Liste des sessions</h1>


<form action="" method="get" class="searchAction">
    <div>
        <label for="name">Entrer nom: </label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <input type="submit" value="Rechercher par nom">
    </div>
</form>
<br/>

<form action="" method="get" class="searchAction">
    <div>
        <label for="date">Entrer date: </label>
        <input type="date" name="date" id="date">
    </div>
    <div>
        <input type="submit" value="Rechercher par date">
    </div>
</form>
<br/>

<form action="" method="get" class="searchAction">
<div>
        <label for="location">Entrer location: </label>
        <SELECT name="location" id="location" size="1">
            <OPTION>
            <%
                ArrayList<Location> listLocation = (ArrayList<Location>)
                        request.getAttribute("listLocation");
                if(listLocation!=null){
                    for(Location loc : listLocation){
                        out.println("<OPTION>"+loc.getCity());
                    }
                }
            %>
        </SELECT>
    </div>
    <div>
        <input type="submit" value="Rechercher par location">
    </div>
</form>
<br/>

<%
    ArrayList<CourseSession> listCourseSession = (ArrayList<CourseSession>)
            request.getAttribute("listCourseSession");
    if(listCourseSession==null || listCourseSession.size()==0){
        out.println("Il n'y a actuellement pas de session pour le nom indiqué");
    }
    else{
%>

<table border="1" cellpadding="15">
    <tr>
        <th>Nom du cours</th>
        <th>Location</th>
        <th>Capacité max</th>
        <th>Date début</th>
        <th>Date fin</th>
    </tr>
    <%

            for (CourseSession cs : listCourseSession) {
                out.println("<tr>");
                out.println("<td>" + cs.getCourse_code().getTitle() + "</td>");
                out.println("<td>" + cs.getLocation_id().getCity() + "</td>");
                out.println("<td>" + cs.getMax() + "</td>");
                out.println("<td>" + cs.getStart_date() + "</td>");
                out.println("<td>" + cs.getEnd_date() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
    %>
</body>
</html>