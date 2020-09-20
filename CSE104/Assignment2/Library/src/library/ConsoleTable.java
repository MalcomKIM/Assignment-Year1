/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Minhao.Jin17
 */
public class ConsoleTable {

    private List<List> rows = new ArrayList<List>();
    private int colum;
    private int[] columLen;
    private static int margin = 2;
    private boolean printHeader = false;

    public ConsoleTable(int colum, boolean printHeader) {
        this.printHeader = printHeader;
        this.colum = colum;
        this.columLen = new int[colum];
    }

    public void appendRow() {
        List row = new ArrayList(colum);
        rows.add(row);
    }

    public ConsoleTable appendColum(Object value) {
        if (value == null) {
            value = "NULL";
        }
        List row = rows.get(rows.size() - 1);
        row.add(value);
        int len = value.toString().getBytes().length;
        if (columLen[row.size() - 1] < len) {
            columLen[row.size() - 1] = len;
        }
        return this;
    }

    private String printLine(char c, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(c);
        }
        return sb.toString();
    }


    public String createTable() {
        StringBuilder sb = new StringBuilder();

        int sumlen = 0;
        for (int len : columLen) {
            sumlen += len;
        }
        if (printHeader) {
            sb.append("|").append(printLine('=', sumlen + margin * 2 * colum + (colum - 1))).append("|\n");
        } else {
            sb.append("|").append(printLine('-', sumlen + margin * 2 * colum + (colum - 1))).append("|\n");
        }
        for (int j = 0; j < rows.size(); j++) {
            List row = rows.get(j);
            for (int i = 0; i < colum; i++) {
                String s = "";
                if (i < row.size()) {
                    s = row.get(i).toString();
                }
                sb.append('|').append(printLine(' ', margin)).append(s);
                sb.append(printLine(' ', columLen[i] - s.getBytes().length + margin));
            }
            sb.append("|\n");
            if (printHeader && j == 0) {
                sb.append("|").append(printLine('=', sumlen + margin * 2 * colum + (colum - 1))).append("|\n");
            } else {
                sb.append("|").append(printLine('-', sumlen + margin * 2 * colum + (colum - 1))).append("|\n");
            }
        }
        return sb.toString();
    }

}
