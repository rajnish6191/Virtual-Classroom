<html>
	<head>
		<meta http-equiv="content-type"
			content="text/html; charset=ISO-8859-1">

		<title>VirtualClassRoom</title>
		<script type="text/javascript">
function validate() {
	var form = document.register
	if (form.username.value == "") {
		alert("User Name is Required");
		return false;
	} else if (form.password.value == "") {
		alert("Pass Word is Required");
		return false;
	}
	return true;
}
</script>

		<script type="text/javascript">
//var x_win = window.self; 

function goOn() {
	var port = document.register.port.value;
	var host = document.register.host.value;
	var userName = document.register.loginid.value;
	window.location.href = 'http://' + host + ':' + port
			+ '/ClassRoom/ChekUserAction?userName=' + userName;

}
</script>
		<script language="JavaScript" src="scripts/gen_validatorv31.js"
			type="text/javascript">
</script>
		<script language="JavaScript" type="text/javascript"
			src="scripts/ts_picker.js">
</script>
		<script language="JavaScript1.1" src="scripts/pass.js">

</script>
		<script type="text/javascript" src="scripts/image.js">
</script>
		<script type="text/javascript" src="scripts/general.js">
</script>
		<script type="text/javascript" src="scripts/adi.js">
</script>
		<script type="text/javascript" src="scripts/form_validation.js">
</script>
		<script type="text/javascript">
//var x_win = window.self; 
function check() {
	var form = document.register;

	if (!form.ch.checked) {
		form.ownquest.disabled = true;
		form.squest.disabled = false;
	} else {

		form.ownquest.disabled = false;
		form.squest.disabled = true;
	}

}</script>



		<meta name="DESCRIPTION"
			content="The Municipal Suppliers Directory is the most complete reference tool available to the Canadian Municipalities.">
		<meta name="KEYWORDS"
			content="Government,Purchasing,Municipal,city,heavy machinerie,water,pump,snow,Fire,environment,street,bus,batterie,cable,concrete,pipe,snowplow,waste management,police,lighting,sign,suppliers,tender,engine,generator,tools,meter,pole,security,traffic,valve,suppliers, parking">
		<meta name="subject"
			content="The Municipal Suppliers Directory is the most complete reference tool available to the Canadian Municipalities.">
		<meta name="robots" content="index, follow">
		<meta name="revisit-after" content="1 days">
		<meta name="reply-to" content="info@jaguar-media.com">
		<meta name="author" content="Jaguar Media">
		<meta name="location" content="Québec, Canada">
		<meta name="Identifier-URL"
			content="http://www.municipalsuppliers.com/">
		<meta name="Publisher" content="Jaguar Media Inc">

		<link rel="stylesheet" href="images/style_municipal1.css">
		<link rel="stylesheet" href="images/style_municipal2.css">
		<link rel="stylesheet" href="images/style_municipal3.css">
		<link rel="stylesheet" href="images/style_municipal1.css">
		<script src="images/include.js">
</script>
		<SCRIPT type="text/javascript" src="scripts/project.js"> </SCRIPT>
		<SCRIPT type="text/javascript" src="scripts/ts_picker.js"> </SCRIPT>
		<style type="text/css">
<!--
.style1 {
	color: #000000;
	font-weight: bold;
}
-->
</style>
	</head>
	<center>
		<body topmargin="0" bgcolor="#234244" marginwidth="">
			<table border=1>
				<tr>
					<td colspan="2" bordercolor="white">
						<img alt="" src="images/classroom.JPG">
					</td>
				</tr>
			</table>

			<!-- ========================== HAUT ====================================== -->
			<!-- ============================ CENTRE TOP ============================================= -->

			<table border=1 bordercolor="white" width="695" height="450"
				cellpadding="0" cellspacing="0" bgcolor="#525678">
				<tr>
					<td bgcolor="white" height="10" width="750">

						<center><jsp:include page="GeneralOptions.jsp" /></center>
					</td>
				</tr>


				<td valign="top" width="617">
					<table
						style="border-collapse: collapse; border-right-width: 0pt; border-top-width: 0pt; border-bottom-width: 0pt;"
						id="AutoNumber2" border="1" bordercolor="#dddddd" cellpadding="0"
						cellspacing="0" width="100%">
						<tbody>
							<tr>
								<td
									style="border-style: none none none solid; border-width: medium medium medium 1px;"
									width="100%">

									<p align="center">
									</p>
						</tbody>
					</table>

					<br>
					<font size="4" color="#950000"><b> &nbsp; &nbsp;<%
 	if (request.getParameter("status") != null) {
 %>
							<%=request.getParameter("status")%>
							<%
								}
							%>
							<div align="right">
								<p>
									&nbsp;
								</p>

								&nbsp;&nbsp;&nbsp;
								<table width="357" height="260" border="0"
									style="width: 357px; height: 265px;">



									<form action="./register.do" method="post" name="register">

										<table border="1" bgcolor="#ECEDF3" bordercolor="#FF0000">
											<tr>
												<td>
													<b>Your VirtualClassRoom Account gives you access to
														view the VirtualClassRoom details . If you already have a
														VirtualClassRoom Account, you can <a href="LoginForm.jsp">sign
															in</a> here.</b>
													<input type="hidden" name="port"
														value="<%=request.getLocalPort()%>" />
													<input type="hidden" name="host"
														value="<%=request.getServerName()%>" />

													<table width="350" border="0" align="left">
														<th colspan=2>
															<font size="3" face="verdana"><b>1.Personal
																	Details</b>
															</font>
														</th>
														<tr></tr>
														<tr></tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="userName" ACCESSKEY="U">
																		<b><U>U</U>ser Name</b>
																	</LABEL>
																</font>
															</td>
															<td width="303">
																<input id="userName" type="text" name="loginid"
																	onblur="goOn()"
																	value="<%if (request.getParameter("userName") != null)
				out.print(request.getParameter("userName"));%>"
																	size="20" />
																<font size="3" face="Verdana">
																	<%
																		if (request.getParameter("status1") != null)
																			out.print(request.getParameter("status1"));
																	%>
																</font>

															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>P</U>assword</b>
																</font>
															</td>
															<td>

																<input type="password" name="password"
																	onkeyup="testPassword(document.forms.register.password.value);"
																	onChange="Encrypt(document.forms.register.password.value);">
															</td>
														</tr>
														<tr>
															<td></td>
															<td>
																<a id="Words">Strength:</a>
															</td>
															<td>
																<table cellpadding=0 cellspacing=0>
																	<tr>
																		<td height=15 bgcolor=#dddddd></td>
																	</tr>
																</table>
															</td>


														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>P</U>Confirm</b>
																</font>
															</td>
															<td>
																<input type="password" name="conformpassword" value=""
																	size="20" onBlur="checkconformpassword()" />
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="verdana"><LABEL
																		FOR="firstName" ACCESSKEY="F">
																		<b><U>F</U>irst Name</b>
																	</LABEL>
																</font>
															</td>
															<td width="255">
																<input id="firstName" type="text" name="firstname"
																	onblur="strValidate(this)">
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="verdana"><LABEL
																		FOR="firstName" ACCESSKEY="F">
																		<b><U>M</U>iddle Name</b>
																	</LABEL>
																</font>
															</td>
															<td width="255">
																<input id="middleName" type="text" name="middlename">
															</td>
														</tr>
														<tr>
															<td width="120">
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>L</U>ast Name</b>
																</font>
															</td>
															<td width="273">
																<font size="3" face="Verdana"> <input type="text"
																		name="lastname" value="" size="20"
																		onBlur="strValidate(this)" /> </font>
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>B</U>irth Date</b>
																</font>
															</td>
															<td>
																<font size="3" face="Verdana"> <input type="text"
																		name="bdate" value="" size="20" readonly /><a
																	href="javascript:show_calendar('document.register.bdate', document.register.bdate.value);">
																		<img src="images/cal.gif" alt="a" width="18"
																			height="18" border="0" />
																</a> </font>
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>G</U>ender</b>
																</font>
															</td>
															<td width="255">
																<select name="gender">
																	<option value="select" selected="true">
																		<font size="3" face="Verdana">Select </font>
																	</option>
																	<option value="Male">
																		<font size="3" face="Verdana">Male</font>
																	</option>
																	<option value="Female">
																		<font size="3" face="Verdana">Female</font>
																	</option>
																</select>
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>B</U>rowse Photo</b>
																</font>
															</td>
															<td>
																<input type="file" name="photo" class="textfield"
																	onChange="preview(this)" />
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>E</U>mail</b>
																</font>
															</td>
															<td>
																<input type="text" name="email" value=""
																	onBlur="isValidEmail(this.value)" />
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>F</U>ax No</b>
																</font>
															</td>
															<td>
																<font size="3" face="Verdana"> <input type="text"
																		name="fax" value="" size="20" /> </font>
															</td>
														</tr>
														<th colspan="2">
															<font size="3" face="verdana"><b>2.Contact
																	Details</b>
															</font>
														</th>
														<tr></tr>
														<tr></tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="addressType" ACCESSKEY="A">
																		<b> <U>A</U>ddress Type</b>
																	</LABEL> </font>
															</td>
															<td width="255">
																<select id="addressType" name="home"
																	onChange="cleartext()">
																	<option value="select" selected="true">
																		<font size="3" face="Verdana">Select </font>
																	</option>
																	<option value="home">
																		<font size="3" face="Verdana">Home</font>
																	</option>
																	<option value="office">
																		<font size="3" face="Verdana">Office</font>
																	</option>
																	<option value="personal">
																		<font size="3" face="Verdana">Personal</font>
																	</option>
																</select>
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>H</U>ouse No</b>
																</font>
															</td>
															<td>
																<input type="text" name="hno" value="" size="20" />
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>S</U>treet</b>
																</font>
															</td>
															<td>
																<input type="text" name="street" value="" size="20"
																	onBlur="strValidate(this)" />
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>P</U>hone Type</b>
																</font>
															</td>
															<td>
																<select name="homePhoneType">
																	<option value="select" selected="true">
																		<font size="3" face="Verdana">Select</font>
																	</option>
																	<option value="home">
																		<font size="3" face="Verdana">Home</font>
																	</option>
																	<option value="office">
																		<font size="3" face="Verdana">Office</font>
																	</option>
																	<option value="mobile">
																		<font size="3" face="Verdana">Mobile</font>
																	</option>
																</select>
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><b><U>P</U>hone No</b>
																</font>
															</td>
															<td>
																<input type="text" name="phone" value="" size="20"
																	onBlur="ValidateForm();abc()" />
															</td>
														</tr>
														<th colspan="5">
															<font size="3" face="verdana"><b>3.Account
																	Details</b>
															</font>
														</th>
														<tr></tr>
														<tr></tr>
														<tr>
															<td>
																<b>SecurityQuestion</b>
															</td>
															<td>
																<select name="squest">
																	<option value="select" selected="true">
																		<font size="3" face="Verdana">--Select One---</font>
																	</option>
																	<option value="What is your favorite pastime?">
																		<font size="3" face="Verdana">What is your
																			favorite pastime?</font>
																	</option>
																	<option value="Who your childhood hero?">
																		<font size="3" face="Verdana">Who your
																			childhood hero?</font>
																	</option>
																	<option value="What is the name of your first school?">
																		<font size="3" face="Verdana">What is the name
																			of your first school?</font>
																	</option>
																	<option value="Where did you meet your spouse?">
																		<font size="3" face="Verdana">Where did you
																			meet your spouse?</font>
																	</option>
																	<option value="What is your favorite sports team?">
																		<font size="3" face="Verdana">What is your
																			favorite sports team?</font>
																	</option>
																	<option value="What is your father middle name?">
																		<font size="3" face="Verdana">What is your
																			father middle name?</font>
																	</option>
																	<option value="What was your high school mascot?">
																		<font size="3" face="Verdana">What was your
																			high school mascot?</font>
																	</option>
																	<option value="What make was your first car or bike?">
																		<font size="3" face="Verdana">What make was
																			your first car or bike?</font>
																	</option>
																	<option value="What is your pet name?">
																		<font size="3" face="Verdana">What is your pet
																			name?</font>
																	</option>
																</select>
															</td>
														</tr>

														<tr>
															<td>
																<b>Security Answer</b>
															</td>
															<td>
																<INPUT name="sanswer" type="text">
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><center>
																		<input type="submit" name="createAccount"
																			value="Register" />
																	</center>
																</font>
															</td>
															<td>
																<font size="3" face="Verdana"><input
																		type="submit" name="cancel" value="Cancel" />
																</font>
															</td>
														</tr>
													</table>
													<br />
													<br />
													<table width="403" border="0" align="center">
														<tr rowspan="7"></tr>
														<tr></tr>
														<tr></tr>

														<tr colspan="3">
															<td>
																<img alt="See Photo Here" id="previewField"
																	src="images/Hindu-God-Hanuman-Photo-0007.jpg"
																	height="140" width="150">
															</td>
														</tr>

													</table>
													<table width="350" border="0" align="center">
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr rowspan="2"></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr></tr>
														<tr>
															<td width="120">
																<font size="3" face="Verdana"><LABEL FOR="city"
																		ACCESSKEY="C">
																		<b><U>C</U>ity</b>
																	</LABEL>
																</font>
															</td>
															<td width="273">
																<font size="3" face="Verdana"> <input type="text"
																		id="city" name="city" size="20" /> </font>
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><U></U><b>State</b>
																</font>
															</td>
															<td>
																<font size="3" face="Verdana"> <input type="text"
																		name="state" value="" size="20" /> </font>
															</td>
														</tr>
														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><U></U><b>Country</b>
																</font>
															</td>
															<td>
																<font size="3" face="Verdana"> <input type="text"
																		name="country" value="" size="20" /> </font>
															</td>
														</tr>

														<tr>
															<td>
																<font size="3" face="Verdana"><LABEL
																		FOR="id_email" ACCESSKEY="F">
																	</LABEL><U></U><b>Pin</b>
																</font>
															</td>
															<td>
																<font size="3" face="Verdana"> <input type="text"
																		name="pin" value="" size="20"
																		onChange="showStatus();abc1()" /> </font>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>


										<input type="hidden" name="homeaddresstype" />
										<input type="hidden" name="homehouseno" />
										<input type="hidden" name="homestreet" />
										<input type="hidden" name="homephonetype" />
										<input type="hidden" name="homecountry" />
										<input type="hidden" name="homepin" />
										<input type="hidden" name="homestate" />
										<input type="hidden" name="homephoneno" />
										<input type="hidden" name="homecity" />

										<input type="hidden" name="homefax" />

										<input type="hidden" name="officeaddresstype" />
										<input type="hidden" name="officehouseno" />
										<input type="hidden" name="officestreet" />
										<input type="hidden" name="officephonetype" />
										<input type="hidden" name="officecountry" />
										<input type="hidden" name="officepin" />
										<input type="hidden" name="officestate" />
										<input type="hidden" name="officephoneno" />
										<input type="hidden" name="officecity" />

										<input type="hidden" name="officefax" />

										<input type="hidden" name="personaladdresstype" />
										<input type="hidden" name="personalhouseno" />
										<input type="hidden" name="personalstreet" />
										<input type="hidden" name="personalphonetype" />
										<input type="hidden" name="personalcountry" />
										<input type="hidden" name="personalpin" />
										<input type="hidden" name="personalstate" />
										<input type="hidden" name="personalphoneno" />
										<input type="hidden" name="personalcity" />

										<input type="hidden" name="personalfax" />
									</form>
									<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("register");

frmvalidator.addValidation("firstname", "req", "Please enter your First Name");
frmvalidator.addValidation("firstname", "maxlen=20",
		"Max length for FirstName is 20");
frmvalidator.addValidation("firstname", "alpha",
		" First Name Alphabetic chars only");

frmvalidator.addValidation("lastname", "req", "Please enter your Last Name");
frmvalidator.addValidation("lastname", "maxlen=20", "Max length is 20");
frmvalidator.addValidation("lastname", "alpha",
		" Last Name Alphabetic chars only");

frmvalidator.addValidation("gender", "dontselect=0");
frmvalidator.addValidation("bdate", "req", "Please enter your DOB");

frmvalidator.addValidation("photo", "req", "Please Load Your Photo");

frmvalidator.addValidation("email", "maxlen=50");
frmvalidator.addValidation("email", "req");
frmvalidator.addValidation("email", "email");

frmvalidator.addValidation("addressType", "dontselect=0");

frmvalidator.addValidation("hno", "req", "Please enter your House Number");

frmvalidator.addValidation("street", "req", "Please enter your Street Number");
frmvalidator.addValidation("phoneType", "dontselect=0");
frmvalidator.addValidation("phone", "req");

frmvalidator.addValidation("phone", "maxlen=50");
frmvalidator.addValidation("phone", "numeric");
frmvalidator.addValidation("phone", "Phone");

frmvalidator.addValidation("city", "req", "Please enter your city Name");
frmvalidator.addValidation("state", "req", "Please enter your State Name");
frmvalidator.addValidation("country", "req", "Please enter your Country Name");
frmvalidator.addValidation("pin", "req", "Please enter your pin Number");

frmvalidator.addValidation("loginid", "req", "Please enter your Username");
frmvalidator.addValidation("password", "req", "Please enter your Password");
frmvalidator.addValidation("conformpassword", "req",
		"Please enter your Confirm Password");
frmvalidator.addValidation("secrete", "req", "Please enter your Answer");
frmvalidator.addValidation("squest", "dontselect=0");
frmvalidator.addValidation("fax", "req", "Please enter Fax Number");

frmvalidator.addValidation("fax", "age");
</script>



								</table>
		</body>
</html>



