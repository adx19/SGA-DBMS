<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head>
<title>Books</title>
<link rel="stylesheet" href="<c:url value='/style.css'/>">
</head><body>
<header>
  <h1>Books</h1>
  <nav>
    <a href="<c:url value='/'/>">Home</a>
    <a href="<c:url value='/authors'/>">Authors</a>
    <a href="<c:url value='/books'/>">Books</a>
  </nav>
</header>
<div class="container">
  <div class="section">
    <h2>All Books</h2>
    <p><a class="btn" href="<c:url value='/books/new'/>">+ Add Book</a></p>
    <table>
      <tr><th>ID</th><th>Title</th><th>Genre</th><th>Year</th><th>Author</th><th>Actions</th></tr>
      <c:forEach var="b" items="${books}">
        <tr>
          <td>${b.id}</td>
          <td>${b.title}</td>
          <td>${b.genre}</td>
          <td>${b.publishedYear}</td>
          <td>${b.author.name}</td>
          <td><a class="btn btn-edit" href="<c:url value='/books/edit/${b.id}'/>">Edit</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>

  <div class="section">
    <h2>Books ⨝ Authors (Custom INNER JOIN query)</h2>
    <table>
      <tr><th>Book Title</th><th>Genre</th><th>Year</th><th>Author Name</th><th>Country</th></tr>
      <c:forEach var="row" items="${joined}">
        <tr>
          <td>${row[0]}</td>
          <td>${row[1]}</td>
          <td>${row[2]}</td>
          <td>${row[3]}</td>
          <td>${row[4]}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body></html>
