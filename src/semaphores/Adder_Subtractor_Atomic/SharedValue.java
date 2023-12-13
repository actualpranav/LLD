package semaphores.Adder_Subtractor_Atomic;

import java.util.concurrent.atomic.AtomicInteger;
public class SharedValue {
    public AtomicInteger value = new AtomicInteger(0);
}
