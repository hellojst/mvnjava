package cn.stjia.api;

/**
 * 新接口
 * va 8 为我们带来了接口的默认方法。 接口现在也可以包含行为，而不仅仅是方法签名。 但是，如果在接口上有几个默认方法，代码几乎相同，
 * 会发生什么情况？ 通常，您将重构这些方法，调用一个可复用的私有方法。 但默认方法不能是私有的。 将复用代码创建为一个默认方法不是
 * 一个解决方案，因为该辅助方法会成为公共API的一部分。 使用 Java 9，您可以向接口添加私有辅助方法来解决此问题：
 */
public interface IntTest {

    /*
     常量
     */
    public static int NUM = 5;

    /*
    抽象方法
     */
    void normalInterfaceMethod();

    /*
    默认方法
     */
    default void defaultInterfaceMethod(){
        init();
    };

    /*
    私有方法
     */
    private void init(){
        System.out.println("Initializing");
    }
}
