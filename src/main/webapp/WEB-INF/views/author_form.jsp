<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html><head>
<title>Author Form</title>
<link rel="stylesheet" href="<c:url value='/style.css'/>">
</head><body>
<header>
  <h1>${author.id == null ? 'Add' : 'Edit'} Author</h1>
  <nav>
    <a href="<c:url value='/'/>">Home</a>
    <a href="<c:url value='/authors'/>">Authors</a>
    <a href="<c:url value='/books'/>">Books</a>
  </nav>
</header>
<div class="container">
  <c:set var="action" value="${author.id == null ? '/authors' : '/authors/update/'.concat(author.id)}"/>
  <form:form class="entity-form" modelAttribute="author" action="${pageContext.request.contextPath}${action}" method="post">
    <label>Name</label>
    <form:input path="name" required="true"/>
    <form:errors path="name" cssClass="error"/>

    <label>Country</label>
    <form:input path="country"/>

    <p style="margin-top:20px;">
      <button type="submit" class="btn">Save</button>
      <a class="btn btn-edit" href="<c:url value='/authors'/>">Cancel</a>
    </p>
  </form:form>
</div>
</body></html>
