/**
 * 
 */
/**
 * @author owner
 *
 */
package com.pocv01.model;

public class Greeting {
    private long id;
    private String content;

    // Constructor
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}