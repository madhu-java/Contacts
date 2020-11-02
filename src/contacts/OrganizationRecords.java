package contacts;

public class OrganizationRecords extends AllRecords {
    private String organizationName = "[no data]";
    private String organizationAddress = "[no data]";
    private final String[] changeableFields = new String[]{"name", "address", "number"};

    @Override
    public String[] changableFields() {
        return changeableFields;
    }

    @Override
    public void changeAField(String name, String value) {
        switch (name) {
            case "name":
                this.setOrganizationName(value);
                break;
            case "address":
                this.setOrganizationAddress(value);
                break;

            case "number":
                this.setPhoneNumber(value);
            default:
                System.out.println("no such fiels to change");
        }
    }
@Override
public String getName(){
        return organizationName;
}
    @Override
    public String getAField(String name) {
        switch (name) {
            case "name":
                return "OrganizationName: " + getOrganizationName();
            case "address":
                return "OrganizationAddress: " + getOrganizationAddress();

            case "number":
                return "Number: " + getPhoneNumber();
        }
        return " ";
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public boolean isPerson(AllRecords record) {
        return record.getClass() == PersonRecords.class;
    }

    public void setOrganizationName(String organizationName) {
        if (organizationName.isEmpty()) {
            System.out.println("wrong");
        } else {
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
                organizationName, organizationAddress) + super.toString();
//        "Contact{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
    }
}
