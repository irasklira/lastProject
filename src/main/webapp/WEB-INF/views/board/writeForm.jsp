<%--
  Created by IntelliJ IDEA.
  User: khotaehyeong
  Date: 20. 10. 29.
  Time: 오후 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Insert title here</title>

    <link rel="shortcut icon" href="/resources/image/icon.png" />
    <link rel="apple-touch-icon" href="/resources/image/icon.png" />

    <!--[if lt IE 9]>
    <script src="/resources/include/js/html5shiv.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css" href="/resources/include/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/csS" href="/resources/include/dist/css/bootstrap-theme.css" />

    <script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="/resources/include/js/common.js"></script>
    <script type="text/javascript" src="/resources/include/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#boardInsertBtn").click(function(){
                if(!chkData("#b_name","이름을")) return;
                else if(!chkData("#b_title","제목을")) return;
                else if(!chkData("#b_content","작성할 내용을")) return;
                else if(!chkData("#b_pwd","비밀번호를")) return;
                else{
                    $("#f_writeForm").attr({
                        "method" : "post",
                        "action" : "/board/boardInsert"
                    });
                    $("#f_writeForm").submit();
                }
            });

            //취소 버튼 클릭 시 처리 이벤트
            $("#boardCancelBtn").click(function(){
                $("#f_writeForm").each(function(){
                    this.reset();
                });
            });

            //목록 버튼 클릭 시 처리 이벤트
            $("#boardListBtn").click(function(){
               location.href = "/board/boardList";
            });
        })
    </script>
</head>
<body>
    <div class="container">
        <div class="text-center">
            <form id="f_writeForm" name="f_writeForm" class="form-horizontal">
                <table class="table table-bordered">
                    <colgroup>
                        <col width="20%" />
                        <col width="80%" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <td>작성자</td>
                            <td class="text-left">
                                <input type="text" name="b_name" id="b_name" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>글제목</td>
                            <td class="text-left">
                                <input type="text" name="b_title" id="b_title" class="form-control" />
                            </td>
                        </tr>
                        <tr>
                            <td>글내용</td>
                            <td class="text-left">
                                <textarea name="b_content" id="b_content" class="form-control" rows="8"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td class="text-left">
                                <input type="password" name="b_pwd" id="b_pwd" maxlength="16"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="text-right">
                    <input type="button" value="저장" id="boardInsertBtn" class="btn btn-success" />
                    <input type="button" value="취소" id="boardCancelBtn" class="btn btn-success" />
                    <input type="button" value="목록" id="boardListBtn" class="btn btn-success" />
                </div>
            </form>
        </div>
    </div>
</body>
</html>