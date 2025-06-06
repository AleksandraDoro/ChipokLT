package org.example.utils;


import lombok.Getter;

@Getter
public enum QueryTypes {

    SELECT("SELECT * from items_table"),
    SELECTID("SELECT name from items_table where id = ?"),
    SELECTNAME("SELECT id from items_table where name = ?"),
    SELECTPRICE("SELECT price FROM items_table WHERE name = ?");


    private final String query;

    QueryTypes(String query) {
        this.query = query;
    }

}
