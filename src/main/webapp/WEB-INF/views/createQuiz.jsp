<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ include file="header.jsp" %> 
<!-- Page Content -->
<div id="page-content-wrapper">
  <div class="container-fluid">
    <h1>${user.user_name}, Create your Quiz!</h1>
    <form:form action="/test/createQuiz" method="post" modelAttribute="quiz">
      <%for(int i=0; i<4; i++)  { %>
	      <div class="form-group">
	        <label for="questions[<%= i %>].question">Question <%= i + 1 %>:</label>
	        <input type="text" name="questions[<%= i %>].question" class="form-control" id="question" placeholder="Type a question here" />
	        <input type="hidden" name="questions[<%= i %>].id" value="<%= i %>" />
	        <!-- <input type="text" class="form-control" id="question" name="question" placeholder="Type a question here" /> -->
	      </div>
	      <div class="form-group">
	        <label>Answers:</label>
	        <%for(int j=0; j<4; j++) { %>
	        <div class="input-group">
	          <div class="input-group-prepend">
	            <div class="input-group-text">
	              <input type="radio" aria-label="Radio button for following text input">
	            </div>
	          </div>
	          <input type="text" name="answers[<%= j %>].answer" class="form-control" id="answer" placeholder="Type an answer here" />
	          <input type="hidden" name="answers[<%= j %>].questionId" value="<%= i %>" />
	        </div>
	        <% }%>
	        <!-- <input type="text" class="form-control" id="answer" name="answer" placeholder="Type an answer here" /> -->
	      </div>
      <%  }%>
      <input type="hidden" name="id" value="1" />
      <button type="submit" class="btn btn-primary">Create Quiz</button>
    </form:form>
    <br/>
    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
  </div>
</div>
<script type="text/javascript"></script>
<!-- /#page-content-wrapper -->
<%@ include file="footer.jsp" %>