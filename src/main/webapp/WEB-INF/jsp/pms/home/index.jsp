<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/pms/include/_dtd.jsp"%>
    <title>pms</title>
</head>
<body>
    <div id="wrap">
        <!--<jsp:include page="/pms/include/_head.do"/>-->
        <div id="content">
            <div class="indexBox">
            		<table>
						<colgroup>
							<col style="width: 20%">
							<col style="width: 20%">
							<col style="width: 20%">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">사업번호</th>
								<th scope="col">사업번호2</th>
								<th scope="col">사업명</th>
							</tr>
						</thead>
						<tbody>
            				<c:forEach var="businessList" items="${businessList}" varStatus="status">
            					<tr class="fold">
									<td><c:out value="${businessList.BIZ_NO}" /></td>
									<td><c:out value="${businessList.BIZ_NUMBER}" /></td>
									<td><c:out value="${businessList.BIZ_NAME}" /></td>
								</tr>
            				</c:forEach>
            			</tbody>
            	
            				
                </table>
            </div>
        </div>
        <!--<jsp:include page="/pms/include/_footer.do"/>-->
    </div>
    
</body>
</html>