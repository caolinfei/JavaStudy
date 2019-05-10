package com.proxy;
import java.lang.reflect.*;

public  class Proxyimpl extends Proxy implements Computer
{
    private static Method m1;
    private static Method m3;
    private static Method m2;
    private static Method m0;

    public Proxyimpl(final InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    public final boolean equals(final Object o) {
        try {
            return (boolean)super.h.invoke(this, Proxyimpl.m1, new Object[] { o });
        }
        catch (Error | RuntimeException error) {
            throw error;
        }
        catch (Throwable t) {
            throw new UndeclaredThrowableException(t);
        }
    }

    public final String sale(final double n) {
        try {
            return (String)super.h.invoke(this, Proxyimpl.m3, new Object[] { n });
        }
        catch (Error | RuntimeException error) {
            throw error;
        }
        catch (Throwable t) {
            throw new UndeclaredThrowableException(t);
        }
    }

    public final String toString() {
        try {
            return (String)super.h.invoke(this, Proxyimpl.m2, null);
        }
        catch (Error | RuntimeException error) {
            throw error;
        }
        catch (Throwable t) {
            throw new UndeclaredThrowableException(t);
        }
    }

    public final int hashCode() {
        try {
            return (int)super.h.invoke(this, Proxyimpl.m0, null);
        }
        catch (Error | RuntimeException error) {
            throw error;
        }
        catch (Throwable t) {
            throw new UndeclaredThrowableException(t);
        }
    }

    static {
        try {
            Proxyimpl.m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            Proxyimpl.m3 = Class.forName("com.proxy.Computer").getMethod("sale", Double.TYPE);
            Proxyimpl.m2 = Class.forName("java.lang.Object").getMethod("toString", (Class<?>[])new Class[0]);
            Proxyimpl.m0 = Class.forName("java.lang.Object").getMethod("hashCode", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException ex) {
            throw new NoSuchMethodError(ex.getMessage());
        }
        catch (ClassNotFoundException ex2) {
            throw new NoClassDefFoundError(ex2.getMessage());
        }
    }
}
