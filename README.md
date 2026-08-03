# Inventory Management Servlet

Java Servlet・JSP・JDBCを用いて開発した在庫管理Webアプリケーションです。

**Version:** 1.0.0  
**Status:** Released  
**Database:** H2 Database


## 概要

本アプリは、PHPで開発した在庫管理アプリを、Java Servlet・JSP・JDBCを使って再設計・再実装することを目的として制作した作品です。

教材『スッキリわかるサーブレット＆JSP入門 第5版』を参考に学習を進めながら、画面構成・データベース設計・画面遷移・データの流れを自分で考えて実装しました。

単にPHPのコードをJavaへ書き換えたのではなく、実際にPHP版アプリを動かし、その動きをもとにJavaらしい構成を考えながら設計・実装しています。そのため、処理やクラス構成はPHP版とは異なる部分が多くあります。

本作品を通して、Java Webアプリケーション開発の基礎技術と、既存アプリケーションを別言語で再設計・再実装する力の習得を目指しました。

---

## 使用技術

- Java 17
- Servlet
- JSP
- JSTL
- JDBC
- Maven
- H2 Database 2.4.240
- HTML
- CSS
- Apache Tomcat 10
- IntelliJ IDEA
- Git
- GitHub

---

## 主な機能

- 商品一覧表示
- 商品登録
- 商品編集
- 商品削除
- 商品名検索
- 商品名昇順・降順ソート
- メッセージ表示
- 検索状態を保持した登録・編集・削除

---

## 工夫した点

PHP版の在庫管理アプリと同じ操作性を目標にJavaで再実装しました。

- PHP版と同じ操作性になるよう画面遷移を設計しました。
- 検索条件や並び順をセッションで保持し、登録・編集・削除後も元の一覧へ戻れるようにしました。
- 上記の点は、PHP版には存在しない機能で実質アップグレードしています。
- DAOパターンを採用し、データアクセスとビジネスロジックを分離しました。
- 実際に操作しながら不具合を発見し、検索結果が失われないようロジックを改善しました。
- PHP版の仕様を参考にしつつ、Javaらしいクラス構成や処理の流れを意識して設計しました。

---

## ディレクトリ構成

```text
src/main/java
└── me.nomurahiroshi.inventorymanagementservlet
    ├── servlet
    ├── bo
    ├── dao
    └── model

src/main/webapp
├── css
├── images
└── WEB-INF/jsp
```

---

## 画面

主な画面は以下のとおりです。

### トップ画面

![トップ画面](src/main/webapp/images/top.png)

### 商品一覧画面

![商品一覧](src/main/webapp/images/read.png)

### 商品登録画面

![商品登録](src/main/webapp/images/create.png)

### 商品編集画面

![商品編集](src/main/webapp/images/update.png)


## データベース

Ver.1.0ではH2 Databaseを使用しています。

---

## 今後の開発予定

### Ver.2.0

- PostgreSQL対応

### Ver.3.0

- 削除確認画面
- バッチ処理

---

## 作者

野村　広

## 公開について

本プロジェクトは、ポートフォリオ・学習目的で公開しています。
