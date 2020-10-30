package com.spring.client.board.dao;


import com.spring.client.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
    @Setter(onMethod_=@Autowired)
    private BoardDao boardDao;

    @Test
    public void testBoardList() {
        BoardVO bvo = new BoardVO();
        List<BoardVO> list = boardDao.boardList(bvo);

        for(BoardVO vo : list){
            log.info(vo);
        }
    }

    @Test
    public void testBoardInsert() {
        BoardVO board = new BoardVO();
        board.setB_name("홍길동");
        board.setB_title("입력확인");
        board.setB_content("오늘도 힘내서 열심히 해 봅시다.");
        board.setB_pwd("1234");

        boardDao.boardInsert(board);
        log.info(board);
    }
}
