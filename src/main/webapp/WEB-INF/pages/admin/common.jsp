<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()
			+ "://"
			+ request.getServerName()
			+ ((request.getServerPort() == 80) ? "" : ":"
					+ request.getServerPort()) + path;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- jQuery库 -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/themes/gray/easyui.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/js/themes/icon.css" />" />
<script type="text/javascript" src="<c:url value="/js/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.easyui.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/locale/easyui-lang-zh_CN.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jquery.uploadify-3.1.min.js" />"></script>
<c:url var="ctx" value="/" />
<script type="text/javascript">
	var ctx = '${ctx}';
	var $min = $;
</script>