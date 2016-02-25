<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Changequestionform.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  <script type="text/javascript" src="scripts/general.js"> </script>
  <body>
    <form action="ChangequestionAction.jsp" method="post" name="changequestion">
                    <table width="200" border="0" align="center">
                      <tr>
                        <td><table width="380" border="0" align="center">
                              <tr>
                                <td width="101">Login Name </td>
                                <td width="269">
                                  <input type="text" name="username">
                                </td>
                              </tr>
                              <tr>
                                <td >Password </td>
                                <td>
                                  <input type="password" name="password">
                                </td>
                              </tr>
                              <tr>
                                <td >Secret Question</td>
                                <td><select name="squest">
                                    <option value="1">What is your favorite pastime?</option>
                                    <option value="2">Who was your childhood hero?</option>
                                    <option value="3">What was the name of your first school?</option>
                                    <option value="4">Where did you meet your spouse?</option>
                                    <option value="5">What is your favorite sports team?</option>
                                    <option value="6">What is your father's middle name?</option>
                                    <option value="7">What was your high school mascot?</option>
                                    <option value="8">What make was your first car or bike?</option>
                                    <option value="9">What is your pet's name?</option>
                                </select></td>
                              </tr>
                              <tr >
                                <td colspan="2">
                                  <input type="checkbox" name="ch" value="1" onClick="check(changequestion)">
                                  Own Question </td>
                              </tr>
                              <tr>
                                <td>Own Question </td>
                                
                                <td>
                                  <input type="text" name="ownquest" disabled>
                                </td>
                              </tr>
                              <tr>
                                <td height="38" class="style23">Secret Answer </td>
                                <td><input name="sanswer" type="text"></td>
                              </tr>
                              <tr>
                                <td colspan="2"><div align="center">
                                  <input name="Input" type="submit" value="Change">
                                </div>
                                    <div align="center"></div></td>
                              </tr>
                            </table></td>
                            </tr>
                          
                        </table>
                    </form>
  </body>
</html>
