package com.spring.client.board.service;

import com.spring.client.board.dao.BoardDao;
import com.spring.client.board.vo.BoardVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Setter(onMethod_=@Autowired)
    private BoardDao boardDao;

    public List<BoardVO> boardList(BoardVO bvo){
        List<BoardVO> list = null;
        list = boardDao.boardList(bvo);

        return list;
    }
}
