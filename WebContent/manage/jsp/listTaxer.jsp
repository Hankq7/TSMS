<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>办税专员管理</title>

<link href="../../static/css/base.css" rel="stylesheet">
<link rel="stylesheet" href="../../static/easyui/uimaker/easyui.css">
<link rel="stylesheet" type="text/css" href="../../static/easyui/uimaker/icon.css">
<link rel="stylesheet" href="../../static/css/taxpayer.css">
  <style type="text/css">
	.a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<div class="container">
		<table id="dg">
		</table>
		<div id="tb" style="padding: 0 30px;">
			办税专员名称: <input type="text" name="taxerName" id="taxerName"
				style="width: 166px; height: 35px; line-height: 35px;" /> <a
				href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton"
				iconCls="icon-search" data-options="selected:true">查询</a> <a
				href="javascript:void(0);" id="setBtn" class="easyui-linkbutton"
				iconCls="icon-reload">重置</a> <a href="javascript:void(0);"
				id="addBtn" class="easyui-linkbutton" iconCls="icon-add">添加办税专员</a>
		</div>
	</div>
	<script type="text/javascript" src="../../static/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../../static/easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		/**
		 *打开在父窗口中打开window
		 */
		function openTopWindow(options) {
			options = !options ? {} : options;
			options.width = !options.width ? 500 : options.width;
			options.height = !options.height ? 400 : options.height;
			options.title = !options.title ? "" : options.title;
			parent.$("#iframe").attr("src", options.url);
			parent.$("#topWindow").window({
				title : options.title,
				width : options.width,
				height : options.height,
				modal : true,
				resizable : true,
				collapsible : false,
			});
			
		}
		//查询
    	   function doSearch(){     	   
			   $("#dg").datagrid("load",{		
					"taxerName": $("#taxerName").val()
				});
			}
        //删除
        function removeTaxPayer(id){
     	   $.messager.confirm('操作提示', '确定要删除吗?', function(r){
	  				if (r){
	  					$.post("../../deleteTaxerServlet.action",{"id":id},function(data){
			           		if(data.success){
			           			alert(data.msg)
			           			doSearch()	
			           		}else{
			           			alert(data.msg)
			           		}
			           	},"json")
			           	doSearch()	     
	  				}
	   		   });
	           	
        }
      //详情
        function detail(id){	          
	           	openTopWindow({"url":"../../getTaxerInfoServlet.action?id="+id,
	   		 	"title":"纳税人信息",	   		 	
	   		 	 width : 750,
              height : 500,
				})
	           	doSearch()	           	          
        }
        //更新
 		function edit(id){	          
	   		 	openTopWindow({url:"../../toGetEditTaxerServlet.action?id="+id,
	   		 	title:"修改纳税人信息",	   		 	
	   		 	 width : 750,
              height : 600,
				})
				doSearch()      	          
  		}         
      
	</script>
	
	<script type="text/javascript">
	$(function() {
		$("#dg").datagrid({
	       	   title:"纳税人信息",
	       	   url:"../../listTaxerServlet.action",
	       	   toolbar:"#tb",
	       	   coolapsible:true,
	       	   method:"POST",
	       	   loadMsg:"数据加载中..",
	       	   pagination:true,
	       	   striped:true,  
	       	   columns:[[
						{field:"taxerCode","title":"办税专员编号"},
	                    {field:"taxerName","title":"办税专员名称"},
	                    {field:"mobile","title":"手机号"},
	                    {field:"address","title":"地址"},
	                    {field:"email","title":"邮件"},
	                    {field:"opreation","title":"操作",formatter:function(value,rowData,index){
	                    return "<a href='javascript:void(0)' onclick='detail("+rowData.id+")'>详情   </a>"
	                    +"<a href='javascript:void(0)' onclick='removeTaxPayer("+rowData.id+")'>删除   </a>"
	                    +"<a href='javascript:void(0)' onclick='edit("+rowData.id+")'>修改   </a>"                              
	                    }}   
	       	   ]]      	          	   
	       	})
		
		 //查询事件
       	   $("#searchBtn").click(function(){      	   
       	     doSearch()
       	   })
       	   
       	   //添加页面事件
       	  $("#addBtn").click(function(e){
              openTopWindow({
                  width : 750,
                  height : 600,
                  title : "新增办税专业",
                  url : "addTaxer.jsp"
              });
              doSearch()
           });
          //重置 
          $("#setBtn").click(function(e){
          //文本框的内容清空
          	$("#taxerName").val("");           
          })
		
		
	});
	</script>
</body>
</html>
