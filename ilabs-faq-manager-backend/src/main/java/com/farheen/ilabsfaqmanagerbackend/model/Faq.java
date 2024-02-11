package com.farheen.ilabsfaqmanagerbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faq")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="question_title", length = 255)
    private String questionTitle;

    @Column(name="category", length = 255)
    private String category;

    public Faq(int id, String questionTitle, String category) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.category = category;
    }

    public Faq() {
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


