<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <jsp:include page="head.jsp"></jsp:include>

  <body>
  
  <!-- Pre-loader start -->
  <jsp:include page="theme-loader.jsp"></jsp:include>
  
  <!-- Pre-loader end -->
  <div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
      <div class="pcoded-container navbar-wrapper">
          
        <jsp:include page="navbar.jsp"></jsp:include>

        <div class="pcoded-main-container">
          <div class="pcoded-wrapper">
            <jsp:include page="navbar-main-menu.jsp"></jsp:include>
              
            <div class="pcoded-content">
              <jsp:include page="page-header.jsp"></jsp:include>
              
              <div class="pcoded-inner-content">
                <div class="main-body">
                  <div class="page-wrapper">
                    <div class="page-body">
                      <div class="row">
                      
                        Conteúdo da página base.
                        
                      </div>
                    </div>
                  </div>
                  <div id="styleSelector"> </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <jsp:include page="call-javascript-files.jsp"></jsp:include>
    
  </body>

</html>