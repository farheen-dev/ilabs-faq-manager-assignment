package com.farheen.ilabsfaqmanagerbackend.dto;

public class FaqDTO {

    private int id;
    private String questionTitle;
    private String category;

    public FaqDTO(int id, String questionTitle, String category) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.category = category;
    }

    public FaqDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
