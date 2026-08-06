<%--
  Created by IntelliJ IDEA.
  User: hiroshi
  Date: 2026/08/06
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品削除</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <!-- Google Fontsの読み込み -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="header.jsp" />
<main>
    <article class="registration">
        <h1>商品削除</h1>
        <p class="deleteConfirm">下記の商品を削除します。<br>よろしいですか？</p>
        <div class="back">
            <a href="SearchServlet" class="btn">&lt; 戻る</a>
        </div>
        <form action="DeleteServlet" method="post" class="registration-form">
            <div>
                <label for="item_code">商品コード</label>
                <input type="text" id="item_code" name="itemCode" value="<c:out value="${item.itemCode}" />" readonly>

                <label for="item_name">商品名</label>
                <input type="text" id="item_name" name="name" value="<c:out value="${item.name}" />" readonly>

                <label for="price">単価</label>
                <input type="number" id="price" name="price" value="<c:out value="${item.price}" />" readonly>

                <label for="stock_number">在庫数</label>
                <input type="number" id="stock_number" name="stockNum" value="<c:out value="${item.stockNum}" />" readonly>

                <label for="supplier_code">仕入先コード</label>
                <input type="text" id="supplier_code" name="supplierCode" value="<c:out value="${item.supplierCode}" />" readonly>
            </div>
            <button type="submit" class="submit-btn" name="submit" value="delete">削除</button>
        </form>
    </article>
</main>
<jsp:include page="footer.jsp" />
</body>
</html>

