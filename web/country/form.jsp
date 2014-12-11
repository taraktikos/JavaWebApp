<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  </body>
</html>
