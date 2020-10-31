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

    //글입력 구현
    @Override
    public int boardInsert(BoardVO bvo) {
        int result = 0;
        result = boardDao.boardInsert(bvo);
        return result;
    }

    @Override
    public BoardVO boardDetail(BoardVO bvo) {
        BoardVO detail = null;
        detail = boardDao.boardDetail(bvo);
        if(detail != null){
            detail.setB_content(detail.getB_content().toString().replaceAll("\n","<br>"));
        }
        return detail;
    }

    @Override
    public int pwdConfirm(BoardVO bvo) {
        int result = 0;
        result = boardDao.pwdConfirm(bvo);

        return result;
    }

    @Override
    public BoardVO updateForm(BoardVO bvo) {
        BoardVO result = null;
        result = boardDao.updateForm(bvo);

        return result;
    }

    @Override
    public int boardUpdate(BoardVO bvo) {
        int result = 0;
        result = boardDao.boardUpdate(bvo);

        return result;
    }

}