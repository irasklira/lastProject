package com.spring.client.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    private int b_num = 0; //글번호
    private String b_name = ""; //작성자
    private String b_title = ""; //제목
    private String b_content = ""; //내용
    private String b_pwd = ""; //비밀번호
    private String b_date; //작성일
}
