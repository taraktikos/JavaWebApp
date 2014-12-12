<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Show countries</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  </head>
  <body>
  <c:import url="/navigation.jsp">
    <c:param name="active" value="country"></c:param>
  </c:import>
    <div class="container">
      <div class="filter">
        <form class="form-inline" role="form" action="CountryController">
          <input type="hidden" name="action" value="list" />
          <div class="form-group">
            <div class="input-group">
              <label class="sr-only" for="exampleInput1">Email address</label>
              <input value="<c:out value="${filterName}" />" name="name" type="text" class="form-control" id="exampleInput1" placeholder="Name">
            </div>
          </div>
          <div class="form-group">
            <label class="sr-only" for="exampleInput2">Password</label>
            <input value="<c:out value="${filterCode}" />" name="code" type="text" class="form-control" id="exampleInput2" placeholder="Code">
          </div>
          <button type="submit" class="btn btn-default">Search</button>
        </form>
      </div>
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
