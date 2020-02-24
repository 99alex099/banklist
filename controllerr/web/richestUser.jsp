<%@ page import="dto.TotalAccount" %>
<%@ page import="services.interfaces.AccountService" %>
<%@ page import="services.implementations.AccountServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: alex099
  Date: 24.02.2020
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserMenu</title>
</head>
<body>
<%

    AccountService accountService = new AccountServiceImpl();
    TotalAccount totalAccount = accountService.findMaxTotalAccountSum();
    if (totalAccount != null) {
        request.setAttribute("name", totalAccount.getOwner().getName() + " " + totalAccount.getOwner().getSurname());
        request.setAttribute("account", totalAccount.getSum());
    }
%>
<b>Richest user: ${name}</b>
<b>His sum: ${account}</b>

</body>
</html>
