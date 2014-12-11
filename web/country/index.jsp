<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Show countries</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  </head>
  <body>
    <nav class="navbar navbar-default" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Java</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li><a href="/index.jsp">Home</a></li>
            <li class="active"><a href="CountryController?action=list">Countries</a></li>
            <li><a href="#">Regions</a></li>
            <li><a href="#">Cities</a></li>
            <li><a href="#">Postcodes</a></li>
            <li><a href="#">File upload</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container">
      <table class="table">
        <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Code</th>
          <th>Long code</th>
          <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${countries}" var="model">
          <tr>
            <td><c:out value="${model.id}" /></td>
            <td><c:out value="${model.name}" /></td>
            <td><c:out value="${model.code}" /></td>
            <td><c:out value="${model.longCode}" /></td>
            <td>
              <a class="btn btn-default" href='CountryController?action=edit&id=<c:out value="${model.id}"/>'>Update</a>
              <a class="btn btn-warning" href='CountryController?action=delete&id=<c:out value="${model.id}"/>'>Delete</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <p><a class="btn btn-primary" href="CountryController?action=insert">Add Country</a></p>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  </body>
</html>
