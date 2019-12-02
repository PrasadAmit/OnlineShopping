<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
              <!--   <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                   <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button> -->
                <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <li id="about">
                    	<a href="${contextRoot}/about">About</a>
                    </li>
                    <li id="contact">
                    	<a href="${contextRoot}/contact">Contact</a>
                    </li>
                     <li id="listProcucts">
                    	<a href="${contextRoot}/show/all/products">View Products</a>
                    </li>
                     <li id="manageProcucts">
                    	<a href="${contextRoot}/manage/products">Manage Products</a>
                    </li>

                    <%-- <li class="dropdown" id="userCart">
                    <a href="javascript:void(0)"
                    
  					class="btn btn-default dropdown-toggle"
  					id="dropdownMenu1"
  					data-toggle="dropdown">
  					
  					${userModel.fullName}
  					<span class="caret"></span>
  					</a>                    
                    </li> --%>                
               
					<li >
					<a href="${contextRoot}/cart/show">
					<span class="glyphicon glyphicon-shopping-cart"></span>
					<span class="badge">${userModel.cart.cartLines}</span>
					- &#8377; ${userModel.cart.grandTotal}
					</a>
					</li>
				</ul>
               
				<ul class="nav navbar-nav navbar-right">
                     <li id="register">
                    	<a href="${contextRoot}/register">Sign Up</a>
                     </li>
                     <li id="login">
                    	<a href="${contextRoot}/login">Login</a>
                     </li>
				</ul>

            </div>
        </div>
        <!-- /.container -->
    </nav>

