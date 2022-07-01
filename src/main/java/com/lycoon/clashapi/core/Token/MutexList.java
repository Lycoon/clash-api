package com.lycoon.clashapi.core.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * This class is used for storing API keys in an async manner.
 *
 * In a nutshell this class is meant to rotate the api keys to avoid rate limit by the api.
 * Each request is made with the key that is currently in use. the index will loop from 0 to the size of the list.
 * this loop is endless. once the index reaches the size of the list, it will start from 0.
 * @param <T>
 */
public class MutexList<T> extends ArrayList<T> {
    // Rather than using the current
    private int index = 0;

    /**
     *
     * @param list
     */
    public MutexList(List<T> list) {
        super(list);
    }
    public MutexList(){
        super();
    }

    @Override @Deprecated
    public T get(int index) {
        throw new IllegalStateException("[ERROR] Do not call this method!");
    }

    /**
     * This method returns the current key in use.
     * @return
     */
    public synchronized T get() {
        return super.get(index);
    }

    /**
     * Increments the index and sets it to 0 if it reaches the size of the list.
     */
    public synchronized void incrementIndex() {
        if (index >= super.size() - 1) {
            index = 0;
        }else {
            index++;
        }
    }


    /**
     * This function basically returns the key in use and increments the index for the next use.
     * @return
     */
    public synchronized T cycle(){
        T t = get();
        incrementIndex();
        return t;
    }
}
