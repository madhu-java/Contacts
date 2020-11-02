package contacts;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllRecords {
    private  String phoneNumber ="";
    private  LocalDateTime dateCreated;
    private LocalDateTime lastEditDate;
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(LocalDateTime lastEditDate) {
        this.lastEditDate = lastEditDate;
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
    public String toString() {
        return String.format("Number: %s\nTime created: %s\nTime last edit: %s\n",phoneNumber,dateCreated,lastEditDate);
    }
}
