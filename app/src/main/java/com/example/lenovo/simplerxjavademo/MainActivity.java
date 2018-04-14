package com.example.lenovo.simplerxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                System.out.println("OnSubscribe@ "+Thread.currentThread().getName()); //new Thread
                subscriber.onNext(1);
            }})
                .subscribeOn(new Scheduler.Schedulers().io())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onNext(Integer var1) {
                        System.out.println("Subscriber@ "+Thread.currentThread().getName()); // new Thread
                        System.out.println(var1);
                    }
                });
    }
}
