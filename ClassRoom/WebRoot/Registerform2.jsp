
<html>
	<head>
		<script language="javascript">

</script>
		<script src="scripts/gen_validatorv31.js" type="text/javascript">
</script>
		<script src="scripts/pass.js" type="text/javascript">
<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/image.js">
</script>
		<script type="text/javascript" src="scripts/ts_picker.js">
</script>
	</head>

	<body>
		<form action="./RegisterAction" method="post" name="register"
			onSubmit="return validate()">

			<table width="405" border="0" align="left">
				<th colspan=2>
					<font size="3" face="verdana"><b>1.Personal Details</b>
					</font>
				</th>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>
						<font size="3" face="verdana">First Name</font>
					</td>
					<td width="255">
						<input type="text" name="firstName" value="">
					</td>
				</tr>
				<tr>
					<td width="120">
						<font size="3" face="Verdana">Last Name</font>
					</td>
					<td width="273">
						<font size="3" face="Verdana"> <input type="text"
								name="lastName" value="" size="20" /> </font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> Birth Date</font>
					</td>
					<td>
						<font size="3" face="Verdana"> <input type="text"
								name="dob" value="" size="20" /><a
							href="javascript:show_calendar('document.register.dob', document.register.dob.value);">
								<img src="images/cal.gif" alt="a" width="18" height="18"
									border="0" />
						</a> </font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="verdana">Gender</font>
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
						<font size="3" face="verdana">Browse Photo</font>
					</td>
					<td>
						<input type="file" name="photo" class="textfield" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="verdana">Email</font>
					</td>
					<td>
						<input type="text" name="email" value="" />
					</td>
				</tr>
				<th colspan="2">
					<font size="3" face="verdana"><b>2.Contact Details</b>
					</font>
				</th>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> Address Type </font>
					</td>
					<td width="255">
						<select name="addressType">
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
						<font size="3" face="Verdana"> House No</font>
					</td>
					<td>
						<input type="text" name="houseNo" value="" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana">Street</font>
					</td>
					<td>
						<input type="text" name="street" value="" size="20" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> Phone Type</font>
					</td>
					<td>
						<select name="phoneType">
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
						<font size="3" face="Verdana"> Phone No</font>
					</td>
					<td>
						<input type="text" name="phoneNo" value="" size="20" />
					</td>
				</tr>
				<th colspan="5">
					<font size="3" face="verdana"><b>3.Account Details</b>
					</font>
				</th>
				<tr></tr>
				<tr></tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> User Name</font>
					</td>
					<td width="303">
						<input type="text" name="userName" value="" size="20" />
						<font size="3" face="Verdana"><input type="submit"
								name="submit" value="check">
						</font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana">Password</font>
					</td>
					<td>

						<input type="text" name="password"
							onkeyup="testPassword(document.forms.register.password.value);">
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
						<font size="3" face="Verdana"> Confirm</font>
					</td>
					<td>
						<input type="text" name="conformpassword" value="" size="20"
							onblur="checkconformpassword()" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> SecurityQuestion</font>
					</td>
					<td>
						<select name="squest">
							<option value="select" selected="true">
								<font size="3" face="Verdana">--Select One---</font>
							</option>
							<option value="What is your favorite pastime?">
								<font size="3" face="Verdana">What is your favorite
									pastime?</font>
							</option>
							<option value="Who your childhood hero?">
								<font size="3" face="Verdana">Who your childhood hero?</font>
							</option>
							<option value="What is the name of your first school?">
								<font size="3" face="Verdana">What is the name of your
									first school?</font>
							</option>
							<option value="Where did you meet your spouse?">
								<font size="3" face="Verdana">Where did you meet your
									spouse?</font>
							</option>
							<option value="What is your favorite sports team?">
								<font size="3" face="Verdana">What is your favorite
									sports team?</font>
							</option>
							<option value="What is your father middle name?">
								<font size="3" face="Verdana">What is your father middle
									name?</font>
							</option>
							<option value="What was your high school mascot?">
								<font size="3" face="Verdana">What was your high school
									mascot?</font>
							</option>
							<option value="What make was your first car or bike?">
								<font size="3" face="Verdana">What make was your first
									car or bike?</font>
							</option>
							<option value="What is your pet name?">
								<font size="3" face="Verdana">What is your pet name?</font>
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> Security Answer</font>
					</td>
					<td>
						<input type="text" name="secrete" value="" size="37" />
					</td>
				</tr>

				<tr>
					<td>
						<font size="3" face="Verdana"><center>
								<input type="submit" name="createAccount" value="Register" />
							</center>
						</font>
					</td>
					<td>
						<font size="3" face="Verdana"><center>
								<input type="submit" name="cancel" value="Cancel" />
							</center> </font>
					</td>
				</tr>
			</table>
			<table width="403" border="0" align="center">
				<tr rowspan="7"></tr>
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
				<tr colspan="3">
					<td>
						<img alt="See Photo Here" id="previewField"
							src="images/default.gif">
					</td>
				</tr>

			</table>
			<table width="403" border="0" align="center">
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
				<tr rowspan="2"></tr>
				<tr>
					<td width="120">
						<font size="3" face="Verdana">City</font>
					</td>
					<td width="273">
						<font size="3" face="Verdana"> <input type="text"
								name="city" value="" size="20" /> </font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> State</font>
					</td>
					<td>
						<font size="3" face="Verdana"> <input type="text"
								name="state" value="" size="20" /> </font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> Country</font>
					</td>
					<td>
						<font size="3" face="Verdana"> <input type="text"
								name="country" value="" size="20" /> </font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> Pin</font>
					</td>
					<td>
						<font size="3" face="Verdana"> <input type="text"
								name="pin" value="" size="20" /> </font>
					</td>
				</tr>
				<tr>
					<td>
						<font size="3" face="Verdana"> Fax No</font>
					</td>
					<td>
						<font size="3" face="Verdana"> <input type="text"
								name="fax" value="" size="20" /> </font>
					</td>
				</tr>

			</table>
		</form>
	</body>
</html>

