<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>Curso JSP</title>
  </head>
  
  <body>

    <h1>Bem vindo ao Curso JSP</h1>
    
    <form action="ServletLogin" method="post">
      
      <label for="login-input">Login</label>
      <input id="login-input" name="login" type="text">
      
      <label for="senha-input">Senha</label>
      <input id="senha-input" name="senha" type="password">
      
      <input type="submit" value="Enviar">
    </form>
    
    <h4>${msg}</h4>

  </body>
</html>