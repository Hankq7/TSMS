<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>纳税人管理</title>
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
      <div id="tb" style="padding:0 30px;">
        纳税人识别号: <input type="text" name="payerCode" id="Code" style="width:166px;height:35px;line-height:35px;"/>
        纳税人名称: <input type="text" name="payerName" id="Name" style="width:166px;height:35px;line-height:35px;"/>
        <a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true">查询</a>
        <a href="javascript:void(0);" id="setBtn" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
        <a href="javascript:void(0);" id="addBtn" class="easyui-linkbutton" iconCls="icon-add">添加纳税人</a>
      </div>
    </div>
  </body>
   <script type="text/javascript" src="../../static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../static/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
         /**
            *打开在父窗口中打开window
            */
           function openTopWindow(options){
               options = !options ? {} :options;
               options.width = !options.width ? 500 : options.width;
               options.height = !options.height ? 400 : options.height;
               options.title = !options.title ? "" : options.title;
               parent.$("#iframe").attr("src",options.url);
               parent.$("#topWindow").window({
                   title : options.title,
                   width: options.width,
                   height: options.height,
                   modal:true,
                   resizable:true,
                   collapsible:false,
               });
              
           }
         	//查询函数
			function doSearch() {
				$('#dg').datagrid("load",{
					"payerCode":$('#Code').val(),
					"payerName":$('#Name').val()
				});
			}
         	//详情函数
         	function detail(id) {
         		openTopWindow({
         			"url":"../../getTaxPayerInfoServlet.action?id="+id,
    	   		 	"title":"纳税人信息",	   		 	
    	   		 	"width" : 750,
                    "height" : 550
    				})
    	           	doSearch()
			}
         	//删除函数
         	function removeTaxPayer(id){
         	   $.messager.confirm('操作提示', '确定要删除吗?', function(r){
 	  				if (r){
 	  					$.post(
 	  						"../../deleteTaxPayerServlet.action",
 	  						{"id":id},
 	  						function(data){
	 			           		if(data.success){
	 			           			alert(data.msg)
	 			           			doSearch()	
	 			           		}else{
	 			           			alert(data.msg)
	 			           		}
 			           		},
 			           		"json"
 			           	)
 			           	doSearch()	     
 	  				}
 	   		   });
 	           	
            }
         	//修改函数
         	function edit(id){	          
	   		 	openTopWindow({
	   		 	"url":"../../toGetTaxPayerServlet.action?id="+id,
	   		 	"title":"修改纳税人信息",	   		 	
	   		 	"width" : 750,
                "height" : 600
				})
				doSearch()      	          
     		} 
         	
         	//新建任务
            function addTask(id){ 
            		parent.addTab("调查任务录入","../../payerAddTaskServlet.action?id="+id)                     		
            }
         	
    </script>
    <script type="text/javascript">
           $(function() {
        		$('#dg').datagrid({    
        		    title:'纳税人信息',
        			url:'../../ListTaxPayerServlet.action',
        		    Method:'POST',
        		    toolbar:'#tb',
        		    loadMsg:'拼死加载中………………',
        		    pagination:true,
        		    striped:true,
        		    columns:[[    
        		        {field:'payerCode',title:'纳税人识别号'},    
        		        {field:'payerName',title:'纳税人名称'},    
        		        {field:'organName',title:'所属税务机关'},    
        		        {field:'industryName',title:'所属行业'},    
        		        {field:'legalPerson',title:'法人代表'},    
        		        {field:'legalIdCard',title:'法人身份证号码'},    
        		        {field:'finaceName',title:'主管财务'},    
        		        {field:'finaceIdCard',title:'财务身份证号码'},    
        		        {field:'recordDate',title:'录入日期'},    
        		        {field:'cz',title:'操作',formatter: function(value,row,index){
        		        		return "<a href='javascript:void(0)' onclick='detail("+row.id+")'>详情   </a>"
        	                    +"<a href='javascript:void(0)' onclick='removeTaxPayer("+row.id+")'>删除   </a>"
        	                    +"<a href='javascript:void(0)' onclick='edit("+row.id+")'>修改   </a>"
        	                    +"<a href='javascript:void(0)' id='addTask' onclick='addTask("+row.id+")'>新建任务 </a>";
        						
        					}	
        		        }   
        		    ]] 
        		}); 
        	
        	//查询按钮绑定点击事件
           	$("#searchBtn").click(function() {
           		doSearch()
			});
           	//重置按钮绑定点击事件
           	$("#setBtn").click(function() {
				$("#payerCode").val(" "),
				$("#payerName").val(" ")
           	});
          	//添加纳税人按钮绑定点击事件
           	$("#addBtn").click(function() {
           		openTopWindow({
           			"width" : 750,
                    "height" : 600,
                    "title" : "新增纳税人",
                    "url" : "addTaxPayer.jsp"
           		});
           		doSearch()
			});
           	
           	
           	
        	});
    </script>
</html>