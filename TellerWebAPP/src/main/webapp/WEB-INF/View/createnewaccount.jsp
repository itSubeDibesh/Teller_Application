

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/dropdown.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/mystyle.css" rel="stylesheet">
        

  </head>
  <body>
	  
<!------ Include the above in your HEAD tag ---------->

<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/resources/images/banklogo.jpg" alt="LOGO"">
            </a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li><a href="#" data-placement="bottom" data-toggle="tooltip" href="#" data-original-title="Stats"><i class="fa fa-bar-chart-o"></i>
                </a>
            </li>            
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.userName}<b class="fa fa-angle-down"></b></a>
                <ul class="dropdown-menu">

                    <li><a href="logout"><i class="fa fa-fw fa-power-off"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="createnewaccount"><i class="fa fa-fw fa-user-plus"></i>  Open New Account</a>
                </li>
                <li>
                    <a href="deleteaccount"><i class="fa fa-fw fa-paper-plane-o"></i> Close Account</a>
                </li>
                <li>
                    <a href="withdraw"><i class="fa fa-fw fa fa-question-circle"></i> Withdraw</a>
                </li>
                <li>
                    <a href="depositamount"><i class="fa fa-fw fa fa-question-circle"></i> Deposit</a>
                </li>
                <li>
                    <a href="fundtransfure"><i class="fa fa-fw fa fa-question-circle"></i> Fund Transfer</a>
                </li>
                <li>
                    <a href="listallaccounts"><i class="fa fa-fw fa fa-question-circle"></i> List All Accounts</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row" id="main" >
                <div class="col-sm-12 col-md-12 well" id="content">
                        <div id="formContent">
                    <!-- Tabs Titles -->

                    <!-- Icon -->
                        <div id="formHeader">
                            Enter customer details to open new account.
                        </div>
                            
                        <form:form modelAttribute="account" action="processNewAccount" method="POST">
                            <label>ACCOUNT NO</label>
                            <form:input path="accountNumber" id="accountNumber" class="fadeIn second"  placeholder="ACCOUNT NO" name="accountNumber"/>
                            <label>ACCOUNT NAME</label>
                            <form:input path="accountName" id="accountName" class="fadeIn second"  placeholder="ACCOUNT NAME" name="accountName"/>
                            <label>OPENING BALANCE</label>
                            <form:input path="accountBalance"  id="accountBalance" class="fadeIn second" placeholder="OPENING BALANCE" name="accountBalance"/>
                            <form:button id="submit" class="fadeIn fourth" name="submit">Create Account</form:button>
                        </form:form>
                            
                        <div id="formFooter">
                            ${message}
                        </div>
                        
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
</div><!-- /#wrapper -->
  </body>
</html>
    
                
