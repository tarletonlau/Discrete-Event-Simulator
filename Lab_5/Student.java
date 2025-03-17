class Student extends KeyableMap<Course> {

    Student(String name) {
        super(name);
    }

    Student(String name, ImmutableMap<String,Course> courses) {
        super(name,courses);
    }

    // =================== Methods ==========================
    @Override
    public Student put(Course item) {
        KeyableMap<Course> updatedMap = super.put(item);
        return new Student(updatedMap.getKey(), updatedMap.getMap());
    }

}
