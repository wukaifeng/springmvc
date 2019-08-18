<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>界面标题</title>
</head>
<body>

<form action="testModel" method="post">
	<button type="submit" value="submit"> testModel</button>
</form>
<br>
<form action="testMap" method="post">
	<button type="submit" value="submit"> testMap</button>
</form>
<br>
<form action="testModelAndView" method="post">
	<button type="submit" value="submit"> testModelAndView</button>
</form>
<br>
<form action="testServlet" method="post">
	<button type="submit" value="submit"> testUserObj</button>
</form>
<br>
<form action="testUserObj/1" method="post">
	<input name="userName" type="text" value="zhangsan">
	<input name ="age" type="text" value="12">
	<input name="salary" type="text" value="12.34"> 
	<input name="address.province" type="text" value="上海">
	<input name="address.city" type="text" value="花桥">
	<button type="submit" value="submit"> testUserObj</button>
</form>
<br>

<form action="testRestDelete/1" method="post">
	<input type="hidden" name="_method" value="DELETE">
	<button type="submit" value="submit"> rest delete</button>
</form>
<br>
<form action="testRestPut/1" method="post">
	<input type="hidden" name="_method" value="PUT">
	<button type="submit" value="submit"> rest put</button>
</form>
<br>
<form action="testRestPost" method="post">
	<button type="submit" value="submit"> rest post</button>
</form>
<br>
<a href="testRestGet/1">rest get</a>
<br>
<br>
 <a href="testPathVariable/1">testPathVariable</a>
<br>
<a href="testParamsAndHeaders?userName=zhangsan&age=11">testParamsAndHeaders</a>
<br>
<a href="hello">hello request_get</a>
<br>
<a href="helloPost">hello request_post</a>

<form action="helloPost" method="post">
	<button type="submit" value="submit"> 提交</button>
</form>
 
</body>
</html>