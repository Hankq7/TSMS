<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看办税专员</title>
    <link href="static/css/base.css" rel="stylesheet">
    <link rel="stylesheet" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link href="static/css/edit.css" rel="stylesheet">
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="static/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="static/js/calendar.js"></script>
  </head>
  <body>
     <div class="container">
        <div class="content">
            <div title="办税专员信息" data-options="closable:false" class="basic-info">
                <div class="column"><span class="current">查看办税专员</span></div>
                <form id="editForm">
                <input name="id" id="id" type="hidden" >
                <table class="kv-table">              	
                    <tbody> 
                    
                       <tr>
                        <td class="kv-label">办税专员编号</td>
                        <td class="kv-content"><label>${list.taxerCode }</label></td>
                        <td class="kv-label">办税专员名称</td>
                        <td class="kv-content"><label>${list.taxerName }</label></td>
                    </tr>
                    <tr>
                        <td class="kv-label">手机号</td>
                        <td class="kv-content"><label>${list.mobile }</label></td>
                        <td class="kv-label">地址</td>
                        <td class="kv-content"><label>${list.address }</label></td>
                    </tr>
                     <tr>
                        <td class="kv-label">性别</td>
                        <td class="kv-content">
                        	<label>${list.sex }</label> 
                        	</td>
                        <td class="kv-label">生日</td>
                        <td class="kv-content"><label>${list.birthday }</label></td>
                    </tr>
                    <tr>
                    <td class="kv-label">Email</td>
                        <td class="kv-content"><label>${list.email }</label></td>
                        <td class="kv-label">所属税务机关</td>
                        <td class="kv-content">
                        	<label>${list.organName }</label>                          
                        </td>
                    </tr>                     
                    </tbody>                                
                </table>
                </form>
            </div>
        </div>
    </div>
  </body>
</script>
</html>