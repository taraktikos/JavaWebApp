<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <li class="<c:if test="${param.active=='home'}">active</c:if>"><a href="/index.jsp">Home</a></li>
        <li class="<c:if test="${param.active=='country'}">active</c:if>"><a href="CountryController?action=list">Countries</a></li>
        <li><a href="#">Regions</a></li>
        <li><a href="#">Cities</a></li>
        <li><a href="#">Postcodes</a></li>
        <li class="<c:if test="${param.active=='import'}">active</c:if>"><a href="CountryController?action=import">File upload</a></li>
      </ul>
    </div>
  </div>
</nav>
