package sk.itsovy.jackanin.bitOperators;

public class Main {
    //CONSTANTS
    public final static byte MONDAY = 1;
    public final static byte TUESDAY = 2;
    public final static byte WEDNESDAY = 4;
    public final static byte THURSDAY = 8;
    public final static byte FRIDAY = 16;
    public final static byte ALLWEEK = 31;

    //MAIN
    public static void main(String[] args) {
        /*
        Student[] list = new Student[5];

        list[0]=new Student("Viliam", (byte) 23);
        list[1]=new Student("Daniela", (byte)10);
        list[2]=new Student("Marian", (byte)21);
        list[3]=new Student("Anastazia", (byte)7);
        list[4]=new Student("Roman", (byte)31);

        //vypis studentov ktory boli v pondelok v skole
        System.out.println("Students present on Monday: ");
        for (int i=0; i<list.length; i++){
            if ((list[i].getAttWeek() & MONDAY) == 1){
                System.out.print(" "+list[i].getName()+" ");
            }
        }
        System.out.println("\nStudents present on Tuesday: ");
        for (int i=0; i<list.length; i++){
            if ((list[i].getAttWeek() & TUESDAY) == 2){
                System.out.print(" "+list[i].getName()+" ");
            }
        }
        System.out.println("\nStudents present on Wednesday: ");
        for (int i=0; i<list.length; i++){
            if ((list[i].getAttWeek() & WEDNESDAY) == 4){
                System.out.print(" "+list[i].getName()+" ");
            }
        }
        System.out.println("\nStudents present on Thursday: ");
        for (int i=0; i<list.length; i++){
            if ((list[i].getAttWeek() & THURSDAY) == 8){
                System.out.print(" "+list[i].getName()+" ");
            }
        }
        System.out.println("\nStudents present on Friday: ");
        for (int i=0; i<list.length; i++){
            if ((list[i].getAttWeek() & FRIDAY) == 16){
                System.out.print(" "+list[i].getName()+" ");
            }
        }

        //vypise studenta ktory nikdy nechybal
        System.out.println("\nStudents present all week: ");
        for (Student student : list) {
            if ((student.getAttWeek() & 31) == ALLWEEK) {
                System.out.println(" " + student.getName() + " ");
            }
        }

        //set anastasia attendance on friday to 1
        list[3].setAttDay(Days.FRI);

        //vypis mena a poctu dni v skole
        for (Student student : list) {
            byte copyAtt = student.getAttWeek();
            int count=0;
            for (int j = 0; j < 5; j++) {
                if ((copyAtt & 1) == 1){
                    count++;
                }
                copyAtt = (byte) (copyAtt>>1);
            }
            System.out.println(student.getName()+" "+count);
        }

         */

        //OBJECTS
        Student student1 = new Student("Miro", (byte) 88, "Presov", "080 01");
        Student student2 = new Student("Peter", (byte) 48, "Kosice", "040 01");
        Student student3 = new Student("Ondrej", (byte) 13, "Kosice", "040 01");
        Student student4 = new Student("Jozef", (byte) 56, "Krivany", "082 71");
        Student student5 = new Student("Richard", (byte) 44, "Vysna Sebastova", "080 06");

        //SETTING HOBBIES
        student1.setHobby(Hobbies.PROGRAMMING);
        student1.setHobby(Hobbies.GAMING);
        student1.setHobby(Hobbies.HOCKEY);
        student2.setHobby(Hobbies.PROGRAMMING);
        student3.setHobby(Hobbies.GAMING);
        student3.setHobby(Hobbies.DANCE);
        student3.setHobby(Hobbies.GOLF);
        student4.setHobby(Hobbies.FOOTBALL);
        student5.setHobby(Hobbies.FOOTBALL);

        //STUDENT METHOD USES
        System.out.println(student1.hasHobby(Hobbies.PROGRAMMING));
        System.out.println(student2.hasHobby(Hobbies.PROGRAMMING));
        System.out.println(student2.hasHobby(Hobbies.DANCE));

        //MAIN OBJECT
        Main main1 = new Main();

        //STUDENT LIST DEFINITION
        Student[] stList = new Student[5];
        stList[0] = student1;
        stList[1] = student2;
        stList[2] = student3;
        stList[3] = student4;
        stList[4] = student5;

        //MAIN METHOD USES
        main1.getHobbies(stList, Hobbies.PROGRAMMING);
        main1.getAtLeastThreeHobbies(stList);

        System.out.println(student1.getName()+" "+student1.getHelp());
    }

    public void getHobbies(Student[] list, Hobbies hobby){
        for (int i=0 ;i<list.length; i++){
            boolean has=false;
            switch (hobby){
                case DANCE:         if ((list[i].getHobby() & 1) == 1) { has=true; } break;
                case FOOTBALL:      if ((list[i].getHobby() & 2) == 2) { has=true; } break;
                case HOCKEY:        if ((list[i].getHobby() & 4) == 4) { has=true; } break;
                case GOLF:          if ((list[i].getHobby() & 8) == 8) { has=true; } break;
                case PROGRAMMING:   if ((list[i].getHobby() & 16) == 16) { has=true; } break;
                case HIKING:        if ((list[i].getHobby() & 32) == 32) { has=true; } break;
                case GAMING:        if ((list[i].getHobby() & 64) == 64) { has=true; } break;
                case TRAVELLING:    if ((list[i].getHobby() & 128) == 128) { has=true; } break;
            }
            if (has) System.out.println(list[i].getName());
        }
    }
    public void getAtLeastThreeHobbies(Student[] list){
        for (int j=0; j<list.length; j++) {
            int number = 128, count = 0;
            for (int i = 8; i > 0; i--) {
                if ((list[j].getHobby() & number) == number) {
                    count++;
                }
                number = number >> 1;
            }
            if (count >= 3){
                System.out.println(list[j].getName()+" has at least 3 hobbies.");
            }
        }
    }
}