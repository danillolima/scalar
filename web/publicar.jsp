<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Publicar posts!">
 <div class="form-box">
            <h1>Publicar</h1>
            <form name="cadastro" action="verifica.jsp" method="POST">
                <ul>
                    <li><label>Titulo(Opcional): <input type="text" name="title" size="10" /> </label></li>
                    <li><label>Conteudo:   <textarea name="content" value=""></textarea></label></li>
                    <li><label><input class="send" type="submit" value="Publicar" /></label></li></ul>
            </form>
    
</t:layout>

