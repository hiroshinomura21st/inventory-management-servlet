<%--
  Created by IntelliJ IDEA.
  User: hiroshi
  Date: 2026/07/29
  Time: 6:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品編集</title>
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
        <h1>商品編集</h1>
        <div class="back">
            <a href="ReadServlet" class="btn">&lt; 戻る</a>
        </div>
        <form action="UpdateServlet" method="post" class="registration-form">
            <div>
                <label for="item_code">商品コード</label>
                <input type="text" id="item_code" name="itemCode" value="<c:out value="${item.itemCode}" />" min="0" max="100000000" required>

                <label for="item_name">商品名</label>
                <input type="text" id="item_name" name="name" value="<c:out value="${item.name}" />" maxlength="50" required>

                <label for="price">単価</label>
                <input type="number" id="price" name="price" value="<c:out value="${item.price}" />" min="0" max="100000000" required>

                <label for="stock_number">在庫数</label>
                <input type="number" id="stock_number" name="stockNum" value="<c:out value="${item.stockNum}" />" min="0" max="100000000" required>

                <label for="supplier_code">仕入先コード</label>
                <select id="supplier_code" name="supplierCode"  required>
                    <option disabled selected value>選択してください</option>
                    <c:forEach var="supplier" items="${supplierList}">
                         <c:choose>
                            <c:when test="${item.supplierCode == supplier.supplierCode}">
                                <option value="${supplier.supplierCode}" selected><c:out value="${supplier.supplierCode}" /></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${supplier.supplierCode}"><c:out value="${supplier.supplierCode}" /></option>
                            </c:otherwise>
                         </c:choose>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="submit-btn" name="submit" value="update">更新</button>
        </form>
    </article>
</main>
<jsp:include page="footer.jsp" />
</body>
</html>
