<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选车</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-table.min.css">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css">
<!-- 最新的 Bootstrap 核心 JavaScript 文件  要将jquery的包放在bootstrap之前-->
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table.min.js"></script>
<script
	src="<%=request.getContextPath()%>/js/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>
<br>

	<div id="toolbar">
		<div class="form-inline" role="form">
			<div class="form-group">
				<span>编号查找：</span> <input name="bikeId" id="bikeId"
					class="form-control" type="text" placeholder="单车车号">
			</div>
			<div class="form-group">
				<span>地址查找：</span> <input name=address id="address"
					class="form-control" type="text" placeholder="骑行城市">
			</div>
			<div class="form-group" >
				<span>代数查找：</span>
					<select class="form-control" name="bikeKind" id="bikeKind"> 
						<option></option>
						<option>第一代</option>
						<option>第二代</option>
						<option>第三代</option>
					</select>
			</div>
			<input type="button" class="btn-sm btn-primary" onclick="_search()"
				value="查询" />
		</div>
	</div>
	<br>
	
	
	<table id="prjTable"></table>
	
	<script type="text/javascript">
var tableData = $('#prjTable');
tableData.bootstrapTable({
url: "<%=request.getContextPath()%>/getBikeList", 
dataType: "json",
pagination: true, //分页
singleSelect: false,
//toolbar:"#toolbar",
showRefresh:true,// 显示刷新按钮
showColumns:true, // 显示所有的列
//data-locale:"zh-CN", //表格汉化
search: false, //显示搜索框
striped:true,
sidePagination: "server", //服务端处理分页
pageList:[5,10,15,20,50],
sortName : 'createDate', // 排序字段
sortOrder : 'desc', // 排序方式
sortable: true, //是否启用排序
queryParams: function (params) {
    return {
            offset: params.offset,  //页码
            limit: params.limit,   //页面大小
            search : params.search, //搜索
            order : params.order, //排序
            ordername : params.sort, //排序
            bikeId:$("#bikeId").val(),
            address:$("#address").val(),
            bikeKind:$("#bikeKind").val(),
        };
    },
      columns: [
    	      {
              title: '单车编号',
                field: 'bikeId',
                align: 'left',
                valign: 'middle',
                align: 'center'
              }, 
              {
                title: '单车代数',
                  field: 'bikeGenerationnum',
                  align: 'left',
                  valign: 'middle',
                  align: 'center'
              }, 
              {
                  title: '所在城市',
                  field: 'bikeArea',
                  align: 'center'
      
              },
               {
                   title: '操作',
                   field: 'bikeId',
                   align: 'center',
                   formatter:function(value,row,index){
                var e = '<a href="javascript:void(0)" onclick="showEditUI(\''+ row.bikeId +'\')" input type="button" class="btn-sm btn-info" >用车</a> ';
                return e;
                 } 
               }
          ]   
  });

//查询		
function _search()
{
	 $('#prjTable').bootstrapTable('refresh', {url: 'getBikeList'});  
}
// 编辑时，弹出数据框
/* function showEditUI(projectEditId)
{
	 $.get("selectByPKey",{id:projectEditId},function(data){
		 // 给每一个输入框赋值
		 $("#modifyid").val(data.id);
		 $("#modifyname").val(data.name);
		 $("#modifyeducation").val(data.education);
		 $("#modifyphoneno").val(data.phoneno);
		 $("#modifyqq").val(data.qq);
		 $("#modifyemail").val(data.email);
		 $("#modifycustomstatu").val(data.customstatu);
		 $("#modifyinvitename").val(data.invitename);
	 },"json");
	// 显示弹窗
	 $("#modifyModal").modal("show");
}

$("#saveModify").click(function(){
	 var prjInfo = { 
			 id:$("#modifyid").val(),
			 name:$("#modifyname").val(),
			 education:$("#modifyeducation").val(),
			 phoneno:$("#modifyphoneno").val(),
			 qq:$("#modifyqq").val(),
			 email:$("#modifyemail").val(),
			 customstatu:$("#modifycustomstatu").val(),
			 invitename:$("#modifyinvitename").val()
	 };
	 // 后台提交保存的请求
	 $.post("editCustom",{custom:JSON.stringify(prjInfo)},function(data){
		 if (data == "1")
			 {
			   alert("修改成功");
			// 关闭弹窗
			$("#modifyModal").modal("hide");
			// 刷新数据
			 $('#prjTable').bootstrapTable('refresh', {url: 'selectCustom'});
			 }
	 });
}); */

     
// 文件的导出
function _download()
{
	window.location.href='<%=request.getContextPath()%>/getAllCostom';
}

//文件的导出
function _export()
{
	window.location.href='<%=request.getContextPath()%>/getAllCostom';
}

</script>

</body>
</html>