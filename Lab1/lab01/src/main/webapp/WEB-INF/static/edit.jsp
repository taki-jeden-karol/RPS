<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

    input[type=submit] {
        background-color: #f44336;
        font-family: Comfortaa;
        color: white;
        padding: 14px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
    }

    input[type=hidden] {
        background-color: #f44336;
        font-family: Comfortaa;
        color: white;
        padding: 14px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
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


<h1>Информация о хозяеве</h1>
<table border="4" style="font-family:Comfortaa,serif ;">
    <tr>
        <td><label>Имя:</label></td>
        <td><c:out value="${master.name}" /></td>
    </tr>
    <tr>
        <td><label>Адрес:</label></td>
        <td><c:out value="${master.address}" /></td>
    </tr>
    <tr>
        <td><label>Имя питомца:</label></td>
        <td><c:out value="${master.petname}" /></td>
    </tr>
    <tfoot>
    <th colspan="2" style="padding: 10px 0px;">
        <c:url value="/master/${master.id}" var="mastaDeleteUrl" />
        <form id="deleteForm"
              action="${mastaDeleteUrl}"
              method="GET">
            <input type="hidden" name="delete" />
            <input type="submit" value="Удалить" />
            <c:url value="/master" var="mastalistUrl" />
            <span><a href="${mastalistUrl}">Отмена</a></span>
        </form>
    </th>
    </tfoot>
</table>