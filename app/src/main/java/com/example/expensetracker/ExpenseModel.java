package com.example.expensetracker;

import java.io.Serializable;

public class ExpenseModel implements Serializable {
    private String expenseId;
    private String note;
    private String category;
    private String type;
    private Long amount;
    private Long time;
    private String uid;

    public ExpenseModel() {

    }

    public ExpenseModel(String expenseId, String note, String category, String type, Long amount, Long time, String uid) {
        this.expenseId = expenseId;
        this.note = note;
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.time = time;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
