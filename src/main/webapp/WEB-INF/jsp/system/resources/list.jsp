<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/resources/list.js"></script>
	<header class="panel-heading">
	<div class="doc-buttons">
		<c:forEach items="${res}" var="key">
			${key.description}
		</c:forEach>
	</div>
	</header>
	<div class="table-responsive">
		<div id="paging" class="pagclass"></div>
	</div>
<script>
$("#seach").click("click", function() {// 绑定查询按扭
	console.log($("#searchForm").serializeJson());
	/*var searchParams = $("#searchForm").serializeJson();
	grid.setOptions({
		data : searchParams
	});*/
});
</script>