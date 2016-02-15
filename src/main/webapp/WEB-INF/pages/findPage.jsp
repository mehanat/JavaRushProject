<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="../../resources/styles/main.css">
  <script src="../../resources/scripts/jquery-2.1.4.js"></script>
  <script src="../../resources/scripts/ajaxDelete.js"></script>
  <script src="../../resources/scripts/ajaxUpdate.js"></script>

</head>
<body>
<div>
  <form action="/find">
    <span>Поиск: </span>
    <input type="text" name="name">
    <input type="submit" value="Найти">
  </form>
</div>
<strong>РЕЗУЛЬТАТЫ ПОИСКА:</strong>
<table>
  <tr>
    <td>Id</td>
    <td>Имя</td>
    <td>Возраст</td>
    <td>Права администратора</td>
    <td>Дата создания</td>
    <td></td>
  </tr>
  <c:forEach items="${foundedUsers}" var="user">
    <tr class="t-user">
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.age}</td>
      <td>${user.isAdmin}</td>
      <td>${user.createdDate}</td>
      <td id="delete"><button data-id="${user.id}">Удалить</button></td>
    </tr>
  </c:forEach>
  <tr>
    <sf:form method="post" modelAttribute="newUser" action="/addUser">

      <td>+</td>
      <td><sf:input path="name"/></td>
      <td><sf:input path="age"/></td>
      <td><sf:checkbox path="isAdmin" /></td>
      <td></td>
      <td><input type="submit"></td>

    </sf:form>
  </tr>
  <tr id="upd-user">


    <td> </td>
    <td><input/></td>
    <td><input/></td>
    <td><input type="checkbox"/></td>
    <td></td>
    <td><input id="goUpdate" type="submit" value="Редактировать"></td>


  </tr>



</table>
<c:if test="${pageCount>0}">
<c:forEach var="i" begin="0" end="${pageCount-1}">
  <a class="paging" href="find?name=${name}&page=${i}"><c:out value="${i}" /></a>
</c:forEach>
</c:if>
</body>
</html>