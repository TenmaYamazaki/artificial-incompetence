package com.example.artificialincompetence.domains;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReplyTest {
    
    @Test
    public void test() {
        Reply reply = new Reply(1, 2, 3, "ドラえもん");
        assertEquals("ドラえもん", reply.getWord());
        assertEquals(1, reply.getId());
        assertEquals(2, reply.getAdjectiveId());
        assertEquals(3, reply.getNounId());
        
        int sum = 500 + 600;
        String s = "not null";
        assertEquals(1100, sum);
        assertTrue(sum > 1000);
        assertThat(sum, is(1100));
        assertThat(sum, not(1000));
        assertThat(s, not(nullValue()));
        
    }
    
    @Test
    public void test2() {
        Reply reply = new Reply(1, 2, 3, "ドラえもん");
        int sum = 500 + 600;
        String s = "Not null";
        
        
        assertThat(s, notNullValue());
    }

}
