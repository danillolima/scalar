<%@ tag body-content="scriptless" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/site.css">
    <link rel="icon" href="img/icon.png">
    <title>${title}</title>
</head>
<body>
    <header>
       
        <div class="logo"> <a href="/scalar"><img src="img/logo.png"/></a></div>
        <nav>
            <a href="/scalar/">INICIO</a>
            <a href="login.jsp">PUBLICAR</a>
            <a href="cadastro.jsp">CADASTRAR</a>
        </nav>
        <div>
            <label class="botao"></label>
        </div>
        
    </header>
    <div class="container">
        <jsp:doBody/>
    </div>
</body>
</html>