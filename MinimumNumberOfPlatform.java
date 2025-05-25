public class MinimumNumberOfPlatform {

    static int timeToMinute(String time){
        String[]  str = time.split(":");
        int hour = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[1]);
        return  hour * 60 + min;


    }

    static int minPlatform(String [] arr, String [] dep){
        int  n = arr.length;
        int [] v = new int[1441];

        for (int i = 0; i < n; i++) {
            int arrivalTime = timeToMinute(arr[i]);
            int depTime = timeToMinute(dep[i]);
            v[arrivalTime]++;
            v[depTime+ 1]--;


        }
        int res =0, count =0;
        for (int i = 0; i <=1440; i++) {
            count +=v[i];
            res = Math.max(res, count);


        }

        return res;




    }

    public static void main(String[] args) {
        String[] arr = {"09:00", "09:45", "09:55", "11:00", "15:00", "18:00"};
        String[] dep = {"09:20", "12:00", "11:30", "11:50", "19:00", "20:00"};

        System.out.println("Minimum Platforms Needed: " + minPlatform(arr, dep));
    }
}
