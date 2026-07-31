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
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品一覧</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

  <!-- Google Fontsの読み込み -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
</head>

<body>
  <jsp:include page="header.jsp" />
  <main>
    <article class="items">
      <h1>商品一覧</h1>
      <c:if test="${Msg != null}">
        <p class="success"><c:out value="${Msg}" /></p>
      </c:if>
      <div class="items-ui">
        <div>
          <form action="SearchServlet" method="post" class="search-form">
            <button type="submit" name="order" value="DESC" class="sort-button">
              <img src="images/desc.png" alt="降順" class="sort-img">
            </button>
            <button type="submit" name="order" value="ASC" class="sort-button">
              <img src="images/asc.png" alt="昇順" class="sort-img">
            </button>
            <input type="search" name="keyword" placeholder="商品名で検索" value="${keyword}" class="search-box">
          </form>
        </div>
        <a href="CreateServlet" class="btn">商品登録</a>
      </div>
      <table class="items-table">
        <tr>
          <th>商品コード</th>
          <th>商品名</th>
          <th>単価</th>
          <th>在庫数</th>
          <th>仕入先コード</th>
          <th>編集</th>
          <th>削除</th>
        </tr>
        <c:forEach var="item" items="${itemList}">
          <tr>
            <td><c:out value="${item.itemCode}" /></td>
            <td><c:out value="${item.name}" /></td>
            <td><c:out value="${item.price}" /></td>
            <td><c:out value="${item.stockNum}" /></td>
            <td><c:out value="${item.supplierCode}" /></td>
            <td><a href="UpdateServlet?itemCode=<c:out value="${item.itemCode}" />"><img src="images/edit.png" alt="編集" class="edit-icon"></a></td>
            <td><a href="DeleteServlet?itemCode=<c:out value="${item.itemCode}" />"><img src="images/delete.png" alt="削除" class="delete-icon"></a></td>
          </tr>
        </c:forEach>
      </table>
    </article>
  </main>
</body>
<jsp:include page="footer.jsp" />

</html>
