public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Student)){
           return false;
        }
        return((this.firstName.equals(((Student) obj).firstName))  &&
                (this.lastName .equals(((Student) obj).lastName)));
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
