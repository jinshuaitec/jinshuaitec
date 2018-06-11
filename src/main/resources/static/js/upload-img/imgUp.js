$(function(){
  var delParent;
  var defaults = {
    fileType         : ["jpg","png","bmp","jpeg"],   // 上传文件的类型
    fileSize         : 1024 * 1024 * 10                  // 上传文件的大小 10M
  };
  /*点击图片的文本框*/
  $(".projectfile").change(function(){
    var idFile = $(this).attr("id");
    var file = document.getElementById(idFile);
    var imgContainer = $(this).parents().siblings(".drop-img"); //存放图片的父亲元素
    var fileList = file.files; //获取的图片文件
    console.log(fileList+"======filelist=====");
    var input = $(this).parent();//文本框的父亲元素
    var imgArr = [];
    //遍历得到的图片文件
    var numUp = imgContainer.find(".drop-img .col-lg-3").length;
    var totalNum = numUp + fileList.length;  //总的数量
    if(fileList.length > 5 || totalNum > 5 ){
      alert("上传图片数目不可以超过5个，请重新选择");  //一次选择上传超过5个 或者是已经上传和这次上传的到的总数也不可以超过5个
    }
    else if(numUp < 5){
      fileList = validateUp(fileList);
      for(var i = 0;i<fileList.length;i++){
        var imgUrl = window.URL.createObjectURL(fileList[i]);
        imgArr.push(imgUrl);
        var $section = $('<div class="col-lg-3 m-b">');
        /*imgContainer.prepend($section);*/

        $section.appendTo(imgContainer);

        var $section1 = $('<div class="contact-box">');
        $section1.appendTo($section);

        var $section2 = $('<a href="#">');
        $section2.appendTo($section1);
        var $section3 = $('<div class="col-sm-12">');
        $section3.appendTo($section2);
        var $section4 = $('<div class="text-center">');
        $section4.appendTo($section3);

        var $span = $("<span class='up-span'>");
        $span.appendTo($section4);

        var $img = $("<img class='img-responsive'>");
        $img.attr("src",imgArr[i]);
        $img.appendTo($section4);

        var $delete = $('<label class="delete">');
        var $deleteInput = $('<input type="checkbox">');
        $delete.appendTo($section3);
        $deleteInput.appendTo($delete);

        var $p = $("<p class='img-name-p'>");
        $p.html(fileList[i].name).appendTo($section);
        var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
        $input.appendTo($section);
        var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
        $input2.appendTo($section);
        $(".drop-img").sortable();
      //  加接口
          
          
      }
    }
    numUp = imgContainer.find("..drop-img .col-lg-3").length;
    if(numUp >= 5){
      $(this).parent().hide();
    }

    //input内容清空
    $(this).val("");
  });

  function validateUp(files){
    var arrFiles = [];//替换的文件数组
    for(var i = 0, file; file = files[i]; i++){
      //获取文件上传的后缀名
      var newStr = file.name.split("").reverse().join("");
      if(newStr.split(".")[0] != null){
        var type = newStr.split(".")[0].split("").reverse().join("");
        console.log(type+"===type===");
        if(jQuery.inArray(type, defaults.fileType) > -1){
          // 类型符合，可以上传
          if (file.size >= defaults.fileSize) {
            alert(file.size);
            alert('您这个"'+ file.name +'"文件大小过大');
          } else {
            // 在这里需要判断当前所有文件中
            arrFiles.push(file);
          }
        }else{
          alert('您这个"'+ file.name +'"上传类型不符合');
        }
      }else{
        alert('您这个"'+ file.name +'"没有类型, 无法识别');
      }
    }
    return arrFiles;
  }
})
