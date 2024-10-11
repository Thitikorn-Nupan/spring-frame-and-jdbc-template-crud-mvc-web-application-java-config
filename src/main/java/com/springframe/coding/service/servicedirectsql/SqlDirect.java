package com.springframe.coding.service.servicedirectsql;

public class SqlDirect {
    private final String CREATE = "insert into users(`fullname`,`email`,`age`,`weight` , `height`)" +
            " values(?,?,?,?,?) ;";
    private final String READS = "select * from users ;";
    private final String READ = "select * from users where id = ?;";
    private final String UPDATE  = "UPDATE users SET fullname =? , email = ? , age = ? , weight = ? , height = ? WHERE id = ? ;";
    private final String DELETE  = "DELETE FROM users WHERE id = ? ;";
   // private final String SORT  = "UPDATE users SET id = id-1 WHERE id > ? ;";
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
