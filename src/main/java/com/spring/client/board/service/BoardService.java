package com.spring.client.board.service;

import com.spring.client.board.vo.BoardVO;

import java.util.List;

public interface BoardService {
    public List<BoardVO> boardList(BoardVO bvo);
    public int boardInsert(BoardVO bvo);
}