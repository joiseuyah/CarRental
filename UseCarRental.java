import java.util.Scanner;

class CarRental {
    private String renterName;
    private String renterAddress;
    private String renterBirthdate;
    private String renterZipcode;
    private String driverLicense;
    private String licenseType;
    private String carSize;
    private double dailyRental;
    private int rentalDays;
    private double totalFee;

    public CarRental(String name, String address, String birthdate, String zipcode, String license, String type,
            String size, int days) throws Exception {
        renterName = name;
        renterAddress = address;
        renterBirthdate = birthdate;
        renterZipcode = zipcode;
        driverLicense = license;
        licenseType = type;
        carSize = size;
        rentalDays = days;

        switch (size) {
            case "economy":
                dailyRental = 3500.00;
                break;
            case "midsize":
                if (type.equals("student")) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please provide guardian's name:");
                    String guardianName = input.nextLine();
                    System.out.println("Please provide guardian's relationship:");
                    String guardianRelationship = input.nextLine();
                    System.out.println("Please provide guardian's address:");
                    String guardianAddress = input.nextLine();
                    System.out.println("Thank you. Your application is being processed...");
                    this.dailyRental = 0.0;
                } else {
                    dailyRental = 4000.00;
                }
                break;
            case "full size":
                if (type.equals("student")) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please provide guardian's name:");
                    String guardianName = input.nextLine();
                    System.out.println("Please provide guardian's relationship:");
                    String guardianRelationship = input.nextLine();
                    System.out.println("Please provide guardian's address:");
                    String guardianAddress = input.nextLine();
                    System.out.println("Thank you. Your application is being processed...");
                    this.dailyRental = 0.0;
                } else {
                    dailyRental = 4750.00;
                }
                break;
            case "luxury":
                dailyRental = 8000.00;
                break;
            default:
                throw new Exception("Invalid car size.");
        }

        totalFee = dailyRental * rentalDays;
    }

    public void display() {
        System.out.println("Renter Name: " + renterName);
        System.out.println("Renter Address: " + renterAddress);
        System.out.println("Renter Birthdate: " + renterBirthdate);
        System.out.println("Renter Zipcode: " + renterZipcode);
        System.out.println("Driver's License: " + driverLicense);
        System.out.println("License Type: " + licenseType);
        System.out.println("Car Size: " + carSize);
        System.out.println("Daily Rental Fee: " + dailyRental);
        System.out.println("Length of Rental in Days: " + rentalDays);
        System.out.println("Total Rental Fee: " + totalFee);
    }
}

class LuxuryCarRental extends CarRental {
    private boolean hasChauffeur;
    private double chauffeurFee;

    public LuxuryCarRental(String name, String address, String birthdate, String zipcode, String license, String type,
            int days) throws Exception {
        super(name, address, birthdate, zipcode, license, type, "luxury", days);
        hasChauffeur = false;
        chauffeurFee = 0.00;

        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to include a chauffeur? (y/n): ");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            hasChauffeur = true;
            chauffeurFee = 10000.00;
        }

        double totalfee = chauffeurFee;
    }

    @Override
    public void display() {
        super.display();
        if (hasChauffeur) {
            System.out.println("Chauffeur Fee: " + chauffeurFee);
        }
    }
}

class UseCarRental {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name, address, birthdate, zipcode, license, type, size;
        int days;

        try {
            System.out.print("Enter renter's name: ");
            name = input.nextLine();
            System.out.print("Enter renter's address: ");
            address = input.nextLine();

            System.out.print("Enter renter's birthdate (MM/DD/YYYY): ");
            birthdate = input.nextLine();

            System.out.print("Enter renter's zipcode: ");
            zipcode = input.nextLine();

            System.out.print("Enter driver's license number: ");
            license = input.nextLine();

            System.out.print("Enter driver's license type (student/regular): ");
            type = input.nextLine();

            System.out.print("Enter car size (economy/midsize/full size/luxury): ");
            size = input.nextLine();

            System.out.print("Enter length of rental in days: ");
            days = input.nextInt();

            CarRental rental;
            if (size.equalsIgnoreCase("luxury")) {
                rental = new LuxuryCarRental(name, address, birthdate, zipcode, license, type, days);
            } else {
                rental = new CarRental(name, address, birthdate, zipcode, license, type, size, days);
            }

            System.out.println("\nRental Details:");
            rental.display();

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}