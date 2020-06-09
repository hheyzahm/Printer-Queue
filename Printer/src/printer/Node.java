package printer;

public class Node {

    private Time submissionTime, startTime, endTime;
    private int numberOfPages;
    int S_second, S_minute, S_hour;
    int E_second, E_minute, E_hour;
    String Status = "";
    Node next;
    int job;

    public Node(int data) {
        this.submissionTime = new Time(2, 29, 0);
        this.numberOfPages = data;
        Status = "IN-Progress";
        Processjob();
        next = null;
    }

    public void estStartTime() {
        //esStarrTime begins
        S_second = submissionTime.getSeconds();
        S_minute = submissionTime.getMinutes();
        S_hour = submissionTime.getHours();
        if (S_second == 59) {
            S_second = 01;
            S_minute++;
            if (S_minute == 60) {
                S_minute = 0;
                S_hour++;
            }
        } else if (S_second < 59) {

            int check = S_second;
            if (check + 2 == 60) {

                S_second = 00;
                S_minute++;
                if (S_minute == 60) {
                    S_minute = 0;
                    S_hour++;
                }
            } else if (check + 2 != 60) {
                S_second += 2;
            }
        }
        startTime = new Time(S_hour, S_minute, S_second);
        //eststarttime calculated
    }

    public void estEndTime() {
        //est endtime begins

        job = numberOfPages * 10;

        E_second = S_second;
        E_hour = S_hour;
        E_minute = S_minute;

        if (job > 60) {
            E_second += job - 60;
            if (E_second > 60) {
                E_second = E_second - 60;
                E_minute++;
                if (E_minute == 60) {
                    E_minute = 0;
                    E_hour++;
                }
            } else {
                E_second = 60 - E_second;
                E_minute++;
                if (E_minute == 60) {
                    E_minute = 0;
                    E_hour++;
                }
            }
        } else if (job < 60) {
            E_second += job;
            if (E_second > 60) {
                E_second = E_second - 60;
                E_minute++;
                if (E_minute == 60) {
                    E_minute = 0;
                    E_hour++;
                }
            }
        }
        endTime = new Time(E_hour, E_minute, E_second);

    }

    public void Processjob() {
        estStartTime();

        estEndTime();

    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Time getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Time submissionTime) {
        this.submissionTime = submissionTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
       // System.out.println("Start before " + this.startTime.TimeDisplay());
        S_second = startTime.getSeconds();
        S_minute = startTime.getMinutes();
        S_hour = startTime.getHours();
        this.startTime = new Time(S_hour, S_minute, S_second);

        // this.startTime =startTime;
        System.out.println("Start a " + this.startTime.TimeDisplay());
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getS_second() {
        return S_second;
    }

    public void setS_second(int S_second) {
        this.S_second = S_second;
    }

    public int getS_minute() {
        return S_minute;
    }

    public void setS_minute(int S_minute) {
        this.S_minute = S_minute;
    }

    public int getS_hour() {
        return S_hour;
    }

    public void setS_hour(int S_hour) {
        this.S_hour = S_hour;
    }

    public int getE_second() {
        return E_second;
    }

    public void setE_second(int E_second) {
        this.E_second = E_second;
    }

    public int getE_minute() {
        return E_minute;
    }

    public void setE_minute(int E_minute) {
        this.E_minute = E_minute;
    }

    public int getE_hour() {
        return E_hour;
    }

    public void setE_hour(int E_hour) {
        this.E_hour = E_hour;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

}
