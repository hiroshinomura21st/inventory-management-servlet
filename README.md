# Inventory Management Servlet

Java Servlet・JSP・JDBCを用いて開発した在庫管理Webアプリケーションです。

**Version:** 1.0.0  
**Status:** Released  
**Database:** H2 Database


## 概要

本アプリは、PHPで開発した在庫管理アプリを、Java Servlet・JSP・JDBCの理解を深めることを目的として、一から再設計・再実装した作品です。

教材『スッキリわかるサーブレット＆JSP入門 第5版』を参考に学習を進めながら、画面構成・データベース設計・画面遷移・データの流れを自分で考えて実装しました。

単にPHPのコードをJavaへ書き換えたのではなく、実際にPHP版アプリを動かし、その仕様をもとにJavaらしい構成を考えながら設計・実装しています。そのため、一部の処理やクラス構成はPHP版とは異なる実装になっています。

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
- 検索状態を保持した編集・削除

---

## 工夫した点

PHP版の在庫管理アプリと同じ操作性を目標にJavaで再実装しました。

- PHP版と同じ操作性になるよう画面遷移を設計しました。
- 検索条件や並び順をセッションで保持し、編集・削除後も元の一覧へ戻れるようにしました。
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

![トップ画面](images/top.png)

### 商品一覧画面

![商品一覧](images/read.png)

### 商品登録画面

![商品登録](images/create.png)

### 商品編集画面

![商品編集](images/update.png)

### 商品検索画面

![商品検索](images/search.png)


## データベース

Ver.1.0ではH2 Databaseを使用しています。

ローカル環境での開発・動作確認を目的として採用しました。

今後はPostgreSQLへ移行し、Herokuなどのクラウド環境でもデータを永続化できるよう改善する予定です。

---

## 今後の改善予定

### Ver.2.0

- PostgreSQL対応
- Heroku環境でのデータ永続化
- 接続設定の改善

### Ver.3.0

- 削除確認画面
- バッチ処理
- エラーハンドリング強化
- UI改善

---

## 作者

Hiroshi Nomura

## 公開について

本プロジェクトは、ポートフォリオ・学習目的で公開しています。
