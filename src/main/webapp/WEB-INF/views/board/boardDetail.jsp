<%--
  Created by IntelliJ IDEA.
  User: khotaehyeong
  Date: 20. 10. 30.
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/resources/include/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var butChk = 0; //수정버튼과 삭제버튼을 구별하기 위한 변수
        $(function() {
            $("#pwdChk").css("visibility","hidden");

            //수정 버튼 클릭시 처리 이벤트
            $("#updateFormBtn").click(function() {
                $("#pwdChk").css("visibility", "visible");
                $("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color","#000099");
                butChk = 1;

                $("#pwdBtn").click(function(){
                    if(butChk == 1){
                        $.ajax({
                            url : "/board/pwdConfirm",
                            type : "post",
                            data : $("#f_pwd").serialize(),
                            dataType : "text",
                            error : function(){
                                alert("에러가 발생하였습니다.");
                                history.back();
                            },
                            success : function(data){
                                if(data == "성공"){
                                    $("#f_data").attr({
                                        "method" : "get",
                                        "action" : "/board/updateForm"
                                    });
                                    $("#f_data").submit();
                                }
                                else if(data == "실패"){
                                    $("#msg").text("비밀번호가 틀렸습니다. 다시 입력해 주세요").css("color","red");
                                }
                            }
                        });
                    }
                });
            });

            //삭제 버튼 클릭시 처리이벤트
            $("#boardDeleteBtn").click(function(){
                $("#pwdChk").css("visibility", "visible");
                $("#msg").text("작성시 입력한 비밀번호를 입력해 주세요.").css("color","#000099");
                butChk = 2;

                $("#pwdBtn").click(function(){
                    if(butChk == 2){
                        $.ajax({
                            url : "/board/pwdConfirm",
                            type : "post",
                            data : $("#f_pwd").serialize(),
                            dataType : "text",
                            error : function(){
                                alert("에러가 발생하였습니다.");
                                history.back();
                            },
                            success : function(data){
                                if(data == "성공"){
                                    $("#f_data").attr({
                                        "method" : "get",
                                        "action" : "/board/boardDelete"
                                    });
                                    $("#f_data").submit();
                                }
                                else if(data == "실패"){
                                    $("#msg").text("비밀번호가 틀렸습니다. 다시 입력해 주세요").css("color","red");
                                }
                            }
                        });
                    }
                });
            });

            //글쓰기 버튼 클릭시 처리이벤트
            $("#insertFormBtn").click(function() {
                location.href = "/board/writeForm";
            });

            //목록 버튼 클릭시 처리이벤트
            $("#boardListBtn").click(function() {
                location.href = "/board/boardList";
            });
        });
    </script>
</head>
<body>
<div class="container">

    <form name="f_data" id="f_data" method="post">
        <input type="hidden" name="b_num" value="${detail.b_num}" />
    </form>
    <%-- ====================비밀번호 확인 버튼 및 버튼 추가 시작====================== --%>
    <div id="boardpwdBut" class="row text-center">
        <div id="pwdChk" class="authArea col-md-8 text-left">
            <form name="f_pwd" id="f_pwd" class="form-inline">
                <input type="hidden" name="b_num" id="b_num" value="${detail.b_num}" />
                <label for="b_pwd" id="l_pwd">비밀번호: </label>
                <input type="password" name="b_pwd" id="b_pwd" class="form-control" />

                <button type="button" id="pwdBtn" class="btn btn-default">확인</button>
                <span id="msg"></span>
            </form>
        </div>
        <div class="btnArea col-md text-right">
            <input type="button" value="글수정" id="updateFormBtn" class="btn btn-success"/>
            <input type="button" value="글삭제" id="boardDeleteBtn" class="btn btn-success"/>
            <input type="button" value="글쓰기" id="insertFormBtn" class="btn btn-success"/>
            <input type="button" value="목록" id="boardListBtn" class="btn btn-success"/>
        </div>
    </div>

    <!-- =====================상세 정보 보여주기 시작 ======================== -->
    <!-- <div class="contentTit page-geader"><h3> class="text-center">게시판 상세보기</h3> -->
    <div class="contentTB text-center">
        <table class="table table-bordered">
            <colgroup>
                <col width="17%">
                <col width="33%">
                <col width="17%">
                <col width="33%">
            </colgroup>
            <tbody>
            <tr>
                <td>작성자</td>
                <td class="text-left">${detail.b_name}</td>
                <td>작성일</td>
                <td class="text-left">${detail.b_date}</td>
            </tr>
            <tr>
                <td>제목</td>
                <td colspan="3" class="text-left">${detail.b_title}</td>
            </tr>
            <tr class="table-height">
                <td>내용</td>
                <td colspan="3" class="text-left">${detail.b_content}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
