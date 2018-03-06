	<link rel="stylesheet" href="ace/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="ace/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="ace/assets/css/ace-part2.css" class="ace-main-stylesheet" />
		<![endif]-->
		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="ace/assets/css/ace-ie.css" />
		<script src='ace/assets/js/jquery.js'></script>
		<![endif]-->
		<!-- inline styles related to this page -->
		<!-- ace settings handler -->
		<script src="ace/assets/js/ace-extra.js"></script>
		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
		<!--[if lte IE 8]>
		<script src="ace/assets/js/html5shiv.js"></script>
		<script src="ace/assets/js/respond.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<#include "/common/Ace/top.ftl">
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			<#include "/common/Ace/left.ftl">
			<div class="main-content">
				<div class="main-content-inner">
					<div class="page-content">
						<div class="page-header" style="height:28px">
							<h1>
								首页
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									${nav_title!}
								</small>
							</h1>
						</div><!-- /.page-header -->