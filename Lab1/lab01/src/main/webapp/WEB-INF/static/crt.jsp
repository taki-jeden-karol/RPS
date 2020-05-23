<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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



<h1>Добавить хозяина</h1>

<c:url value="/master/crt" var="crtMastaUrl" />
<form id="addTaskForm" action="${crtMastaUrl}" method="POST">
    <table border="4" style="font-family:Comfortaa,serif ;">
        <tr>
            <td><label>Имя:</label></td>
            <td><input name="name" type="text" style="font-family:Comfortaa,serif ;"
                    <c:out value="${master.name}"/>/>
            </td>
        </tr>
        <tr>
            <td><label>Адрес:</label></td>
            <td><input name="address" type="text" style="font-family:Comfortaa,serif ;"
                    <c:out value="${master.address}"/>/>
            </td>
        </tr>
        <tr>
            <td><label>Имя питомца:</label></td>
            <td><input name="petname" type="text" style="font-family:Comfortaa,serif ;"
                    <c:out value="${master.petname}"/>/>
            </td>
        </tr>
        <tr>
        <tfoot>
        <th colspan="4" style="padding: 10px 0px;">
            <c:url value="/master" var="mastalistUrl" />
            <input type="submit" value="Добавить" />
            <span><a href="${mastalistUrl}">Отмена</a></span>
        </th>
        </tfoot>
    </table>
</form>