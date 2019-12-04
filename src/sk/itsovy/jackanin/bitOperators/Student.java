package sk.itsovy.jackanin.bitOperators;

public class Student implements HELP{
    private String name;
    private byte attWeek;
    private Address address;
    private static int count = 0;
    private int hobby;

    public class Address{
        private String city;
        private String zip;
        private Address  address;

        public Address(String city, String zip) {
            this.city = city;
            this.zip = zip;
        }
    }

    //CONSTRUCTOR
    public Student(String name, byte attWeek, String city, String zip) {
        this.name = name;
        this.attWeek = attWeek;
        this.address = new Address("Presov", "080 01");
        count++;
        System.out.println("New student id"+count+" has been created. Name: "+name);
        this.hobby = 0;
    }

    //GETTER
    public String getName(){
        return this.name;
    }
    public byte getAttWeek(){
        return this.attWeek;
    }

    //METHOD
    public void setAttDay(Days day){
        switch (day){
            case MON: this.attWeek = (byte) (this.getAttWeek() | 1);
            case TUE: this.attWeek = (byte) (this.getAttWeek() | 2);
            case WED: this.attWeek = (byte) (this.getAttWeek() | 4);
            case THU: this.attWeek = (byte) (this.getAttWeek() | 8);
            case FRI: this.attWeek = (byte) (this.getAttWeek() | 16);
        }
    }
    public void setHobby(Hobbies hobby){
        switch (hobby){
            case DANCE: this.hobby |= 1; break;
            case FOOTBALL: this.hobby |= 2; break;
            case HOCKEY: this.hobby |= 4; break;
            case GOLF: this.hobby |= 8; break;
            case PROGRAMMING: this.hobby |= 16; break;
            case HIKING: this.hobby |= 32; break;
            case GAMING: this.hobby |= 64; break;
            case TRAVELLING: this.hobby |= 128; break;
        }
    }
    public int getHobby(){
        return this.hobby;
    }
    public boolean hasHobby(Hobbies hobby){
        switch (hobby){
            case DANCE:         if ((this.hobby & 1) == 1){ return true; } else break;
            case FOOTBALL:      if ((this.hobby & 2) == 2){ return true; } else break;
            case HOCKEY:        if ((this.hobby & 4) == 4){ return true; } else break;
            case GOLF:          if ((this.hobby & 8) == 8){ return true; } else break;
            case PROGRAMMING:   if ((this.hobby & 16) == 16){ return true; } else break;
            case HIKING:        if ((this.hobby & 32) == 32){ return true; } else break;
            case GAMING:        if ((this.hobby & 64) == 64){ return true; } else break;
            case TRAVELLING:    if ((this.hobby & 128) == 128){ return true; } else break;
        }
        return false;
    }
    @Override
    public String getHelp() {
        return "get some help! GERRARA HERE!";
    }
}
