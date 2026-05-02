<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head>
<title>Authors</title>
<link rel="stylesheet" href="<c:url value='/style.css'/>">
</head><body>
<header>
  <h1>Authors</h1>
  <nav>
    <a href="<c:url value='/'/>">Home</a>
    <a href="<c:url value='/authors'/>">Authors</a>
    <a href="<c:url value='/books'/>">Books</a>
  </nav>
</header>
<div class="container">
  <h2>All Authors</h2>
  <p><a class="btn" href="<c:url value='/authors/new'/>">+ Add Author</a></p>
  <table>
    <tr><th>ID</th><th>Name</th><th>Country</th><th>Books</th><th>Actions</th></tr>
    <c:forEach var="a" items="${authors}">
      <tr>
        <td>${a.id}</td>
        <td>${a.name}</td>
        <td>${a.country}</td>
        <td>${a.books.size()}</td>
        <td><a class="btn btn-edit" href="<c:url value='/authors/edit/${a.id}'/>">Edit</a></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body></html>
