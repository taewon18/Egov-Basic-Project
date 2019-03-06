<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div id="header">
	<div class="topInfoList">
		<div class="logo">
			<a href="/usr/home/index.do">
				<img src="/images/cmn/logo.gif" alt="한국연구개발서비스협회" />
			</a>
		</div>
		<div class="navigation">
			<ul>
				<li><a href="/usr/registGuide/requirements.do">신고제도 안내</a></li>
				<c:if test="${rnDRegisterInfo.getRnDRegisterKindCode() eq 1&&rnDRegisterInfo.getRnDRegisterStatusCode() ne 10}">
					<li><a href="/usr/regist/newRegist/regist.do">신고하기</a></li>
				</c:if>
				<c:if test="${rnDRegisterInfo.getRnDRegisterStatusCode() eq 10}">
					<li><a href="/usr/registGuide/registUpdate.do">신고하기</a></li>
				</c:if>
				<c:if test="${rnDRegisterInfo.getRnDRegisterKindCode() eq 2&&rnDRegisterInfo.getRnDRegisterStatusCode() ne 10}">
					<li><a href="/usr/regist/registUpdate/regist.do">신고하기</a></li>
				</c:if>
				<c:if test="${empty rnDRegisterInfo.getRnDRegisterKindCode()}">
					<li><a href="/usr/login/login.do">신고하기</a></li>
				</c:if>
				<li><a href="/usr/statistics/view.do">주요통계</a></li>
				<li><a href="/usr/faq/listFAQ.do">FAQ</a></li>
				<c:if test="${empty loginVO.getCompanyName()}">
					<c:if test="${empty CompanyRegistrationNumber}">
						<li><a href="/usr/login/login.do">로그인</a></li>
					</c:if>		
				</c:if>	
			</ul>
		</div>
		
		<div class="member-menu">
			<c:if test="${not empty CompanyRegistrationNumber}">
				<c:if test="${not empty loginVO.getCompanyName()}">
					<ul>
						<li><a href="javascript:void(0);">
								<c:choose>
					           		<c:when test="${fn:length(loginVO.getCompanyName()) > 10}">
					            		<c:out value="${fn:substring(loginVO.getCompanyName(),0,9)}"/>....
					           		</c:when>
					           		<c:otherwise>
					            		<c:out value="${loginVO.getCompanyName()}"/>
					           		</c:otherwise> 
					         	</c:choose>
							</a>
						</li>
						<li><a href="/usr/regist/registUpdate/changeCompanyInfo.do">정보변경</a></li>
						<li><a href="/usr/login/logout.do">로그아웃</a></li>
					</ul>	
				</c:if>
				<c:if test="${empty loginVO.getCompanyName()}">
					<ul>
						<li><a href="javascript:void(0);">(신고서작성중)</a></li>
						<li class="w50p"><a href="/usr/login/logout.do">로그아웃</a></li>
					</ul>
				</c:if>
			</c:if>
		</div>
	</div>
</div>