package printer;

import java.util.concurrent.TimeUnit;

public class PrinterQueue {

    LinkList l;
    private int PrintID = 0;
    int i = 1;

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

        String[] data = (getPrintID() + "\n" + t.Status + "\n" + t.getNumberOfPages() + "\n" + t.getSubmissionTime().TimeDisplay() + "\n" + t.getStartTime().TimeDisplay() + "\n" + t.getEndTime().TimeDisplay() + "\n").split("\n");
        System.out.println("");
        for (int j = 0; j < data.length; j++) {

            System.out.printf("%-25s %s", data[j] + "", "");
        }
        System.out.println("");

    }
    int count = 0;

    public void PrintPrinterFinal() throws InterruptedException {

        Node temp = l.head;
        Node previous = temp;
        Node p=previous;
        while (temp != null) {
            p=previous;
            previous = temp;
            print(temp);
            Time time = temp.getStartTime();
            while (true) {

                if ((temp.getS_hour() == time.getHours()) && (temp.getS_minute() == time.getMinutes()) && (temp.getS_second() == time.getSeconds())) {
                    //TimeUnit.SECONDS.sleep(temp.getNumberOfPages());
                    temp.setStatus("Printed");

                    l.deleteNodeFromHead();
                    if (temp.getStatus().equals("Printed")) {
                        if (temp.next != null) {
                            temp.next.setStartTime(p.getEndTime());
                            temp.estEndTime();
                            
                        }
                        else {
                            temp.setStartTime(temp.getEndTime());
                            temp.estEndTime();
                        }
                    }
                    print(previous);

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
            }//true

        }

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

                if ((temp.getS_hour() == time.getHours()) && (temp.getS_minute() == time.getMinutes()) && (temp.getS_second() == time.getSeconds())) {
                    //TimeUnit.SECONDS.sleep(temp.getNumberOfPages());
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
