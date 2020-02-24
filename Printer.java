package printer;

import java.util.Scanner;

public class Printer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Scanner Input = new Scanner(System.in);

        int Numberofpages = 10;
        //System.out.println("Enter the Number of pages You Want to Print:");
        // Numberofpages=Input.nextInt();

       
        PrinterQueue pq = new PrinterQueue();
        pq.enPrinterQueue(Numberofpages);
        pq.PrintPrinterQueue();
        pq.enPrinterQueue(Numberofpages + 2);
        pq.PrintPrinterQueue();
        
    }

}
