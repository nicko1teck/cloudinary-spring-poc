<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>






<form action="/upload" method="post" enctype="multipart/form-data">
	select photo:
	<input type="file" accept="*" name="file" />
	<input type="submit" value="Upload File" /> 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>



