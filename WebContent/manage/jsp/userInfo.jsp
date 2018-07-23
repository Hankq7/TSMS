<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户基本信息</title>
    <link rel="stylesheet" type="text/css" href="static/css/base.css" >
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/easyui/uimaker/icon.css">
    <link rel="stylesheet" type="text/css" href="static/css/edit.css">
  </head>
  <style>
  	input{
  		readonly:true
  	}  
  </style>
  <body>
   <div class="container">
    <div class="content">
        <div title="纳税人信息" data-options="closable:false" class="basic-info">
            <div class="column"><span class="current">用户基本信息</span></div>
            <table class="kv-table">
                <tbody>
                <tr>
                    <td class="kv-label">用户员工编号</td>
                    <td class="kv-content"><input type="text" name="payerCode" value="1" ></td>
                    <td class="kv-label">用户权限</td>
                    <td class="kv-content">1</td>
                    <td class="kv-label">用户状态</td>
                    <td class="kv-content">1</td>
                </tr>
                <tr>
                    <td class="kv-label">税务人员工号</td>
                    <td class="kv-content">201703</td>
                    <td class="kv-label">税务人员名称</td>
                    <td class="kv-content">章莉</td>
                    <td class="kv-label">税务人员电话</td>
                    <td class="kv-content">10010</td>
                </tr>
                <tr>
                    <td class="kv-label">地址</td>
                    <td class="kv-content">武汉</td>
                    <td class="kv-label">性别</td>
                    <td class="kv-content">1</td>
                    <td class="kv-label">出生日期</td>
                    <td class="kv-content">2010-03-16</td>
                </tr>
                <tr>
                    <td class="kv-label">邮箱</td>
                    <td class="kv-content">986432727@qq.com</td>
                    <td class="kv-label">税务机关</td>
                    <td class="kv-content">6</td>
                    <td class="kv-label">税务状态</td>
                    <td class="kv-content">0</td>
                </tr>
                <tr>
                    <td class="kv-label">上级主管</td>
                    <td class="kv-content">0</td>
                    <td class="kv-label">系统管理员标志</td>
                    <td class="kv-content">0</td>
                    <td class="kv-label">记录日期</td>
                    <td class="kv-content">2018-07-19</td>
                </tr>
                </tbody>
            </table>
         </div>
    </div>
</div>

  </body>
</html>
