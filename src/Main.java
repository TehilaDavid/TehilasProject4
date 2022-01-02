import java.util.Scanner;

public class Main {
    final static int SIGN_UP = 1;
    final static int LOG_IN = 2;
    final static int EXIT = 3;
    final static int FIRST_MENU_MAX_CHOICE = 3;
    final static int FIRST_MENU_MIN_CHOICE = 0;
    final static int USER_CHOICE_1 = 1;
    final static int USER_CHOICE_2 = 2;
    final static int USER_CHOICE_3 = 3;
    final static int USER_CHOICE_4 = 4;
    final static int USER_CHOICE_5 = 5;
    final static int USER_CHOICE_6 = 6;
    final static int SECOND_MENU_MAX_CHOICE = 6;
    final static int SECOND_MENU_MIN_CHOICE = 1;


    public static void main(String[] args) {
        int userChoice1;
        int userChoice2;
        Scanner scanner = new Scanner(System.in);

        RealEstate realEstate = new RealEstate();
        do {
            do {
                System.out.println("To sign up enter 1 to Log-in enter 2 and to Exit enter 3");
                userChoice1 = scanner.nextInt();

            }while (userChoice1 > FIRST_MENU_MAX_CHOICE || userChoice1 <= FIRST_MENU_MIN_CHOICE);

            if (userChoice1 == SIGN_UP) {
                realEstate.createUser();

            }if (userChoice1 == LOG_IN){
                User loggedUser = realEstate.userLogIn();

                if (loggedUser == null) {
                    System.out.println("Login failed, The username or password is incorrect");
                }else {
                    do {
                        System.out.println("Enter your choice: " +
                                "\n" + "1- Post a new property" +
                                "\n" + "2- Remove property posting" +
                                "\n" + "3- View all property in the system" +
                                "\n" + "4- View all properties posted by you" +
                                "\n" + "5- Search for properties by parameters" +
                                "\n" + "6- Disconnect and return to the main menu");
                        userChoice2 = scanner.nextInt();
                    }while (userChoice2 > SECOND_MENU_MAX_CHOICE || userChoice2 < SECOND_MENU_MIN_CHOICE);


                    switch (userChoice2) {
                        case USER_CHOICE_1:
                            realEstate.postNewProperty(loggedUser);
                            break;
                        case USER_CHOICE_2:
                            realEstate.removeProperty(loggedUser);
                            break;
                        case USER_CHOICE_3:
                            realEstate.printAllProperties();
                            break;
                        case USER_CHOICE_4:
                            realEstate.printMyProperties(loggedUser);
                            break;
                        case USER_CHOICE_5:
                            Property [] printProperties = realEstate.search();
                            for (int i = 0; i < printProperties.length; i++) {
                                System.out.println(printProperties[i]);
                            }
                            break;
                        case USER_CHOICE_6:
                            break;
                    }
                }


            }
        }while (userChoice1 != EXIT);
    }






}




