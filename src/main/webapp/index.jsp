<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>商品管理アプリ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <!-- Google Fontsの読み込み -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">
</head>

<body>
    <jsp:include page="WEB-INF/jsp/header.jsp" />
    <main>
        <article class="home">
            <h1>商品管理アプリ</h1>
            <p>Servlet & JSP版</p>
            <a href="ReadServlet" class="btn">商品一覧</a>
        </article>
    </main>
    <jsp:include page="WEB-INF/jsp/footer.jsp" />
</body>

</html>