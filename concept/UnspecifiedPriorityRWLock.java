import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnspecifiedPriorityRWLock {
    private final Lock lock;
    private final Condition noReaders;
    private final Condition noWriters;
    private int readers;
    private boolean isWriting;

    public UnspecifiedPriorityRWLock() {
        lock = new ReentrantLock();
        noReaders = lock.newCondition();
        noWriters = lock.newCondition();
        readers = 0;
        isWriting = false;
    }

    // Acquire a read lock
    public void acquireReader() throws InterruptedException {
        lock.lock();
        try {
            while (isWriting) {
                noWriters.await(); // Wait if a writer is active
            }
            readers++;
        } finally {
            lock.unlock();
        }
    }

    // Release a read lock
    public void releaseReader() {
        lock.lock();
        try {
            readers--;
            if (readers == 0) {
                noReaders.signalAll(); // Signal writers if no readers left
            }
        } finally {
            lock.unlock();
        }
    }

    // Acquire a write lock
    public void acquireWriter() throws InterruptedException {
        lock.lock();
        try {
            while (readers > 0 || isWriting) {
                noReaders.await(); // Wait if readers or other writers are active
            }
            isWriting = true;
        } finally {
            lock.unlock();
        }
    }

    // Release a write lock
    public void releaseWriter() {
        lock.lock();
        try {
            isWriting = false;
            noWriters.signal(); // Signal waiting writers
            noReaders.signalAll(); // Signal waiting readers
        } finally {
            lock.unlock();
        }
    }
}
