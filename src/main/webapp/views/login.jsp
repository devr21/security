<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Please Login</title>
  </head>
  <body>
        <form name="f" action="/secure-mvc/perform_login" method="post">               
            <fieldset>
                <legend>Please Login</legend>
        				<div>
        				${error}
        				</div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username"/>        
                <label for="password">Password</label>
                <input type="password" id="password" name="password"/>    
                <div class="form-actions">
                    <button type="submit" class="btn">Log in</button>
                </div>
            </fieldset>
        </form>
  </body>
</html>