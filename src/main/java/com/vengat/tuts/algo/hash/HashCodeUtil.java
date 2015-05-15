package com.vengat.tuts.algo.hash;

/**
 * Created by veramanan on 4/22/14.
 */
public final class HashCodeUtil {


    public static final int SEED = 23;

    private static final int fODD_PRIME_NUMBER = 37;

    private static void log(String aMessage) {
        System.out.println("log:- "+aMessage);
    }

    private static int firstTerm(int aSeed) {
        return fODD_PRIME_NUMBER * aSeed;
    }

    public static int hash(int aSeed, boolean aBoolean) {
        log("boolean...");
        return firstTerm(aSeed) + (aBoolean ? 1 : 0);
    }

    public static int hash(int aSeed, char aChar) {
        log("char...");
        return firstTerm(aSeed) + (int) aChar;
    }

    public static int hash(int aSeed, int aInt) {
        log("int...");
        return firstTerm(aSeed) + aInt;
    }

    public static int hash(int aSeed, double aDouble) {
        log("double...");
        return hash(aSeed, Double.doubleToLongBits(aDouble));
    }

    public static int hash(int aSeed, float aFloat) {
        log("float...");
        return hash(aSeed, Float.floatToIntBits(aFloat));
    }

    public static int hash(int aSeed, long aLong) {
        log("long...");
        return firstTerm(aSeed) + (int) (aLong ^ (aLong >>> 32));
    }

//    public static int hash(int aSeed, Object aObject) {
//
//    }
}
