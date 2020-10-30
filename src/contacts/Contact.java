package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
    private  String firstName ="";
    private  String lastName ="";
    private  String phoneNumber ="";
    private boolean checkNumber(String phoneNumber){
       // System.out.println("from check ph "+phoneNumber );
       boolean correctFormat = false;
        correctFormat= phoneNumber.matches("\\+?\\(?[0-9a-zA-Z]+\\)?([\\s-]{1}\\(?[0-9a-zA-Z]{2,}\\)?)*");
       String regex = "(\\+?\\(\\w+\\)([\\s-]\\w{2,})*)|(\\+?\\w+([\\s-]\\(\\w{2,}\\))?([\\s-]\\w{2,})*)";
        //System.out.println("pnum "+phoneNumber+" correctformat "+correctFormat);
//        if(correctFormat) {
//            String[] s = phoneNumber.split("\\s|-");
//            int paraCount = 0;
//            for (String str : s) {
//                if (str.contains("(") && str.contains(")")) {
//                    paraCount++;
//                    //System.out.println("paraCount " + paraCount);
//                }else
//                if (str.contains("(") || str.contains(")")) {
//                    correctFormat = false;
//                    break;
//                }
//            }
//            if (paraCount > 1) {
//                correctFormat = false;
//            }
//        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        correctFormat = matcher.matches();
        return correctFormat;
    }

    @Override
    public String toString() {
        return  ". "+firstName +" "+lastName+", "+phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        //System.out.println("from set "+phoneNumber);
        if(checkNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }else{
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
