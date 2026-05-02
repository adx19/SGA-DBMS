<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html><head>
<title>Book Form</title>
<link rel="stylesheet" href="<c:url value='/style.css'/>">
</head><body>
<header>
  <h1>${book.id == null ? 'Add' : 'Edit'} Book</h1>
  <nav>
    <a href="<c:url value='/'/>">Home</a>
    <a href="<c:url value='/authors'/>">Authors</a>
    <a href="<c:url value='/books'/>">Books</a>
  </nav>
</header>
<div class="container">
  <c:set var="action" value="${book.id == null ? '/books' : '/books/update/'.concat(book.id)}"/>
  <form:form class="entity-form" modelAttribute="book" action="${pageContext.request.contextPath}${action}" method="post">
    <label>Title</label>
    <form:input path="title" required="true"/>
    <form:errors path="title" cssClass="error"/>

    <label>Genre</label>
    <form:input path="genre"/>

    <label>Published Year</label>
    <form:input path="publishedYear" type="number"/>

    <label>Author</label>
    <form:select path="author.id">
      <c:forEach var="a" items="${authors}">
        <form:option value="${a.id}">${a.name}</form:option>
      </c:forEach>
    </form:select>
    <form:errors path="author" cssClass="error"/>

    <p style="margin-top:20px;">
      <button type="submit" class="btn">Save</button>
      <a class="btn btn-edit" href="<c:url value='/books'/>">Cancel</a>
    </p>
  </form:form>
</div>
</body></html>
