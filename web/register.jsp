<!DOCTYPE html>
<html >
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>PosteManager</title>
		<meta name="description" content="Demo for the tutorial: Styling and Customizing File Inputs the Smart Way" />
		<meta name="keywords" content="cutom file input, styling, label, cross-browser, accessible, input type file" />
		<meta name="author" content="Osvaldas Valutis for Codrops" />
		<link rel="shortcut icon" href="favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
  
  
  
      <link rel="stylesheet" href="css/style.css">
  <link rel="shortcut icon" href="favicon.ico">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />

  <script src="js/index.js">  </script>
  <script src="js/custom-file-input.js"></script>
  <script src="js/jquery.custom-file-input.js"></script>
 

</head>

<body>
  
<div class="container">
	<section id="content">
            <div class="logo">
        <h1><a href="#"><img src="<%= request.getContextPath() %>/style/images/Logo_poste_maroc.jpg" width="350" height="100" alt="" class="gal" />  <small></small></a></h1>
      </div>
		<form action="">
			<h1>Ajouter un compte </h1>
                        <div>
				<input type="text" placeholder="votre nom" required="" id="nom" />
			</div>
			<div>
				<input type="text" placeholder="Username" required="" id="username" />
			</div>
                         <div>
				<input type="text" placeholder="Email" required="" id="email" />
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" />
			</div>
                            <div>
				<input type="text" placeholder="Email" required="" id="email" />
			</div>
                       
                        <div>
                          
  <input type="file" name="file-3[]" id="file-3" class="inputfile inputfile-3"  />
					<label for="file-3">
                                           <figure>  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17">
                                                <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/>
                                                </svg>
                                            </figure>
                                            <span>Choose a file&hellip;</span></label>

 
                               
                        </div>            
                             
                    
                        
			<div>
				<input type="submit" value="Log in" />
				<a href="#">Lost your password?</a>
				<a href="#">Register</a>
			</div>
		</form><!-- form -->
		
	</section><!-- content -->
</div><!-- container -->
</body>
  
    


</html>
