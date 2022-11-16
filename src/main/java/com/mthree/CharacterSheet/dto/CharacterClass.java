/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.CharacterSheet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Josef
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterClass {
    private String type, index, name;
    private int id, count;
    private APIReference results[] = new APIReference[12];

    public APIReference[] getResults() {
        return results;
    }

    public void setResults(APIReference[] results) {
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DndClass{" + "type=" + type + ", index=" + index + '}';
    }

  
    
}
