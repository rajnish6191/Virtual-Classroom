<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" /> 
<title>Password Strength</title>
<script language="javascript" type="text/javascript">
    
    var minpwlength = 4;
    var fairpwlength = 7;
    
    var STRENGTH_SHORT = 0;  // less than minpwlength 
    var STRENGTH_WEAK = 1;  // less than fairpwlength
    var STRENGTH_FAIR = 2;  // fairpwlength or over, no numbers
    var STRENGTH_STRONG = 3; // fairpwlength or over with at least one number
    
    img0 = new Image(); 
    img1 = new Image();
    img2 = new Image();
    img3 = new Image();
    
    img0.src = 'images/blank.gif';
    img1.src = 'images/cal.gif';
    img2.src = 'images/next.gif';
    img3.src = 'images/prev.gif';
    
    var strengthlevel = 0;
    
    var strengthimages = Array( img0.src,
                                img1.src,
                                img2.src,
                                img3.src );
    
    function updatestrength( pw ) {
    
        if( istoosmall( pw ) ) {
    
            strengthlevel = STRENGTH_SHORT;
    
        }
        else if( !isfair( pw ) ) { 
    
            strengthlevel = STRENGTH_WEAK;
    
        }    
        else if( hasnum( pw ) ) {
    
            strengthlevel = STRENGTH_STRONG;
    
        }
        else {
    
            strengthlevel = STRENGTH_FAIR;
    
        }
    
        document.getElementById( 'strength' ).src = strengthimages[ strengthlevel ];
    
    }
    
    function isfair( pw ) {
    
        if( pw.length < fairpwlength ) {
    
            return false;
    
        }
        else { 
    
            return true;
    
        }
    
    }
    
    function istoosmall( pw ) {
    
        if( pw.length < minpwlength ) {
    
            return true;
    
        }
        else {
    
            return false;

        }
    
    }
    
    function hasnum( pw ) {
    
        var hasnum = false;
    
        for( var counter = 0; counter < pw.length; counter ++ ) {
    
            if( !isNaN( pw.charAt( counter ) ) ) {
    
                hasnum = true;
    
            }
    
        }
    
    
        return hasnum;
    
    }

</script>
<style media="all" type="text/css">

    body {
    
        background-color: #858585;
        color: #EEEEEE;
        font-family: Tahoma, sans-serif;
        font-size: 11px;
    
    }
    
    input {
    
        background-color: #EEEEEE;
        border: 1px solid #333333; 
        color: #333333;
        font-family: Tahoma, sans-serif;
        font-size: 11px;
        margin-bottom: 20px;
    
    }

</style>
</head>
<body onload="document.getElementById( 'password' ).focus();">
<div>Enter your password here:</div>
<br />
<div>
    <input maxlength="15" onkeyup="updatestrength( this.value );" type="password" name="password" id="password" value="" />
    <img src="images/tooshort.jpg" id="strength" alt="" />
</div>
</body>
</html>
