<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="left">
	<div class="_top verticalM" Style="text-align:center;">
		<span>로그아웃</span>
		<span id="timer"></span>
		<button type="button" class="img-button button small blue" onclick="javascript:refreshTimer();">연장</button>
	</div>
	<div class="current-page">
		<dl>
			<dt>신고유형</dt>
			<dd>${rnDRegisterInfo.rnDRegisterKindCodeNm}</dd>
		</dl>
		<dl>
			<dt>진행</dt>
			<dd>${rnDRegisterInfo.rnDRegisterStatusCodeNm}</dd>
		</dl>
		<dl>
			<dt>신고번호</dt>
			<dd>${rnDRegisterInfo.rnDRegisterApprovalNumber}</dd>
		</dl>
		
		<div class="left-table">
			<table style="border-collapse: separate;">
				<caption>상태, 처리일자</caption>
				<colgroup>
					<col style="width:37%">
					<col>
				</colgroup>
				<thead>
					<tr>
						<th scope="col">상태</th>
						<th scope="col">처리일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="registInfoList" items="${registInfoList}">
					<tr>
						<td>
							<button onclick="javascript:registView('${registInfoList.companyRegistrationNumber}', '${registInfoList.rnDRegisterNumber}','${registInfoList.rnDRegisterKindCode}','${registInfoList.rnDRegisterStatusCode}');">
							${registInfoList.rnDRegisterKindCodeNm}
							</button>
						</td>
						<td>
							<button onclick="javascript:registView('${registInfoList.companyRegistrationNumber}', '${registInfoList.rnDRegisterNumber}','${registInfoList.rnDRegisterKindCode}','${registInfoList.rnDRegisterStatusCode}');">
							${registInfoList.approvalDateTime}
							<c:if test="${empty registInfoList.approvalDateTime}">현재신고서</c:if>
							</button>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
	var iSecond; //초단위로 환산
	var timerchecker = null;
	
	$(document).ready(function(){
		fncClearTime();
	    initTimer();
	});
	
	/* 
	window.onload = function() {
	    fncClearTime();
	    initTimer();
	}
	*/
	 
	function fncClearTime() {
	    iSecond = 900;
	}
	 
	Lpad = function(str, len) {
	    str = str + "";
	    while (str.length < len) {
	        str = "0" + str;
	    }
	    return str;
	}
	 
	initTimer = function() {
	    var timer = document.getElementById("timer");
	    rHour = parseInt(iSecond / 3600);
	    rHour = rHour % 60;
	 
	    rMinute = parseInt(iSecond / 60);
	    rMinute = rMinute % 60;
	 
	    rSecond = iSecond % 60;
	 
	    
	    
	    if (iSecond > 0) {
	        timer.innerHTML = 
	        		//"&nbsp;" + Lpad(rHour, 2) + "시간 "+
	        		Lpad(rMinute, 2)
	                + "분 " + Lpad(rSecond, 2) + "초 ";
	        iSecond--;
	        timerchecker = 1000; 
	        	setTimeout("initTimer()", 1000); // 1초 간격으로 체크\ 개발임시주석
	        if(iSecond==59){
	        	alert("로그아웃 1분전입니다 연장버튼을 눌러주세요");
	        }
	    } else {
	        logoutUser();
	    }
	}
	 
	function refreshTimer() {
	    var xhr = initAjax();
	    //xhr.open("POST", "/jsp_std/kor/util/window_reload2.jsp", false);
	    //xhr.send();
	    fncClearTime();
	}
	 
	function logoutUser() {
		alert("이용시간이 만료되었습니다.");
		window.location.href="/usr/login/logout.do";
	    //clearTimeout(timerchecker);
	    //var xhr = initAjax();
	    //xhr.open("POST", "www.naver.com", true);
	    //xhr.send();
	    //location.reload();
	}
	 
	function initAjax() { // 브라우저에 따른 AjaxObject 인스턴스 분기 처리
	    var xmlhttp;
	    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	        xmlhttp = new XMLHttpRequest();
	    } else {// code for IE6, IE5
	        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }
	    return xmlhttp;
	}

	function registView(companyRegistrationNumber,rnDRegisterNumber,rnDRegisterKindCode,rnDRegisterStatusCode){
		window.open("/usr/regist/registUpdate/leftPopup.do?companyRegistrationNumber="+companyRegistrationNumber+"&rnDRegisterNumber="+rnDRegisterNumber+"&rnDRegisterKindCode="+rnDRegisterKindCode+"&rnDRegisterStatusCode="+rnDRegisterStatusCode,"_blank", "left=10, top=10, width=730, height=500, scrollbars=yes, resizable=yes");
	}
</script>