<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head>
<title>Books & Authors</title>
<link rel="stylesheet" href="<c:url value='/style.css'/>">
</head><body>
<header>
  <h1>Books & Authors Management</h1>
  <nav>
    <a href="<c:url value='/'/>">Home</a>
    <a href="<c:url value='/authors'/>">Authors</a>
    <a href="<c:url value='/books'/>">Books</a>
  </nav>
</header>
<div class="container">
  <h2>Welcome</h2>
  <p>This Spring Boot + JSP application manages <strong>Books</strong> and <strong>Authors</strong>.</p>
  <ul>
    <li>Create, list, and update authors</li>
    <li>Create, list, and update books (linked to an author)</li>
    <li>Custom inner-join query joining both tables</li>
  </ul>
  <p>
    <a class="btn" href="<c:url value='/authors'/>">Manage Authors</a>
    <a class="btn" href="<c:url value='/books'/>">Manage Books</a>
  </p>
</div>
</body></html>
