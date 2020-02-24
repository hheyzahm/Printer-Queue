
package printer;

import java.util.concurrent.TimeUnit;

public class PrinterQueue {

    LinkList l;
    private int PrintID = 0;

    PrinterQueue() {
        l = new LinkList();
    }

    public void enPrinterQueue(int numberOfPages) {
        if (l.isEmpty()) {
            l.addNodeAtHead(numberOfPages);
        } else {
            l.addNodeAtTail(numberOfPages);
        }
        this.PrintID++;
    }

    public int getPrintID() {
        return PrintID;
    }

    public void setPrintID(int PrintID) {
        this.PrintID = PrintID;
    }

    public void dePrinterQueue() {
        l.deleteNodeFromHead();
    }

    public void print(Node t) {
        System.out.println("Printing Job ID           Status          Number of Pages               Submitted                  Start Time                 End Time    ");
       
         System.out.println(getPrintID() + "                       " + t.Status + "              " + t.getNumberOfPages() + "                      " + t.getSubmissionTime().TimeDisplay() + "                 " + t.getStartTime().TimeDisplay() + "                 " + t.getEndTime().TimeDisplay());
       
    }

    public void PrintPrinterQueue() throws InterruptedException {
        //Time now = new Time();
        Node temp = l.head;
        Node previous = null;
        while (temp != null) {
            previous = temp;
            if (temp != l.head) {
                temp.setStartTime(previous.getEndTime());
                temp.estEndTime();
            }
            print(previous);
            Time time = temp.getStartTime();
            while (true) {

                if ((temp.getHour() == time.getHours()) && (temp.getMinute() == time.getMinutes()) && (temp.getSecond() == time.getSeconds())) {
                    TimeUnit.SECONDS.sleep(temp.getNumberOfPages());
                    temp.setStatus("Printed");
                    print(temp);
                    l.deleteNodeFromHead();
                    temp = temp.next;
                    break;
                } else {
                    time.setSeconds(time.getSeconds() + 1);
                    if (time.getSeconds() == 60) {
                        time.setSeconds(0);
                        time.setMinutes(time.getMinutes() + 1);

                    }
                    if (time.getMinutes() == 60) {
                        time.setMinutes(0);
                        time.setHours(time.getHours() + 1);
                    }
                }
            }

        }

    }
}
