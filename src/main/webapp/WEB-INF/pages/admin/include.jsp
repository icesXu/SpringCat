<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/easyui/icon.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/easyui/metro/easyui.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/tencr.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/main.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/rytpay/payMgr.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/rytpay/bfMgr.css"/>' />
<script type="text/javascript" src='<c:url value="/js/jquery-1.9.1.min.js"/>?versionnumber=<spring:message code="vn"></spring:message>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery.easyui.min.js"/>?versionnumber=<spring:message code="vn"></spring:message>'></script>
<script type="text/javascript" src='<c:url value="/js/datagrid-detailview.js"/>?versionnumber=<spring:message code="vn"></spring:message>'></script>
<script type="text/javascript" src='<c:url value="/js/easyui-lang-zh_CN.js"/>?versionnumber=<spring:message code="vn"></spring:message>'></script>
<script type="text/javascript" src='<c:url value="/js/Constant.js"/>?versionnumber=<spring:message code="vn"></spring:message>'></script>
<script type="text/javascript" src='<c:url value="/js/payMgrCommon.js"/>?versionnumber=<spring:message code="vn"></spring:message>'></script>
<script type="text/javascript" src='<c:url value="/js/jquery.form.js"/>?versionnumber=<spring:message code="vn"></spring:message>'></script>
<%-- <script type="text/javascript" src='<c:url value="/js/payMgrConstant.js"/>?versionnumber=<spring:message code="vn"></spring:message>'> </script> --%>

<style type="text/css">
    /*-- 消除grid屏闪问题 --//*/
    .datagrid-mask{
      opacity:0;
      filter:alpha(opacity=0);
    }
    .datagrid-mask-msg{
      opacity:0;
      filter:alpha(opacity=0);
    }
</style>

<c:url var="ctx" value="/" />
<script type="text/javascript">
	var ctx = '${ctx}';
	var $min = $;
</script>
