<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Send Email</title>
</head>
<body>
<form action="send" method="post" enctype="multipart/form-data">
<table align="center" border="0" width="80">
<tr><td>To :</td><td><input type="text" name="recepient" size="60"></td>
<tr><td>Sub:</td><td><input type="text" name="subject" size="60"></td>
<tr><td>Message :</td><td><textarea cols="60" rows="10" name="message" size="60"></textarea></td></tr>
<tr><td>Attachment</td><td><input type="file" name="attachFile" size="60"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Send"></td></tr>

</table>
</form>

</body>
</html>