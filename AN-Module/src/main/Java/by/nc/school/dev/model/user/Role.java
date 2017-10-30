package by.nc.school.dev.model.user;

public enum Role
{
    USER("USER"),
    ADMIN("ADMIN"),
    TEACHER("TEACHER"),
    STUDENT("STUDENT")
    ;

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
