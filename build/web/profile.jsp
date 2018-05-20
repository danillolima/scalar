<%@page import="model.Post"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts"); %>

<c:set var="postsContent"> 
<% for(Post post : posts ){ 
out.print("<div class=\"post\">");
out.print("<h2>" + post.getTitle() + "</h2>");
out.print("<p>" + post.getContent() + "</p>");
out.print("<video src=\"\"/>");
out.print("<img src=\"\"/></div>"); } %>
</c:set>



<t:layout title="${sessionScope.user} profile">
    <div class="profile">
    <h1> ${sessionScope.user} </h1>
      
           
           ${postsContent}
    </div>
</t:layout>

