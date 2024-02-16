import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RWLock {
    private final Lock writerLock;
    private final Lock numReadersLock;
    private int numReaders;

    public RWLock() {
        this.writerLock = new ReentrantLock();
        this.numReadersLock = new ReentrantLock();
        this.numReaders = 0;
    }

    public void acquireReader() {
        numReadersLock.lock();
        try {
            numReaders++;
            if (numReaders == 1) {
                writerLock.lock();
            }
        } finally {
            numReadersLock.unlock();
        }
    }

    public void releaseReader() {
        assert numReaders > 0;
        numReadersLock.lock();
        try {
            numReaders--;
            if (numReaders == 0) {
                writerLock.unlock();
            }
        } finally {
            numReadersLock.unlock();
        }
    }

    public void acquireWriter() {
        writerLock.lock();
    }

    public void releaseWriter() {
        writerLock.unlock();
    }
}
