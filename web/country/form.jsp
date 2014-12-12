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
      <form role="form" action="CountryController?action=country" method="POST">
        <input type="hidden" readonly="readonly" name="id" value="<c:out value="${model.id}" />" />
        <div class="form-group">
          <label for="input1">Name</label>
          <input name="name" type="text" class="form-control <c:if test="${errors.containsKey('name')}">has-error</c:if>" id="input1" placeholder="Enter name" value="<c:out value="${model.name}" />">
          <c:if test="${errors.containsKey('name')}">
            <div class="alert alert-warning"><c:out value="${errors['name']}"/></div>
          </c:if>
        </div>
        <div class="form-group">
          <label for="input2">Code</label>
          <input name="code" type="text" class="form-control <c:if test="${errors.containsKey('code')}">has-error</c:if>" id="input2" placeholder="Enter code" value="<c:out value="${model.code}" />">
          <c:if test="${errors.containsKey('code')}">
            <div class="alert alert-warning"><c:out value="${errors['code']}"/></div>
          </c:if>
        </div>
        <div class="form-group">
          <label for="input3">Long Code</label>
          <input name="longCode" type="text" class="form-control <c:if test="${errors.containsKey('longCode')}">has-error</c:if>" id="input3" placeholder="Enter long code" value="<c:out value="${model.longCode}" />">
          <c:if test="${errors.containsKey('longCode')}">
            <div class="alert alert-warning"><c:out value="${errors['longCode']}"/></div>
          </c:if>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  </body>
</html>
