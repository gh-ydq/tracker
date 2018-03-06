var ShowList = {//ShowList
    //表格标签
    grid_table1: "#jqGridList",
    //分页标签
    grid_page1: "#jqGridPager",
}

//委外商信息
jQuery(ShowList.grid_table1).jqGrid({
    url:"/led/info",
    datatype: "local",
    mtype:"POST",
    height:300,
    autowidth: true,
    colNames:['流水号','委外商名称','来源','佣金比例','提交日期','合同数','应还总额','起始日期','终止日期','状态'],
    colModel:[
        {name:'id',index:'id',width:40},
        {name:'outsourceCompanyName',index:'outsourceCompanyName',width:80},
        {name:'outsourceType',index:'outsourceType',width:50},
        {name:'commissionRatio',index:'commissionRatio',width:40},
        {name:'submitDate',index:'submitDate',width:60},
        {name:'contractAmount',index:'contractAmount',width:40},
        {name:'sumMoney',index:'sumMoney',width:60},
        {name:'startDate',index:'startDate',width:60},
        {name:'endDate',index:'endDate',width:60},
        {name:'status',index:'status',width:40},
    ],
    loadComplete : function(){
        var table = this;
        updatePagerIcons(table);
    },
    //scrollOffset:0,//设置右侧滚动条的宽度,0=没有
    viewrecords : true,//是否要显示总记录数
    rowNum:10,
    rowList:[10,20,50],
    rownumbers: true,
    pager:ShowList.grid_page1,
    pgbuttons:true,//是否显示翻页按钮
    pginput:true,//是否显示跳转页面的输入框
    altRows: true,
    multiboxonly: true,
    editurl: "../outSourceContract/showOutSourceList",
    caption: "委外记录查询",
    gridComplete:function(){
        $(ShowList.grid_table1).parents(".ui-jqgrid-bdiv").css("overflow-x","hidden");
    }
});


function updatePagerIcons(table) {
    var replacement =
        {
            'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
            'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
            'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
            'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
        };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
    });
}