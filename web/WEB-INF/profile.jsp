<%@page import="model.Post"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% ArrayList<Post> posts = (ArrayList<Post>)request.getAttribute("posts"); %>
<c:set var="postsContent"> 
<% 
    for(Post post : posts ){ 
        out.print("<div class=\"post\">");
        if(post.getTitle()!= null)
        out.print("<h2>" + post.getTitle() + "</h2>");
        if(post.getContent()!= null)
        out.print("<p>" + post.getContent() + "</p>");
        if(post.getVideo() != null)
            out.print("<video controls src=\"" + post.getVideo() + "\"/></video>");
        if(post.getImg() != null)
            out.print("<img src=\"" + post.getImg() + "\"/>");
        out.print("</div>");
    } 
%>
</c:set>
<t:layout title="${sessionScope.user} profile">
   
 <div class="profile">
    <script>
    function fetchdata(e){
        $.ajax({
            url: '/scalar/posts?feed=true',
            type: 'GET',
            success: function(response){
                    var jsonData = JSON.parse(response);
                    var html;
                    for (var i = 0; i < jsonData.posts.length; i++) {
                        var html = "";
                        var post = jsonData.posts[i];
                        
                        html += '<div class="post">';   
                        html += '<input type="hidden" value="' + post.time + '"/>';   
                        
                        if(post.title !== 'null')
                            html += "<h2>"  + post.title + "</h2>";
                        if(post.content !== 'null')
                            html += '<p>'+ post.content +'</p>'; 
                        if(post.video !== 'null' )
                            html += '<video controls src="' + post.video + '"/></video>';
                        if(post.img !== 'null')
                            html +=  '<img src="' + post.img + '"/></div>';
                        if(e === true){ 
                            $("#posts").append(html);
                        }
                        else{ 
                            //var last = document.getElementByClass('timestamp');
                          //  alert(last.children[1].innerHTML);
                            	
                          //  console.log($("#posts.timestamp").children().html());
                            //$("#posts").prepend(html);
                        }
                    }
                   
                }
            
        });
    }

$(document).ready(function(){
    fetchdata(true);
  
    setInterval(fetchdata, 80000, false);
    $( "#posts div:nth-child(1)" ).append( "<span> - 2nd!</span>" );
});
     
         </script>
    <h1> ${sessionScope.user} </h1>
    <%-- ${postsContent} --%> 
    <div id="posts"></div>
    </div>
</t:layout>

