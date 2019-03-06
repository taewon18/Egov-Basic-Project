<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- 기본 meta -->
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" >
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- //기본 meta -->
	
	<!-- sns 정보제공 -->
	<meta property="og:title" content="한국 연구개발 서비스 협회 " />
	<meta property="og:type" content="website" />
	<meta property="og:url" content="http://www.rndservice.or.kr"/>
	<meta property="og:image" content="http://www.rndservice.or.kr/images/main/sitemain.png" />
	<meta property="og:description" content="한국 연구개발 서비스 협회 방문을 환영합니다." />
	<!-- //sns 정보제공 -->

	<!-- 검색로봇 -->
	<meta name="description" content="홈페이지 설명 150자 미만, SPP의 이런 저런 것들의 정보" />
	<meta name="keywords" content="한국 연구개발 서비스 협회 " />
	<!-- //검색로봇 -->

	<!-- //선행script -->
	<link rel="stylesheet" href="/css/cmn/jquery-ui-1.8.4.custom.css">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="/css/cmn/common.css" />
	<link rel="stylesheet" href="/css/usr/style.css" />

	<!-- 선행script - page가 로드되기 전에 사용되어야 할 스크립트만 넣어주세요 -->
	<script src="https://ajax.googleapis.com/ajax/libs/webfont/1.4.10/webfont.js"></script>
	<script src="/js/cmn/frontend-start-script.js"></script>
	<script src="/js/cmn/common.js"></script>
	
	<!--<script src="/js/cmn/vendor/jquery-1.4.1.js"></script>  -->
	<script src="/js/cmn/vendor/jquery-3.3.1.min.js"></script>
	<script src="/js/cmn/vendor/jquery.validate.js"></script>
	<script src="/js/cmn/vendor/jquery-ui.min.js"></script>
	<script src="/js/usr/common.js"></script> <!-- 퍼블 -->
	
	<!-- 암호화 -->
	<script src="/js/cmn/base64.js"></script>
	<script src="/js/cmn/cryptoJS/aes.js"></script>
	<script src="/js/cmn/cryptoJS/core-min.js"></script>
	<script src="/js/cmn/cryptoJS/pad-zeropadding.js"></script>
	
	<!-- 모달팝업 -->
	<script src="/js/cmn/modal.js"></script>
	