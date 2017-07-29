<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Persona Manager</title>


    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/css/logo-nav.css" var="logonavCss" />

    <link href="${mainCss}" rel="stylesheet" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${logonavCss}" rel="stylesheet" />

  </head>

  <body>

      <!-- Navigation -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container">
              <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                      <span class="sr-only">Toggle navigation</span>
                  </button>
                  <a class="navbar-brand" href="#">Persona Manager</a>
              </div>

          </div>
      </nav>

      <!-- Page Content -->
      <div class="container">
          <h1 class="page-header">Persona Manager</h1>
      </div>
      <!-- jQuery & Bootstrap -->
      <spring:url value="/resources/js/jquery.js" var="jqueryJs" />
      <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

      <script src="${jqueryJs}" type="text/javascript"></script>
      <script src="${bootstrapJs}" type="text/javascript"></script>²

  </body>
</html>
