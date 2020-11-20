(function () {
    require(['jquery', 'ajaxUtil','bootstrapTableUtil','objectUtil','alertUtil','modalUtil','selectUtil','stringUtil','dictUtil'],
        function (jquery,ajaxUtil,bootstrapTableUtil,objectUtil,alertUtil,modalUtil,selectUtil,stringUtil,dictUtil) {

            var url = "/industrialdevelop/topic";

            //var webStatus = dictUtil.getDictByCode(dictUtil.DICT_LIST.webStatus);

            //角色加载工具
            //url = selectUtil.getRoleTable(sessionStorage.getItem("rolename"),url,"dataStatus",webStatus);

            var addUrl = "/scientificProject/topicManagement";
            var aParam = {

            };

            //操作
            function operation(value, row, index){
                if (row.industrialDevelopStatus === '展示中'){
                    return [
                        '<a class="unshelve" style="margin:0 1em;text-decoration: none;color: #775637" data-toggle="modal" data-target="" >下架</a>'
                    ].join('')
                } else {
                    return [
                        '<a class="edit" style="margin:0 1em;text-decoration: none;color: #775637" data-toggle="modal" data-target="" >编辑</a>',
                        '<a class="delete" style="margin:0 1em;text-decoration: none;color:#D60000;"  data-toggle="modal" data-target="#staticBackdrop" >删除</a>',
                    ].join('');
                }
            }

            //修改事件
            window.orgEvents = {
                'click .edit' : function(e, value, row, index) {
                    localStorage.setItem("rowData", JSON.stringify(row));
                    orange.redirect(addUrl);
                },

                'click .delete': function (e, value, row, index) {
                    var myDeleteModalData ={
                        modalBodyID : "myDeleteRegulation",
                        modalTitle : "删除政策法规",
                        modalClass : "modal-lg",
                        confirmButtonClass : "btn-danger",
                        modalConfirmFun:function () {
                            var isSuccess = false;
                            ajaxUtil.myAjax(null,"/datado/regulation/deleteByPrimaryKey/"+row.itemid+"/"+row.itemcode,null,function (data) {
                                if(ajaxUtil.success(data)){
                                    ajaxUtil.myAjax(null,"/file/delete?dataCode="+row.itemcode,null,function (data) {
                                        if(!ajaxUtil.success(data)){
                                            return alertUtil.error("附件删除失败");
                                        }
                                    },false,"","get");
                                    alertUtil.info("删除政策法规成功");
                                    isSuccess = true;
                                    refreshTable();
                                }
                            },false,true,"delete");
                            return isSuccess;
                        }

                    };
                    var myDeleteModal = modalUtil.init(myDeleteModalData);
                    myDeleteModal.show();
                },

                'click .pass' : function (e, value, row, index) {
                    var myPassRegulationModalData ={
                        modalBodyID :"myPassModal",
                        modalTitle : "审核通过",
                        modalClass : "modal-lg",
                        modalConfirmFun:function () {
                            var isSuccess = false;
                            var submitStatus = {
                                "dataStatus": selectUtil.getStatus(sessionStorage.getItem("rolename"),webStatus)
                            };
                            ajaxUtil.myAjax(null,"/datado/newsInf/changeNewsStatus/"+row.itemid+"/"+row.itemcode,submitStatus,function (data) {
                                if(ajaxUtil.success(data)){
                                    if(data.code == 88888){
                                        if(sessionStorage.getItem("rolename") == "政务资源处长"){
                                            alertUtil.info("审核已通过，已发送给综合处处长做最后审核！");
                                        }else{
                                            alertUtil.info("审核已通过，已上架！");
                                        }
                                        isSuccess = true;
                                        refreshTable();
                                    }else{
                                        alertUtil.error(data.msg);
                                    }
                                }
                            },false);
                            return isSuccess;
                        }
                    };
                    var myPassModal = modalUtil.init(myPassRegulationModalData);
                    myPassModal.show();
                },

                'click .fail' : function (e, value, row, index) {
                    var myFailRegulationModalData ={
                        modalBodyID :"myFailModal",
                        modalTitle : "审核不通过",
                        modalClass : "modal-lg",
                        modalConfirmFun:function () {
                            var isSuccess = false;
                            var submitStatus = {
                                "dataStatus": ""
                            };
                            if(sessionStorage.getItem("rolename") == "文化宣传处长" || sessionStorage.getItem("rolename") == "政务资源处长"){
                                submitStatus.dataStatus = webStatus[3].id;
                            }else{
                                submitStatus.dataStatus = webStatus[4].id;
                            }
                            ajaxUtil.myAjax(null,"/datado/newsInf/changeNewsStatus/"+row.itemid+"/"+row.itemcode,submitStatus,function (data) {
                                if(ajaxUtil.success(data)){
                                    if(data.code == 88888){
                                        alertUtil.info("操作成功");
                                        isSuccess = true;
                                        refreshTable();
                                    }else{
                                        alertUtil.error(data.msg);
                                    }
                                }
                            },false);
                            return isSuccess;
                        }

                    };
                    var myFailModal = modalUtil.init(myFailRegulationModalData);
                    myFailModal.show();
                },

                'click .under-shelf' : function (e, value, row, index) {
                    var myUnderShelfRegulationModalData ={
                        modalBodyID :"myUnderShelfModal",
                        modalTitle : "下架",
                        modalClass : "modal-lg",
                        modalConfirmFun:function () {
                            var isSuccess = false;
                            var submitStatus = {
                                "dataStatus": webStatus[6].id
                            };
                            ajaxUtil.myAjax(null,"/datado/newsInf/changeNewsStatus/"+row.itemid+"/"+row.itemcode,submitStatus,function (data) {
                                if(ajaxUtil.success(data)){
                                    if(data.code == 88888){
                                        alertUtil.success("下架成功");
                                        isSuccess = true;
                                        refreshTable();
                                    }else{
                                        alertUtil.error(data.msg);
                                    }
                                }
                            },false);
                            return isSuccess;
                        }

                    };
                    var myUnderShelfModal = modalUtil.init(myUnderShelfRegulationModalData);
                    myUnderShelfModal.show();
                },

                'click .view' : function (e, value, row, index) {
                    var myViewRegulationModalData ={
                        modalBodyID : "myViewDataModal", //公用的在后面给span加不同的内容就行了，其他模块同理
                        modalTitle : "查看详情",
                        modalClass : "modal-lg",
                        confirmButtonStyle: "display:none",
                    };
                    var myRegulationModal = modalUtil.init(myViewRegulationModalData);
                    $("#dataTitle").val(row.dataTitle);
                    $("#dataSource").val(row.dataSource);
                    $("#dataContent").val(row.dataContent);
                    $("#creater").val(row.creater);
                    $("#itemCreateAt").val(row.itemcreateat);
                    $("#dataStatus").val(webStatus[row.dataStatus].text);
                    $("#dataFileType").val(webFileType[row.dataFileType].text);
                    $("#imgDiv").attr("style","display:none");
                    $("#author").attr("style","display:none");
                    $('#dataTitleSpan').html("政策法规名称");
                    $('#dataFileTypeSpan').html("文件类型");
                    $("#fileDiv").attr("style","display:block");
                    $("#upFile").html(row.fileName);

                    myRegulationModal.show();
                },

                'click .submit' : function (e, value, row, index) {
                    var mySubmitRegulationModalData ={
                        modalBodyID :"mySubmitModal",
                        modalTitle : "提交",
                        modalClass : "modal-lg",
                        modalConfirmFun:function () {
                            var isSuccess = false;
                            var submitStatus = {
                                "dataStatus": selectUtil.getStatus(sessionStorage.getItem("rolename"),webStatus)
                            };
                            ajaxUtil.myAjax(null,"/datado/newsInf/changeNewsStatus/"+row.itemid+"/"+row.itemcode,submitStatus,function (data) {
                                if(ajaxUtil.success(data)){
                                    if(data.code == 88888){
                                        alertUtil.info("已提交");
                                        isSuccess = true;
                                        refreshTable();
                                    }else{
                                        alertUtil.error(data.msg);
                                    }

                                }
                            },false);
                            return isSuccess;
                        }
                    };
                    var mySubmitModal = modalUtil.init(mySubmitRegulationModalData);
                    mySubmitModal.show();
                },

                'click .no-submit' : function (e, value, row, index) {
                    var myNoSubmitRegulationModalData ={
                        modalBodyID :"myNoSubmitModal",
                        modalTitle : "取消提交",
                        modalClass : "modal-lg",
                        modalConfirmFun:function () {
                            var isSuccess = false;
                            var submitStatus = {
                                "dataStatus": webStatus[0].id
                            };
                            ajaxUtil.myAjax(null,"/datado/newsInf/changeNewsStatus/"+row.itemid+"/"+row.itemcode,submitStatus,function (data) {
                                if(ajaxUtil.success(data)){
                                    if(data.code == 88888){
                                        alertUtil.info("已提交");
                                        isSuccess = true;
                                        refreshTable();
                                    }else{
                                        alertUtil.error(data.msg);
                                    }

                                }
                            },false);
                            return isSuccess;
                        }
                    };
                    var mySubmitModal = modalUtil.init(myNoSubmitRegulationModalData);
                    mySubmitModal.show();
                },
            };


            $("#btn_addTask").unbind().on('click',function () {
                localStorage.removeItem("rowData");
                orange.redirect(addUrl);
            });

            var pl = dictUtil.getDictByCode(dictUtil.DICT_LIST.showStatus);
            $("#chargePersonSearch").selectUtil(pl);


            var aCol = [
                {field: 'dataTitle', title: '政策法规名称'},
                {field: 'dataSource', title: '来源'},
                {field: 'dataFileType', title: '文件类型', formatter:function (value) {
                        return '</p>'+webFileType[value].text+'</p>'
                    }},
                {field: 'filePath', title: '附件', formatter:function (value, row, index) {
                        if(value == "已经损坏了"){
                            return '<p>'+value+'</p>';
                        }else if (row.fileName == null){
                            return '<p>————</p>';
                        }else{
                            return '<a href="'+value+'">'+row.fileName+'</a>'
                        }
                    }},
                {field: 'itemcreateat', title: '发布时间'},
                {field: 'action',  title: '操作',formatter: operation,events:orgEvents}
            ];

            var myTable = bootstrapTableUtil.myBootStrapTableInit("table", url, aParam, aCol);

            function refreshTable() {
                var param = {};
                myTable.free();
                myTable = bootstrapTableUtil.myBootStrapTableInit("table", url, param, aCol);
            }

            bootstrapTableUtil.globalSearch("table",url,aParam, aCol);
            var allTableData = $("#table").bootstrapTable("getData");
            //console.log(allTableData);
            localStorage.setItem('2',JSON.stringify(allTableData))
            obj2=JSON.parse(localStorage.getItem("2"));
            //console.log(obj2);

        })
})();