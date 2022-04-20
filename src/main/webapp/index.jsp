<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html lang="pt-br">
<html>
  
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Curso JSP</title>
  </head>
  
  <body class="container col-xl-10 col-xxl-8 px-4 py-5">
  
    <div class="row align-items-center g-lg-5 py-5">
    
      <div class="col-lg-7 text-center text-lg-start">
        <h1 class="display-4 fw-bold lh-1 mb-3">Bem vindo ao Curso JSP</h1>
        <p class="col-lg-10 fs-5">Esta página está sendo criada ao longo de minha participação no treinamento de desenvolvimento web full stack utilizando Java e JPS. O treinamento está sendo ministrado pela JDev Treinamentos.</p>    
      </div>

    
      <div class="col-md-10 mx-auto col-lg-5">
        <form action="ServletLogin" method="post" class="p-4 p-md-5 border rounded-3 bg-light needs-validation" novalidate>
    
          <input type="hidden" value="<%= request.getParameter("url") %>" name="url"> <!--O = entre os % faz com que esse valor seja impresso no html.-->
      
          <div class="mb-3">
            <label for="login-input" class="form-label">Login</label>
            <input id="login-input" name="login" type="text" class="form-control" required>
            <div class="valid-feedback">
              Ok!
            </div>
            <div class="invalid-feedback">
              Informe o nome de usuário.
            </div>
          </div>  
  
          <div class="mb-3">      
            <label for="senha-input" class="form-label">Senha</label>
            <input id="senha-input" name="senha" type="password" class="form-control" required>
            <div class="valid-feedback">
              Ok!
            </div>
            <div class="invalid-feedback">
              Informe a senha.
            </div>
          </div>
      
          <div class="mb-3">
            <input type="submit" value="Enviar" class="w-100 btn btn-primary">
          </div>
          
          <p class="text-muted">${msg}</p>
    
          <hr class="my-4">
          
          <small class="text-muted">Embora o foco principal do treinamento não seja o front-end, estou aproveitando a liberdade para conhecer melhor o Bootstrap. Este layout foi construído 100% a partir do Bootstrap CSS.</small>
      
        </form>
      </div>
    
    
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    <script src="index.js" type="text/javascript"></script>
  </body>
</html>