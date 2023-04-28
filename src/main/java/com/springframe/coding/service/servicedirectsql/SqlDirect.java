package com.springframe.coding.service.servicedirectsql;

public class SqlDirect {
    private final String CREATE = "insert into contact(`fullname`,`email`,`age`,`weight` , `height`)" +
            " values(?,?,?,?,?) ;";
    private final String READS = "select * from contact ;";
    private final String READ = "select * from contact where id = ?;";
    private final String UPDATE  = "UPDATE contact SET fullname =? , email = ? , age = ? , weight = ? , height = ? WHERE id = ? ;";
    private final String DELETE  = "DELETE FROM contact WHERE id = ? ;";
    private final String SORT  = "UPDATE contact SET id = id-1 WHERE id > ? ;";
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
