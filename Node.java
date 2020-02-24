package printer;


public class Node {

    private Time submissionTime, startTime, endTime;
    private int numberOfPages;
    int second, minute, hour;
    String Status = "";
    Node next;
    int job;

    public Node(int data) {
        this.submissionTime = new Time();
        this.numberOfPages = data;
        Status = "IN-Progress";
        Processjob();
        next = null;
    }

    public void estStartTime() {
        //esStarrTime begins
        second = submissionTime.getSeconds();
        minute = submissionTime.getMinutes();
        hour = submissionTime.getHours();
        if (second == 59) {
            second = 01;
            minute++;
            if (minute == 60) {
                minute = 0;
                hour++;
            }
        } else if (second < 59) {

            int check = second;
            if (check + 2 == 60) {
                System.out.println("dfdf");
                second = 00;
                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                }
            } else if (check + 2 != 60) {
                second += 2;
            }
        }
        startTime = new Time(hour, minute, second);
        //eststarttime calculated
    }

    public void estEndTime() {
        //est endtime begins

        int job = numberOfPages * 10;

        if (job > 60) {
            second += job - 60;
            if (second > 60) {
                second = second - 60;
                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                }
            } else {
                second = 60 - second;
                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                }
            }
        } else if (job < 60) {
            second += job;
            if (second > 60) {
                second = second - 60;
                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                }
            }
        }
        endTime = new Time(hour, minute, second);

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
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
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
