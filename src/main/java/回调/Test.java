package 回调;

public class Test {
    public static void main(String[] args) {
        System.out.println("发送请求");
        Request request = new Request();
        new Thread(()->{
            request.send(()->{
                System.out.println("回调");
            });
        }).start();
        System.out.println("结束请求，去干别的了");
    }
}
