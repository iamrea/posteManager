



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion RH</title>
        <%@include file="/include/css.jsp" %>
        <style type="text/css">
.form-style-2{
    max-width: 3000px;
    padding: 20px 12px 10px 20px;
    font: 16px Liberation sans, Arial;
    color: #3f3f3f;
}
.form-style-2-heading{
    font-weight: bold;
    font-style: italic;
    border-bottom: 2px solid #ddd;
    margin-bottom: 20px;
    font-size: 19px;
    padding-bottom: 3px;
}
.form-style-2 label{
    display: block;
    margin: 0px 0px 15px 0px;
}
.form-style-2 label > span{
    width: 100px;
    font-weight: bold;
    float: left;
    padding-top: 8px;
    padding-right: 5px;
}
.form-style-2 span.required{
    color:red;
}
.form-style-2 .tel-number-field{
    width: 40px;
    text-align: center;
}
.form-style-2 input.input-field{
    width: 48%;
    
}

.form-style-2 input.input-field, 
.form-style-2 .tel-number-field, 
.form-style-2 .textarea-field, 
 .form-style-2 .select-field{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    border: 1px solid #C2C2C2;
    box-shadow: 1px 1px 4px #EBEBEB;
    -moz-box-shadow: 1px 1px 4px #EBEBEB;
    -webkit-box-shadow: 1px 1px 4px #EBEBEB;
    border-radius: 3px;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
    padding: 7px;
    outline: none;
}
.form-style-2 .input-field:focus, 
.form-style-2 .tel-number-field:focus, 
.form-style-2 .textarea-field:focus,  
.form-style-2 .select-field:focus{
    border: 1px solid #0C0;
}
.form-style-2 .textarea-field{
    height:100px;
    width: 55%;
}
.form-style-2 input[type=submit],
.form-style-2 input[type=button]{
    border: none;
    padding: 8px 15px 8px 15px;
    background: #f7f7f7;
    color: black;
    box-shadow: 1px 1px 4px #DADADA;
    -moz-box-shadow: 1px 1px 4px #DADADA;
    -webkit-box-shadow: 1px 1px 4px #DADADA;
    border-radius: 3px;
    -webkit-border-radius: 3px;
    -moz-border-radius: 3px;
     height:30px;
    width: 124px;
}
.form-style-2 input[type=submit]:hover,
.form-style-2 input[type=button]:hover{
    background: #2B0882;
    color: black;
    
}
</style>
    </head>
    <body>
        <div class="main">
            <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="#"><img src="<%= request.getContextPath() %>/style/images/Logo_poste_maroc.jpg" width="350" height="100" alt="" class="gal" />  <small></small></a></h1>
      </div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.jsp"><span>Home Page</span></a></li>
          <li><a href="support.html"><span>Support</span></a></li>
          <li><a href="about.html"><span>About Us</span></a></li>
          <li><a href="blog.html"><span>Blog</span></a></li>
          <li><a href="contact.html"><span>Contact Us</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
      
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
      <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        
      <div class="col c2">
        <h2><span></span></h2>
        
        
      </div>
      <div class="col c3">
       
      </div>
      <div class="clr"></div>
    </div>
  </div>
     </div>         
            <div class="content" >
    <div class="content_resize" align="center">
      <div class="mainbar" align="center" >
        <div class="article" align="center">
         <div align="center">
        <div class="form-style-2" >
            <div class="form-style-2-heading"> <strong> Ajouter une tournée </strong></div>
<form action="" method="post">
<label for="field1"><span>Naumero<span class="required">*</span></span><input type="text" class="input-field" name="field1" value="" /></label>
<label for="field2"><span>CP <span class="required">*</span></span><input type="text" class="input-field" name="field2" value="" /></label>
<label for="field1"><span>date de creation<span class="required">*</span></span><input type="Date" class="input-field" name="field1" value="" /></label>
<label for="field1"><span>Reference<span class="required">*</span></span><input type="text" class="input-field" name="field1" value="" /></label>
<label for="field1"><span>indemnite<span class="required">*</span></span><input type="text" class="input-field" name="field1" value="" /></label>


<label for="field1"><span>frequenceDistribution<span class="required">*</span></span><input type="text" class="input-field" name="field1" value="" /></label>
<label for="field1"><span>dateMAJ<span class="required">*</span></span><input type="Date" class="input-field" name="field1" value="" /></label>
<label for="field4"><span>id_secteur</span><select name="field4" class="select-field">
<option value="General Question">1</option>
<option value="Advertise">2</option>
<option value="Partnership">3   </option>
</select></label>
		
	
<label><span>&nbsp;</span><input type="submit" value="Ajouter" /></label>
</form>
</div>
       
            </div>
     
          </div>
          <div class="fbg">
    <div class="fbg_resize">
      <div class="col c1">
        
      <div class="col c2">
        <h2><span></span></h2>
        
        
      </div>
      <div class="col c3">
       
      </div>
      <div class="clr"></div>
    </div>
  </div>
     </div> 
          </div>
                      
         </div>
                 </div>
      
    
 

            
            
            
    </body>
      
    
<%@include file="/include/js.jsp" %>

</html>