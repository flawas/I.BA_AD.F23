/*
 * Copyright 2023 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sw06.buffer;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeoutException;

/**
 * Puffer nach dem First In First Out Prinzip mit einer begrenzten Kapazität.
 * Der Puffer ist thread sicher.
 *
 * @param <T> Elememente des Buffers
 */
public final class BoundedBuffer<T> implements Buffer<T> {

    private final ArrayDeque<T> queue;
    private final Semaphore putSema;
    private final Semaphore takeSema;

    /**
     * Erzeugt einen Puffer mit bestimmter Kapazität.
     *
     * @param n Kapazität des Puffers
     */
    public BoundedBuffer(final int n) {
        queue = new ArrayDeque<>(n);
        putSema = new Semaphore(n);
        takeSema = new Semaphore(0);
    }

    @Override
    public void add(final T elem) throws InterruptedException {
        putSema.acquire();
        synchronized (queue) {
            queue.addFirst(elem);
        }
        takeSema.release();
    }

    @Override
    public T remove() throws InterruptedException {
        takeSema.acquire();
        T elem = null;
        synchronized (queue) {
            elem = queue.removeLast();
        }
        putSema.release();
        return elem;
    }

    @Override
    public boolean add(T elem, long millis) throws InterruptedException {
        try {
            putSema.acquire();
            synchronized (queue) {
                queue.addFirst(elem);
            }
            takeSema.release();
            return true;
        } catch (InterruptedException ex) {
            throw new InterruptedException("Zeit Abgelaufen.");
        }
    }

    @Override
    public T remove(long millis) throws InterruptedException {
        try {
            takeSema.acquire();
            T elem;
            synchronized (queue) {
                elem = queue.removeLast();
            }
            putSema.release();
            return elem;
        } catch (InterruptedException ex) {
            throw new InterruptedException();
        }
    }

    @Override
    public boolean empty() {
        int size;
        synchronized (queue) {
            size = queue.size();
        }
        if(size == 0 && putSema.getQueueLength() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean full() {
        int size;
        synchronized (queue) {
            size = queue.size();
        }
        if(putSema.getQueueLength() == size) {
            return true;
        }
        return false;
    }

    @Override
    public boolean size() {
        int size;
        synchronized (queue) {
            size = queue.size();
        }
        if(putSema.getQueueLength() == 0 && takeSema.getQueueLength() == 0 && size == 0) {
            return true;
        }
        return false;
    }
}
