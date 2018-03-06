<script src="ace/assets/js/jquery.js"></script>
<script src="ace/assets/js/jquery-ui.js"></script>
<script src="ace/assets/js/jquery.ui.touch-punch.js"></script>
<script src="ace/assets/js/jqGrid/jquery.jqGrid.src.js"></script>
<script src="ace/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
<link rel="stylesheet" href="ace/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
<!-- <link rel="stylesheet" href="ace/assets/css/bootstrap.css" /> -->
<div id="navbar" class="navbar navbar-default">
<script type="text/javascript">
	try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	jQuery(document).ready(function(){
	    //getOnlineNum();
	    //window.setInterval("getOnlineNum()",30000);
			
		$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
				_title: function(title) {
					var $title = this.options.title || '&nbsp;'
					if( ("title_html" in this.options) && this.options.title_html == true )
						title.html($title);
					else title.text($title);
				}
		}));
			
		/* $("#showOnlineUserList").on('click', function(e) {
			e.preventDefault();		
			var dialog = $( "#showOnlineUserListDialog-message" ).removeClass('hide').dialog({
				modal: true,
				width: '350',
				title: '<div class=\"widget-header widget-header-small\"><h4 class=\"smaller\"><i class=\"ace-icon fa fa-check\"></i> 查看在线人数</h4></div>',
				title_html: true,
				buttons: [ 
					{
						text: "确定",
						"class" : "btn btn-primary btn-minier",
						click: function() {
							$( this ).dialog( "close" ); 
						} 
					}
				]
			});
			
			$("#showOnlineUserList-table").jqGrid('setGridParam',{ 
				datatype:'json', 
				postData:{} //发送数据 
			}).trigger("reloadGrid");
			
    	}); */
		
		/* $("#showOnlineUserList-table").jqGrid({
			//url:"../onlineUser/showOnlineUserList",
			datatype:"local",
			mtype:"POST",
			colNames:[ '在线人员','登录时间'],
			colModel:[
				{name:'account',index:'account',width:120},
				{name:'longinDate',index:'longinDate',width:180}
			], 
			height:200,
			viewrecords : true,		
			rowNum:-1,
			//rowList:[5,15,20],
			autowidth: true,
			rownumbers: true,//显示行号
			pager : "#showOnlineUserList-pager",
			altRows: true,
			multiselect: false,
			multiboxonly: true,
			pgbuttons:false,//是否显示翻页按钮
			pginput:false,//是否显示跳转页面的输入框
			//caption: "在线人数",
			onSelectRow : function(rowid){}
		    }); */
	});
	
	function getOnlineNum(){
	    $.ajax({
		    type: "post",
		    async: false,
		    url: "../onlineUser/getOnlineNum",
		    dataType: "json",
		    success: function(data){
				if(data!=null){
				    $("#onlineNum").html(data);
				}else{ 
				    $("#onlineNum").html("0");
				}
		    }
		});
	}
</script>

			<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="#" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							通善Collection系统
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>

				<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
						<!-- 	<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-tasks"></i>
								<span id="showOnlineUserList" class="badge badge-grey">
									<span>在线人数</span>
									<span id="onlineNum"></span>人
								</span>
							</a> -->
						</li>

						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important"></span>
							</a>
						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span class="badge badge-success"></span>
							</a>
						</li>

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="ace/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎</small>
								 	${Session.___collectionUser______.caStaff.userName}  
								 </span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="ace-icon fa fa-user"></i>
										个人信息
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="../user/loginout">
										<i class="ace-icon fa fa-power-off"></i>
										退出登录
									</a>
								</li>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
			<div id="showOnlineUserListDialog">
			</div>
			<div id="showOnlineUserListDialog-message" class="hide">
				<!--jqgrid-->
				<table id="showOnlineUserList-table"></table>
				<div id="showOnlineUserList-pager" style="height:36px"></div>
			</div>
		</div>