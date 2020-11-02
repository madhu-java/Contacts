package contacts;

public class PersonRecords extends AllRecords {
    private String firstName = "";
    private String lastName = "";
    private String birthDate = "[no data]";
    private String gender = "[no data]";
    private final String[] changeableFields = new String[]{"name", "surName", "birth", "gender", "number"};

    @Override
    public String[] changableFields() {
        return changeableFields;
    }

    @Override
    public void changeAField(String name, String value) {
        switch (name) {
            case "name":
                this.setFirstName(value);
                break;
            case "surName":
                this.setLastName(value);
                break;
            case "birth":
                this. setBirthDate(value);
                break;
            case "gender":
                this.setGender(value);
                break;
            case "number":
                this.setPhoneNumber(value);
            default:
                System.out.println("no such fiels to change");
        }
    }

    @Override
    public String getAField(String name) {
        switch (name){
            case "name":
                return "Name: "+getFirstName();
            case "surName":
                return "SurName: "+getLastName();

            case "birth":
                return "Birth date: "+getBirthDate();

            case "gender":
                return "Gender: "+getGender();

            case "number":
                return "Number: "+getPhoneNumber();
        }
return " ";
    }
@Override
public String getName(){
        return getFirstName()+" "+getLastName();
}
    @Override
    public String toString() {
        return String.format("Name: %s\nSurname: %s\nBirth date: %s\nGender: %s\n",
                firstName, lastName, birthDate, gender) + super.toString();
//        "Contact{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        if (birthDate.equals("")) {
            System.out.println("Bad birth date!");
        } else {
            this.birthDate = birthDate;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equals("F") || gender.equals("M")) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
