# はじめに
本プロジェクトはKENスクール Webアプリ開発科 の最終課題、
「レンタルサイト新規構築 要望書」を元にログイン機能＋1機能を
新規で構築するという課題の成果物です。プロジェクト名は要望書の発行元「Music Life Agency」をベースにしております。

## DEMO(準備中 #2)
[https://mla-web.herokuapp.com/](https://mla-web.herokuapp.com/)

## 開発環境
* [Windows10 64bit](https://www.microsoft.com/ja-jp/store/b/windows)（KENスクールでは**CentOS Linux 7**を使用）
* [Java SE Ver15.0.2](https://www.oracle.com/java/technologies/javase-downloads.html)（Java Development Kit）
* [Eclipse 2020 Pleiades All in One 最新版](https://mergedoc.osdn.jp/) (KENスクールでは2018を使用)
	* spring framework Ver4.0.3.RELEASE (Java Webシステム構築用)
	* hibernate Ver4.3.6.Final (MySQL DB接続用)
	* [Spring Tool Suite 3](https://github.com/spring-projects/toolsuite-distribution/wiki/Spring-Tool-Suite-3) (spring framework レガシープロジェクト作成用)
	* DBViewer Plugin for Eclipse(MySQL DB参照／編集用)
	* [Apache Tomcat9](https://tomcat.apache.org/download-90.cgi)(ローカル実行環境用。KENスクールでは8を使用)
	* [Apache Maven Ver3.6.3](https://maven.apache.org/download.cgi)(パッケージ管理、リモートビルド用)
* [MySQL Ver8.0.23](https://dev.mysql.com/)（DateBase）
* [AdminLTE 3](https://adminlte.io/themes/v3/)(管理画面特化型CSSフレームワーク)
	* [jQuery Ver3.5.1](https://jquery.com/)(JavaScriptライブラリ)
	* [Bootstrap Ver4.5.3](https://getbootstrap.com/)(WEBフレームワーク)
* [Git Hub](https://github.com/)(開発コード管理／公開用)
* [heroku](https://jp.heroku.com/) (DEMOページ公開用クラウドサーバー構築用) 

## ローカル実行環境構築手順
1. 上記開発環境の[Java SE Ver15.0.2](https://www.oracle.com/java/technologies/javase-downloads.html) 〜 [MySQL Ver8.0.23](https://dev.mysql.com/)までを全てインストールする。
2. MySQLにUser名:**root** パスワード:**無し**で管理者を設定し、**spring_database**というデータベースを設定。
3. 本ページのプロジェクト一式をGit Clone 又は Download ZIPにて入手
4. Eclipseにプロジェクトをインポートする。
5. 本プロジェクトTOPの**db_setup.sql**をEclipseのDBViewer、又はコマンドから実行する。
6. Eclipseから本プロジェクトを**サーバーで実行**する。
7. ブラウザにて[http://localhost:8080/mla/index](http://localhost:8080/mla/index)を開く

## Webアプリ操作手順
### 【1. TOP画面(未ログイン)】
* 右上の**ログイン**ボタンをクリックすると【2. ログイン画面】に遷移します。

### 【2. ログイン画面】
* Email:**a@a.com** Password: **aaa** を入力し、**ログイン**ボタンをクリックすると【5. TOP画面(管理者ログイン)】に遷移します。
* Email:**b@b.com** Password: **bbb** を入力し、**ログイン**ボタンをクリックすると【4. TOP画面(会員ログイン)】に遷移します。
* **新規登録**のリンクを クリックすると【3. 新規会員登録画面】に遷移します。

### 【3. 新規会員登録画面】
* 各項目を入力後、**登録**ボタンをクリックすると【4. TOP画面(会員ログイン)】に遷移します。

### 【4. TOP画面(会員ログイン)】
* 会員ユーザが表示され、プラン、ポイントの確認、会員権限メニューが使用可能になります。
* サイドメニューの**個人情報管理**のリンクを クリックすると【6. 個人情報管理画面】に遷移します。
* 右上の**ログアウト**ボタンをクリックすると【2. ログイン画面】に遷移します。

### 【5. TOP画面(管理者ログイン)】
* 管理者ユーザが表示され、プラン、ポイントの確認、管理者権限メニューが使用可能になります。
* サイドメニューの**個人情報管理**のリンクを クリックすると【6. 個人情報管理画面】に遷移します。
* 右上の**ログアウト**ボタンをクリックすると【2. ログイン画面】に遷移します。

### 【6. 個人情報管理画面】
* 各項目を入力後、**更新**ボタンをクリックするとユーザ情報が更新され前の画面に遷移します。
* **退会**ボタンをクリックすると、確認後に【1. TOP画面(未ログイン)】に遷移します。

※各画面のスクショを用意する(準備中)

## 自身で作成した主なファイル
* /mla/src/main/java/jp/ken/mla 配下
	* javaで作成したコード。Controller, dao, entity, model 等
* /mla/src/main/webapp/WEB-INF/views 配下
	* JSPで作成したWebページ一式 


