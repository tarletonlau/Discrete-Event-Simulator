class Assessment implements Keyable {
    private final String assessment;
    private final String grade;

    Assessment(String assessment, String grade) {
        this.assessment = assessment;
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }

    public String getKey() {
        return this.assessment;
    }

    @Override
    public String toString() {
        return String.format("{%s: %s}", this.assessment, this.grade);
    }

}

