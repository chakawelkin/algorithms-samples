import java.util.concurrent.atomic.AtomicLong;

public class SlidingWindow {

    // 时间片数，统计每个时间片的计数
    private AtomicLong[] timeSlices;

    // 队列的长度
    private int timeSliceSize;

    // 每个时间片的时间长度，毫秒
    private int timeMillsPerSize;

    // 一个时间窗口所占的时间片数，即窗口大小
    private int windowSliceSize;

    // 一个窗口内能通过的阈值
    private int threshold;

    // 滑动窗口的起始时间
    private long beginTimeMills;

    // 最后一次统计到时间窗口的访问时间
    private long lastAddTimeMills;

    public SlidingWindow(int threshold) {
        this.windowSliceSize = 5;
        this.timeMillsPerSize = 200;
        // 队列大小
        this.timeSliceSize = this.windowSliceSize * 2;
        this.threshold = threshold;
    }

    private void reset() {
        this.beginTimeMills = System.currentTimeMillis();
        // 初始化循环队列
        final AtomicLong[] currTimeSlices = new AtomicLong[timeSliceSize];
        for (int i = 0; i < timeSliceSize; i++) {
            currTimeSlices[i] = new AtomicLong(0L);
        }
        this.timeSlices = currTimeSlices;
    }

    private int currTimeLocation() {
        long now = System.currentTimeMillis();
        // 上次添加时间， 已经超过了一个完整的时间窗口, 那么初始化新的时间窗口即可
        if (now - lastAddTimeMills > (long) timeMillsPerSize * windowSliceSize) {
            reset();
        }
        // 计算当前时间对应的idx
        int idx = (int) ((now - beginTimeMills) / timeMillsPerSize) % timeSliceSize;
        if (idx < 0) {
            return 0;
        }
        return idx;
    }

    public synchronized boolean incr(int cnt) {
        int currIdx = currTimeLocation();
        // 清理过期时间窗口内的值
        for (int i = 1; i <= windowSliceSize; i++) {
            timeSlices[(currIdx + i) % timeSliceSize].set(0L);
        }

        // 统计近一个时间窗口内的数量
        long sum = 0L;
        for (int i = 0; i <= windowSliceSize; i++) {
            sum += timeSlices[(currIdx - i + timeSliceSize) % timeSliceSize].get();
        }

        // 该窗口内容不下
        if (sum + cnt > threshold) {
            return false;
        }
        // 将数量统计到该时间窗口里
        timeSlices[currIdx].addAndGet(cnt);
        this.lastAddTimeMills = System.currentTimeMillis();
        return true;
    }

}