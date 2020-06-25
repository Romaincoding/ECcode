package com.codflix.backend.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateformat {
    public static void main(String[] args) {
        SimpleDateFormat formater = null;

        Date aujourdhui = new Date();

        formater = new SimpleDateFormat("dd-MM-yy");
        System.out.println(formater.format(aujourdhui));

    }

}

