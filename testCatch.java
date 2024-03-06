import java.sql.SQLException;

/**
 * @author zhengtianze
 * @version 1.0
 * @description: TODO
 * @date 2024/2/29 1:44 下午
 */
public class testCatch {
    public static void main(String[] args) throws InterruptedException {
        try {
            test1();
        } catch (ArithmeticException e){
            System.out.println("主进程 捕获异常");
            return;

        } finally {
            System.out.println("test 1 最终执行");
        }


    }


    public static void test1() throws ArithmeticException {
        System.out.println("hello word");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            try{
                System.out.println("get");
                int a = 5 / 0;
            } catch (ArithmeticException e){
                System.out.println("异常");
                //throw new ArithmeticException("err ");
                try {
                    throw new SQLException("");
                } catch (SQLException throwables) {

                }
                // System.exit(0);

            } finally {
                System.out.println("最终执行");
            }

            }
        });

        thread.run();


    }
}
