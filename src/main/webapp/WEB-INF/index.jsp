<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
</head>
<body>       
        <form method="POST" action="/passsubmit">
        <label> What is the code?
        <br>
        <input type="text" name="passcode">
        </label>
        <button>Try Code!</button>
        </form>
        <c:if test = "${wrong}" > <p>Nah dog that's the wrong code.</p> </c:if>
</body>
</html>