<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ include file="header.jsp" %> 
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
            		<div class="row">
            			<div class="col-lg-offset-4 col-lg-4 col-sm-offset-2 col-sm-8">
	            			 <h1>Login</h1> 
										<form:form method="post" action="/test/login" modelAttribute="user">
											<div class="form-group">
												<label class="" for="user_name">Username: </label>
												<input type="text" class="form-control" name="user_name" id="user_name" placeholder="Username"/>
											</div>
											<div class="form-group">
												<label class="" for="user_password">Password: </label>
												<input type="password" class="form-control" name="user_password" id="user_password" placeholder="Password"/>
											</div>
											<div>
												<input class="btn btn-primary" type="submit" value="Login"/>
												<a href="<c:url value="/register"/>" class="btn btn-default">Sign Up</a>
											</div>
										</form:form>
						                <!-- <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a> -->
						          </div>
						        </div>
					        </div>
            		</div>
               
        <!-- /#page-content-wrapper -->
<%@ include file="footer.jsp" %> 