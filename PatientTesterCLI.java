import java.util.ArrayList; 
import java.util.Scanner;

public class PatientTesterCLI {

    static Scanner keyboardIn = new Scanner(System.in);
    ArrayList<Patient> patientList = new ArrayList<Patient>();

    public static void main(String[] args) {
        
        mainMenu();

        
    }
    
    public static void mainMenu() {
        int input=-1;
        while (input!=0) {
            System.out.print("MENU\n");
            System.out.print("1 - Patient Management\n");
            System.out.print("2 - Patient Operations\n");
            System.out.print("3 - Database Operations\n");
            System.out.print("0 - Exit Program\n");
            System.out.print("Your option: ");
            try {
                input = keyboardIn.nextInt();
                switch (input) {
                    case 1:
                        patientManagementMenu();
                        break;
                    case 2:
                        patientOperationsMenu();
                        break;
                    case 3:
                        databaseOperationsMenu();
                        break;
                    case 0:
                        System.out.print("Exitting Program!\n");
                        System.exit(0);;
                        break;
                    default:
                        System.out.print("Invalid Option!\n");
                }
            }
            catch (Exception exc) {
                input = -1;
                keyboardIn.next();


            }


        }
    }

    public static void patientManagementMenu() {
        System.out.print("Patient Management\n");
        System.out.print("1 - Insert new Patient\n");
        System.out.print("2 - Edit Existing Patient Details\n");
        System.out.print("3 - Remove Existing Patient\n");
        System.out.print("0 - Exit Menu\n");
        System.out.print("Your option: ");
    }

    public static void patientOperationsMenu() {
        System.out.print("Patient Operations\n");
        System.out.print("1 - Display IMC\n");
        System.out.print("2 - Calculate Risk\n");
        System.out.print("3 - Remove Existing Patient\n");
        System.out.print("0 - Exit Menu\n");
        System.out.print("Your option: ");
    }

    public static void databaseOperationsMenu() {
        System.out.print("Database Operations\n");
        System.out.print("1 - Clear Database\n");
        System.out.print("2 - Load Database\n");
        System.out.print("3 - Save Database\n");
        System.out.print("0 - Exit Menu\n");
        System.out.print("Your option: ");
    }
}
