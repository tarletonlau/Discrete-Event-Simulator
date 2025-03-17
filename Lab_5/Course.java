class Course extends KeyableMap<Assessment> {
    Course(String course) {
        super(course);
    }

    Course(String course, ImmutableMap<String, Assessment> assessments) {
        super(course, assessments);
    }

    // =================== Methods ==========================
    @Override
    public Course put(Assessment item) {
        KeyableMap<Assessment> updatedMap = super.put(item);
        return new Course(updatedMap.getKey(), updatedMap.getMap());
    }
}
