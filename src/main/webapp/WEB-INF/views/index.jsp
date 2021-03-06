<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<c:set var="path" value="${pageContext.request.contextPath}" />


<head>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
   integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
   crossorigin="anonymous">
<link rel="stylesheet" href="${path}/css/challengeCard.css">
<link rel="stylesheet" href="${path}/css/calendar.css">
<link rel="stylesheet" href="${path}/css/emoticon.css">
<link rel="stylesheet" href="${path}/css/checkbox.css">
<link rel="stylesheet" href="${path}/css/switch.css">
<link rel="stylesheet" href="${path}/css/memo.css">
<link rel="stylesheet" href="${path}/css/carousel.css">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<!-- title -->
<link href="https://fonts.googleapis.com/css?family=Bangers"
   rel="stylesheet">
<link rel="stylesheet" href="${path}/css/title.css">
<script src="${path}/js/title.js"></script>
<!-- title -->

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
   href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>

<!-- nav end-->

<link href="https://fonts.googleapis.com/css?family=Cute+Font"
   rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo"
   rel="stylesheet">
<link
   href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
   rel="stylesheet">

<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
   integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
   crossorigin="anonymous"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
   integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
   crossorigin="anonymous"></script>
<script src="${path}/js/calendar.js"></script>
<script src="${path}/js/moment.js"></script>
<script src="${path}/js/glider.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.2/TweenMax.min.js"></script>

<style type="text/css">
hr {
   width: 100%;
}

body {
   background-color: #ECECEC;
   font-family: 'Cute Font', cursive;
}

a, h1, h2, label {
   color: #001E36;
}

h4 {
   color: #0F3347;
}
</style>
<script type="text/javascript">
   var colorArr = ['red','yellow','green','blue','pink','orange'];
    var monthCount = moment().month();
    var yearCount = moment().year();
   var m;
      
   $(function() {
      if(monthCount<10) m = '0'+monthCount;
      m = monthCount+1;
      //2. Section2(Daily)에 오늘 날짜를 출력하는 기능
      var date = moment().date();
      var month = moment().month() + 1;
      var year = moment().year();
      $('#Date ').html(year + "년 " + month + "월 " + date + "일");
      //$('#Date ').html(year +"/ " + month + "/ " + date);
      $('#Date ').css('font-size', '2.8em');
      $('#sec3month').html(month+"월");
      $('#search h2').html(year + "년 " + month + "월 " + date + "일");
      //2

      //3. emotion 가져오기, 보내기
      $('#emotion_tbl td').click(function() {
         var emotion = $(this).children().attr('id');
         $.ajax({
            type : "get",
            url : "updateEmotion.do",
            data : {
               "emotion" : emotion,
               "memberNo" : ${sessionScope.member.memberNo}
            },
            success : function(data) {
               $('#emotion_tbl td').addClass('clicked');
               $('#' + emotion).parent().removeClass('clicked');
            }//callback
         });//ajax 
      });//click
      //3

      //4. newChallengeBtn을 누르면 writechallenge.jsp를 캐러셀에 포함한다.
      $('#newChallengeBtn').click(function() {
         $.ajax({
            url : "writechallenge.jsp",

            success : function(result) {

               $("#newchallengeDiv").html(result);
               /* $('#challengeWriteOK').click(function(){
                  location.href="addChallenge.do"
               }); */
            }//susccess
         });//ajax
      });//click

      //6.   달력
      var tempArr = ${daily.scheduleFormattedArray};
      var arr = ${daily.scheduleFormattedArray}; //challenge (시작일, 마지막일) format으로 arr로 입력
      new Promise(function(resolve, reject) {
         calendarInit(yearCount, monthCount);
         if(arr==null || arr[0]==null || arr.length==0){
            reject("No Schedule");
         }
         resolve(arr);       
      },function(e){
         alert(e);
      }).then(setChallenge1(arr)).then(setChallenge2(arr)).then(
            setChallenge3(arr));
      //alert(moment().format());

      var geo = navigator.geolocation;
      var lon;
      var lat;
      geo.getCurrentPosition(function(position) {
         lon = position.coords.longitude;
         lat = position.coords.latitude;
         $.ajax({
            method : "get",
            url : 'http://api.openweathermap.org/data/2.5/weather?lat='
                  + lat + '&lon=' + lon
                  + '&&appid=8bc6e9cc3e1a41d04319bd97ea0e0214',
            success : function(data) {
               $('#weatherTest h2').append(data.weather[0].main);
            }
         });
      });
   
      //7. calendar next searchResultTab..
      var tag = '${daily.scheduleList[0].scheduleTag}';
      $.ajax({
         method : 'get',
         url : 'searchResult.do',
         data : {
            "word" : tag
         },
         dataType : 'json',
         success : function(data) {
            var d = JSON.parse(data.result);
            $('#search h4').html('#'+tag);
            $('#search div').each(
                  function(index) {
                     $(this).html(
                           '<h4><a href="'+d.items[index].link+'">' + d.items[index].title + '</a></h4><p>'
                                 + d.items[index].description
                                 + '</p>');
                     
                     });
         }
      });
      
      
      $('.tracker').click(function(){
//         alert($(this).parent().attr('id'));                  $(this).parent().attr('id') -- habit
//         alert(getDateByTrackerId($(this).attr('id')));           ex)20181202
         var id = $(this).attr('id');
            var x = getDateByTrackerId(id).substring(6);
            if(x<10) x=x.substring(1);
            x=x-1;
         var monthId = id.substring(0,1)+x;

         $.ajax({
            url : "checkHabit.do",
            data : {
               "habit" : $(this).parent().attr('id'),
               "day" : getDateByTrackerId($(this).attr('id')),
               "memberNo" : ${member.memberNo}
            },
            success : function(data){
               if(data.flag=='check'){
                  $('#'+id).css('background-color','red');
                  $('#m'+monthId).css('background-color','red');
               } else if(data.flag == 'uncheck'){
                  $('#'+id).css('background-color','white');
                  $('#m'+monthId).css('background-color','white');
               }else{
                  alert("fail");
               }
            }
         });
            });

	   	 $('#weeklyHabit').click(function(){
	  	  	alert($(this).position().left+"       "+$(this).position().top);
			  	 window.open("","SETTING","width=400,height=500,top="+($(this).position().top-500)+",left="+$(this).position().left);
	   	 });
	    
	     $('.calendar__day').hover(function(){
	   	 	var selector = $(this);
	 	   	if($(this).attr('id')!=null && ($(this).hasClass('c1')||$(this).hasClass('c2')||$(this).hasClass('c3'))){
	    		$.ajax({
	    			url : "getScheduleByDay.do",
	    			data : {
	    				month : yearCount+""+m,
	    				d : $(this).attr('id')
	    			},
	    			success : function(data){
	    				if(data.json!= ""){
	    					importSchedule(data.json,selector);
	    					if(data.json[0].scheduleTag!=''){
			    				$.ajax({
			    			         method : 'get',
			    			         url : 'searchResult.do',
			    			         data : {
			    			            "word" : data.json[0].scheduleTag
			    			         },
			    			         dataType : 'json',
			    			         success : function(r) {
			    			            var d = JSON.parse(r.result);
			    			            $('#search h4').html('#'+data.json[0].scheduleTag);
			    			            $('#search div').each(
			    			                  function(index) {
			    			                     $(this).html(
			    			                           '<h4><a href="'+d.items[index].link+'">' + d.items[index].title + '</a></h4><p>'
			    			                                 + d.items[index].description
			    			                                 + '</p>');
			    			                  });
			    			         }
			    			      });
	    					}else{
	    						$.ajax({
			    			         method : 'get',
			    			         url : 'searchResult.do',
			    			         data : {
			    			            "word" : data.json[0].scheduleCategory
			    			         },
			    			         dataType : 'json',
			    			         success : function(r) {
			    			            var d = JSON.parse(r.result);
			    			            $('#search h4').html('#'+data.json[0].scheduleTag);
			    			            $('#search div').each(
			    			                  function(index) {
			    			                     $(this).html(
			    			                           '<h4><a href="'+d.items[index].link+'">' + d.items[index].title + '</a></h4><p>'
			    			                                 + d.items[index].description
			    			                                 + '</p>');
			    			                  });
			    			         }		///success
			    			      });	///ajax
	    					}//else
	    				}////    if data.json!=''
	    			}///success
	    		});//    ajax
	    		
		    	TweenMax.to(this, 0.5, {scale:3});
		    	$(this).css('z-index','100');
		    	$(this).find('hr').css('display','none');
	    	}
	    },function(){
	    	$(this).find('br').remove();
	    	$(this).find('h6').remove();
	    	if($(this).attr('id')!=null){
		    	TweenMax.to(this, 0.5, {scale:1});
		    	$(this).css('z-index','0');
		    	$(this).find('hr').css('display','block');
	    	}
	    });
	    
	    $('input[type=checkbox]').change(function(){
	    	if($(this).attr('id').indexOf('Challenge')!=-1){
	    		if($(this).attr('id').substring(14,15)!="c"){
		    		$.ajax({
			    		url : $(this).attr('id')+'.do',
			    		data : {
			    			"challengeNo" : $(this).attr('id').substring(14),
			    			"challengeContent" : $(this).attr('value')
			    		},
			    		success : function(data){
			    		}
			    	});
	    		}else{
	    			$.ajax({
			    		url : $(this).attr('id')+'.do',
			    		data : {
			    			"challengeNo" : $(this).parent().attr('id'),
			    			"challengeContent" : $(this).attr('value').substring(15)
			    		},
			    		success : function(data){
			    		}
			    	});	
	    		}
	    	}else{
		    	$.ajax({
		    		url : $(this).attr('id')+'.do',
		    		data : {
		    			"scheduleNo" : $(this).attr('id').substring(13)
		    		},
		    		success : function(data){
		    		}
		    	});
	    	}
	    });
	    $('#scheduleSetting').click(function(){
	    	 window.open("","SETTING","width=300,height=300,top="+($(this).position().top)+",left="+$(this).position().left);
	    });
	    
	    var emotion = '${daily.emotion}';
	    $('#emotion_tbl img').each(function(){
	    	if($(this).attr('id')!=emotion)
	    		$(this).addClass('clicked');
	    });
	    
	    $('#paper textarea').focusout(function(){
	    	$.ajax({
	    		url:"updateMemo.do",
	    		data : {
	    			"memo" : $(this).val()
	    		},
	    		success : function(){
	    			alert("success~");
	    		}
	    	});
	    });
   }); //ready

  
</script>

</head>
<body>
   <div id="titleArea"
      style="height: 70px; margin-top: 0px; margin-bottom: 0px;">
      <h1 class="titleRow skew-title">
         <span>M</span><span class="last">Y</span> <span class="alt">P</span><span
            class="alt">L</span><span class="alt">A</span><span class="alt last">N</span><span
            class="alt">N</span><span class="alt">E</span><span class="alt">R</span>
      </h1>
   </div>

   <div id="contents"
      style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 25px; /* background-color: green;  */height: 100%">

      <div>${data}</div>
      <div id="weatherTest">
         <h2 style="margin-left: 10%">weather :</h2>
      </div>

      <!-- START section1 -->
      <div id="section1">
         <div id="weather"></div>
         <div class="calendar" id="calendar"
            style="width: 50%; display: inline-block;">
            <a href="javascript:prev()">이전</a>
            <p id="title_monthdate" style="display: inline-block;"></p>
            <a href="javascript:next()">이후</a>
            <img src="${path}/img/set.png" width="20px;" style="float: right; cursor: pointer; margin-right: 10px; margin-top: 10px;" id="scheduleSetting">
            <div class="calendar__header">
               <div>SUN</div>
               <div>MON</div>
               <div>TUE</div>
               <div>WED</div>
               <div>THU</div>
               <div>FRI</div>
               <div>SAT</div>
            </div>
            <div class="calendar__week"></div>
            <div class="calendar__week"></div>
            <div class="calendar__week"></div>
            <div class="calendar__week"></div>
            <div class="calendar__week"></div>
         </div>
         <div
            style="width: 30%; border: 1px black double; display: inline-block;  margin-left: 100px; margin-top: -40px;"
            id="search">
            <h4>#</h4>
            <div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height: 100px; overflow: hidden;"></div>
            <div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height: 100px; overflow: hidden;"></div>
            <div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height: 100px; overflow: hidden;"></div>
            <div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height: 100px; overflow: hidden;"></div>
            <div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height: 100px; overflow: hidden;"></div>
            <div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height: 100px; overflow: hidden;"></div>
            <div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height: 100px; overflow: hidden;"></div>
         </div>
      </div>
      <!-- END section1 -->

      <hr>
      <!-- START section2 -->
      <div id="section2" style="height: 450px; margin-top: 200px; /* background-color: pink; */">
         <table style="width: 100%; margin: auto">
            <tr>
               <td colspan="2">
                  <h1 id="Date" align="left"
                     style="display: inline; margin-left: 35px; margin-bottom: 5px;"></h1>
               </td>
               <td><img src="${path}/img/weather/rainy.png" width="70px"
                  height="70px" style="float: left">
               <td>
               <td align="right">
                  <table id="emotion_tbl"
                     style="float: right; margin-top: 22px; margin-right: 22px; height: 30px;">
                     <td><img id="happy" src="${path}/img/emotion/happy.png"></td>
                     <td><img id="love" src="${path}/img/emotion/love.png"></td>
                     <td><img id="shocked" src="${path}/img/emotion/shocked.png"></td>
                     <td><img id="shy" src="${path}/img/emotion/shy.png"></td>
                     <td><img id="tired" src="${path}/img/emotion/tired.png"></td>
                     <td><img id="upset" src="${path}/img/emotion/upset.png"></td>
                     <td><img id="verysad" src="${path}/img/emotion/verysad.png"></td>
                  </table>
               </td>
            </tr>
            <tr>
               <td colspan="2"><div
                     style="float: left; width: 100%; padding-left: 4%; padding-right: 2%; height: 400px;">
                     <div id="wrapper">
                        <hr>
                        <h2>
                           Today's Schedule <i class="fa fa-check"></i>
                        </h2>
                        <hr>
                        <c:forEach items="${daily.todaySchedule}" var="item" varStatus="i">
                           <div>
                              <c:if test="${item.check}">
                                 <input type="checkbox" id="checkSchedule${item.scheduleNo}" checked="checked" /> 
                                 <label for="checkSchedule${item.scheduleNo}">
                                    <div>
                                       <i class="fa fa-check"></i>
                                    </div> ${item.scheduleTitle}
                                 </label>
                              </c:if>
                              <c:if test="${!item.check}">
                                    <input type="checkbox" id="checkSchedule${item.scheduleNo}"/> 
                                 <label for="checkSchedule${item.scheduleNo}">
                                    <div>
                                       <i class="fa fa-check"></i>
                                    </div> ${item.scheduleTitle}
                                 </label>
                              </c:if>
                           </div>
                        </c:forEach>
                     </div>
                  </div></td>
               <td colspan="2">
                  <div
                     style="float: left; width: 100%; margin-left: 5%; margin-right: 1%; height: 400px;">
                     <div id="wrapper">
                        <hr>
                        <h2>
                           Your Challenge <i class="fa fa-check"></i>
                        </h2>
                        <hr>
                        <c:forEach items="${daily.todayChallenge}" var="item">
                        	<c:if test="${item.challengeContentSize==0}">
	                        	<div id="${item.challengeNo}">
		                           <input type="checkbox" id="checkChallenge${item.challengeNo}" value="challenge${item.challengeNo}"/> <label
		                              for="checkChallenge${item.challengeNo}">
		                              <div>
		                                 <i class="fa fa-check"></i>
		                              </div> ${item.challengeTitle}
		                           </label>
		                        </div>
	                        </c:if>
	                        <c:if test="${item.challengeContentSize!=0}">
	                        	<c:forEach items="${item.challengeContentList}" var="i">
	                        		<c:if test="${i.check && i.challengeContent!=null}">
	                        			<div id="${item.challengeNo}">
		                           		<input type="checkbox" id="checkChallengec${i.challengeContent}" value="checkChallengec${i.challengeContent}" checked="checked"/> <label
			                              for="checkChallengec${i.challengeContent}">
			                              <div>
			                                 <i class="fa fa-check"></i>
			                              </div> ${item.challengeTitle} : ${i.challengeContent}
			                              </label>
				                        </div>
	                        		</c:if>
	                        		<c:if test="${!i.check && i.challengeContent!=null}">
	                        			<div id="${item.challengeNo}">
		                           		<input type="checkbox" id="checkChallengec${i.challengeContent}" value="checkChallengec${i.challengeContent}"/> <label
			                              for="checkChallengec${i.challengeContent}">
			                              <div>
			                                 <i class="fa fa-check"></i>
			                              </div> ${item.challengeTitle} : ${i.challengeContent}
				                           </label>
				                        </div>
	                        		</c:if>
	                        	</c:forEach>
	                        </c:if>
                        </c:forEach>
                     </div>
                  </div>
               </td>
               <td colspan="2" align="right">
                  <div
                     style="float: right; width: 100%; height: 400px; margin-top: 20px; margin-right: 0;">
                     <div id="wrapper">
                        <form id="paper" method="get" action="" style="margin-right: 2%">
                           <textarea placeholder="Enter something." id="text" name="text"
                              rows="4"
                              style="overflow: hidden; word-wrap: break-word; resize: none; width: 50%; height: 180px;">${daily.memo}</textarea>
                           <br> <input id="button" type="submit" value="Create">

                        </form>
                     </div>
                  </div>
               </td>
         </table>
      </div>
      <!-- END section2 -->

      <div id="section3" style="margin-top: 100px; height: 700px; width: 100%">
         <img src="${path}/img/set.png" width="20px;"
            style="float: right; cursor: pointer;" id="weeklyHabit">
         <div class="row weeklyTrackerDiv" style="border: 1px solid #ECECEC">
            <c:forEach items="${daily.weeklyCheckHabit}" var="item"
               varStatus="h">
               <table
                  style="border: 1px solid white; width: 300px; margin-left: 10px; margin-top: 30px; text-align: center; display: inline-block;">
                  <tr class="weeklyTracker">
                     <td style="width: 50%;" rowspan="2" style="width:50%;">
                        <div style="width: 0;heigth:0;">
                           <img alt="" src="${path}/img/trash.png" style="width: 12px;height: 12px; cursor: pointer;">
                        </div>
                        ${item.habit}
                     </td>
                     <td style="width: 10px;"></td>
                     <td>일</td>
                     <td>월</td>
                     <td>화</td>
                     <td>수</td>
                     <td>목</td>
                     <td>금</td>
                     <td>토</td>
                  </tr>
                  <tr id="${item.habit}" height="25">
                     <td></td>
                     <c:forEach items="${item.habitCheck}" var="i" varStatus="d">
                        <c:choose>
                           <c:when test="${fn:contains(i, '0')}">
                              <td id="${h.index}${d.index}" class="tracker"
                                 style="background: white; cursor: pointer; width: 20px;">
                           </c:when>
                           <c:otherwise>
                              <td id="${h.index}${d.index}" class="tracker"
                                 style="cursor: pointer; background-color: red; width: 20px;">
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
                  </tr>
               </table>
            </c:forEach>
         </div>
         <div class="row"
            style=" height: 300px; margin-top: 100px">
            <h1 id="sec3month" align="center"
               style="margin-top: 20px; height: 50px;"></h1>
            <table
               style="border: 1px solid white; width: 100%;height : 200px; text-align: center; margin-top: 0;" id="monthlyTrackerTable">
               <thead>
                  <tr>
                     <td></td>
                     <c:forEach begin="1" end="${daily.lastDate}" varStatus="s">
                        <td style="width: 2.5%"><h6>${s.count}</h6></td>
                     </c:forEach>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach items="${daily.monthlyCheckHabit}" var="item"
                     varStatus="h">
                     <tr id="${item.habit}">
                        <td>${item.habit}</td>
                        <c:forEach items="${item.checkHabit}" var="i" varStatus="d">
                           <c:choose>
                              <c:when test="${fn:contains(i, '0')}">
                                 <td id="m${h.index}${d.index}" style="background: white;">
                              </c:when>
                              <c:otherwise>
                                 <td id="m${h.index}${d.index}" style="background-color:red">
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>


      <div id="section4"
         style="height: 450px; /* background-color: blue; */ margin-top: 20px;">

         <div class="demo">
            <div data-name="Add/Remove Items" class="glider-contain multiple">
               <div class="gradient-border-bottom">
                  <div class="gradient-border">
                     <div class="glider" id="glider-add"
                        style="width: 1160px; height: auto;">
                        <c:forEach var="challengeList" items="${daily.challengeList}">
                           <div class="challengeSection">
                              <div class="card">
                                 <!-- Face 1 -->
                                 <div class="card-face face-1">
                                    <!-- Avatar -->
                                    <div class="card-face__avatar">
                                       <!-- User avatar -->
                                       <img
                                          src="https://image.flaticon.com/icons/svg/188/188241.svg"
                                          width="110" height="110" draggable="false" />
                                    </div>
                                    <!-- Name -->
                                    <h2 id="challengeTitle" class="card-face__name">
                                       <a
                                          href="detailChallenge.do?challengeNo=${challengeList.challengeNo}"><b>${challengeList.challengeTitle}</b></a>
                                    </h2>
                                    <!-- Title -->
                                    <span class="card-face__title"><b>${challengeList.memberNo}</b></span>
                                    <div class="challenge-content" style="font-size: 20px;">
                                       <h4>
                                          <b> STARTDATE : </b> <span id="startDate">${challengeList.challengeStartDate}</span>
                                          <br> <b> ENDDATE : </b> <span id="endDate">${challengeList.challengeEndDate}</span>
                                       </h4>
                                       <b>Category : </b><label id="challengeCategory">
                                          ${challengeList.challengeCategory}</label><br> <b>Sharing
                                          : </b><label id="challengeSharing">
                                          ${challengeList.challengeSharing}</label>
                                       <hr>
                                       <ul style="text-align: left">
                                          <c:forEach var="challengeLogList"
                                             items="${challengeList.challengeLogList}">
                                             <li><b>Day ${challengeLogList.dayCount}</b>
                                                ${challengeLogList.challengeLogContent}
                                          </c:forEach>
                                       </ul>
                                       <hr>
                                       <em>${challengeList.challengeLikes}명</em>이 응원합니당.
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </c:forEach>
                        <div id="newchallengeDiv" class="newchallengeDiv"
                           style="width: 290px; height: 500px">
                           <div class="card">
                              <img src="${path}/img/writeChallenge.png"
                                 style="display: block; margin: auto; width: 50%; margin-top: 38%">
                              <br> <br>
                              <h3 align="center">새로운 도전을 해보세요!</h3>
                              <br>
                              <button id="newChallengeBtn">GO</button>
                           </div>
                        </div>



                     </div>



                  </div>
                  <button role="button" aria-label="Previous" class="glider-prev"
                     id="glider-prev-add">
                     <i class="fa fa-chevron-left"></i>
                  </button>
                  <button role="button" aria-label="Next" class="glider-next"
                     id="glider-next-add">
                     <i class="fa fa-chevron-right"></i>
                  </button>
                  <div id="add-dots"></div>
               </div>

               <script>
                  window
                        .addEventListener(
                              'load',
                              function() {
                                 var glider = new Glider(
                                       document
                                             .getElementById('glider-add'),
                                       {
                                          slidesToShow : 4,
                                          duration : .6,
                                          dots : '#add-dots',
                                          arrows : {
                                             prev : '#glider-prev-add',
                                             next : '#glider-next-add'
                                          }
                                       });
                                 document
                                       .getElementById('addSlide')
                                       .addEventListener(
                                             'click',
                                             function() {
                                                var ele = document
                                                      .getElementById(
                                                            'challengeSection')
                                                      .cloneNode(
                                                            true);
                                                ele.id = '';
                                                ele
                                                      .querySelector('h1').textContent = glider.slides.length + 1;
                                                glider
                                                      .addItem(ele);
                                                try {
                                                   ga(
                                                         'send',
                                                         'event',
                                                         'Add/Remove Item',
                                                         'Add')
                                                } catch (ex) {
                                                }
                                             });
                                 document
                                       .getElementById(
                                             'removeSlide')
                                       .addEventListener(
                                             'click',
                                             function() {
                                                glider
                                                      .removeItem(glider.slides.length - 1);
                                                try {
                                                   ga(
                                                         'send',
                                                         'event',
                                                         'Add/Remove Item',
                                                         'Remove')
                                                } catch (ex) {
                                                }
                                             });
                              });
               </script>


            </div>
         </div>
         <!-- section4 -->
      </div>
      <!-- contents -->

   </div>
   <%@include file="nav.jsp"%>
</body>
<script type="text/javascript">
   
</script>
</html>