class Roster extends KeyableMap<Student> {
    Roster(String key) {
        super(key);
    }

    Roster(String key, ImmutableMap<String,Student> students) {
        super(key,students);
    }

    public Roster put(Student item) {
        KeyableMap<Student> updatedMap = super.put(item);
        return new Roster(updatedMap.getKey(), updatedMap.getMap());
    }

    String getGrade(String studentId, String courseId, String assessmentId) {
        return this.get(studentId)
                .flatMap(student -> student.get(courseId))
                .flatMap(course -> course.get(assessmentId))
                .map(assessment -> assessment.getGrade())
                .orElse("No such record: " + studentId + " " + courseId + " " + assessmentId);
    }

    public Roster add(String studentId, String courseCode, String assessmentTitle, String grade) {
        Student existingStudent = this.get(studentId).orElse(new Student(studentId));
        Course existingCourse = existingStudent.get(courseCode).orElse(new Course(courseCode));

        Assessment newAssessment = new Assessment(assessmentTitle, grade);
        Course updatedCourse = existingCourse.put(newAssessment);
        Student updatedStudent = existingStudent.put(updatedCourse);

        return this.put(updatedStudent);
    }
}
