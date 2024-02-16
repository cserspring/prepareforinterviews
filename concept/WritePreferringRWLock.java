import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WritePreferringRWLock {
    private int numWritersWaiting;
    private boolean isWriting;
    private final Lock writerLock;
    private final Condition writerCondition;
    private int numReadersReading;

    public WritePreferringRWLock() {
        this.numWritersWaiting = 0;
        this.isWriting = false;
        this.writerLock = new ReentrantLock();
        this.writerCondition = writerLock.newCondition();
        this.numReadersReading = 0;
    }

    public void acquireReader() throws InterruptedException {
        writerLock.lock();
        try {
            while (numWritersWaiting > 0 || isWriting) {
                writerCondition.await();
            }
            numReadersReading++;
        } finally {
            writerLock.unlock();
        }
    }

    public void releaseReader() {
        writerLock.lock();
        try {
            numReadersReading--;
            if (numReadersReading < 0) {
                throw new IllegalStateException("Improper use of lock!");
            }
            if (numReadersReading == 0) {
                writerCondition.signalAll();
            }
        } finally {
            writerLock.unlock();
        }
    }

    public void acquireWriter() throws InterruptedException {
        writerLock.lock();
        try {
            numWritersWaiting++;
            while (numReadersReading > 0 || isWriting) {
                writerCondition.await();
            }
            numWritersWaiting--;
            isWriting = true;
        } finally {
            writerLock.unlock();
        }
    }

    public void releaseWriter() {
        writerLock.lock();
        try {
            isWriting = false;
            writerCondition.signalAll();
        } finally {
            writerLock.unlock();
        }
    }
}
