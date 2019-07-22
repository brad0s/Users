<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ include file="header.jsp" %> 
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
            <h1>Users</h1>
  <%--               <h1>Quiz Generator</h1>
                <p>Click this button to create your own quiz</p>
                <form:form action="/test/createQuiz" method="GET">
                	<div class="form-group">
                		<label for="name">Name: </label>
                		<input type="text" class="form-control" id="name" name="name" placeholder="Type your name here"/>
                	</div>
                	<input type="submit" class="btn btn-primary" value="Create A Quiz"/>
                </form:form>
                <br/> --%>
                
         <table>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.user_name}</td>
							<td><a href="<c:url value="/editUser/${user.id}" />">Edit</a></td>
							<td><a href="<c:url value="/deleteUser/${user.id}" />">Delete</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td>
							<a class="btn btn-primary" href="<c:url value="/addUser" />">
								Add User
							</a>
						</td>
					</tr>
					<tr>
						<td>
							<a class="btn btn-primary" href="<c:url value="/login" />">
								Login
							</a>
						</td>
					</tr>
				</table>
                
<%-- 				<table>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.user_name}</td>
							<td><a href="<c:url value="/editUser/${user.id}" />">Edit</a></td>
							<td><a href="<c:url value="/deleteUser/${user.id}" />">Delete</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td><a class="btn btn-primary" href="<c:url value="/addUser" />">Add User</a></td>
					</tr>
				</table>
                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>--%>
            </div>
        </div> 
        <!-- /#page-content-wrapper -->
<%@ include file="footer.jsp" %> 


				
    