package time_compute;

public class time_compute
{
    int h,m,s;
    public time_compute(int hours, int minutes, int seconds)
    {
        h = hours;
        m = minutes;
        s = seconds;
    }
    public int differenceTime(time_compute t1, time_compute t2)
    {
        int ts1 = t1.h * 3600 + t1.m * 60 + t1.s;
        int ts2 = t2.h * 3600 + t2.m * 60 + t2.s;
        return Math.abs(ts2 - ts1);
    }
}

