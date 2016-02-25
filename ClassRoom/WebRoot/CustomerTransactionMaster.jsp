<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
 
<html> 
	<head>
		<title>JSP for CustomerTransactionMasterForm form</title>
	</head>
	<body>
		<html:form action="/[ACTION_PATH]">
			transactionTime : <html:text property="transactionTime"/><html:errors property="transactionTime"/><br/>
			branchName : <html:text property="branchName"/><html:errors property="branchName"/><br/>
			transactionDate : <html:text property="transactionDate"/><html:errors property="transactionDate"/><br/>
			dateOfChqOrDd : <html:text property="dateOfChqOrDd"/><html:errors property="dateOfChqOrDd"/><br/>
			transactionVoucerType : <html:text property="transactionVoucerType"/><html:errors property="transactionVoucerType"/><br/>
			customerId : <html:text property="customerId"/><html:errors property="customerId"/><br/>
			chqOrDdNo : <html:text property="chqOrDdNo"/><html:errors property="chqOrDdNo"/><br/>
			amount : <html:text property="amount"/><html:errors property="amount"/><br/>
			accountNo : <html:text property="accountNo"/><html:errors property="accountNo"/><br/>
			transactionType : <html:text property="transactionType"/><html:errors property="transactionType"/><br/>
			balanceAdjusted : <html:text property="balanceAdjusted"/><html:errors property="balanceAdjusted"/><br/>
			transactionConfirmDate : <html:text property="transactionConfirmDate"/><html:errors property="transactionConfirmDate"/><br/>
			employeId : <html:text property="employeId"/><html:errors property="employeId"/><br/>
			customerTransactionId : <html:text property="customerTransactionId"/><html:errors property="customerTransactionId"/><br/>
			transactionConfirmState : <html:text property="transactionConfirmState"/><html:errors property="transactionConfirmState"/><br/>
			bankName : <html:text property="bankName"/><html:errors property="bankName"/><br/>
			<html:submit/><html:cancel/>
		</html:form>
	</body>
</html>

