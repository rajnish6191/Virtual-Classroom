<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for DesignationMasterForm form</title>
	</head>
	<body>
		<html:form action="/[ACTION_PATH]">
			inchargeDesignationId : <html:text property="inchargeDesignationId"/><html:errors property="inchargeDesignationId"/><br/>
			designationInchargeId : <html:text property="designationInchargeId"/><html:errors property="designationInchargeId"/><br/>
			abbrevation : <html:text property="abbrevation"/><html:errors property="abbrevation"/><br/>
			designationId : <html:text property="designationId"/><html:errors property="designationId"/><br/>
			designationName : <html:text property="designationName"/><html:errors property="designationName"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

