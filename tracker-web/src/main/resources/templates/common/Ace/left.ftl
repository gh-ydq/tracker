	<div id="sidebar" class="sidebar                  responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

			<ul class="nav nav-list" id="leftnav">
				<li class="active">
						<a href="/collection/index/main">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Collection系统 </span>
						</a>
						<b class="arrow"></b>
					</li>
			<@menuTag ;MenuRoot>
				<#list MenuRoot.childrens as c2>
					<li class="">
						<a href="${c2.getAttribute("resValue")}" class="dropdown-toggle">
							<i class="${c2.getAttribute("resCode")}"></i>
							<span class="menu-text"> ${c2.text} </span>
							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<#list c2.childrens as c3>
								<li class="">
								<a href="${c3.getAttribute("resValue")}"><!--tables.html -->
									<i class="menu-icon fa fa-caret-right"></i>
									${c3.text}
								</a>

								<b class="arrow"></b>
								</li>
							</#list>	
						</ul>
					</li>		
				</#list>
			</@menuTag>
				</ul><!-- /.nav-list -->
				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>
