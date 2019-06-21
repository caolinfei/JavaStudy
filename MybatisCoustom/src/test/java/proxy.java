import com.proxy.Computer;
import com.proxy.MyInvocationHandler;
import com.proxy.Proxyimpl;

import java.io.IOException;

public class proxy {

    public static void main(String[] args) throws IOException {

//
//        Lenveo l=new Lenveo();
//        //Computer computer=new Lenveo();
//
//        Computer o = (Computer)Proxy.newProxyInstance(Computer.class.getClassLoader(), new Class[]{Computer.class}, new MyInvocationHandler() );
//        final String sale1 = o.sale(213);
//        System.out.println(o.getClass().getInterfaces()[0].getName());
//        System.out.println(o.getClass());
//        String sale = o.sale(800);
//        System.out.println(sale);
        //如果只有一个接口没有实现类 直接代理接口
//        Computer computer= (Computer)Proxy.newProxyInstance(Computer.class.getClassLoader(), new Class[]{Computer.class}, new MyInvocationHandler());
//      Computer computer= (Computer)Proxy.newProxyInstance(Computer.class.getClassLoader(), new Class[]{Computer.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//             return  null;
//            }
//        });
//        computer.sale(123);
//
//        byte[] $Prox0s = ProxyGenerator.generateProxyClass("$Prox0", new Class[]{Computer.class});
//
//        FileOutputStream outputStream=new FileOutputStream("$Prox0.class");
//        outputStream.write($Prox0s);

        //computer 执行 toString hasCode Equals 都会经过<MyInvocationHandler 而Idea默认Computer是调用toString  if("toString".equals(method.getName())){
        //          return "ToString";
        //      } 这样就回去显示ToString
        Computer computer=new Proxyimpl(new MyInvocationHandler());

    }
}
