<html>
<head>
<title>Login.jsp</title>
</head>

<body>
	${SPRING_SECURITY_LAST_EXCEPTION.message}
	<form action="login" method="get">
		<table align="center" border="2">
			<tr>
				<th align="center" colspan="2">Login</th>

			</tr>

			<tr>
				<td align="center">User Name</td>
				<td align="center"><input type="text" name="username"></td>
			</tr>

			<tr>
				<td align="center">Password</td>
				<td align="center"><input type="password" name="password"></td>
			</tr>

			<tr>
				<td align="center"><input type="submit" value="Login">
				</td>

			</tr>




		</table>


	</form>

</body>


</html>