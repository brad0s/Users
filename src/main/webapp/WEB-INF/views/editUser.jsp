<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ include file="header.jsp" %> 
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <h1>Edit User</h1> 
				<form:form method="post" action="/test/editUser/${user.id}" modelAttribute="user">
					<table>
						<tr>
							<td><form:hidden path="id" value="${user.id}"/>
						</tr>
						<tr>
							<td><form:label class="" path="user_name">User Name: </form:label></td>
							<td><form:input class="form-control" path="user_name" value="${user.user_name}"></form:input></td>
						</tr>
						<tr>
							<td><input type="submit" value="Save" /></td>
						</tr>
					</table>
				</form:form>
                <!-- <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a> -->
            </div>
        </div>
        <!-- /#page-content-wrapper -->
<%@ include file="footer.jsp" %> 