package com.example.testnet;

public class Question {
    private String question;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private String fourthOption;

    public Question() {}

    public Question(String question, String firstOption, String secondOption, String thirdOption, String fourthOption) {
        this.question = question;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.thirdOption = thirdOption;
        this.fourthOption = fourthOption;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public void setFirstOption(String firstOption) {
        this.firstOption = firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public void setSecondOption(String secondOption) {
        this.secondOption = secondOption;
    }

    public String getThirdOption() {
        return thirdOption;
    }

    public void setThirdOption(String thirdOption) {
        this.thirdOption = thirdOption;
    }

    public String getFourthOption() {
        return fourthOption;
    }

    public void setFourthOption(String fourthOption) {
        this.fourthOption = fourthOption;
    }

    /**
     * The method will determine whether a given answer is correct (assuming that the first option is correct)
     * @param answer is the given answer to check
     * @return true or false if the answer is correct or incorrect
     */
    public boolean isAnswerCorrect(String answer){
        return answer.equals(this.firstOption);
    }
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", firstOption='" + firstOption + '\'' +
                ", secondOption='" + secondOption + '\'' +
                ", thirdOption='" + thirdOption + '\'' +
                ", fourthOption='" + fourthOption + '\'' +
                '}';
    }
}
