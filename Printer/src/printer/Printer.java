package printer;

import java.util.Scanner;

public class Printer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Scanner Input = new Scanner(System.in);

        int Numberofpages = 1;
        //System.out.println("Enter the Number of pages You Want to Print:");
        // Numberofpages=Input.nextInt();

       
        PrinterQueue pq = new PrinterQueue();
        pq.enPrinterQueue(Numberofpages);
        String[] top = ("Printing Job ID\nStatus\nNumber of Pages\nSubmitted\nStart Time\nEnd Time\n").split("\n");
        for (int i = 0; i < top.length; i++) {

            System.out.printf("%-25s %s", top[i] + "", "");
        }
        pq.PrintPrinterFinal();
        pq.enPrinterQueue(Numberofpages + 2);
        pq.PrintPrinterFinal();
        
    }

}
