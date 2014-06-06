<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en" xmlns:ng="http://angularjs.org" id="ng-app">
  <head>
    <meta charset="utf-8">
    <title>TODO</title>
    <asset:javascript src="todo.js"/>
    <asset:stylesheet src="todo.css"/>
  </head>
  <body ng-app="todomvc">
    <ng-view />
  </body>
</html>
