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
    
    <%
      out.print("Seu sucesso garantido!");
    %>
    
    <form action="ServletLogin" method="post">
      <input name="nome">
      <input name="idade">
      
      <input type="submit" value="Enviar">
    </form>

  </body>
</html>