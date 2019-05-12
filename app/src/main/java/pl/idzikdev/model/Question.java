package pl.idzikdev.model;




public class Question {
    private int id;
    private String category;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String valid;

    public Question(int id, String category, String question, String answerA, String answerB, String answerC, String answerD, String valid) {
        this.id = id;
        this.category = category;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", category=" + category +
                ", question='" + question + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", valid='" + valid + '\'' +
                '}';
    }
}