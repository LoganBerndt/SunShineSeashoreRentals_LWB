/*

This program will prompt the user for the number of minutes that they rent a
piece of sports equipment for. It also displays the companies motto with a
border and the price for the rental. Also Displays the date.

Logan Berndt

12/14/22

*/



import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;

public class SeashoreMain {


    public class Ch3Sunshine {



        static DecimalFormat dollarAmount;

        static Scanner userInput = new Scanner(System.in);

        static DecimalFormat timeAmt;

        static String iDate;

        public static void main(String[] args) {

            LocalDate myDateObj = LocalDate.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMMM dd,yyyy");
            String formattedDate = myDateObj.format(myFormatObj);
            System.out.println("Today's Date: " + formattedDate);

            String iDate;
            iDate = getDateFromUser();
            dateDisplay(iDate);

            init();
            int iTime = input();
            int cHours = calcs1(iTime);
            int cMinutes = calcs2(iTime);
            double TotalPrice = calcs3(cMinutes, cHours);
            CompanyMotto.output();
            System.out.println("Date as Entered: " + iDate);
            output(cHours,cMinutes,TotalPrice);

        }

        private static void init() {

            timeAmt = new DecimalFormat( "##");

            dollarAmount = new DecimalFormat("$#,###.00");

            userInput = new Scanner(System.in);

        }

        private static int input() {

            int iTime;
            System.out.println("Please enter the amount of time rented: ");
            String iUserRent = userInput.nextLine();

            try {
                iTime = Integer.parseInt(iUserRent);
            }
            catch(Exception e) {
                System.out.println("Error.");
                System.out.println("Time set to 60 minutes.");
                iTime = 60;
            }

            return iTime;

        }

        public static String getDateFromUser(){
            String enterDate;
            System.out.println("Enter a date (MM/DD/YYYY).");
            enterDate = userInput.nextLine();

            return enterDate;
        }

        private static int calcs1(int iTime) {

            int cHours = iTime / 60;

            return cHours;
        }

        private static int calcs2(int iTime){

            int cMinutes = iTime % 60;

            return cMinutes;

        }

        private static double calcs3(int cMinutes, double cHours){

            double cRentalHours = cHours * 40;
            double cTotalRent = cRentalHours + cMinutes;

            return cTotalRent;

        }

        public static void dateDisplay(String iDate) {


            String formattedDate1 = "MM/dd/yyyy";
            String formattedDate2 = "MMM dd, yyyy";


            SimpleDateFormat sdf = new SimpleDateFormat(formattedDate1);
            try {
                Date d = sdf.parse(iDate);
                sdf.applyPattern(formattedDate2);
                String newDateString = sdf.format(d);
                System.out.println("Entered Date Formatted: " + newDateString);
            }
            catch (ParseException e) {
                System.out.println("Invalid Date Entered.");
            }


        }

        private static void output(int cHours, int cMinutes,double TotalPrice) {

            String oHours, oMinutes, oTotalPrice;

            oHours = timeAmt.format(cHours);
            oMinutes = timeAmt.format(cMinutes);
            oTotalPrice = dollarAmount.format(TotalPrice);

            System.out.println();
            System.out.println();

            System.out.printf("%-10s%5s%-10s%5s%-10s\n",
                    "Hours", "", "Minutes", "", "Rental Price");

            System.out.println("------------------------------------------");

            System.out.printf("%-10s%5s%-10s%5s%-10s\n",
                    oHours, "", oMinutes, "", oTotalPrice);


        }
    }
}


