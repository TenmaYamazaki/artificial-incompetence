package com.example.artificialincompetence.domains;

public class Reply {

    private int id;
    private int adjectiveId;
    private int nounId;
    private String word;
    private Adjective adjective;
    private Noun noun;
    
    public Reply(String word) {
        this.word = word;
    }
    public Reply(int i, int j, String k, int l, String n, int m, String o) {
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAdjectiveId() {
        return adjectiveId;
    }
    public void setAdjectiveId(int adjectiveId) {
        this.adjectiveId = adjectiveId;
    }
    public int getNounId() {
        return nounId;
    }
    public void setNounId(int nounId) {
        this.nounId = nounId;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public Adjective getAdjective() {
        return adjective;
    }
    public void setAdjective(Adjective adjective) {
        this.adjective = adjective;
    }
    public Noun getNoun() {
        return noun;
    }
    public void setNoun(Noun noun) {
        this.noun = noun;
    }
    
}
