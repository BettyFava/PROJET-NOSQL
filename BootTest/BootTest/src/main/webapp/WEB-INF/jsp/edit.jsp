<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="fr">


<head>

<title>NoSQL</title>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/clean-blog.min.css" rel="stylesheet">

<!-- Personal CSS -->
<link href="../css/nosql.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="retour">L'antre du NoSQL</a>
			</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="retour">Home</a>
                    </li>
                    <li>
                        <a href="new">Nouvel Article</a>
                    </li>
                    <li>
                        <a href="contact">Qui sommes-nous ?</a>
                    </li>
                      <li>
                        <a href="logout">Déconnexion</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header centrage"
		style="background-image: url('../img/fontupdate.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="post-heading">
						<h1>
						L'antre du NoSQL
						</h1>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Post Content -->
	<article>
		<div class="container">
			<div class="row">
			<h4>Modifier un article</h4>
			
			
			<form:form method="POST" modelAttribute="post" action="valider/${id}">
			<div class="form-group">
			<%-- <form:hidden path="id" value="${id}" /> --%>
			<form:label path="author" class="control-label col-md-3">
					Auteur <span class="required">*</span>
			</form:label>
			<div class="col-md-9">
			<form:input type="text" class="form-control" path="author" value="${author}" />
				</div>
				
				
			<form:label path="title" class="control-label col-md-3">
					Titre <span class="required">*</span>
			</form:label>
			<div class="col-md-9">
			<form:input type="text" class="form-control" path="title" value="${title}" />
			
				</div>
				
				
				
			<form:label path="content" class="control-label col-md-3">
					Message <span class="required">*</span>
			</form:label>
			<div class="col-md-9">
			<form:textarea rows="10" type="text" class="form-control" path="content" value="${content}" />
				</div>
				<div class="col-md-center">	
				<br />
				<br />
						<div class="form-actions right"> 
					<button  type="submit" class="btn btn-default buttonmargin"> Modifier </button> 
				 </div>  					
				
			
			</div>
			</div>
			</form:form>
		</div>
	</div>
				
	</article>

	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<p class="copyright text-muted">Copyright &copy; L'Antre du
						NoSQL</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- JS Editeur -->
	<script type="text/javascript" src="../js/tinymce/tinymce.min.js"></script>

	<script type="text/javascript">
		tinymce.init({
    		selector: "textarea"
 		});
	</script>
	

	<!-- jQuery -->
	<script src="../js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../js/clean-blog.min.js"></script>

</body>

</html>
