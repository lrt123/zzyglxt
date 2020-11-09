(function () {
    require(['jquery','ajaxUtil','wangEditor'],
        function (jquery,ajaxUtil, wangEditor) {

            var type = isUpdate() ? "put":"post";

            var url = "/industrialdevelop/achievement";

            const editor = new wangEditor('#div1');
            // 或者 const editor = new E( document.getElementById('div1') )
            //菜单配置
            editor.config.menus = [
                'head',
                'bold',
                'fontSize',
                'fontName',
                'italic',
                'underline',
                'strikeThrough',
                'indent',
                'lineHeight',
                'foreColor',
                'backColor',
                'link',
                'list',
                'justify',
                'image',
                'table',
                'splitLine',
                'undo',
                'redo',

            ];
            //取消粘贴后的样式
            editor.config.pasteFilterStyle = false
            //不粘贴图片
            editor.config.pasteIgnoreImg = true
            //隐藏上传网络图片
            editor.config.showLinkImg = false
            editor.config.uploadImgShowBase64 = true
            editor.create()
            editor.txt.html('<p></p>')

            $("#div1").on("input propertychange", function() {
                var textNUm=editor.txt.text();
                if(textNUm.length>=100000){
                    str=textNUm.substring(0,10000)+"";  //使用字符串截取，获取前30个字符，多余的字符使用“......”代替
                    editor.txt.html(str);
                    alert("字数不能超过10000");                  //将替换的值赋值给当前对象
                }
            });



            $("#cancelBtn").click(function () {
                $("#main_body").html("");

                orange.loadPage({url: url, target: 'main_body', selector: '#fir_body', success: function(data){

                        if(data == null||data == ""){
                            return alert(url+"加载失败");
                        }

                        $("#main_body").html(data);
                    }})
            });

            function generateParam(){
                var param = {};
                param.cooperationExchangeName = $("#cooperationExchangeName").val();
                param.cooperativeOrg = $("#cooperativeOrg").val();
                param.contacts = $("#contacts").val();
                param.phone = $("#phone").val();
                param.projectIntroduce = $(".w-e-text").html();
                param.orgCode = "未定义";
                return param;
            }

            $("#saveBtn").unbind().on('click',function () {
                var param = generateParam();

                ajaxUtil.myAjax(null,url,param,function (data) {
                    if(ajaxUtil.success(data)){
                    }
                },true,"123",type);
                return false;
            })

            $("#submitBtn").unbind().on('click',function () {
                var param = generateParam();
                ajaxUtil.myAjax(null,url,param,function (data) {
                    if(ajaxUtil.success(data)){
                    }
                },true,"123",type);
                return false;
            })



            (function init() {
                if (isUpdate()){
                    var tempdata = JSON.parse(localStorage.getItem("rowData"));
                    $("#industrialDevelopLeader").val(tempdata.industrialDevelopLeader);
                    $("#industrialDevelopName").val(tempdata.industrialDevelopName);
                    $("#contacts").val(tempdata.contacts);
                    $("#phone").val(tempdata.phone);
                    $("#projectName").val(tempdata.projectName);
                    $(".w-e-text").html(tempdata.context);
                }
            }());


            function isUpdate() {
                return (localStorage.getItem("rowData") != null || localStorage.getItem("rowData") != undefined)
            }
    })
})();


