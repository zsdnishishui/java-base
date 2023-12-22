package 继承;

import java.io.Closeable;
import java.io.IOException;

public class B extends A implements Closeable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id+"zsd";
    }
    @Override
    public int add(int a, int b){
        return a+b;
    }
    public int num(int a, int b){
        return this.add(a, b) + 100;
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {

    }
}
