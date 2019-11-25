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
    if(courseSession == null)
        out.println("Cette session n'existe pas");
    else{
        int nombreInscrit =
                (Integer)request.getAttribute("nombreInscrit");
%>

<h1>Inscription au cours : <% out.println(courseSession.getCourse_code().getTitle()); %> </h1>

<p>Places disponibles : <% out.print(nombreInscrit+"/"+courseSession.getMax());  %></p>
<p>Pourcentage de remplissage : <% out.print((float)nombreInscrit/courseSession.getMax()*100+"%");  %></p>
<br/>

<form action="http://localhost:8080/inscription/?cs=<% out.print(courseSession.getCourse_session_id()); %>"
      method="POST" class="inscription">
    <div>
        <label for="firstname">Entrer votre prénom : </label>
        <input type="text" name="firstname" id="firstname">
    </div>
    <div>
        <label for="lastname">Entrer votre nom : </label>
        <input type="text" name="lastname" id="lastname">
    </div>
    <div>
        <label for="address">Entrer votre adresse : </label>
        <input type="text" name="address" id="address">
    </div>
    <div>
        <label for="phone">Entrer votre téléphone : </label>
        <input type="number" name="phone" id="phone">
    </div>
    <div>
        <label for="email">Entrer votre email : </label>
        <input type="text" name="email" id="email">
    </div>
    <div>
        <input type="hidden" name="courseSession"id="courseSession"
            value="<% out.print(courseSession.getCourse_session_id()); %>">
    </div>

    <div>
        <input type="submit" value="Valider">
    </div>
</form>
<%
    }
%>
</body>
</html>