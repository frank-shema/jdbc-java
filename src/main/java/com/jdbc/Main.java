package com.jdbc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
         db.insert(new Student("Shema", 17, "G.SMUKAMIRA"));
         db.insert(new Student("prince", 23, "abcd"));
//         db.insert(new Student("prince", 111, "LNDC" ));
//         db.update(new Student("frank", 16, "ESM"), 2);
//        db.delete(7);
        List<Student> res = db.read();
        // Student res_one = db.readOne(1);
        // System.out.println(res_one);
        System.out.println(res);
    }
}

