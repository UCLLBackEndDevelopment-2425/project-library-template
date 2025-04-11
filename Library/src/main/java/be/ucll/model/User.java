package be.ucll.model;

public class User {
    private String name;
    private int age;
    private String email;
    private String password;

    public User(String name, int age, String email, String password) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new RuntimeException("Name is required");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new RuntimeException("Age must be a positive integer between 0 and 101");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isEmailValid(email)) {
            throw new RuntimeException("E-mail must be a valid email format");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new RuntimeException("Password is required");
        }
        this.password = password;
    }

    private boolean isEmailValid(String email){
        if (email == null) return false;
        return email.contains("@") && email.contains(".");
    }
}
