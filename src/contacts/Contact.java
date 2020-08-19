package contacts;

public class Contact {
        private String name;
        private String surName;
        private String number;
        public Contact(String name, String surName, String number){
            this.name = name;
            this.surName = surName;
            this.number = number;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setSurName(String surName){
            this.surName = surName;
        }
        public void setNumber(String number){
            this.number = number;
        }
    }

