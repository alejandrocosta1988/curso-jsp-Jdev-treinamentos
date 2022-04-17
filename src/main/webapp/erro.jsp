<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Erro</title>
  </head>
  
  <body>

    <h1>Se você está vendo esta tela é porque ocorreu um erro. Entre em contato com a equipe de suporte do sistema.</h1>
    <%
      out.print(request.getAttribute("msg"));
    %>
  </body>
</html>