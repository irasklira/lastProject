package com.spring.client.board.service;

import com.spring.client.board.dao.BoardDao;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl {
    @Setter(onMethod_=@Autowired)
    private BoardDao boardDao;
}
