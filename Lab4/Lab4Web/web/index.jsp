<%-- 
    Document   : index
    Created on : 23.05.2020, 17:07:25
    Author     : Алиса
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main page</title>
    </head>
    <body>
        <form action = "TransactionController" method="post">
            <input type="hidden" name="action" value="master">
            <input type="submit" value="Transaction to Master">
        </form><br>
        <form action = "TransactionController" method="post">
            <input type="hidden" name="action" value="petschool">
            <input type="submit" value="Transaction to Petschool">
        </form>
    </body>
</html>
