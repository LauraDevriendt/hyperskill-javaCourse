class User {
    private String firstName;
    private String lastName;


    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if(firstName != (null)){
            this.firstName=firstName;
        }



    }

    public void setLastName(String lastName) {
       if(lastName != (null)){
           this.lastName=lastName;
       }

    }

    public String getFullName() {
        if(this.firstName.equals ("") && this.lastName.equals ("")){
            return "Unknown";
        } else if (this.firstName.equals ("")) {
            return lastName;
        } else if (this.lastName.equals ("")) {
            return firstName;
        }else {
            return firstName + " " + lastName; // write your code here
        }
    }
}
