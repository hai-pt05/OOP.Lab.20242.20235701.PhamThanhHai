import java.util.Scanner;

public class DaysInMonth{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int month = 0;
        int year = 0;
        boolean validInput = false;

        while (!validInput){
            System.out.print("month: ");
            String monthInput = scanner.nextLine().trim().toLowerCase();
            month = Month(monthInput);
            if (month != -1)
                validInput = true;
            else
                System.out.println("Nhập sai tháng!");
        }

        validInput = false;

        while (!validInput){
            System.out.print("year: ");
            String yearInput = scanner.nextLine().trim();
            try{
                year = Integer.parseInt(yearInput);
                if (year >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Nhập sai năm (số dương)");
                }
            }catch (NumberFormatException e){
                System.out.println("Nhập sai năm (chữ số)");
            }
        }

        // số ngày trong tháng
        int daysInMonth = DaysOfMonth(month, year);
        System.out.println("Number of days in month: " + daysInMonth);

        scanner.close();
    }

    private static int Month(String month){
        switch (month){
            case "January": case "Jan.": case "Jan": case "january": case "jan.": case "jan": case "1": return 1;
            case "February": case "Feb.": case "Feb": case "february": case "feb.": case "feb": case "2": return 2;
            case "March": case "Mar.": case "Mar": case "march": case "mar.": case "mar": case "3": return 3;
            case "April": case "Apr.": case "Apr": case "april": case "apr.": case "apr": case "4": return 4;
            case "May": case "may": case "5": return 5;
            case "June": case "Jun.": case "Jun": case "june": case "jun.": case "jun": case "6": return 6;
            case "July": case "Jul.": case "Jul": case "july": case "jul.": case "jul": case "7": return 7;
            case "August": case "Aug.": case "Aug": case "august": case "aug.": case "aug": case "8": return 8;
            case "September": case "Sept.": case "Sep": case "september": case "sept.": case "sep": case "9": return 9;
            case "October": case "Oct.": case "Oct": case "october": case "oct.": case "oct": case "10": return 10;
            case "November": case "Nov.": case "Nov": case "november": case "nov.": case "nov": case "11": return 11;
            case "December": case "Dec.": case "Dec": case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    private static int DaysOfMonth(int month, int year){
        switch (month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return LeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    private static boolean LeapYear(int year){
        if(year % 4 != 0){
            return false;
        }else if (year % 100 != 0){
            return true;
        }else{
            return year % 400 == 0;
        }
    }
}


