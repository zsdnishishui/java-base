package 回调;



public class Request {
    public void send(Callback callback){
        callback.call();
    }
}
