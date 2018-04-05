package com.didispace.demo;

import rx.Observable;
import rx.Subscriber;

/**
 * @version 2018/4/4.
 */
public class ObservableDemo {
//    public static void main(String[] args) {
//        test();
//    }

    public static void test() {
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxJava");
                subscriber.onNext("I am xxxxxx");
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("subscrib : " + s);
            }
        };

        observable.subscribe(subscriber);
    }
}
