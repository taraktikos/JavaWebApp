<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Import</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
  </head>
  <body>
  <c:import url="/navigation.jsp">
    <c:param name="active" value="import"></c:param>
  </c:import>
    <div class="container">
      <c:if test="${error != null}">
        <div class="alert alert-warning"><c:out value="${error}" /></div>
      </c:if>
      <c:if test="${message != null}">
        <div class="alert alert-success"><c:out value="${message}" /></div>
      </c:if>
      <form role="form" action="CountryController?action=import" method="POST" enctype="multipart/form-data">
        <div class="form-group">
          <label for="exampleInputFile">File input</label>
          <input type="file" id="exampleInputFile" name="file">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  </body>
</html>
