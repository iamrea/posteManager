<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login form using HTML5 and CSS3</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

    <script src="js/index.js"></script>
</head>

<body>
  
<div class="container">
	<section id="content">
            <div class="logo">
        <h1><a href="#"><img src="<%= request.getContextPath() %>/style/images/Logo_poste_maroc.jpg" width="350" height="100" alt="" class="gal" />  <small></small></a></h1>
      </div>
		<form action="loginprocess.jsp">
			<h1>Login Form</h1>
			<div>
				<input type="text" placeholder="Username" required="" id="username" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" />
			</div>
                       
			<div>
				<input type="submit" value="Log in" />
				<a href="#">Lost your password?</a>
				<a href="#">Register</a>
			</div>
		</form><!-- form -->
		<div class="button">
			<a href="#">News</a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
  
  


</html>
