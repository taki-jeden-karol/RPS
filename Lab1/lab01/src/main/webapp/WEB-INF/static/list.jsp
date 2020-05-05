<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список всех хозяев</title>
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Comfortaa" />
    <style>
        h1 {
            font-size: 200%;
            font-family: Comfortaa;
            color: #a85050;
        }
        a:link, a:visited {
            background-color: #f44336;
            font-family: Comfortaa;
            color: white;
            padding: 14px 25px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
        }

        a:hover, a:active {
            background-color: #a64030;
        }
        th {
            font-weight: normal;
            font-size: 14px;
            color: #000000;
            padding: 10px 12px;
            background: white;
        }
        td {
            color: #3b3c8d;
            border-top: 1px solid white;
            padding: 10px 12px;
            background: rgba(51, 51, 153, .2);
            transition: .3s;
        }
        tr:hover td {
            background: rgba(51, 51, 153, .1);
        }
    </style>
</head>
<body>
<h1>Список всех хозяев</h1>
<br/>
<a href="/master/crt">Добавить хозяина</a>
<br/>
<br/>
<br/>
<table border="4" style="font-family:Comfortaa,serif ;">
    <thead>
    <th>№</th>
    <th>Имя</th>
    <th>Адрес</th>
    <th>Имя питомца</th>
    </thead>
    <c:forEach var ="master" items="${masterList}">
        <c:url value="/master/edit/${master.id}" var="showMastaUrl" />
        <c:url value="/master/${master.id}" var="mastaDeleteUrl" />
        <c:url value="/master/upd/${master.id}" var="mastaUpdUrl" />

        <tr>
            <td><c:out value="${master.id}"/></td>
            <td><c:out value="${master.name}"/></td>
            <td><c:out value="${master.address}"/></td>
            <td><c:out value="${master.petname}"/></td>
            <td>
                <a href="${showMastaUrl}">Просмотр</a> |
                <a href="${mastaUpdUrl}">Изменить</a> |
                <a href="${mastaDeleteUrl}">Удалить</a>
            </td>
        </tr>

    </c:forEach>

    <label><h3>Число новых хозяев = 1</h3></label>
    <h3> Поздравляем с вступлением в ковенант, ТестЛаб2</h3>
</table>
