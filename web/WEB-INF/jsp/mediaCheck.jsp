<%--
  Created by IntelliJ IDEA.
  User: sunbo
  Date: 16/7/5
  Time: 下午8:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>审核类型</title>
    <link href="http://vjs.zencdn.net/5.8/video-js.min.css" rel="stylesheet">
    <script src="http://vjs.zencdn.net/5.8/video.min.js"></script>
    <script src="http://vjs.zencdn.net/5.8.8/video.js"></script>
</head>
<body background="image/a.jpg">
<video id="my-video" class="video-js" controls preload="auto" width="640" height="264" data-setup="{}">
    <source src="${media.file_uri}" type="video/mp4">
    <source src="http://video-js.zencoder.com/oceans-clip.webm" type='video/webm'/>
    <p class="vjs-no-js">
        To view this video please enable JavaScript, and consider upgrading to a web browser that
        <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
    </p>
</video>
<%--<a href="/legal/${media.id}">通过</a>  <a href="/illegal/${media.id}">不通过</a>--%>
<div id="global">
<form method="post" action="check/${media.id}" id="checkResult">
    审核结果:<br/>
    待审核<input type="radio" name="resultStatus" value=1><br/>
    通过<input type="radio" name="resultStatus" value=2 /><br/>
    未通过<input type="radio" name="resultStatus" value=3><br/>
    <textarea name="remark" rows="3" cols="20">备注</textarea>
    <input type="submit" value="确定"/>&nbsp;<input type="reset" value="取消"/>
</form>
</div>
</body>
</html>
