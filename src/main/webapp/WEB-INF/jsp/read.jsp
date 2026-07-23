<%--
  Created by IntelliJ IDEA.
  User: hiroshi
  Date: 2026/07/23
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
    <title>商品一覧</title>
</head>
<header>
  <a href="index.jsp">商品登録アプリ</a>
</header>
<body>
<h1>商品一覧</h1>
<a href="CreateServlet">商品登録</a>
<table>
  <tr>
    <th>商品コード</th><th>商品名</th><th>単価</th><th>在庫数</th><th>仕入先コード</th><th>編集</th><th>削除</th>
  </tr>
  <c:forEach var="item" items="${itemList}">
    <tr>
      <td><c:out value="${item.itemCode}" /></td>
      <td><c:out value="${item.name}" /></td>
      <td><c:out value="${item.price}" /></td>
      <td><c:out value="${item.stockNum}" /></td>
      <td><c:out value="${item.supplierCode}" /></td>
      <td>アイコン</td>
      <td>アイコン</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
