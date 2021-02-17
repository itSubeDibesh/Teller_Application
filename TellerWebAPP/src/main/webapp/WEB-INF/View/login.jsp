


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>


<html>
        <head>
            <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
            <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet">
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
        </head>
        <body>
            <div class="wrapper fadeInDown">
                <div id="formContent">
                <!-- Tabs Titles -->
                <h3>Login Form</h3>
               <form:form method="POST" modelAttribute="command" action="loginProcess">
                    <form:input id="username" class="fadeIn second" placeholder="USERNAME" path="userName"/>
                    <form:password id="password" class="fadeIn third" placeholder="PASSWORD" path="passWord"/>
                    <form:button id="submit" class="fadeIn fourth" name="submit">LogIn</form:button>
                    
                </form:form>
                
                
                <div id="formFooter">
                    ${message}
                </div>
            </div>
        </div>
            
        </body>
        </html>