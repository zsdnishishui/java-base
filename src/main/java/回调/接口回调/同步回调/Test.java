package 回调.接口回调.同步回调;

public class Test {
    public static void main(String[] args) {
        Caller caller = new Caller();
        // 下面是三种写法

        // 1.创建一个实现接口的类
        CallbackTo callback = new CallbackImpl();
        caller.execute(callback);

        // 2.匿名内部类
        caller.execute(new CallbackTo() {
            @Override
            public void onCallback(String message) {
                System.out.println("回调方法被调用，参数为：" + message);
            }
        });
        // 3.Lambda表达式
        caller.execute((x) -> {
            System.out.println("回调方法被调用，参数为：" + x);
        });
    }
}

interface CallbackTo {
    void onCallback(String message);
}

class Caller {
    void execute(CallbackTo callback) {
// 执行任务
        String result = "任务执行完成"; // 调用回调方法
        callback.onCallback(result);
    }
}

class CallbackImpl implements CallbackTo {
    @Override
    public void onCallback(String message) {
        System.out.println("回调方法被调用，参数为：" + message);
    }
}

