<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">

<head>

    <title>NoSQL</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

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
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="retour">L'antre du NoSQL</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="retour">Home</a>
                    </li>
                     <c:if test="${administrateur==true}">
                    <li>
                        <a href="new">Nouvel Article</a>
                    </li>
                    </c:if>
                    <li>
                        <a href="contact">Qui sommes-nous ?</a>
                    </li>
                      <c:if test="${administrateur==false}">
                      <li>
                        <a href="login">Connexion</a>
                    </li>
                    </c:if>
                    <c:if test="${administrateur==true}">
                      <li>
                        <a href="logout">D�connexion</a>
                    </li>
                    </c:if>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Header -->
    <!-- Set your background image for this header on the line below. -->
    <header class="intro-header" style="background-image: url('img/home-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <div class="site-heading">
                        <h1>L'ANTRE DU NoSQL</h1>
                        <hr class="small">
                        <span class="subheading">Un blog sur le NoSQL</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
               <c:forEach items="${posts}" var="post">
               <c:set var="post_id" value="${post.id}"/>
           <div class="post-preview">
           	<a href="post/${post_id}">
                        <h2 class="post-title"> 
                            ${post.title}
                        </h2>
                         </a>
                    <p class="post-meta">R�dig� avec professionnalisme par ${post.author} on September 24, 2014</p>
                     <p class="post-meta"><bold>${nbrComment} commentaire(s)</bold></p>
                </div>
                
                <c:if test="${administrateur==true}">

                	<a href="delete/${post_id}"> <span class="fa-stack fa-lg">
							<i class="fa fa-circle fa-stack-2x"></i> <i
							class="fa fa-eraser fa-stack-1x fa-inverse"></i>
					</span>
					</a>
               
               
               <a href="edit/${post_id}"> <span class="fa-stack fa-lg">
							<i class="fa fa-circle fa-stack-2x"></i> <i
							class="fa fa-edit fa-stack-1x fa-inverse"></i>
					</span>
					</a>
				</c:if>

                </c:forEach>
                </div>
                <hr>
                
                <!-- Pager -->
                <ul class="pager">
                <c:if test="${administrateur==true}">
                    <li class="next">
                        <a href="new">Nouvel Article</a>
                    </li>
                </c:if>
                </ul>
            </div>
        </div>
    <hr>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <p class="copyright text-muted">Copyright &copy; L'Antre du NOSQL</p>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/clean-blog.min.js"></script>

</body>

</html>
