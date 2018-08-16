package com.example.artificialincompetence.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.artificialincompetence.domains.Adjective;
import com.example.artificialincompetence.domains.Noun;
import com.example.artificialincompetence.domains.Reply;
import com.example.artificialincompetence.mappers.AiMapper;

@Controller
public class AiController {

    private final AiMapper aiMapper;
    
    @Autowired
    public AiController(AiMapper aiMapper) {
        this.aiMapper = aiMapper;
    }
    
    @GetMapping("/")
    public String index(Model model) {
        List<Adjective> adjectives = aiMapper.allAdj();
        List<Noun> nouns = aiMapper.allNoun();
        model.addAttribute("adjectives", adjectives);
        model.addAttribute("nouns", nouns);
        return "index";
    }
    
    @GetMapping("/question/{adjective}/{noun}")
    @ResponseBody
    public Reply question(@PathVariable int adjective,
                          @PathVariable int noun) {
        if(adjective == 0 || noun == 0) {
            Reply reply = new Reply( "<p>なにが知りたいんだい？<p><br>" +
                    "<form id=\"addres\" action=\"/add/word\" method=\"POST\">\r\n" + 
                        "<input type=\"hidden\" value=\"" + adjective + "name=\"adjective\">" +
                        "<input type=\"hidden\" value=\"" + noun + "name=\"noun\">" +
                        "<input id=\"addwordtext\" name=\"addwordtext\" type=\"text\" id=\"reply\" name=\"reply\" placeholder=\"質問の答えを入力してね\" />\r\n" + 
                        "<input id=\"addwordsubmit\" type=\"submit\" value=\"決定\" />\r\n" + 
                    "</form>");
            return reply;
        } else {
            try {
               System.out.println("adjective = " + adjective + "  noun = " + noun);
               Reply reply = aiMapper.getRes(adjective, noun);
               System.out.println("aaa: " + reply.getWord());
               return reply;
            } catch (NullPointerException e) {
               Reply reply = new Reply( "<p>ぼくにはわからないからおしえて!<p><br>" +
                                        "<form id=\"addres\" action=\"/add/res\" method=\"POST\">\r\n" + 
                                            "<input type=\"hidden\" value=\"" + adjective + "name=\"adjective\">" +
                                            "<input type=\"hidden\" value=\"" + noun + "name=\"noun\">" +
                                            "<input id=\"addrestext\" name=\"addrestext\" type=\"text\" id=\"reply\" name=\"reply\" placeholder=\"質問の答えを入力してね\" />\r\n" + 
                                            "<input id=\"addressubmit\" type=\"submit\" value=\"決定\" />\r\n" + 
                                        "</form>");
               return reply;
            }
        }
    }
    @PostMapping("/add/res")
    public String create(@RequestParam("adjective") int adjective,
                         @RequestParam("noun") int noun,
                         @RequestParam("addrestext") String restext) {
        aiMapper.addRes(adjective, noun, restext);
        return "redirect:/";
    }
    @PostMapping("/add/word")
    public String addword(@RequestParam("adjective") int adjective,
                          @RequestParam("noun") int noun,
                          @RequestParam("addwordtext") String wordtext) {
        if(adjective == 0) {
            aiMapper.addAdjectiveWord(wordtext);
        } else if(noun == 0) {
            aiMapper.addNounWord(wordtext);
        }
        return "redirect:/";
    }
    
}
