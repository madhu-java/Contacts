package contacts;

public class OrganizationRecords extends  AllRecords {
    private  String organizationName = "[no data]";
    private  String organizationAddress = "[no data]";

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        if(organizationName.isEmpty()){
            System.out.println("wrong");
        }else {
            this.organizationName = organizationName;
        }
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }
    @Override
    public String toString() {
        return String.format("Organization name: %s\nAddress: %s\n",
                organizationName,organizationAddress)+super.toString();
//        "Contact{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
    }
}
