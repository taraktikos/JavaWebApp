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
