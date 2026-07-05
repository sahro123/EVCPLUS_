import java.util.Date;
import java.util.Scanner;
public class evcPLUS {
    static Scanner input = new Scanner(System.in);
    static final int binka_saxda = 5693;
    private static double evcharaaga = 956.8;
    private static double Bankharaaga = 2000.5;
    private static final int max_pin_attempts = 5;
    private static final int Aqoonsiga_kaarkaa = 5566;
    private static final int koonto_numberka = 555666;
    private static final int ref_num = 2288;
    private static final Date currentTime = new Date();

    public static void main(String[] args) {
        System.out.print(" Geli USSD");
        String ussd = input.nextLine();

        if (!ussd.equals("*770#")) {
            System.out.println("USSD waa khaldan yahay.");
            return;
        }

        if (verifyPin()) {
            showblance();
        } else {
            System.out.println("pin khaldan.");

        }
    }


    public static boolean verifyPin() {
        System.out.println("/n EVCPLUS");
        System.out.println("Geli pin");
        for (int i = 0; i < max_pin_attempts; i++) {
            int pin = input.nextInt();
            input.nextLine();
            if (pin == binka_saxda) {
                return true;
            }

            System.out.println("incorrect bin try again");
        }
        return false;

    }


    public static void showblance() {

        System.out.println("1: itus haragaaga ");
        System.out.println("2: kaarka hadalka ");
        System.out.println("3: bixi biilka ");
        System.out.println("4: wareeji ");
        System.out.println("5:warbixin kooban ");
        System.out.println("6: salaam bank ");
        System.out.println("7: maaraynta");
        System.out.println("8: billnpayment");

        System.out.println("9: exit");
        System.out.println("dooro(1-9):");
        int dooro = input.nextInt();
        input.nextLine();

        switch (dooro) {

            case 1:
                showBalance();
                break;

            case 2:
                kaarkahadalka();
                break;

            case 3:
                bixiBill();
                break;

            case 4:
                uWareejiEVC();
                break;

            case 5:
                warbixinKooban();
                break;

            case 6:
                salaamBank();
                break;

            case 7:
                maarayn();
                break;

            case 8:
                billPayment();
                break;
            case 9:
                System.out.println("Waad ku mahadsanthy isticmaalka EVCPLUS");
                System.exit(0);
                break;

            default:
                System.out.println("Doorasho khaldan.");
        }
    }


    private static void showBalance() {
        System.out.println("/n haraagaaga");
        System.out.println("EVC PLUS: $" + evcharaaga);

    }

    private static void kaarkahadalka() {
        System.out.println("/n... kaarka hadalka ......");
        System.out.println("1: ku shubo Airtime ");
        System.out.println("2:ugu shub qof kale ");
        System.out.println("3: internet packages");
        System.out.println("dooro adeega");
        String doorasho = input.nextLine();
        switch (doorasho) {
            case "1":
                kushuboAirtime();
                break;
            case "2":
                ugushuboQofkale();
            case "3":
                internetPackages();

                break;
            default:
                System.out.println("Doorasho khaldan");

        }
    }

    private static void kushuboAirtime() {
        System.out.println("Geli lacagta");
        double lacag = input.nextInt();
        input.nextLine();
        if (lacag > 0 && lacag <= evcharaaga) {
            System.out.println("ma hubtaa? 1. haa 2.maya");
            String confirm = input.nextLine();
            if (confirm.equals("1")) {
                evcharaaga -= lacag;
                System.out.println("waxaad ku shubaty $+ lacag");
                System.out.println("haraaga:$ " + evcharaaga);
            } else {
                System.out.println(" waala joojiyay howlgalka");
            }

        } else {
            System.out.println("haragaaga kuguma filno");
        }
    }

    private static void ugushuboQofkale() {
        System.out.println("Geli numberka:");
        String number = input.nextLine();
        System.out.println("Geli lacagta ");
        double lacag = input.nextInt();
        input.nextLine();
        if (lacag > 0 && lacag <= evcharaaga) {
        System.out.println("Ma hubtaa inaad $" + lacag + "u dirtid" + number + "1: haa 2: maya ");
        String confirm = input.nextLine();
        if (confirm.equals("1")) {
            evcharaaga -= lacag;
            System.out.println("la diray $" + lacag + "()" + number);
            System.out.println("Haraagaaga " + evcharaaga);
            System.out.println("Taariikh" + currentTime);
        } else {
            System.out.println("Haraagaaga kuguma filna");

        }

    }}

    private static void internetPackages() {
        String[] packages = {"Daily $1", "Weekly $5", "Monthly $25"};
        int[] prices = {1, 5, 25};

        System.out.println("Internet Packages:");
        for (int i = 0; i < packages.length; i++) {
            System.out.println((i + 1) + ". " + packages[i]);
        }

        System.out.print("Dooro package: ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice >= 1 && choice <= packages.length) {
            int cost = prices[choice - 1];

            if (cost <= evcharaaga) {
                System.out.println("Ma hubtaa? 1. Haa 2. Maya");
                String confirm = input.nextLine();

                if (confirm.equals("1")) {
                    evcharaaga -= cost;
                    System.out.println("Package-ka waa la iibsaday.");
                    System.out.println("Waxaad dooratay: " + packages[choice - 1]);
                    System.out.println("Lacagta la jaray: $" + cost);
                    System.out.println("Haraagaaga: $" + evcharaaga);
                }
            } else {
                System.out.println("Haraaga kuguma filna.");
            }
        } else {
            System.out.println("Doorasho khaldan.");
        }
    }




    private static void salaamBank() {
        System.out.println("/n ----- salaamBank----");
        System.out.println("1: Haraaga");
        System.out.println("2: lacag dhigasho");
        System.out.println("3: lacag qaadasho");
        System.out.println("4: ka wareeji evcpluska");
        System.out.println("5: Dib unoqo");
        System.out.println("dooro adeega");
        int choices = input.nextInt();
        input.nextLine();

        switch (choices) {
            case 1:
                System.out.println("koonto number: $" + koonto_numberka);
                System.out.println("Bank Blance: $" + Bankharaaga);

                break;
            case 2:
                Lacagdhigasho();
                break;
            case 3:
                lacagqaadasho();
                break;
            case 4:
                kawareejievcpluska();
                break;
            case 5:
                showblance();
                break;

            default:
                System.out.println("invalid option");
        }

    }


    private static void Lacagdhigasho() {
        System.out.println(" Geli lacagta");
        double lacag = input.nextInt();
        input.nextLine();
        if (lacag > 0 && lacag <= evcharaaga) {
            Bankharaaga += lacag;
            evcharaaga -= lacag;
            System.out.println("waad qaadaty $" + lacag);
            System.out.println("Bank Balace$ " + Bankharaaga);
            System.out.println("EVCPLUS $" + evcharaaga);


        } else {
            System.out.println("Kuguma filna haraagaga Bankiga");
        }
    }

    private static void lacagqaadasho() {
        System.out.println("geli lacagta$");
        double lacag = input.nextInt();
        input.nextLine();
        if (lacag > 0 && lacag <= Bankharaaga) {
            Bankharaaga -= lacag;
            evcharaaga += lacag;
            System.out.println("waxaad kala baxday" + lacag);
            System.out.println("bank balance" + Bankharaaga);
            System.out.println("EVCPLUS" + evcharaaga);
        } else {
            System.out.println("haragaga bankiga kuguma filno");
        }

    }

    private static void kawareejievcpluska() {
        System.out.println("geli accunt numberka");
        int accunt = input.nextInt();
        input.nextLine();
        if (accunt != koonto_numberka) {
            System.out.println("account numberka woo khaldan yhy");
            return;
        }
        System.out.println("geli lacagta: $");
        double lacag = input.nextInt();
        input.nextLine();
        if (lacag > 0 && lacag <= Bankharaaga) {
            System.out.println("ma hubtaa (1: haa ama 2: maya");
            String confirm = input.nextLine();
            if (confirm.equals("1")) {
                Bankharaaga -= lacag;
                System.out.println(" waxad $ " + lacag + " ugu wareejisay evcpluska ");
                System.out.println("Taariikh" + currentTime);
                System.out.println("Bank balance" + Bankharaaga);
            } else {
                System.out.println("Howlkalka waa la joojiyaya");
            }
        } else {
            System.out.println("haraagaaga bankiga kuguma filna");

        }
    }


    private static void kaWareejiAccount() {

        System.out.print("Geli Account Number: ");
        int account = input.nextInt();
        input.nextLine();

        if (account != koonto_numberka) {
            System.out.println("Account Number waa khaldan yahay.");
            return;
        }

        System.out.print("Geli lacagta: $");
        double lacag = input.nextDouble();
        input.nextLine();

        if (lacag > 0 && lacag <= Bankharaaga) {

            System.out.print("Ma hubtaa? (1.Haa 2.Maya): ");
            String confirm = input.nextLine();

            if (confirm.equals("1")) {

                Bankharaaga -= lacag;

                System.out.println("Waxaad $" + lacag + " u wareejisay Account-ka.");
                System.out.println("Taariikh: " + currentTime);
                System.out.println("Haraaga Bangiga: $" + Bankharaaga);

            } else {
                System.out.println("Hawlgalka waa la joojiyay.");
            }

        } else {
            System.out.println("Haraaga Bangiga kuguma filna.");
        }
    }


    private static void hubiWareejin() {

        System.out.print("Geli Reference Number: ");
        int ref = input.nextInt();
        input.nextLine();

        if (ref == ref_num) {
            System.out.println("Wareejinta waa lagu guulaystay.");
        } else {
            System.out.println("Reference Number lama helin.");
        }
    }


    private static void maareyntaBangiga() {

        System.out.print("Geli PIN-ka Bangiga: ");
        int pin = input.nextInt();
        input.nextLine();

        if (pin != binka_saxda) {
            System.out.println("PIN waa khaldan yahay.");
            return;
        }

        System.out.print("Geli PIN cusub: ");
        int newPin = input.nextInt();

        System.out.print("Ku celi PIN-ka cusub: ");
        int confirmPin = input.nextInt();

        if (newPin == confirmPin) {
            System.out.println("PIN-ka Bangiga waa la beddelay.");
        } else {
            System.out.println("PIN-yadu isma waafaqaan.");
        }
    }


    private static void kalaBax() {

        System.out.print("Geli lacagta aad rabto: $");
        double lacag = input.nextDouble();
        input.nextLine();

        if (lacag > 0 && lacag <= Bankharaaga) {

            Bankharaaga -= lacag;

            System.out.println("Waxaad kala baxday $" + lacag);
            System.out.println("Taariikh: " + currentTime);
            System.out.println("Haraaga Bangiga: $" + Bankharaaga);

        } else {
            System.out.println("Haraaga Bangiga kuguma filna.");
        }
    }


    private static void bixiBill() {
        System.out.println("\n=== Bixi Bill ===");
        System.out.println("Adeeggan wali waa socdaa...");
    }


    private static void uWareejiEVC() {

        System.out.print("Geli numberka: ");
        String number = input.nextLine();

        System.out.print("Geli lacagta: ");
        double lacag = input.nextDouble();
        input.nextLine();

        if (lacag > 0 && lacag <= evcharaaga) {

            evcharaaga -= lacag;

            System.out.println("Waxaad $" + lacag + " u wareejisay " + number);
            System.out.println("Taariikh: " + currentTime);
            System.out.println("Haraaga: $" + evcharaaga);

        } else {
            System.out.println("Haraaga kuguma filna.");
        }
    }


    private static void warbixinKooban() {

        System.out.println("\n=== Warbixin Kooban ===");
        System.out.println("1. Hawlgalkii ugu dambeeyay");
        System.out.println("2. Saddexdii hawlgal ee ugu dambeeyay");

        System.out.print("Dooro: ");
        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Hawlgalkii ugu dambeeyay...");
                break;

            case 2:
                System.out.println("Saddexdii hawlgal ee ugu dambeeyay...");
                break;

            default:
                System.out.println("Doorasho khaldan.");
        }
    }

    private static void maarayn() {

        System.out.println("\n=== Maarayn ===");
        System.out.println("1. Beddel PIN");
        System.out.println("2. Beddel Luqadda");
    }



    private static void billPayment() {

        System.out.println("\n=== Bill Payment ===");

        System.out.print("Geli Reference Number: ");
        int ref = input.nextInt();
        input.nextLine();

        if (ref == ref_num) {
            System.out.println("Reference Number waa sax.");
        } else {
            System.out.println("Reference Number waa khaldan yahay.");
        }
    }}
