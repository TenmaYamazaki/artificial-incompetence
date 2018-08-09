package com.example.artificialincompetence.controllers;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.artificialincompetence.domains.Reply;
import com.example.artificialincompetence.mappers.AiMapper;

public class AiControllerTest {
    AiMapper aiMapper;
    @Autowired
    public AiControllerTest(AiMapper aiMapper) {
        this.aiMapper = aiMapper;
    }
    AiController ac = new AiController(aiMapper);
    @Test
    public void test() {
        assertEquals(new Reply( "<p>なにが知りたいんだい？<p><br>" +
                    "<form id=\"addres\" action=\"/add/word\" method=\"POST\">\r\n" + 
                        "<input type=\"hidden\" value=\"" + 0 + "\" id=\"adjective\" name=\"adjective\">" +
                        "<input type=\"hidden\" value=\"" + 1 + "\" id=\"noun\" name=\"noun\">" +
                        "<input id=\"addwordtext\" name=\"addwordtext\" type=\"text\" id=\"reply\" name=\"reply\" placeholder=\"質問の答えを入力してね\" />\r\n" + 
                        "<input id=\"addwordsubmit\" type=\"submit\" value=\"決定\" />\r\n" + 
                    "</form>"), ac.question(0, 1));
    }

}
