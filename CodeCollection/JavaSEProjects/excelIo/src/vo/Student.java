package vo;

public class Student {
    private String id;
    private String name;
    private String gender;
    private float java;
    private float english;
    private float math;
    private float totalScore;
    private float average;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getJava() {
        return java;
    }

    public void setJava(float java) {
        this.java = java;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore() {
        this.totalScore = this.java + this.english + this.math;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage() {
        this.average = this.totalScore / 3;
    }

    @Override
    public String toString() {
        return "Student [id=" + id
                + ", name=" + name
                + ", gender=" + gender
                + ", java=" + java
                + ", english=" + english
                + ", math=" + math
                + ", totalScore=" + totalScore
                + ", average=" + average + "]";
    }


}
