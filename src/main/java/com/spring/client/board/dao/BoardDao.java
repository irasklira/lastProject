package com.spring.client.board.dao;

import com.spring.client.board.vo.BoardVO;

import java.util.List;

public interface BoardDao {
    public List<BoardVO> boardList(BoardVO bvo);
    public int boardInsert(BoardVO bvo);
    public BoardVO boardDetail(BoardVO bvo);
    public int pwdConfirm(BoardVO bvo);
    public BoardVO updateForm(BoardVO bvo);
    public int boardUpdate(BoardVO bvo);
    public int boardDelete(BoardVO bvo);
}
