package com.example.artificialincompetence.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.artificialincompetence.domains.Adjective;
import com.example.artificialincompetence.domains.Noun;
import com.example.artificialincompetence.domains.Reply;

@Mapper
public interface AiMapper {
    List<Adjective> allAdj();
    List<Noun> allNoun();
    Reply getRes(@Param("adjective") int adjective,
                 @Param("noun") int noun);
    void addRes(@Param("adjective") int adjective,
                @Param("noun") int noun,
                @Param("restext") String restext);
    void addAdjectiveWord(String wordtext);
    void addNounWord(String wordtext);
}
