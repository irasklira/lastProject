package com.spring.client.board.controller;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @RequestMapping(value="/boardList", method = RequestMethod.GET)
    public String boardList(@ModelAttribute("data") BoardVO bvo, Model model){
        log.info("boardList 호출 성공");

        List<BoardVO> boardList = boardService.boardList(bvo);
        model.addAttribute("boardList", boardList);

        return "board/boardList";
    }
}
