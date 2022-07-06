package userclasses;

public class User {
	   // VARIABLES
    private String username;
    private String name;
    private String surname;
    private String department;
    private static int usersCounter=0; // userCounter=0, userCounter++ when constructor is called
    private String email;
    private String password;
    //----------------------------------------------------------------------------------
    //Getter&Setter of username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //Getter&Setter of password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getter&Setter of name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter&Setter of surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //Getter&Setter of  department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //Getter&Setter of email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getter&Setter of userCounter
    public int getUsersCounter() {
        return usersCounter;
    }
    //---------------------------------------------------------------------------------------
    //constructor of Users
    public User(){
        usersCounter++;
    }

    public User(String username,String name, String surname, String department, String email) {
        usersCounter++;
        setUsername(username);
        setName(name);
        setSurname(surname);
        setDepartment(department);
        setEmail(email);
    }
    //-------------------------------------------------------------------------------------------
    //METHODS

    public void login() {
        System.out.println("\nUser Login Successful\n");
    }
    public void logout() {}
    public void register() {}
    public void updatedata() {}
}
