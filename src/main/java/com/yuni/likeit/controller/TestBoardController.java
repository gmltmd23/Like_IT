package com.yuni.likeit.controller;

import com.yuni.likeit.entities.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TestBoardController {
    @GetMapping("/testBoardList")
    public String testBoardList(Model model) {
        String[] contentList = {
                "첫번째 게시글이다 라라라라라라라",
                "두번째네> 헗왜ㅑ옿래ㅑ",
                "세번째란다 랴러내ㅗㅈ!!!",
                "네번째 카페 여기 좋다",
                "마지막 다섯번째 게시글"
        };

        ArrayList<Board> boardList = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            Board board = Board.builder()
                    .id(i + 1)
                    .title((i + 1) + "번째 게시글 제목")
                    .writer((i + 1) + "맨")
                    .content(contentList[i])
                    .createDate(new Date())
                    .watchCount(0)
                    .build();
            boardList.add(board);
        }
        model.addAttribute("boardBoard", boardList);

        return "testBoardListYeah";
    }
}
