package com.spring.client.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

    private BoardService boardService;

    /**************************************************
     * 글목록 구현하기 (페이징 처리 목록 조회)
     *************************************************/
    @RequestMapping(value="/boardList", method = RequestMethod.GET)
    //@GetMapping("/boardList")
    public String boardList(@ModelAttribute("data") BoardVO bvo, Model model) {
        log.info("boardList 호출 성공");
        //전체 레코드 조회
        List<BoardVO> boardList = boardService.boardList(bvo);
        model.addAttribute("boardList", boardList);

        return "board/boardList";
    }

    /****************************************************
     * 글쓰기 폼 출력하기
     ***************************************************/
    @RequestMapping(value="/writeForm")
    public String writeForm(@ModelAttribute("data") BoardVO bvo) {
        log.info("writeForm 호출 성공");

        return "board/writeForm";
    }

    /*****************************************************
     * 글쓰기 구현하기
     ****************************************************/
    @RequestMapping(value="/boardInsert", method=RequestMethod.POST)
    //@PostMapping("/boardInsert")
    public String boardInsert(BoardVO bvo, Model model) {
        log.info("boardInsert 호출 성공");

        int result = 0;
        String url = "";

        result = boardService.boardInsert(bvo);
        if(result == 1) {
            url = "/board/boardList";
        }else {
            url = "/board/writeForm";
        }
        return "redirect:"+url;
    }

    @RequestMapping(value="/boardDetail", method=RequestMethod.GET)
    public String boardDetail(@ModelAttribute("data") BoardVO bvo, Model model){
        log.info("boardDetail 호출 성공");

        BoardVO detail = boardService.boardDetail(bvo);
        model.addAttribute("detail", detail);

        return "board/boardDetail";
    }

    @ResponseBody
    @RequestMapping(value="/pwdConfirm", method=RequestMethod.POST,
    produces = "text/plain; charset=UTF-8")
    public String pwdConfirm(BoardVO bvo){
        log.info("pwdConfirm 호출 성공");
        String value = "";

        int result = boardService.pwdConfirm(bvo);
        if(result == 1){
            value="성공";
        }
        else{
            value="실패";
        }

        log.info("result = " + result);

        return value;
    }

    @RequestMapping(value="/updateForm", method=RequestMethod.GET)
    public String updateForm(@ModelAttribute("data") BoardVO bvo, Model model){
        log.info("updateForm 호출 성공");

        BoardVO update = boardService.updateForm(bvo);
        model.addAttribute("update", update);

        return "board/updateForm";
    }

    @RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
    public String boardUpdate(BoardVO bvo){
        log.info("boardUpdate 호출 성공");

        int result = 0;
        String url = "";

        result = boardService.boardUpdate(bvo);

        if(result == 1){
            url = "/board/boardList";
        }
        else{
            url = "/board/updateForm";
        }

        log.info("result = " + result);

        return "redirect:" + url;
    }
}

