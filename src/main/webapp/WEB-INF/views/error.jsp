<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head>
<title>Error</title>
<link rel="stylesheet" href="<c:url value='/style.css'/>">
</head><body>
<header><h1>Error</h1>
<nav><a href="<c:url value='/'/>">Home</a></nav>
</header>
<div class="container">
  <div class="error">${errorMessage}</div>
  <a class="btn" href="<c:url value='/'/>">Back to Home</a>
</div>
</body></html>
