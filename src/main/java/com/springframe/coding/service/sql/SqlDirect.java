package com.springframe.coding.service.sql;

public class SqlDirect {
    private final String CREATE = "insert into users_2(`fullname`,`email`,`age`,`weight` , `height`)  values(?,?,?,?,?) ;";
    private final String READS = "select * from users_2 ;";
    private final String READ = "select * from users_2 where id = ?;";
    private final String UPDATE  = "UPDATE users_2 SET fullname =? , email = ? , age = ? , weight = ? , height = ? WHERE id = ? ;";
    private final String DELETE  = "DELETE FROM users_2 WHERE id = ? ;";
   // private final String SORT  = "UPDATE users_2 SET id = id-1 WHERE id > ? ;";
    public String getCREATE() {
        return CREATE;
    }
    public String getREADS() {
        return READS;
    }
    public String getREAD() {
        return READ;
    }
    public String getUPDATE() {
        return UPDATE;
    }
    public String getDELETE() {
        return DELETE;
    }
}
